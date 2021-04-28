package sample.process;

public class ActionsPerform {

    public static void doAction(Action ac) {
        if (ac.reg==-1) {
            for (int i=0; i<MainStep.world.length; i++) updateWorldStats(ac, i);
        } else updateWorldStats(ac, ac.reg);
    }

    public static void updateWorldStats(Action ac, int reg) {
        MainStep.world[reg].add_power(ac.power);
        MainStep.world[reg].add_capital(ac.capital);
        MainStep.world[reg].add_ecology(ac.ecology);
        MainStep.world[reg].add_workable_population(ac.workable);
        MainStep.world[reg].add_stability(ac.stab);
        MainStep.world[reg].add_population(ac.population);
        MainStep.world[reg].setWorld_status(ac.wrld_st);
        MainStep.world[reg].setWar_status(ac.war_st);
    }
}
