package sample.process.TaskPackage;

import javafx.scene.layout.VBox;
import sample.process.panes.TaskPane;

import java.util.Random;

public class Task {

    public Task() {
        this.name="Task";
        this.time=4;
        this.reg=-1;
        this.workable=500;
        this.text="Info";
        this.population=2000;
        this.stab=50;
        this.ecology=30;
        this.power=100;
        this.war_st=0;
        this.wrld_st=0;
        this.capital=1000;
        this.isInstant=true;
    }

    //  GENERAL TASK WITH ALL PARAMS
    public Task(int reg, int time, String name, String txt,
                int cap, int eco, int pop, int st, int workpop, int pwr,
                int war_st, int wrld_st,
                int IT_lvl_needed,
                int engineering_lvl_needed, int biology_lvl_needed,
                int politics_lvl_needed, int social_lvl_needed, int playerCapital, boolean isInstant) {
        this.text=txt;
        this.time=time;
        this.reg=reg;
        this.capital=cap;
        this.ecology=eco;
        this.power=pwr;
        this.population=pop;
        this.stab = st;
        this.workable=workpop;
        this.war_st=war_st;
        this.wrld_st=wrld_st;
        this.biology_lvl_needed= (byte) biology_lvl_needed;
        this.engineering_lvl_needed= (byte) engineering_lvl_needed;
        this.social_lvl_needed= (byte) social_lvl_needed;
        this.IT_lvl_needed= (byte) IT_lvl_needed;
        this.politics_lvl_needed= (byte) politics_lvl_needed;
        this.isInstant=isInstant;
        this.name=name;
        this.playerCapital=playerCapital;
    }

    //  TASK FOR WORK
    public Task(int time, String name, String txt, int IT_lvl_needed,
                int engineering_lvl_needed, int biology_lvl_needed,
                int politics_lvl_needed, int social_lvl_needed, int playerCapital, boolean isInstant) {
        this.text=txt;
        this.time=time;
        this.reg=-1;
        this.capital=0;
        this.ecology=0;
        this.power=0;
        this.population=0;
        this.stab = 0;
        this.workable=0;
        this.war_st=-5;
        this.wrld_st=-5;
        this.biology_lvl_needed= (byte) biology_lvl_needed;
        this.engineering_lvl_needed= (byte) engineering_lvl_needed;
        this.social_lvl_needed= (byte) social_lvl_needed;
        this.IT_lvl_needed= (byte) IT_lvl_needed;
        this.politics_lvl_needed= (byte) politics_lvl_needed;
        this.isInstant=isInstant;
        this.name=name;
        this.playerCapital=playerCapital;
    }

    public static void addTasksToGUI(VBox tasksBox) {       //  DISPLAY TASKS ON TASKS TAB
        for (int i = 0; i< TasksList.taskList.length; i++) {
            TaskPane newPane = new TaskPane();
            newPane.setId(String.valueOf(i));
            newPane.displayTaskInfo(TasksList.taskList[i]);
            newPane.displayTaskName(TasksList.taskList[i]);
            tasksBox.getChildren().add(newPane);
        }
    }

    String text;
    String name;

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
    private int playerCapital;
    private boolean isInstant;

    private byte IT_lvl_needed = 0;
    private byte biology_lvl_needed = 0;
    private byte politics_lvl_needed = 0;
    private byte engineering_lvl_needed = 0;
    private byte social_lvl_needed = 0;

    public String getText() {
        return text;
    }
    public String getName() {
        return name;
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

    public boolean isInstant() {
        return isInstant;
    }
    public void setInstant(boolean instant) {
        isInstant = instant;
    }
    public byte getIT_lvl_needed() {
        return IT_lvl_needed;
    }
    public void setIT_lvl_needed(byte IT_lvl_needed) {
        this.IT_lvl_needed = IT_lvl_needed;
    }
    public byte getBiology_lvl_needed() {
        return biology_lvl_needed;
    }
    public void setBiology_lvl_needed(byte biology_lvl_needed) {
        this.biology_lvl_needed = biology_lvl_needed;
    }
    public byte getPolitics_lvl_needed() {
        return politics_lvl_needed;
    }
    public void setPolitics_lvl_needed(byte politics_lvl_needed) {
        this.politics_lvl_needed = politics_lvl_needed;
    }
    public byte getEngineering_lvl_needed() {
        return engineering_lvl_needed;
    }
    public void setEngineering_lvl_needed(byte engineering_lvl_needed) {
        this.engineering_lvl_needed = engineering_lvl_needed;
    }
    public byte getSocial_lvl_needed() {
        return social_lvl_needed;
    }
    public void setSocial_lvl_needed(byte social_lvl_needed) {
        this.social_lvl_needed = social_lvl_needed;
    }
    public int getPlayerCapital() {
        return playerCapital;
    }
    public void setPlayerCapital(int playerCapital) {
        this.playerCapital = playerCapital;
    }
}
