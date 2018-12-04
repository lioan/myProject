package cn.com.lioan.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.parser.JSONToken;

public class TestBasicJson {

    public TestBasicJson() {
    }

    private void testJsonObject() {
        JSONObject json = new JSONObject(true);
        json.put("name", "lixx");
        json.put("age", 20);
        json.put("home", "");
        String name = json.getString("name");
        int age = json.getIntValue("age");
        System.out.println(name + ":" + age);
        System.out.println(json.toString());
        System.out.println("home === null : " + (json.getString("home") == null));
        System.out.println("home === \"\" : " + (json.getString("home").equals("")));
        System.out.println("not exists : " + (json.getString("nonexists") == null));

        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject json1 = new JSONObject();
        json1.put("Data", map);
        System.out.println(json1.toString());

        JSONObject json2 = new JSONObject(map);
        System.out.println(json2.toString());
    }

    private void testJsonNest() {
        JSONObject lixx = new JSONObject(true);
        lixx.put("name", "lixx");
        lixx.put("age", 28);
        lixx.put("birthday", new Date());

        JSONObject lixz = new JSONObject();
        lixz.put("name", "lixz");
        lixz.put("age", 24);

        JSONObject people = new JSONObject();
        people.put("lixx", lixx);
        people.put("lixz", lixz);

        JSONObject family = new JSONObject();
        family.put("family", people);

        System.out.println(family.toJSONString());
        System.out.println(people.toString());
        System.out.println(family.toString());
    }

    private void testJsonArray() {
        JSONArray jsons = new JSONArray();
        JSONObject lixx = new JSONObject(true);
        lixx.put("name", "lixx");
        lixx.put("age", 28);
        lixx.put("birthday", new Date());

        JSONObject lixz = new JSONObject();
        lixz.put("name", "lixz");
        lixz.put("age", 24);

        jsons.add(0, lixx);
        jsons.add(1, lixz);

        JSONObject family = new JSONObject();
        family.put("familyName", "LiZQ");
        family.put("numbers", jsons);

        JSONObject data = new JSONObject();
        data.put("data", family);

        System.out.println(jsons.toJSONString());
        System.out.println(jsons.toString());
        System.out.println(family.toJSONString());
        System.out.println(data.toJSONString());

        for (Iterator iterator = jsons.iterator(); iterator.hasNext(); ) {
            JSONObject json = (JSONObject) iterator.next();
            System.out.println(json.toJSONString());
        }

        JSONArray jsonArray = new JSONArray();
        System.out.println(jsonArray.size());
        System.out.println(jsonArray.toJSONString());
        System.out.println(jsonArray.toString());

        JSONArray jsonArray2 = null;
        jsonArray2 = JSONObject.parseArray("[]");
        System.out.println(jsonArray2.size());
        System.out.println(jsonArray2.toJSONString());

        JSONArray jsonArray3 = null;
        System.out.println(jsonArray3.toJSONString());

        String jsonArrayString = "[{\"SourceType\":\"1\",\"MonthAvg\":\"1000\",\"Photo\":\"1001,1002,1003\"},"
                + "{\"SourceType\":\"2\",\"MonthAvg\":\"2000\",\"Photo\":\"2001,2002,2003\"}]";
        JSONArray tjArray = JSONObject.parseArray(jsonArrayString);
        System.out.println(tjArray.size());
        System.out.println(tjArray.toJSONString());
        System.out.println(tjArray.toString());

        Iterator<Object> iterator = tjArray.iterator();
        while (iterator.hasNext()) {
            JSONObject json = (JSONObject) iterator.next();
            System.out.println("SourceType = " + json.getString("SourceType"));
            System.out.println("MonthAvg = " + json.getString("MonthAvg"));
            System.out.println("Photo = " + json.getString("Photo"));
        }
    }

    private void testJsonWriter() {
        JSONArray jsons = new JSONArray();
        JSONObject lixx = new JSONObject(true);
        lixx.put("name", "lixx");
        lixx.put("age", 28);
        lixx.put("birthday", new Date());

        JSONObject lixz = new JSONObject();
        lixz.put("name", "lixz");
        lixz.put("age", 24);

        jsons.add(0, lixx);
        jsons.add(1, lixz);

        JSONObject family = new JSONObject();
        family.put("familyName", "LiZQ");
        family.put("numbers", jsons);

        JSONObject data = new JSONObject();
        data.put("data", family);

        JSONWriter writer = null;
        try {
            writer = new JSONWriter(new FileWriter(new File("json.txt")));
            writer.writeObject(data);

//			writer.writeObject(lixx);
            System.out.print("write success!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testJsonReader() {
        JSONReader reader = null;
        try {
            reader = new JSONReader(new FileReader(new File("json.txt")));
            JSONObject json = (JSONObject) reader.readObject();
            System.out.println(json.toJSONString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

    }

    public void testJsonToken() {
        JSONToken jsonToken = new JSONToken();

    }

    public void testJsonArrayWrite() {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 1000 * 1000; i++) {
            list.add(i + "");
        }

//		String path = "TestJsonArray.JSON";
        String path = "TestJsonArray.txt";
        File file = new File(path);
        if (!file.exists()) {
//			file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JSONWriter writer = null;

        try {
            writer = new JSONWriter(new FileWriter(file));
            writer.startArray();
            writer.writeObject(list);
            writer.endArray();
            writer.close();
            System.out.println("json array wite success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testJsonArrayRead() {
        List<String> list = new ArrayList<String>();
        String path = "TestJsonArray.txt";
        File file = new File(path);
        JSONReader reader = null;
        try {
            reader = new JSONReader(new FileReader(file));
            reader.startArray();
//			reader.readObject(List.class);
            list = reader.readObject(List.class);
            reader.endArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i)+",");
        }
    }

    private void testJsonMap() {
//		String jsonString = "{\"Lixx\":{\"birthday\":\"1447920711894\",\"age\":28,\"name\":\"lixx\"}}";
        String jsonString = "{\"Lixx\":{\"birthday\":\"1447920711894\",\"age\":28,\"name\":\"lixx\",\"address\":\"\"}}";
        JSONObject jsonUser = JSONObject.parseObject(jsonString);
        System.out.println("jsonUser:" + jsonUser.toJSONString());
        Map<String, Object> map = JSONObject.parseObject(jsonUser.getString("Lixx"), Map.class);
        System.out.println("size == " + map.size());
        for (Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("address == " + (map.get("address") == null));
        System.out.println("address == " + map.get("address").equals(""));

        JSONObject json = jsonUser.getJSONObject("Lixx");
        System.out.println(json.getString("birthday"));
    }

    public static void main(String[] args) {
        TestBasicJson test = new TestBasicJson();
//		 test.testJsonObject();
//		 test.testJsonNest();
//		 test.testJsonArray();

//		test.testJsonWriter();
//		test.testJsonReader();

//		test.testJsonArrayWrite();
//		test.testJsonArrayRead();

        test.testJsonMap();
    }

}
