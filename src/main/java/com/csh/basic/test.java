package com.csh.basic;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class test {
    public static void main(String[] args) {
        List<String> dateList = getLastDates(30);
        System.out.println(dateList); //true
    }

    public static List<String> getLastDates(int num) {
        List<String> dataList = new ArrayList<>(num);
        LocalDate localDate = LocalDate.now();
        for (int i = 0; i < num; i++) {
            dataList.add(localDate.toString());
            localDate = localDate.minusDays(1);
        }
        return dataList;
    }


}
