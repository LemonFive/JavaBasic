package com.csh.Concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class MyLock implements Lock {

    private Helper helper = new Helper();

    private class Helper extends AbstractQueuedSynchronizer{
        //获取锁
        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            if(state==0){
                //利用CAS原理修改state
                if(compareAndSetState(0,arg)){
                    //设置当前线程占有资源
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }
            //判断可重入锁
            else if(getExclusiveOwnerThread()==Thread.currentThread()){
                setState(getState()+arg);
                return true;
            }
            return false;
        }

        //释放锁
        @Override
        protected boolean tryRelease(int arg) {
            boolean flag = false;

            //释放后判断是否为0
            int state = getState() - arg;
            if(state == 0){
                setExclusiveOwnerThread(null);
                return true;
            }

            //释放锁时不存在线程安全问题
            //当前线程已经独占该资源，其他线程不会干扰
            setState(state);
            return false;
        }

        public Condition newConditionObjecct(){
            return new ConditionObject();
        }
    }


    @Override
    public void lock() {
        helper.acquire(1);
    }

    //以中断方式获取锁
    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    //自旋超时
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        return helper.newConditionObjecct();
    }
}


