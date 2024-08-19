package model;

import java.sql.Date;

public class mainTasks
{
 int id;
 String name;
 String description;
 String note;
 boolean isComplete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete)
    {


        isComplete = complete;

    }

    public mainTasks(int id, String name, String description, String note, boolean isComplete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.note = note;
        this.isComplete = isComplete;
    }








}
