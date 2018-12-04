package cn.com.lioan.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

    private void dateMillsConvert() {
        Date date = new Date();
        long mills = date.getTime();
        System.out.println("date =========== " + date);
        System.out.println("mills ============= " + mills);
        Date date2 = new Date(mills);
        System.out.println("date2 =========== " + date2);
        System.out.println("date2.getTime() ===== " + date2.getTime());

    }

    private void nanoTime() {
		/*System.out.println("==============begin format date===================");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		
		System.out.println(format.format(d));
		System.out.println(format.parse("2015-04-27 15:01:01"));
		System.out.println(format.parse("2015-04-27 15:01:01").getTime());
		System.out.println("===============end format date====================");
		
		System.out.println("==============begin format date1===================");
		DateFormat format1 = new SimpleDateFormat("yy/MM/dd");
		Date d1 = new Date();
		System.out.println(format1.format(d1));
		System.out.println(format1.parse("15/04/27"));
		System.out.println(format1.parse("15/04/27").getTime());
		System.out.println("===============end format date1====================");
		
		//毫秒级别
		System.out.println("==============begin millTime===================");
		long millTime = System.currentTimeMillis();
		System.out.println(millTime);
		System.out.println("===============end millTime====================");
		
		//纳秒级别
		System.out.println("==============begin nanoTime===================");
		long nanoTime = System.nanoTime();
		System.out.println(nanoTime);
		System.out.println("===============end nanoTime====================");*/
    }

    private void calendarTest() throws InterruptedException, ParseException {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(date);
        Thread.sleep(1000);
        System.out.println(calendar.getTime());
        System.out.println(Calendar.getInstance().getTime());
    }

    private void getMills() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = format.parse("2015-11-05 01:00:00");
            System.out.println("d1 mills :" + d1.getTime());
            Date d2 = format.parse("2015-11-05 00:00:00");
            System.out.println("d2 mills :" + d2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param args
     * @throws InterruptedException
     * @throws ParseException
     */
    public static void main(String[] args) throws InterruptedException, ParseException {
        TestDate test = new TestDate();
//		test.dateMillsConvert();

//		test.calendarTest();

        test.getMills();
    }

}
