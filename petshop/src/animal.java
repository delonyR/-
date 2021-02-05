import java.awt.*;

public abstract class animal extends Petshopobj{
     int weight ;
     int height;
     //0:死亡 1：生病 2：良好 3：极其健康
     int health;
     public static final int Totaltype = 4;
    public animal(int weight, int height, int health) {
        this.weight = weight;
        this.height = height;
        this.health = health;
    }

    public static String print() {
        return "动物类  1:狗 2：猫 3：仓鼠 4:鸟";
    }
}
class Dog extends animal{
    public Dog(int weight, int height, int health) {
        super(weight, height, health);
    }
}
class Cat extends animal{
    public Cat(int weight, int height, int health) {
        super(weight, height, health);
    }
}
class Hamster extends animal{ ;
    public Hamster(int weight, int height, int health) {
        super(weight, height, health);
    }
}
class Bird extends animal{
    public Bird(int weight, int height, int health) {
        super(weight, height, health);
    }

}
