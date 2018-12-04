package cn.com.lioan.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHashMap {

    private void testMapList() {
        Map<String, Object> item = new HashMap<String, Object>();
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        int len = 3;
        for (int i = 0; i < len; i++) {
            item.put("mark", (Integer) i);
            items.add(item);
        }
        for (int i = 0; i < items.size(); i++) {
            Map<String, Object> map = items.get(i);
            System.out.println(i + " map value :" + map.get("mark"));
        }
    }

    private void testMapSortByValue() {
        Map<String, Object> map1 = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        Map<String, Object> map3 = new HashMap<String, Object>();
        Map<String, Object> map4 = new HashMap<String, Object>();
        List<Map<String, Object>> listMaps1 = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> listMaps2 = new ArrayList<Map<String, Object>>();

        map1.put("id", 1001);
        map1.put("createTime", "2016-02-21");
        map1.put("status", 0);

        map2.put("id", 1003);
        map2.put("createTime", "2016-02-23");
        map2.put("status", 1);

        map3.put("id", 1002);
        map3.put("createTime", "2016-02-22");
        map3.put("status", 1);

        map4.put("id", 1004);
        map4.put("createTime", "2016-02-24");
        map4.put("status", 0);

        listMaps1.add(map1);
        listMaps1.add(map2);
        listMaps1.add(map3);
        listMaps1.add(map4);

        listMaps2.add(map1);
        listMaps2.add(map2);
        listMaps2.add(map3);
        listMaps2.add(map4);

        System.out.println("============sort before============");
        for (int i = 0; i < listMaps1.size(); i++) {
            Map<String, Object> map = listMaps1.get(i);
            System.out.println(map.get("id") + ":" + map.get("status") + ":" + map.get("createTime"));
        }

        System.out.println("============sort after by id============");
        Collections.sort(listMaps1, new Comparator<Map<String, Object>>() {

            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                return (Integer) o1.get("id") - (Integer) o2.get("id");
            }

        });
        for (int i = 0; i < listMaps1.size(); i++) {
            Map<String, Object> map = listMaps1.get(i);
            System.out.println(map.get("id") + ":" + map.get("status") + ":" + map.get("createTime"));
        }

        System.out.println("============sort after by status============");
        Collections.sort(listMaps2, new Comparator<Map<String, Object>>() {

            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                return (Integer) o1.get("status") - (Integer) o2.get("status");
            }

        });
        for (int i = 0; i < listMaps2.size(); i++) {
            Map<String, Object> map = listMaps2.get(i);
            System.out.println(map.get("id") + ":" + map.get("status") + ":" + map.get("createTime"));
        }
    }

    public static void main(String[] args) {
        TestHashMap test = new TestHashMap();
//		test.testMapList();
        test.testMapSortByValue();
    }

}
