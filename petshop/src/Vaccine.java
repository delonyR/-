public abstract class Vaccine extends Petshopobj{
    public static final int Totaltype = 3;

    public static String print() {
        return "疫苗类 1:犬三联 2：猫三联 3：狂犬疫苗";
    }
}
class DogSanlian extends Vaccine{
    private final String name = "犬三联";

    public String getName() {
        return name;
    }

}
class CatSanlian extends Vaccine{
    private final String name = "猫三联";

    public String getName() {
        return name;
    }

}
class RabiesVaccine extends Vaccine{
    private final String name = "狂犬疫苗";

    public String getName() {
        return name;
    }

}