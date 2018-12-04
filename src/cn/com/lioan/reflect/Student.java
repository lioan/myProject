package cn.com.lioan.reflect;

import java.util.ArrayList;
import java.util.List;

public class Student implements Operate {

    public String name;
    private int age;
    private String password;

    private int[] scores;
    private String[] classes;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, int[] scores, String[] classes) {
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.classes = classes;
    }

    public Student(String name, int age, String password, int[] score, String[] classes) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.scores = score;
        this.classes = classes;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public String[] getClasses() {
        return classes;
    }

    public void setClasses(String[] classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "stu:" + name + "," + age;
    }

    ;

    @Override
    public List<?> act(List<Object> params) {
        List<String> resultList = new ArrayList<String>();
        for (Object obj : params) {
            System.out.println(obj.toString());
        }
        resultList.add("Success");
        return resultList;
    }

}
