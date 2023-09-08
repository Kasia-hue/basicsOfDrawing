package edu.km.apka.mvvm;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppUserRepository {

    private AppUserDao appUserDao;
    private LiveData<List<String>> usernames;
    private LiveData<List<AppUser>> allUsers;
    public LiveData<Integer> chapter;
    private int selectedChapter;
    private String username;


    ExecutorService executors = Executors.newSingleThreadExecutor();

    public AppUserRepository(Application application){

        AppUserDatabase appUserDatabase = AppUserDatabase.getInstance(application);
        appUserDao = appUserDatabase.appUserDao();
        usernames = appUserDao.getAllUsernames();
        chapter = appUserDao.selectedChapter(username);
        allUsers = appUserDao.getAllUsers();
        //selectedChapter = appUserDao.selectedChapter(username);

    }

    public void insert (AppUser appUser){
        executors.execute(new Runnable() {
            @Override
            public void run() {
                appUserDao.insert(appUser);
            }
        });

    }

    public void update (AppUser appUser){
        executors.execute(new Runnable() {
            @Override
            public void run() {
                appUserDao.update(appUser);
            }
        });
    }
    //to potem
    public void delete (AppUser appUser){
        executors.execute(new Runnable() {
            @Override
            public void run() {
                appUserDao.delete(appUser);
            }
        });
    }

    public void updateChapterForExistingUser (int chapter, String username){
        executors.execute(new Runnable() {
            @Override
            public void run() {
                appUserDao.updateChapterForExistingUser(chapter,username);
            }
        });
    }
/*
    public int selectedChapter(String username){
        return 0;
    }

 */
//    public void selectedChapter(String username){
//        executors.execute(new Runnable() {
//            @Override
//            public void run() {
//                appUserDao.selectedChapter(username);
//            }
//        });
//    }

    public LiveData<Integer> selectedChapter(String username){return chapter;}

    public LiveData<List<String>> getAllUsernames(){
        return usernames;
    }

    public LiveData<List<AppUser>> getAllUsers(){
        return allUsers;
    }





}
