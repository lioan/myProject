package cn.com.lioan.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestReflect {

    private void response() {
        try {
            //对于静态成员 则只需要类即可 即Field.get(clazz) Method.invoke(null,args)
            Class clazz = Class.forName("cn.com.lioan.reflect.Student");
            System.out.println("获取类的修饰符==========" + Modifier.toString(clazz.getModifiers()));
            System.out.println("获取包名==========" + clazz.getPackage().getName());
            //使用无参构造器
            //创建对象
            Student stu1 = (Student) clazz.newInstance();
            stu1.setName("lixz");
            stu1.setAge(25);
            System.out.println(stu1.getName());
            System.out.println(stu1);
            //获取字段值
            Field nameField = clazz.getField("name");//只能访问类能够访问到的字段 例如private修饰的则无法访问
            System.out.println(nameField.getName() + "Field isAccessible :" + nameField.isAccessible());
//			Field ageField = clazz.getField("age");//访问类的公共字段
            Field ageField = clazz.getDeclaredField("age");
            System.out.println("字段" + ageField.getName() + "修饰符====" + Modifier.toString(ageField.getModifiers()));
            ageField.setAccessible(true);//此时需要设置私有字段的访问权限，否则会出现IllegalAccessException
            System.out.println(ageField.getName() + "Field isAccessible :" + ageField.isAccessible());

            String name = nameField.get(stu1).toString();
            int age = ageField.getInt(stu1);
            System.out.println("Field name === " + name);
            System.out.println("Field age === " + age);

            //使用带参数的构造器
            System.out.println("==================开始执行带参数的构造器===============");
            Constructor cons1 = clazz.getConstructor(String.class, int.class, String.class, int[].class, String[].class);
            //使用构造器创建对象
            Student stu2 = (Student) cons1.newInstance("lixx", 29, "123456", new int[]{88, 89, 95, 76}, new String[]{"英语", "高等数学", "计算机科学", "体育"});
            System.out.println(stu2.getName());
            System.out.println(stu2);
            int[] scores = stu2.getScores();
            String[] classes = stu2.getClasses();
            for (int score : scores) {
                System.out.print(score + ",");
            }
            System.out.println();
            for (String clas : classes) {
                System.out.print(clas + ',');
            }
            System.out.println();
            //获取字段数据类型对应的class对象
            System.out.println("==========开始验证字段数据类型对应的class对象============");
            Field scoreField = clazz.getDeclaredField("scores");
            Class scoreType = scoreField.getType();
            String fieldModifier = Modifier.toString(scoreType.getModifiers());
            //array类型字段需要特殊对待 所有对应的返回参数 输入参数类型都应如此对待
            if (scoreType.isArray()) {
                String arrType = scoreType.getComponentType().getName() + "[]";
                System.out.println("" + fieldModifier + " " + scoreType + " " + scoreField.getName());
                System.out.println(fieldModifier + " " + arrType + " " + scoreField.getName());
            } else {
                System.out.println(fieldModifier + " " + scoreType + " " + scoreField.getName());
            }

            //调用方法 act
            System.out.println("===============开始调用act方法=================");
            //利用特定构造器
			/*Constructor cons2 = clazz.getConstructor(String.class,int.class);
			Operate o = (Operate) cons2.newInstance("lixxue",26);*/
            //直接利用无参构造器 class.newInstance()
            Operate o = (Operate) clazz.newInstance();
            Class[] params = {List.class};
            Method m = clazz.getDeclaredMethod("act", params);
            List<String> args = new ArrayList<String>();
            args.add("load");
			/*Object[] args = new Object[1];
			args[0] = "load";*/
            Object r = m.invoke(o, args);
            List<String> results = (List<String>) r;
            for (Object object : results) {
                System.out.println(object.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestReflect r = new TestReflect();
        r.response();
    }

}
