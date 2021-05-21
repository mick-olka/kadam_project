package sample.process;

import sample.process.TaskPackage.Task;
import sample.process.TaskPackage.TasksPerform;

import java.util.ArrayList;

//*******************************//
// CLASS FOR STORING MAIN DATA   //
//*******************************//

public class MainData {

    public static Region[] world = {new Region("Nikolaev"), new Region("Arken"), new Region("Domok")};

    public static ArrayList<TasksPerform> chosenTasks = new ArrayList<>();

    public static ArrayList<Person> myTeam = new ArrayList<>();

    public static void initMainData() {     //  INIT GAME STATE FOR TESTING
        myTeam.add(new Person(1, 2, 3, 2,3, 5000));
        myTeam.add(new Person(5, 2, 3, 2,3, 1000));
    }

    public static void setTaskToPerform(Task task) {    //  CHOOSE TASK TO PERFORM
        chosenTasks.add(new TasksPerform(task));
    }

    public static void updateWorldStats() {
        for (Region region : world) {
            region.updateRegionStats();
        }
    }

    public static int getWorldPopulation() {
        int population=0;
        for (Region region : world) {
            population += region.getPopulation();
        }
        return (population/world.length);
    }

    public static int getWorldStability() {
        int n=0;
        for (Region region : world) {
            n += region.getStability();
        }
        return (n/world.length);
    }

    public static int getWorldEcology() {
        int n=0;
        for (Region region : world) {
            n += region.getEcology();
        }
        return (n/world.length);
    }
}
