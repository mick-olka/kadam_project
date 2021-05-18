package sample.process;

public class MainData {
    public static Region[] world = {new Region("First"), new Region("Second"), new Region("Third")};

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
