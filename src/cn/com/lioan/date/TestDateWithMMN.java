package cn.com.lioan.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateWithMMN {

    public static void main(String[] args) {
        //毫秒级别
//		System.out.println("==============begin millTime===================");
//		long millTime = System.currentTimeMillis();
//		System.out.println(millTime);
//		System.out.println("===============end millTime====================");
//		
        //纳秒级别
//		System.out.println("==============begin nanoTime===================");
//		long nanoTime = System.nanoTime();
//		System.out.println(nanoTime);
//		System.out.println("===============end nanoTime====================");

        //毫秒输出
        System.out.println("==============begin format date===================");
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS");
        DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        DateFormat format3 = new SimpleDateFormat("yyyyMMddHHmmssmmmuuu");//不对
        Date d = new Date();

        System.out.println(format1.format(d));
        System.out.println(format2.format(d).concat("000"));
        System.out.println(format3.format(d));
    }

}
