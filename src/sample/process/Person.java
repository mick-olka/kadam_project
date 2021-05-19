package sample.process;

import javafx.scene.layout.VBox;
import sample.process.panes.PersonPane;

public class Person {
    int IT_lvl = 0;
    int biology_lvl = 0;
    int politics_lvl = 0;
    int engineering_lvl = 0;
    int social_lvl = 0;
    int salary = 1000;

    public Person(int it_lvl, int biology_lvl, int politics_lvl, int engineering_lvl, int social_lvl, int salary){
        this.IT_lvl=it_lvl;
        this.engineering_lvl=engineering_lvl;
        this.biology_lvl=biology_lvl;
        this.politics_lvl=politics_lvl;
        this.social_lvl=social_lvl;
        this.salary=salary;
    }

    public Person() {
        //
    }

    public static void addPersonsToGUI(VBox tasksBox) {
        for (int i = 0; i< MainData.myTeam.size(); i++) {
            PersonPane newPane = new PersonPane();
            newPane.setId(String.valueOf(i));       //  set id to pane
            Person person = MainData.myTeam.get(i);
            newPane.setPersonInfo(person);
            tasksBox.getChildren().add(newPane);
        }
    }

    public String getText() {
        return "it/bio/eng/soc/pol: "+this.IT_lvl+"/"+this.biology_lvl+"/"
                +this.engineering_lvl+"/"+this.social_lvl+"/"+this.politics_lvl;
    }

    public void upgrade_IT_lvl() {
        this.IT_lvl=+1;
    }
    public void upgrade_politics_lvl() {
        this.politics_lvl=+1;
    }
    public void upgrade_biology_lvl() {
        this.biology_lvl=+1;
    }
    public void upgrade_engineering_lvl() {
        this.engineering_lvl=+1;
    }
    public void upgrade_social_lvl() {
        this.social_lvl=+1;
    }
}
