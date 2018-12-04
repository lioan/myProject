package cn.com.lioan.serializable;

import java.io.Serializable;

public class UserInfoExt implements Serializable {

    private static final long serialVersionUID = 1L;

    private String address;
    private String postCode;
    private boolean isMarry;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public boolean isMarry() {
        return isMarry;
    }

    public void setMarry(boolean isMarry) {
        this.isMarry = isMarry;
    }

    public String toString() {
        return "地址: " + address + ",邮编: " + postCode + ",婚姻: " + isMarry;
    }

}
