package cn.com.lioan.testEnum;

public class TestEnums {

    public TestEnums() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		Color red = Color.RED;
//		System.out.println(red.ordinal() + "  " + red);
//		System.out.println(Color.BLUE.ordinal() + "  " + Color.BLUE);

        System.out.println(MyEnum.ONE.getKey() + ":" + MyEnum.ONE.getValue());
        System.out.println(MyEnum.getValueByKey("key2"));
    }

}
