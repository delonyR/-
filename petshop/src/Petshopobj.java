public abstract class Petshopobj {
    public static int Petshopobj_type = 3;

    public static String print() {
        return "1：动物类 2：疫苗类 3：饲料类" ;
    }
    public static String select(int one_level,int two_level){
        switch (one_level){
            case 1:return animal_type(two_level);
            case 2:return vaccine_type(two_level);
            case 3:return feed_type(two_level);
        }
        return null;
    }
    private static String animal_type(int type){
        switch (type){
            case 1: return "狗";
            case 2: return "猫";
            case 3: return "仓鼠";
            case 4: return "鸟";
        }
        return null;
    }
    private static String vaccine_type(int type){
        switch (type){
            case 1: return "犬三联";
            case 2: return "猫三联";
            case 3: return "狂犬疫苗";
        }
        return null;
    }
    private static String feed_type(int type){
        switch (type){
            case 1: return "狗饲料";
            case 2: return "猫饲料";
            case 3: return "仓鼠饲料";
            case 4: return "鸟饲料";
        }
        return null;
    }
}
