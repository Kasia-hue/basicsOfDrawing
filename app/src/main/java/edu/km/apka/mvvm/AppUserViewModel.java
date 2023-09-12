package edu.km.apka.mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AppUserViewModel extends AndroidViewModel {

    private AppUserRepository repository;
    private LiveData<List<String>> usernames;
    private LiveData<List<AppUser>> allUsers;
    public LiveData<Integer> chapter;
//    private AppUser selectedChapter;
    private String username;

    public AppUserViewModel(@NonNull Application application) {
        super(application);

        repository = new AppUserRepository(application);
        usernames = repository.getAllUsernames();
        allUsers = repository.getAllUsers();
        chapter = repository.selectedChapter(username);
    }

    public void insert (AppUser appUser){
        repository.insert(appUser);
    }

    public void update (AppUser appUser){
        repository.update(appUser);
    }

    public void delete (AppUser appUser){
        repository.delete(appUser);
    }

    public void updateChapterForExistingUser (int chapter, String username){
        repository.updateChapterForExistingUser(chapter,username);
    }
/*
    public int selectedChapter(String username){
        return 0;
    }

 */

//    public void selectedChapter(String username){
//        repository.selectedChapter(username);
//    }
    public LiveData<Integer> selectedChapter(String username){return chapter;}

    public LiveData<List<String>> getUsernames(){
        return usernames;
    }

    public LiveData<List<AppUser>> getAllUsers(){
        return allUsers;
    }
}
