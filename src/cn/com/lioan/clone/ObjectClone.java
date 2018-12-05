package cn.com.lioan.clone;

public class ObjectClone implements Cloneable {

    public String name;

    public Farmer farmer;

    public String[] names;

    public Farmer[] farmers;

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public Farmer[] getFarmers() {
        return farmers;
    }

    public void setFarmers(Farmer[] farmers) {
        this.farmers = farmers;
    }

    public ObjectClone() {
        names = new String[2];
        farmers = new Farmer[2];
    }

    public ObjectClone(Farmer farmer) {
        this.farmer = farmer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public void printFarmerInfo() {
        System.out.println("farmer name = " + farmer.getName() + ",age = " + farmer.getAge()
                + ",identityCardNO = " + farmer.getIdentityCardNo());
    }

    //覆盖克隆方法
    public Object clone() {
        ObjectClone o = null;
        try {
            o = (ObjectClone) super.clone();//对象浅克隆

            o.names = names.clone();//数组深克隆
            o.farmers = farmers.clone();//数组深克隆
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
