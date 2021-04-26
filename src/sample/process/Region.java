package sample.process;

public class Region {

    int population = 1000;          //
    int workable_population = 300;  //  x 1000
    int capital = 1000;             //

    int ecology = 40;   // 0-100
    int military_power = 100;

    byte war_status = 0;    // 0-peace 1-attacker 2-defender
    byte world_status = 0;   // 0-neutral 1-supremacy 2-dependency

    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        if (population>=0) this.population = population;
        else System.out.println("Count Error");
    }

    public int getCapital() {
        return capital;
    }
    public void setCapital(int capital) {
        if (capital>=0) this.capital = capital;
        else System.out.println("Count Error");
    }

    public int getEcology() {
        return ecology;
    }
    public void setEcology(int ecology) {
        if (ecology>=0 && ecology<=100) this.ecology = ecology;
        else System.out.println("Count Error");
    }

    public int getWorkable_population() {
        return workable_population;
    }
    public void setWorkable_population(int workable_population) {
        if (workable_population>=0) this.workable_population = workable_population;
        else System.out.println("Count Error");
    }

    public byte getWar_status() {
        return war_status;
    }
    public void setWar_status(byte war_status) {
        if (war_status>=1&&war_status<=2) this.war_status = war_status;
        else System.out.println("Count Error");
    }

    public byte getWorld_status() {
        return world_status;
    }

    public void setWorld_status(byte world_status) {
        if (world_status>=1&&world_status<=2) this.world_status = world_status;
        else System.out.println("Count Error");
    }

    public int getMilitary_power() {
        return military_power;
    }
    public void setMilitary_power(int military_power) {
        if (military_power>=0) this.military_power = military_power;
        else System.out.println("Count Error");
    }

    public void add_population(int p) {
        this.setPopulation(population+p);
    }
    public void reduce_population(int p) {
        this.setPopulation(population-p);
    }

    public void add_workable_population(int p) {
        this.setWorkable_population(workable_population+p);
    }
    public void reduce_workable_population(int p) {
        this.setWorkable_population(workable_population-p);
    }

    public void add_capital(int c) {
        this.setCapital(capital+c);
    }
    public void reduce_capital(int c) {
        this.setCapital(capital-c);
    }

    public void add_ecology(int e) {
        this.setEcology(ecology+e);
    }
    public void reduce_ecology(int e) {
        this.setEcology(ecology-e);
    }

    public void add_power(int p) {
        this.setMilitary_power(military_power+p);
    }
    public void reduce_power(int p) {
        this.setMilitary_power(military_power-p);
    }

    public void set_war_status(byte s) {
        this.setWar_status(s);
    }

    public void set_world_status(byte s) {
        this.setWorld_status(s);
    }

}
