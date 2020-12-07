package Project10_Vlad.Books;

import java.util.Random;

public enum Categories {


    WORLD_CLASSICS(1), NOVELS(2), LITERATURE(3), EARLY_AGE(4), GENERAL(5),
    MATH(6), SCIENCE(7), SOCIAL(8), HISTORICAL(9),REFFERANCE(10);
    private int category;

    //////////////   Constructor   ///////////////////
    Categories(int category) {
        this.category = category;
    }

    /////////////  getCategory    ///////////////////////////
    public int getTax() {
        return this.category;
    }

    public static int random() {

        Random random = new Random();
        int rand = random.nextInt(5);
        return  rand;
    }
}