package cn.com.lioan.testEnum;

public enum TestEnum {

    FRANK("The given name of me"),
    LIU("The family name of mime");

    private String context;

    private TestEnum() {
    }

    private TestEnum(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public static void main(String[] args) {
        for (TestEnum name : TestEnum.values()) {
            System.out.println(name.toString());
            System.out.println(name + "  " + name.getContext() + "  " + name.context);
            System.out.println(name.ordinal());
        }

        System.out.println(TestEnum.FRANK.getDeclaringClass());
    }
}

