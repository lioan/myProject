package cn.com.lioan.design.decorator;

public class DecoratorSage {

    public static void main(String[] args){
        TheSage fish = new Fish(new Bird(new Mokey()));
        fish.move();
    }
}

/**
 * “大圣本尊”是ConcreteComponent类，而“鸟儿”、“鱼儿”是装饰类。
 * 要装饰的是“大圣本尊”，也即“猢狲”实例。
 */
//抽象构件角色(Component) 齐天大圣
interface TheSage {
    //责任操作
    void  move();
}

//具体构件角色(ConcreteComponent)：将要接收附加责任的类，例如齐天大圣的本尊就是猴子
class Mokey implements TheSage{

    @Override
    public void move() {
        //业务代码
        System.out.println("Monkey move");
    }
}

//装饰角色(Decorator)：持有一个构件对象的实例，定义与抽象构件接口一致的接口
class Change implements TheSage{
    private TheSage sage;

    public Change(TheSage sage){
        this.sage = sage;
    }

    @Override
    public void move() {
        //委派给构件
        sage.move();
    }
}

//具体装饰角色(ConcreteDecorator)：负责给具体构件对象增加或贴上附加的责任
class Fish extends Change {
    public Fish(TheSage sage){
        super(sage);
    }

    public void move(){
        super.move();
        //附件责任操作
        System.out.println("Fish move");
    }
}

class Bird extends Change{
    public Bird(TheSage sage){
        super(sage);
    }

    public void move(){
        super.move();
        //附件责任操作
        System.out.println("Bird move");
    }
}
