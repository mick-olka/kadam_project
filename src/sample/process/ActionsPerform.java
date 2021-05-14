package sample.process;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ActionsPerform {

    public static Action tempAction;
    public static void doAction(Action ac) {    //  IMPLEMENT ACTION IN GAME PROCESS
        if (ac.getReg()==-1) {
            for (int i=0; i<MainStep.world.length; i++) updateWorldStats(ac, i);
        } else updateWorldStats(ac, ac.getReg());
    }

    public static void readAction(int num) {    // READS ACTION FROM TXT AND WRITE IT IN @tempAction
        try {
            File myObj = new File("src/sample/process/data/Actions.txt");
            Scanner myReader = new Scanner(myObj);
            int n = -1;
            String data;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                if (data.equals("END")) n++;
                else if (!data.isEmpty()) {
                    if (data.charAt(0) != '*')
                        if (n==num) {
                            System.out.println(data);   //
                            Action act=new Action();
                            act.setText(data);
                            data=myReader.nextLine();
                            System.out.println(data);   // delete
                            String[] sDat = data.split(" ");
                            int[] iDat=new int[sDat.length];
                            for (int i=0; i<sDat.length; i++) {
                                iDat[i]=Integer.parseInt(sDat[i]);
                            }
                            act.setReg(iDat[0]);
                            act.setTime(iDat[1]);
                            act.setCapital(iDat[2]);
                            act.setEcology(iDat[3]);
                            act.setPopulation(iDat[4]);
                            act.setStab(iDat[5]);
                            act.setWorkable(iDat[6]);
                            act.setPower(iDat[7]);
                            act.setWar_st(iDat[8]);
                            act.setWrld_st(iDat[9]);
                            tempAction=act;
                            }
                        }
                }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void updateWorldStats(Action ac, int reg) {
        MainStep.world[reg].add_power(ac.getPower());
        MainStep.world[reg].add_capital(ac.getCapital());
        MainStep.world[reg].add_ecology(ac.getEcology());
        MainStep.world[reg].add_workable_population(ac.getWorkable());
        MainStep.world[reg].add_stability(ac.getStab());
        MainStep.world[reg].add_population(ac.getPopulation());
        MainStep.world[reg].setWorld_status(ac.getWrld_st());
        MainStep.world[reg].setWar_status(ac.getWar_st());
    }
}
