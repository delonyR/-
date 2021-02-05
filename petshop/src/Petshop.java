import java.util.ArrayList;
import java.util.List;

public class Petshop implements Petshops {
    //动物类单位：只 疫苗类单位：支 饲料单位：袋(进货时为箱）
    private int money = 5000;
    private int[][] warehouse = {{0,10,10,20,5},{0,2,1,2},{0,100,50,20,20}};
    private int[][] purchase_pricelist = {{0,300,200,20,500},{0,20,15,50},{0,360,240,120,120}};
    private int[][] sell_pricelist = {{0,500,450,50,800},{0,60,30,100},{0,30,20,10,10}};
    private static boolean[] space= new boolean[40];
    private static final int SPACE = 40;
    private static Adoption[] adopted = new Adoption[SPACE];
    private static final int FAILURE = -1;
    @Override
    public void sellmeal(SetMeal meal) {
        if(warehouse[Petshops.ANIMAL][meal.getAnimal_type()] > meal.getAnimal_num() && warehouse[Petshops.VACCINE][meal.getVaccine_type()] > meal.getVaccine_num() && warehouse[Petshops.FEED][meal.getFeed_type()] > meal.getFeed_num()){
            warehouse[Petshops.ANIMAL][meal.getAnimal_type()] -= meal.getAnimal_num();
            warehouse[Petshops.VACCINE][meal.getVaccine_type()] -= meal.getVaccine_num();
            warehouse[Petshops.FEED][meal.getFeed_type()] -= meal.getFeed_num();
            this.money += meal.getPrice();
        }
        else System.out.println("有内鬼（没货了），交易取消！");
    }

    @Override
    public void purchase(Purchase purchase) {
        if(this.money > purchase.getPrice()){
            warehouse[purchase.getPurchase_type()][purchase.getType()] += purchase.getNum();
            this.money -= purchase.getPrice();
        }
        else System.out.println("有内鬼（没钱了），交易取消！");
    }

    @Override
    public void sell(int onelevel,int twolevel,int num) {
        warehouse[onelevel][twolevel] -= num;
        this.money += sell_pricelist[onelevel][twolevel] * num;
    }

    @Override
    public int adopt(animal adoptor){
        try{
            Adoption newadoptor = new Adoption(adoptor);
            adopted[newadoptor.code] = newadoptor;
            return newadoptor.code;
        }catch (Adoptexception e){
          System.out.println(e.getMessage());
        }

        return FAILURE;
    }

    class Adoption{
        private int code = -1;
        private animal adopted;

        public Adoption(animal adopted) throws Adoptexception{

            for(int i = 0;i < SPACE;i++)
                if(!space[i])
                    this.code = i;
            if(this.code == -1) throw new Adoptexception();
            else
                this.adopted = adopted;
        }

    }

    public int[][] getPurchase_pricelist() {
        return purchase_pricelist;
    }

    public int[][] getSell_pricelist() {
        return sell_pricelist;
    }
}
class Adoptexception extends Exception{
    public Adoptexception() {
        super("爆仓咯！莫得地方住咯！");
    }
}

