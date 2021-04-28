package sample.process;

public class Person {
    int IT_lvl = 0;
    int biology_lvl = 0;
    int politics_lvl = 0;
    int engineering_lvl = 0;
    int social_lvl = 0;

    public Person(int it_lvl, int biology_lvl, int politics_lvl, int engineering_lvl, int social_lvl){
        this.IT_lvl=it_lvl;
        this.engineering_lvl=engineering_lvl;
        this.biology_lvl=biology_lvl;
        this.politics_lvl=politics_lvl;
        this.social_lvl=social_lvl;
    }

    public Person() {
        //
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
