package edu.km.apka.mvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AppUserDao {

    @Insert
    void insert(AppUser appUser);
    @Update
    void update(AppUser appUser);

    @Delete
    void delete(AppUser appUser);

    @Query("SELECT username FROM appUser_table")
    LiveData<List<String>> getAllUsernames ();

    @Query("SELECT * FROM appUser_table")
    LiveData<List<AppUser>> getAllUsers();

    @Query("UPDATE appUser_table SET chapter=:chapter WHERE username=:username")
    void updateChapterForExistingUser(int chapter, String username);

    @Query("SELECT chapter FROM appUser_table WHERE username=:username")
    LiveData<Integer> selectedChapter(String username);
//    void selectedChapter(String username);
}
