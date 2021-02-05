public abstract class feed extends Petshopobj{
    public static final int Totaltype = 4;

    public static String print() {
        return "饲料类 1：狗饲料 2：猫饲料 3：仓鼠饲料 4：鸟饲料";
    }
}
class Dogfeed extends feed{
    //一箱24袋

}
class Birdfeed extends feed{
    //一箱24袋

}
class Catfeed extends feed{
    //一箱24袋

}
class Hamsterfeed extends feed{
    //一箱24袋

}