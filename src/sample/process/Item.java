package sample.process;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.MenuItem;

public class Item extends MenuItem {    //  это пока не нужно
    private final String name ;
    private final StringProperty details = new SimpleStringProperty() ;

    public Item(String name, String details) {
        this.name = name ;
        setDetails(details) ;
    }

    public String getName() {
        return name ;
    }

    @Override
    public String toString() {
        return getName();
    }

    public final StringProperty detailsProperty() {
        return this.details;
    }


    public final String getDetails() {
        return this.detailsProperty().get();
    }


    public final void setDetails(final String details) {
        this.detailsProperty().set(details);
    }



}
