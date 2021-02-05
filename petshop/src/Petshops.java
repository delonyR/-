public interface Petshops {
    int ANIMAL = 1;
    int DOG = 1;
    int CAT = 2;
    int HAMSTER = 3;
    int BIRD= 4;
    int VACCINE = 2;
    int DOGSANLIAN = 1;
    int MAOSANLIAN = 2;
    int RABIESVACCINE = 3;
    int FEED = 3;
    int DOGFEED = 1;
    int CATFEED = 2;
    int HAMSTERFEED = 3;
    int BIRDFEED = 4;
    void sellmeal(SetMeal meal);
    void purchase(Purchase purchase);
    void sell(int onelevel,int twolevel,int num);
    int adopt(animal adopted);
}
