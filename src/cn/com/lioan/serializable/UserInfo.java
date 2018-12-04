package cn.com.lioan.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String identityNum;
    private String name;
    private int age;
    private String phone;
    private transient String passwd;
    private static int count = 0;

    private UserInfoExt userInfoExt;

    public UserInfo() {
        count++;
    }

    public UserInfo(String identityNum, String name, int age, String phone, String passwd) {
        this.identityNum = identityNum;
        this.age = age;
        this.name = name;
        this.phone = phone;
        this.passwd = passwd;
        count++;
    }

    public UserInfo(String identityNum, String name, int age, String phone, String passwd, UserInfoExt userInfoExt) {
        this.identityNum = identityNum;
        this.age = age;
        this.name = name;
        this.phone = phone;
        this.passwd = passwd;
        this.userInfoExt = userInfoExt;
        count++;
    }

    public UserInfoExt getUserInfoExt() {
        return userInfoExt;
    }

    public void setUserInfoExt(UserInfoExt userInfoExt) {
        this.userInfoExt = userInfoExt;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
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

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeChars(passwd);
    }

    ;

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

    public String toString() {
        return "人数: " + count + " ,身份证：" + identityNum + ",姓名: " + name + ",电话号码: " + phone
                + " ,年龄：" + age + " ,密码：" + passwd + " ,扩展信息  : " + userInfoExt;
    }
}
