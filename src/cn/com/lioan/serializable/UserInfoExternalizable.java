package cn.com.lioan.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfoExternalizable implements Externalizable {

    private final static long serialVersionUID = 1L;

    private String name;
    private int age;
    private String phone;
    private String passwd;

    public UserInfoExternalizable() {
    }

    public UserInfoExternalizable(String name, int age, String phone, String passwd) {
        this.age = age;
        this.name = name;
        this.phone = phone;
        this.passwd = passwd;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * 序列化操作的扩展类
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //增加一个新的对象
        Date date = new Date();
        out.writeObject(name);
        out.writeObject(phone);
        out.writeObject(age);
        out.writeObject(date);
    }

    /**
     * 反序列化的扩展类
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        //注意：这里的反序列化接收是有顺序限制的 否则会出错
        //反序列化对象的顺序 与 上述 writeExternal顺序一致
        name = (String) in.readObject();
        phone = (String) in.readObject();
        age = (int) in.readObject();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = (Date) in.readObject();
        System.out.println("反序列化后的日期为：" + format.format(date));
    }

    public String toString() {
        return "姓名: " + name + ",电话号码: " + phone + " 年龄：" + age + " 密码：" + passwd;
    }

}
