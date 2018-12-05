package cn.com.lioan.clone;

public class Farmer {

    private int age;
    private String name;
    private String identityCardNo;

    public Farmer() {
    }

    public Farmer(String name, int age, String identityNo) {
        this.name = name;
        this.age = age;
        this.identityCardNo = identityNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }


}
