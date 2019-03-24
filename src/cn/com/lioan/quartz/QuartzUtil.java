package cn.com.lioan.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuartzUtil {

    private final static String JOB_GROUP_NAME = "QUARTZ_JOBGROUP_LIXX";//任务组名称
    private final static String TRIGGER_GROUP_NAME= "QUARTZ_TRIGGERGROUP_LIXX";//触发器组名称
    private static Logger log = LoggerFactory.getLogger(QuartzUtil.class);

    /**
     * 添加固定时间间隔任务
     * @param jobName   任务名
     * @param triggerName   触发器名
     * @param jobClass  执行具体任务的类
     * @param seconds   任务执行时间间隔
     * @return result boolean
     */
    public static boolean addJob(String jobName, String triggerName, Class<? extends Job> jobClass,int seconds) throws SchedulerException {
        boolean result = true;
        log.info("=================initialization=================");
        //创建一个SchedulerFactory工厂实例
        SchedulerFactory sf = new StdSchedulerFactory();
        //通过SchedulerFactory构建Scheduler实例
        Scheduler scheduler = sf.getScheduler();
        log.info("=================initialize finshed=================");

        log.info("=================add the job to Scheduler=================");

        //用于描述Job实现类及其他的一些静态信息，构建一个作业实例
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                                .withIdentity(jobName, JOB_GROUP_NAME)
                                .build();

        //构建一个固定时间间隔触发器，规定触发的规则
        Trigger triggerFix = TriggerBuilder.newTrigger()
                            .withIdentity(triggerName, TRIGGER_GROUP_NAME)
                            .startNow()
                            .withSchedule(
                                    SimpleScheduleBuilder.simpleSchedule()
                                    .withIntervalInSeconds(seconds)
                                    .repeatForever()
                            )
                            .build();//产生触发器

        //构建一个cron表达式时间间隔触发器，规定触发的规则
        Trigger triggerCron = TriggerBuilder.newTrigger()
                .withIdentity(triggerName, TRIGGER_GROUP_NAME)
                .startNow()
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("*/3 * * * * ?")
                )
                .build();//产生触发器

        //TODO 需要去理解为什么是这样？？
        //向Scheduler中添加job任务和trigger触发器
        //scheduler.scheduleJob(jobDetail, triggerFix);
        scheduler.scheduleJob(jobDetail, triggerCron);

        //启动
        scheduler.start();
        return result;
    }

    public static void main(String[] args){
        try {
            QuartzUtil.addJob("taskJob1", "trigger1", TestTask1.class, 5);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
