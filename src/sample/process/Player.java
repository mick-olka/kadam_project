package sample.process;

import sample.process.TaskPackage.Task;

public class Player extends Person{
    long coins = 1000;
    int dailyIncome = 0;

    public Player() {

    }
    public Player(int it_lvl, int biology_lvl, int politics_lvl, int engineering_lvl, int social_lvl, int cash) {
        this.IT_lvl=it_lvl;
        this.engineering_lvl=engineering_lvl;
        this.biology_lvl=biology_lvl;
        this.politics_lvl=politics_lvl;
        this.social_lvl=social_lvl;
        this.coins=cash;
    }

    public void paySalary() {
        if (MainData.monthPassed) {
            for (int i = 0; i < MainData.myTeam.size(); i++) {
                this.coins -= MainData.myTeam.get(i).salary;
            }
        }
    }

    public void getIncome() {
        this.coins+=this.dailyIncome;
    }

    public long getCoins() {
        return this.coins;
    }
    public void setCoins(long c) {
        if (this.coins>0) this.coins = c;
    }
    public void add_coins(long c) {
        this.setCoins(this.coins+c);
    }

    public void updatePlayerStats(Task ac) {
        this.coins+=ac.getPlayerCapital();
    }

    public void updatePlayerChangingStats(Task ac) {
        this.dailyIncome+=ac.getPlayerCapital();
    }
}
