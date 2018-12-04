package cn.com.lioan.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class TestSerializable {

    public static void serializableUsers(UserInfo[] users, String desc) throws IOException {
        System.out.println("users serializable begin==============");
        FileOutputStream fos = new FileOutputStream(desc);
        ObjectOutput bos = new ObjectOutputStream(fos);
        for (int i = 0; i < users.length; i++) {
            bos.writeObject(users[i]);
            System.out.println("user: " + users[i].getName() + " serializable.");
        }
        bos.flush();
        bos.close();
        fos.close();

        System.out.println("users serializable success==============");
    }

    public static UserInfo[] deSerializableUsers(String src, int len) throws IOException, ClassNotFoundException {
        System.out.println("users deserializable begin==============");
        UserInfo[] users = new UserInfo[len];
        FileInputStream fis = new FileInputStream(new File(src));
        ObjectInput ios = new ObjectInputStream(fis);
        for (int i = 0; i < len; i++) {
            UserInfo user = (UserInfo) ios.readObject();
            System.out.println("user " + user.getName() + ": " + user.toString());
//			if (user.getUserInfoExt() != null) {
//				System.out.println("user:" + user.getName() + ", isMarray:" + user.getUserInfoExt().isMarry());
//			}
            users[i] = user;
        }
        ios.close();
        System.out.println("users deserializable success==============");
        return users;
    }

    public static void main(String[] args) {
        UserInfo u1 = new UserInfo();
        UserInfoExt userInfoExt1 = new UserInfoExt();
        userInfoExt1.setAddress("SZ");
        userInfoExt1.setMarry(true);
        userInfoExt1.setPostCode("518000");
        u1.setIdentityNum("1001");
        u1.setName("U1");
        u1.setAge(29);
        u1.setPhone("13800000001");
        u1.setPasswd("1111");
        u1.setUserInfoExt(userInfoExt1);
        UserInfo u2 = new UserInfo("1001", "U2", 33, "18988888888", "1112");
        UserInfo[] users = {u1, u2};
        String desc = "user_1.obj";
        try {
            serializableUsers(users, desc);
            deSerializableUsers(desc, 2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
