package com.csh.basic;

import org.junit.platform.commons.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class CalendarDemo2 {
    public static void main(String[] args) {

        try{
            Date d1 = parse("2017-01-01","yyyy-MM-dd");//定义起始日期

            Date d2 = parse("2019-12-31","yyyy-MM-dd");//定义结束日期  可以去当前月也可以手动写日期。

            Calendar dd = Calendar.getInstance();//定义日期实例

            dd.setTime(d2);//设置日期起始时间

            while (dd.getTime().after(d1)||dd.getTime().equals(d1)) {//判断是否到结束日期

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

                String str = sdf.format(dd.getTime());

                System.out.println(str);//输出日期结果

                dd.add(Calendar.DATE, -1);//进行当前日期月份加1

            }

        }catch (Exception e){
            System.out.println("异常"+e.getMessage());
        }
    }


    /**
     * 根据字符串解析为日期
     * @author bazhandao
     * @date 2018-11-10
     * @param dateStr
     * @param formatter
     * @return
     */
    public static Date parse(String dateStr, String formatter) {
        if(StringUtils.isBlank(dateStr)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("格式化日期出错!date={},formatter={},{}" + dateStr + formatter + e);
        }
        return null;
    }
}
