package sample.process;

import sample.process.TaskPackage.Task;

public class Region {

    public Region(String name) {
        this.name=name;
    }
    String name;

    private float population = 1000;          //
    private float workable_population = 300;  //  x 1000
    private float capital = 1000;             //

    private float population_change = 1;
    private float work_population_change = 0.5f;
    private float ecology_change = -1;
    private float stability_change = -1;
    private float power_change = 0.1f;
    private float capital_change = 0.1f;

    private float ecology = 40;   // 0-100
    private float stability = 50; //

    private int military_power = 100;

    private int war_status = 0;    // 0-peace 1-attacker 2-defender
    private int world_status = 0;   // 0-neutral 1-supremacy 2-dependency

    public int getPopulation() {
        return (int) population;
    }
    void setPopulation(int population) {
        if (population>=0) this.population = population;
        else this.population=0;
    }
    public int getCapital() {
        return (int) capital;
    }
    void setCapital(int capital) {
        if (capital>=0) this.capital = capital;
        else this.capital=0;
    }
    public int getEcology() {
        return (int) ecology;
    }
    void setEcology(int ecology) {
        if (ecology>=0) this.ecology = ecology;
        else this.ecology=0;
        if (ecology>100) this.ecology = 100;
    }

    public int getWorkable_population() {
        return (int) workable_population;
    }
    public void setWorkable_population(int workable_population) {
        if (workable_population>=0) this.workable_population = workable_population;
        else this.workable_population=0;
    }
    public int getWar_status() {
        return war_status;
    }
    public void setWar_status(int war_status) {
        if (war_status==0||war_status==1||war_status==2) this.war_status = war_status;
    }
    public int getWorld_status() {
        return world_status;
    }
    public void setWorld_status(int world_status) {
        if (world_status==0||world_status==1||world_status==2) this.world_status = world_status;
    }
    public int getMilitary_power() {
        return military_power;
    }
    public void setMilitary_power(int military_power) {
        if (military_power>=0) this.military_power = military_power;
        else this.military_power=0;
    }
    public int getStability() {
        return (int) stability;
    }
    void setStability(int stability) {
        if (stability>=0) this.stability = stability;
        else this.stability=0;
        if (stability>100) this.stability = 100;
    }

    public void add_population(int p) {
        this.population+=p;
    }
    public void add_workable_population(int p) {
        this.workable_population+=p;
    }
    public void add_capital(int c) {
        this.capital+=c;
    }
    public void add_ecology(int e) {
        this.ecology+=e;
    }
    public void add_power(int p) {
        this.military_power+=p;
    }
    public void add_stability(int s) {this.stability+=s;}

    public float get_population_change() {
        return population_change;
    }
    public void add_population_change(float population_change) {
        this.population_change += population_change;
    }
    public float get_work_population_change() {
        return work_population_change;
    }
    public void add_work_population_change(float work_population_change) {
        this.work_population_change += work_population_change;
    }
    public float get_ecology_change() {
        return ecology_change;
    }
    public void add_ecology_change(float ecology_change) {
        this.ecology_change += ecology_change;
    }
    public float get_stability_change() {
        return stability_change;
    }
    public void add_stability_change(float stability_change) {
        this.stability_change += stability_change;
    }
    public float get_power_change() {
        return power_change;
    }
    public void add_power_change(float power_change) {
        this.power_change += power_change;
    }
    public float get_capital_change() {
        return capital_change;
    }
    public void add_capital_change(float capital_change) {
        this.capital_change += capital_change;
    }

    public void addRegionStats(Task task) {
        this.add_power(task.getPower());
        this.add_capital(task.getCapital());
        this.add_ecology(task.getEcology());
        this.add_workable_population(task.getWorkable());
        this.add_stability(task.getStab());
        this.add_population(task.getPopulation());
        this.setWorld_status(task.getWrld_st());
        this.setWar_status(task.getWar_st());
    }
    public void addRegionChangingStats(Task ac) {
        this.add_power_change(ac.getPower());
        this.add_capital_change(ac.getCapital());
        this.add_ecology_change(ac.getEcology());
        this.add_work_population_change(ac.getWorkable());
        this.add_stability_change(ac.getStab());
        this.add_population_change(ac.getPopulation());
        this.setWorld_status(ac.getWrld_st());
        this.setWar_status(ac.getWar_st());
        System.out.println("changing stats modified");
    }

    public void updateRegionStats() {
        this.population+=population_change;
        this.ecology+=ecology_change;
        this.stability+=stability_change;
        this.capital+=capital_change;
        this.workable_population+=work_population_change;
        this.military_power+=power_change;
    }
}
