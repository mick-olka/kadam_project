package sample.process;

public class Region {

    public Region(String name) {
        this.name=name;
    }

    String name = "region";

    int population = 1000;          //
    int workable_population = 300;  //  x 1000
    int capital = 1000;             //

    int ecology = 40;   // 0-100
    int stability = 50; //

    int military_power = 100;

    int war_status = 0;    // 0-peace 1-attacker 2-defender
    int world_status = 0;   // 0-neutral 1-supremacy 2-dependency

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
        if (ecology>=0) this.ecology = ecology;
        if (ecology>100) this.ecology = 100;
        else System.out.println("Count Error");
    }

    public int getWorkable_population() {
        return workable_population;
    }
    public void setWorkable_population(int workable_population) {
        if (workable_population>=0) this.workable_population = workable_population;
        else System.out.println("Count Error");
    }

    public int getWar_status() {
        return war_status;
    }
    public void setWar_status(int war_status) {
        if (war_status>=1&&war_status<=2) this.war_status = war_status;
        else System.out.println("Count Error");
    }

    public int getWorld_status() {
        return world_status;
    }

    public void setWorld_status(int world_status) {
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

    public int getStability() {
        return stability;
    }
    public void setStability(int stability) {
        if (stability>=0) this.stability = stability;
        if (stability>100) this.stability = 100;
        else System.out.println("Count Error");
    }

    public void add_population(int p) {
        this.setPopulation(population+p);
    }
    public void add_workable_population(int p) {
        this.setWorkable_population(workable_population+p);
    }
    public void add_capital(int c) {
        this.setCapital(capital+c);
    }
    public void add_ecology(int e) {
        this.setEcology(ecology+e);
    }
    public void add_power(int p) {
        this.setMilitary_power(military_power+p);
    }
    public void add_stability(int s) {this.setStability(stability+s);}

}
