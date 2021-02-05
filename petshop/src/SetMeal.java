import java.util.Scanner;

public class SetMeal {
    //1:狗 2：猫 3：仓鼠 4:鸟
    private int animal_type;
    //1:犬三联 2：猫三联 3：狂犬疫苗
    private int vaccine_type;
    //1：狗饲料 2：猫饲料 3：仓鼠饲料 4：鸟饲料
    private int feed_type;
    private int feed_num;
    private int animal_num;
    private int vaccine_num;
    private int price;

    private SetMeal (Petshop petshop,int animal_type, int animal_num, int vaccine_type, int vaccine_num,int feed_type,int feed_num) throws Mealexception {
        if(animal_type > animal.Totaltype || animal_type < 1)
            throw new Mealexception(1);
        else if(animal_num < 1)
            throw new Mealexception(2);
        else if(vaccine_type > Vaccine.Totaltype || vaccine_type < 1)
            throw new Mealexception(3);
        else if(vaccine_num < 1)
            throw new Mealexception(4);
        else if(feed_type > feed.Totaltype || feed_type < 1)
            throw new Mealexception(5);
        else if(feed_num < 1)
            throw new Mealexception(6);
        else{
            this.animal_type = animal_type;
            this.animal_num = animal_num;
            this.vaccine_type = vaccine_type;
            this.vaccine_num = vaccine_num;
            this.feed_type = feed_type;
            this.feed_num = feed_num;
            this.price = (int)((petshop.getSell_pricelist()[Petshops.ANIMAL][animal_type]*animal_num + petshop.getSell_pricelist()[Petshops.VACCINE][vaccine_type]*vaccine_num + petshop.getSell_pricelist()[Petshops.FEED][feed_type]*feed_num)*0.9);
        }

    }

    @Override
    public String toString() {
        return "套餐出售：\n  " + this.animal_num + "只" + Petshopobj.select(1,this.animal_type)
                           +"\n  " + this.vaccine_num + "支" + Petshopobj.select(2,this.vaccine_type)
                            + "\n  " + this.feed_num + "袋" + Petshopobj.select(3,this.feed_type)
                            + "\n售价只需：" +this.price + "元";
    }

    public static SetMeal setmeal(Petshop petshop) {
        Scanner scanner = new Scanner(System.in);
        int animal_type = scanner.nextInt();
        int animal_num = scanner.nextInt();
        int vaccine_type = scanner.nextInt();
        int vaccine_num = scanner.nextInt();
        int feed_type = scanner.nextInt();
        int feed_num = scanner.nextInt();
        try {
            return new SetMeal(petshop,animal_type,animal_num,vaccine_type,vaccine_num,feed_type,feed_num);
        }
        catch (Mealexception e){
            System.out.println(e.getMessage());
            return setmeal(petshop);
        }
    }

    public int getAnimal_type() {
        return animal_type;
    }

    public int getVaccine_type() {
        return vaccine_type;
    }

    public int getFeed_type() {
        return feed_type;
    }

    public int getFeed_num() {
        return feed_num;
    }

    public int getAnimal_num() {
        return animal_num;
    }

    public int getVaccine_num() {
        return vaccine_num;
    }

    public int getPrice() {
        return price;
    }
}
class Mealexception extends Exception{
    public static String [] Exceptiontype = {"我是来占位置的！" +
                                                "动物种类输入不在范围内，" + "正确输入范围应是" + 1 + "~" + animal.Totaltype,
                                                "动物数量输入不在范围内，" + "正确输入范围应大于零",
                                                "疫苗种类输入不在范围内，" + "正确输入范围应是" + 1 + "~" + Vaccine.Totaltype,
                                                "疫苗数量输入不在范围内，" + "正确输入范围应大于零",
                                                "饲料种类输入不在范围内，" + "正确输入范围应是" + 1 + "~" + feed.Totaltype,
                                                "饲料数量输入不在范围内，" + "正确输入范围应大于零"};
    public Mealexception(int type) {
        super(Exceptiontype[type]+"\n请重新输入");
    }
}

