package sample.process;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TasksPerform {

    public static Task tempTask = new Task();

    public static void taskDone(int id) {
        doTask(readTask(id));
    }

    public static void doTask(Task ac) {    //  IMPLEMENT Task IN GAME PROCESS
        if (ac.getReg()==-1) {
            for (int i=0; i<MainData.world.length; i++) updateWorldStats(ac, i);
        } else updateWorldStats(ac, ac.getReg());
    }

    public static Task readTask(int num) {    // READS Task FROM TXT AND WRITE IT IN @tempTask
        try {
            File myObj = new File("src/sample/process/data/Tasks.txt");
            Scanner myReader = new Scanner(myObj);
            int n = -1;
            boolean isInstant;
            String data;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                if (data.equals("END")) n++;
                else if (!data.isEmpty()) {
                    if (data.charAt(0) != '*')
                        if (n==num) {
                            //System.out.println(data);   //
                            Task act=new Task();
                            act.setText(data);  //  first data string with text
                            data=myReader.nextLine();   //  second with bool "isInstant"
                            isInstant= data.equals("1");
                            act.setInstant(isInstant);
                            data=myReader.nextLine();   //  third string with data
                            System.out.println(data);   //
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
                            tempTask =act;
                            return act;
                            }
                        }
                }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return tempTask;
    }

    public static int getTasksCount() {
        int count=-1;
        try {
            File myObj = new File("src/sample/process/data/Tasks.txt");
            Scanner myReader = new Scanner(myObj);
            String data;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                if (data.equals("END")) count++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return count;
    }

    public static void updateWorldStats(Task ac, int reg) {
        MainData.world[reg].updateWorldStats(ac);
    }
    public static void updateWorldChangingStats(Task ac, int reg) {
        MainData.world[reg].updateWorldChangingStats(ac);
    }
}
