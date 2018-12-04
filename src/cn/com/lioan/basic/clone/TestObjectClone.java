package cn.com.lioan.basic.clone;

public class TestObjectClone {

    private void test1() {
//		Farmer farmer = new Farmer("lixx",30,"123456789");
//		ObjectClone obj = new ObjectClone(farmer);
//		obj.printFarmerInfo();

        //Java中引用类型的传递、赋值都是对象地址的复制 故改变其一 另一个对象的内容也会随之改变
        Farmer farmer1 = new Farmer("lixx", 32, "123456789");
        ObjectClone obj1 = new ObjectClone(farmer1);
        obj1.printFarmerInfo();
        Farmer farmer2 = new Farmer();
        farmer2 = farmer1;
        farmer2.setAge(29);
        obj1.printFarmerInfo();
    }

    /**
     * 浅表克隆 默认的克隆模式 对于基本类型、String类型基本上可以达到克隆的目的（都是值传递）
     * 但是对于成员变量是数组或者其他复杂类型(自己创建的对象) 都是地址传递  必须使用深度克隆
     */
    private void testSurfaceClone() {
        Farmer farmer1 = new Farmer("lixx", 32, "123456789");
        Farmer farmer2 = new Farmer("lixx", 29, "123456789");
        ObjectClone o1 = new ObjectClone(farmer1);
        ObjectClone o2 = new ObjectClone(farmer2);
        o1.name = "o1";
//		o2 = o1;
        o2 = (ObjectClone) o1.clone();
        System.out.println("o1 == " + o1);
        System.out.println("o2 == " + o2);

        System.out.println("after clone , but o2 name do not change");
        System.out.println("o1 name = " + o1.getName());
        System.out.println("o2 name = " + o2.getName());
        o1.printFarmerInfo();
        o2.printFarmerInfo();
        System.out.println("o1.farmer = " + o1.getFarmer());
        System.out.println("o2.farmer = " + o2.getFarmer());

        o2.name = "o2";
        o2.getFarmer().setAge(22);
        o2.getFarmer().setIdentityCardNo("987654321");

        System.out.println("change o2 name to o2");
        System.out.println("o1 name = " + o1.getName());
        System.out.println("o2 name = " + o2.getName());
        o1.printFarmerInfo();
        o2.printFarmerInfo();
        System.out.println("o1.farmer = " + o1.getFarmer());
        System.out.println("o2.farmer = " + o2.getFarmer());
    }

    private void testArrSurfaceClone() {
        Farmer farmer1 = new Farmer("lixx", 32, "123456789");
        Farmer farmer2 = new Farmer("lixiaoxiong", 29, "987654321");
        Farmer[] farmers = new Farmer[]{farmer1, farmer2};

        String[] names = {"o11", "o12"};

        ObjectClone o1 = new ObjectClone();
        ObjectClone o2 = new ObjectClone();

//		o1.setFarmers(farmers);
//		o1.setNames(names);

        o1.names[0] = "a";
        o1.names[1] = "1";
        o1.farmers[0] = farmer1;

        o2 = (ObjectClone) o1.clone();
        System.out.println("o1 == " + o1);
        System.out.println("o2 == " + o2);

        System.out.println("o1 farmers = " + o1.getFarmers());
        System.out.println("o1 names = " + o1.getNames());
        System.out.println("o1 names : " + o1.getNames()[0] + " " + o1.getNames()[1]);
        System.out.println("o1 farmers[0] : " + o1.getFarmers()[0].getName() + " " + o1.getFarmers()[0].getIdentityCardNo());

        System.out.println("o2 farmers = " + o2.getFarmers());
        System.out.println("o2 names = " + o2.getNames());
        System.out.println("o2 names : " + o2.getNames()[0] + " " + o2.getNames()[1]);
        System.out.println("o2 farmers[0] : " + o2.getFarmers()[0].getName() + " " + o2.getFarmers()[0].getIdentityCardNo());
        System.out.println("===============================");

//		o2.setNames(new String[]{"o11","o22"});
        o2.names[0] = "b";
        o2.names[1] = "1";
        o2.farmers[0] = farmer2;

        System.out.println("o1 farmers = " + o1.getFarmers());
        System.out.println("o1 names = " + o1.getNames());
        System.out.println("o1 names : " + o1.getNames()[0] + " " + o1.getNames()[1]);
        System.out.println("o1 farmers[0] : " + o1.getFarmers()[0].getName() + " " + o1.getFarmers()[0].getIdentityCardNo());

        System.out.println("o2 farmers = " + o2.getFarmers());
        System.out.println("o2 names = " + o2.getNames());
        System.out.println("o2 names : " + o2.getNames()[0] + " " + o2.getNames()[1]);
        System.out.println("o2 farmers[0] : " + o2.getFarmers()[0].getName() + " " + o2.getFarmers()[0].getIdentityCardNo());
    }

    public static void main(String[] args) {
        TestObjectClone test = new TestObjectClone();
        test.test1();

//		test.testSurfaceClone();

//		test.testArrSurfaceClone();
    }

}
