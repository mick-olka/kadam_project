package sample.process;

public class Player extends Person{
    static long coins = 1000;

    public static long getCoins() {
        return coins;
    }
    public static void setCoins(long c) {
        if (coins>0) coins = c;
    }
    public static void add_coins(long c) {
        setCoins(coins+c);
    }
}
