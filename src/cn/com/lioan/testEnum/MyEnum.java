package cn.com.lioan.testEnum;

/**
 * Created by dell on 2017/1/6.
 */
public enum MyEnum {

    ONE("key1", "value1"), TWO("key2", "value2");

    private String key;
    private String value;

    private MyEnum() {
    }

    ;

    private MyEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    ;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static String getValueByKey(String key) {
        for (MyEnum myEnum : MyEnum.values()) {
            if ((key).equals(myEnum.getKey())) {
                return myEnum.value;
            }
        }
        return null;
    }
}
