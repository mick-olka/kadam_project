package sample.process.TaskPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//***********************************//
// EXAMPLE OF READING FILE WITH DATA //
//  UNNECESSARY FOR NOW              //
//***********************************//

public class ReadTask {
    static Task tempTask;
    public static Task readTask(int num) {    // READS Task FROM TXT AND WRITE IT IN @tempTask
        try {
            File myObj = new File("src/sample/process/data/Tasks.txt");
            Scanner myReader = new Scanner(myObj);
            int n = -1;
            boolean isInstant;
            String data, taskText;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                if (data.equals("END")) n++;
                else if (!data.isEmpty()) {
                    if (data.charAt(0) != '*')
                        if (n==num) {
                            Task act;
                            taskText=data;  //  first data string with text
                            data=myReader.nextLine();   //  second with bool "isInstant"
                            isInstant= data.equals("1");
                            data=myReader.nextLine();   //  third string with data
                            String[] sDat = data.split(" ");
                            int[] iDat=new int[sDat.length];
                            for (int i=0; i<sDat.length; i++) {
                                iDat[i]=Integer.parseInt(sDat[i]);
                            }
                            act=new Task(iDat[0], iDat[1], taskText, iDat[2], iDat[3], iDat[4], iDat[5],
                                    iDat[6], iDat[7], iDat[8], iDat[9], iDat[10],
                                    iDat[11], iDat[12], iDat[13], iDat[14], isInstant);
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
}
