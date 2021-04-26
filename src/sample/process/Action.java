package sample.process;

import sample.Main;

import java.util.Random;

public class Action {

    public Action(String txt, int cap, int eco, int pop, int workpop, int pwr, byte war_st, byte wrld_st) {
        this.text=txt;
        this.capital=rand.nextInt(cap);
        this.ecology=rand.nextInt(eco);
        this.power=rand.nextInt(pwr);
        this.population=rand.nextInt(pop);
        this.workable=rand.nextInt(workpop);
        this.war_st=war_st;
        this.wrld_st=wrld_st;
    }

    Random rand = new Random();
    String text;

    int ecology;
    int power;
    int capital;
    int population;
    int workable;
    byte war_st;
    byte wrld_st;

}
