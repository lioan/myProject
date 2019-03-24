package cn.com.lioan.design.decorator;

public class DecoratorFood {
    public static void main(String[] args){
        Food sandWich =  new Bread(new Vegetable(new Cream(new Food("香肠"))));
        String cooks = sandWich.cook();
        System.out.println("SandWich=" + cooks);
    }
}

/**
 * 如果只有一个ConcreteComponent类，那么可以考虑去掉抽象的Component类（接口）
 * 把Decorator作为一个ConcreteComponent子类
 */
class Food{
    private String foodName;

    public Food(){}

    public Food(String foodName){
        this.foodName = foodName;
    }

    public String cook(){
        return foodName;
    }
}

class Process extends Food{
    private Food food;

    public Process(Food food){
        this.food = food;
    }

    public String cook(){
        return food.cook();
    }
}

class Bread extends Process{
    public Bread(Food food){
        super(food);
    }

    public String cook(){
        String food = super.cook();
        //具体业务代码
        return food + "+面包";
    }
}

class Cream extends Process{
    public Cream(Food food){
        super(food);
    }

    public String cook(){
        String food = super.cook();
        //具体业务代码
        return food + "+奶油";
    }
}

class Vegetable extends Process{
    public Vegetable(Food food){
        super(food);
    }

    public String cook(){
        String food = super.cook();
        //具体业务代码
        return food + "+蔬菜";
    }
}