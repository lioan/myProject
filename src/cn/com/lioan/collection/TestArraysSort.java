package cn.com.lioan.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TestArraysSort {

    private void testArraySort() {
        int[] iarray = new int[]{8, 5, 9, 0, 6, 3, 4, 7, 2, 1};
        System.out.println("int数组排序前");
        for (int i = 0; i < iarray.length; i++) {
            System.out.print(iarray[i] + " ");
        }
        System.out.println();
        Arrays.sort(iarray);
        System.out.println("int数组排序后");
        for (int i = 0; i < iarray.length; i++) {
            System.out.print(iarray[i] + " ");
        }
        System.out.println();
        // 字符串类型
        String[] sarray = new String[]{"300", "900", "500", "1500", "1200"};
        System.out.println("string数组排序前");
        for (int i = 0; i < sarray.length; i++) {
            System.out.print(sarray[i] + " ");
        }
        System.out.println();
        System.out.println("string数组排序后");
        Arrays.sort(sarray);
        for (int i = 0; i < sarray.length; i++) {
            System.out.print(sarray[i] + " ");
        }
        System.out.println();
    }

    private void testListSort() {
        //�����Զ����࣬����comparable�ӿڶ�����������������һ
        LinkedList<Animals> list = new LinkedList<Animals>();
        list.add(new Animals("a", 2));
        list.add(new Animals("c", 6));
        list.add(new Animals("b", 4));
        System.out.println("Animals ����ǰ================ Comparable");
        for (Animals animals : list) {
            System.out.println("Animals name=" + animals.name + ",age=" + animals.age);
        }
        Collections.sort(list);//Animals�Ѿ�ʵ��comparable�ӿڲ�����дcompareTo()����������������
        System.out.println("Animals �����================ Comparable");
        for (Animals animals : list) {
            System.out.println("Animals name=" + animals.name + ",age=" + animals.age);
        }

        //�����Զ����࣬����comparator�ӿڶ����������,��������������������
        LinkedList<Animals> list1 = new LinkedList<Animals>();
        list1.add(new Animals("a", 2));
        list1.add(new Animals("c", 6));
        list1.add(new Animals("d", 4));
        System.out.println("Animals ����ǰ================ ComparatorAge");
        for (Animals animals : list1) {
            System.out.println("Animals name=" + animals.name + ",age=" + animals.age);
        }
        Collections.sort(list1, new AnimalsAgeComparator());//Animals�Ѿ�ʵ��comparable�ӿڲ�����дcompareTo()����������������
        System.out.println("Animals �����================ ComparatorAge");
        for (Animals animals : list1) {
            System.out.println("Animals name=" + animals.name + ",age=" + animals.age);
        }

        //�����Զ����࣬����comparator�ӿڶ����������,��������������������
        LinkedList<Animals> list2 = new LinkedList<Animals>();
        list2.add(new Animals("a", 2));
        list2.add(new Animals("b", 6));
        list2.add(new Animals("b", 4));
        System.out.println("Animals ����ǰ================ ComparatorName");
        for (Animals animals : list2) {
            System.out.println("Animals name=" + animals.name + ",age=" + animals.age);
        }
        Collections.sort(list2, new AnimalsNameComparator());//Animals�Ѿ�ʵ��comparable�ӿڲ�����дcompareTo()����������������
        System.out.println("Animals �����================ ComparatorName");
        for (Animals animals : list2) {
            System.out.println("Animals name=" + animals.name + ",age=" + animals.age);
        }
    }

    class Animals implements Comparable<Animals> {
        public String name;
        public int age;

        public Animals(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Animals o) {
            if (this.age > o.age)
                return 1;
            if (this.age < o.age)
                return -1;
            else
                return 0;
        }
    }

    class AnimalsAgeComparator implements Comparator<Animals> {

        @Override
        public int compare(Animals o1, Animals o2) {
            if (o1.age > o2.age) {
                return 1;
            } else if (o1.age < o2.age) {
                return -1;
            } else {
                return 0;
            }
        }

    }

    class AnimalsNameComparator implements Comparator<Animals> {

        @Override
        public int compare(Animals o1, Animals o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static void main(String[] args) {
        TestArraysSort test = new TestArraysSort();
        test.testArraySort();
//		test.testListSort();
    }

}
