package edu.km.apka.mvvm;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {AppUser.class},version = 1)
public abstract class AppUserDatabase extends RoomDatabase {

    private static AppUserDatabase instance;

    public abstract AppUserDao appUserDao();

    public static synchronized AppUserDatabase getInstance(Context context){
        if (instance==null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),AppUserDatabase.class
                    , "appUser_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            AppUserDao appUserDao = instance.appUserDao();
            ExecutorService executorService = Executors.newSingleThreadExecutor();

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    appUserDao.insert(new AppUser("kasia2", 3));
                }
            });
        }
    };


}
