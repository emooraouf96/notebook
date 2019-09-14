package com.example.android.notebook;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
     private int id;
     private int priority;
     private String title;
     private String Desc;

     public Note(){}

    public Note(int priority, String title, String desc) {
        this.priority = priority;
        this.title = title;
        Desc = desc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
