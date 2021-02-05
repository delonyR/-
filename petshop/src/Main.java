public class Main {
    public static void main(String[] args) {
        Petshop petshop = new Petshop();
        SetMeal meal = SetMeal.setmeal(petshop);
        petshop.sellmeal(meal);
        Purchase purchase = Purchase.setPurchase(petshop);
        petshop.adopt(new Dog(10,10,3));
    }
}
