package com.csh.Concurrent;

import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * @desc: 按顺序处理
 * @author: CuiShiHao
 **/
public class CompletionServiceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        CompletionService<String> service = new ExecutorCompletionService<String>(pool);

        Stream.of("苹果", "梨", "葡萄", "桃")
                .forEach(fruit -> service.submit(() -> {
                            if (fruit.equals("苹果")) {
                                TimeUnit.SECONDS.sleep(6);
                            } else if (fruit.equals("梨")) {
                                TimeUnit.SECONDS.sleep(1);
                            } else if (fruit.equals("葡萄")) {
                                TimeUnit.SECONDS.sleep(10);
                            } else if (fruit.equals("桃")) {
                                TimeUnit.SECONDS.sleep(3);
                            }
                            return "洗干净的" + fruit;
                        })
                );

        String result;
        while ((result = service.take().get()) != null) {
            System.out.println("吃掉" + result);
        }
    }
}
