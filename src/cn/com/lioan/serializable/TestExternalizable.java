package cn.com.lioan.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class TestExternalizable {

    public static void serializableUsers(UserInfoExternalizable[] users, String desc) throws IOException {
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

    public static UserInfoExternalizable[] deSerializableUsers(String src, int len) throws IOException, ClassNotFoundException {
        System.out.println("users deserializable begin==============");
        UserInfoExternalizable[] users = new UserInfoExternalizable[len];
        FileInputStream fis = new FileInputStream(new File(src));
        ObjectInput ios = new ObjectInputStream(fis);
        for (int i = 0; i < len; i++) {
            users[i] = (UserInfoExternalizable) ios.readObject();
            System.out.println("user: " + users[i].toString() + " deserializable.");
        }
        ios.close();
        fis.close();
        System.out.println("users deserializable success==============");
        return users;
    }

    public static void main(String[] args) {
        UserInfoExternalizable u1 = new UserInfoExternalizable();
        u1.setName("U1");
        u1.setAge(27);
        u1.setPhone("13800000001");
        u1.setPasswd("1111");
        UserInfoExternalizable u2 = new UserInfoExternalizable("U2", 30, "18988888888", "1112");
        UserInfoExternalizable[] users = {u1, u2};
        String desc = "userExternal_1.obj";
        try {
//			serializableUsers(users, desc);
            deSerializableUsers(desc, 2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
