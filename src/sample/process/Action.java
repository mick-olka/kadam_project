package sample.process;

import sample.Main;

import java.util.Random;

public class Action {

    public Action(int reg, int time, String txt, int cap, int eco, int pop, int st, int workpop, int pwr, byte war_st, byte wrld_st) {
        this.text=txt;
        this.time=time;
        this.reg=reg;
        this.capital=rand.nextInt(cap);
        this.ecology=rand.nextInt(eco);
        this.power=rand.nextInt(pwr);
        this.population=rand.nextInt(pop);
        this.stab = rand.nextInt(st);
        this.workable=rand.nextInt(workpop);
        this.war_st=war_st;
        this.wrld_st=wrld_st;

    }

    Random rand = new Random();
    String text;

    int time;   // time needed to do for 1 person
    int reg;    // -1-all 0-world[0] 1-world[1] 2-world[2]
    int ecology;
    int power;
    int capital;
    int population;
    int stab;
    int workable;
    byte war_st;
    byte wrld_st;

}
