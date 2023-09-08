package edu.km.apka.mvvm;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "appUser_table")
public class AppUser {
    @PrimaryKey(autoGenerate = true)
    protected int id;

    protected String username;

    protected int chapter =2 ;

    public AppUser(){}

    public AppUser(String username){
        this.username=username;
    }
    public AppUser(String username, int chapter) {
        this.username = username;
        this.chapter = chapter;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


    public int getChapter() {
        return chapter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setChapter(int chapter){this.chapter=chapter;}

    public void setUsername(String username) {
        this.username = username;
    }
}
