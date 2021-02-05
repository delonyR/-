import java.util.Scanner;

class Purchase {
    //1：动物 2：疫苗 3:饲料(单位：箱）
    private int purchase_type;
    //1:狗 2：猫 3：仓鼠 4:鸟 or 1:犬三联 2：猫三联 3：狂犬疫苗 or 1：狗饲料 2：猫饲料 3：仓鼠饲料 4：鸟饲料
    private int type;
    private int num;
    private int price;
    private static int []typelist = {0,animal.Totaltype,Vaccine.Totaltype,feed.Totaltype};
    private Purchase(Petshop petshop,int purchase_type, int type, int num) throws Purchaseexception{
        if(purchase_type > Petshopobj.Petshopobj_type || purchase_type < 1)
            throw new Purchaseexception(1);
        else if(type > typelist[purchase_type] || type < 1)
            throw new Purchaseexception(2);
        else if(num < 1)
            throw new Purchaseexception(3);
        else{
            this.purchase_type = purchase_type;
            this.type = type;
            this.num = num;
            this.price = petshop.getPurchase_pricelist()[purchase_type][type]*num ;
        }
    }
    public static Purchase setPurchase(Petshop petshop) {
        Scanner scanner = new Scanner(System.in);
        int purchase_type = scanner.nextInt();
        int type = scanner.nextInt();
        int num = scanner.nextInt();
        try {
            return new Purchase(petshop,purchase_type,type,num);
        }
        catch (Purchaseexception e){
            System.out.println(e.getMessage());
            return setPurchase(petshop);
        }
    }

    @Override
    public String toString() {
        return "进货清单：" + Petshopobj.select(purchase_type,type) + num
                + '\n' + "总计：" + this.price + "元";
    }

    public int getPrice() {
        return price;
    }

    public int getPurchase_type() {
        return purchase_type;
    }

    public int getType() {
        return type;
    }

    public int getNum() {
        return num;
    }

    public static int[] getTypelist() {
        return typelist;
    }
}
class Purchaseexception extends Exception{
    //存储种类总数
    public static int[] totaltype ={0,animal.Totaltype,Vaccine.Totaltype,feed.Totaltype};
    public static String [] Exceptiontype = {"我是来占位置的！" +
            "进货分类输入不在范围内，" + "正确输入范围应是" + Petshopobj.print(),
            "进货种类输入不在范围内，" + "正确输入范围应是" + animal.print() + "\n" + Vaccine.print() + "\n" + feed.print(),
            "进货数量输入不在范围内，" + "正确输入范围应大于零"
    };
    public Purchaseexception(int type) {
        super(Exceptiontype[type]+"\n请重新输入");

    }
}