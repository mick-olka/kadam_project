package sample.process;

import com.sun.javaws.IconUtil;
import sample.Main;

import java.util.Random;

public class Action {

    public Action() {
        this.time=4;
        this.reg=-1;
        this.workable=500;
        this.text="Action";
        this.population=2000;
        this.stab=50;
        this.ecology=30;
        this.power=100;
        this.war_st=0;
        this.wrld_st=0;
        this.capital=1000;
    }

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

    private int time;   // time needed to do for 1 person
    private int reg;    // -1-all 0-world[0] 1-world[1] 2-world[2]
    private int ecology;
    private int power;
    private int capital;
    private int population;
    private int stab;
    private int workable;
    private int war_st;
    private int wrld_st;

    public String getText() {
        return text;
    }

    public int getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public int getEcology() {
        return ecology;
    }

    public int getWar_st() {
        return war_st;
    }

    public int getPower() {
        return power;
    }

    public int getReg() {
        return reg;
    }

    public int getWrld_st() {
        return wrld_st;
    }

    public int getStab() {
        return stab;
    }

    public int getTime() {
        return time;
    }

    public int getWorkable() {
        return workable;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setEcology(int ecology) {
        this.ecology = ecology;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setReg(int reg) {
        this.reg = reg;
    }

    public void setStab(int stab) {
        this.stab = stab;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setWar_st(int war_st) {
        this.war_st = war_st;
    }

    public void setWorkable(int workable) {
        this.workable = workable;
    }

    public void setWrld_st(int wrld_st) {
        this.wrld_st = wrld_st;
    }

    public void showAction() {
        System.out.println(text);
        System.out.println(time);
        System.out.println(capital);
    }
}
