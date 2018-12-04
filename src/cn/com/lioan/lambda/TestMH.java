package cn.com.lioan.lambda;

public class TestMH {

    @FunctionalInterface
    interface IConvert<F,T>{
        T convert(F from);
    }

    public static void main(String[] args) {
        //集合中应用
        /*List<String> al = Arrays.asList("a","b","c","d");
        al.forEach(AcceptMethod::printValue);
        System.out.println("----------------consumer-------------------");
        Consumer<String> consumer = AcceptMethod::printValue;
        al.forEach(consumer);
        System.out.println("----------------other----------------------");
        al.forEach(x -> AcceptMethod.printValue(x));
        System.out.println("----------------other多余----------------------");
        al.forEach(x -> consumer.accept(x));*/

        //自定义应用
        //调用静态方法
        IConvert<String, String> convert = SomeThing::startsWith;
        System.out.println(convert.convert("abc"));

        //调用对象方法
        convert = new SomeThing()::endWith;
        System.out.println(convert.convert("JAVA"));

        //调用构造方法 返回一个具体实例
        IConvert<String, SomeThing> convertn = SomeThing::new;
        SomeThing someThing = convertn.convert("constructors");
        someThing.endWith();
    }
}

class AcceptMethod {
    public static void printValue(String str) {
        System.out.println("print value :" + str);
    }
}

class SomeThing {
    SomeThing(){}

    SomeThing(String something) {
        System.out.println(something);
    }

    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    String endWith(String s) {
        return String.valueOf(s.charAt(s.length()-1));
    }

    void endWith() {
        System.out.println("void endWith");
    }
}