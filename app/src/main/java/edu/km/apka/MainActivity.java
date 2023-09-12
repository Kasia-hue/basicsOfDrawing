package edu.km.apka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.km.apka.mvvm.AppUser;
import edu.km.apka.mvvm.AppUserViewModel;

public class MainActivity extends AppCompatActivity {

    TextView textViewWelcome;
    Button tools, shapes, stillLife, landscape;

    boolean isToolsClicked = false;
    boolean isShapesClicked = false;
    boolean isStillLifeClicked = false;
    boolean isLandscapeClicked = false;

    int chapterId;
    int currentChapter;

    AppUser appUser = new AppUser();

    AppUserViewModel appUserViewModel, appUserViewModel1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewWelcome = findViewById(R.id.textViewWelcome);
        tools = findViewById(R.id.buttonTools);
        shapes = findViewById(R.id.buttonShapes);
        stillLife = findViewById(R.id.buttonStillLife);
        landscape = findViewById(R.id.buttonLandscape);

        String hello = getResources().getString(R.string.hello);
        String whatLearn = getResources().getString(R.string.what_learn);

        tools.setEnabled(false);
        shapes.setEnabled(false);
        stillLife.setEnabled(false);
        landscape.setEnabled(false);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");

        textViewWelcome.setText( hello + " " + userName+"! \n\n" + whatLearn);

        appUser.setUsername(userName);

        check(currentChapter);

        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isToolsClicked = true;
                chapterId=2;
                if(currentChapter<chapterId){
                currentChapter=chapterId;}

                Intent intent = new Intent(getApplicationContext(), ChapterActivity.class);
                intent.putExtra("tools", isToolsClicked);
                startActivity(intent);

                isToolsClicked = false;
                check(currentChapter);
            }
        });



        shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isShapesClicked = true;
                chapterId=3;
                if(currentChapter<chapterId){
                    currentChapter=chapterId;}

                Intent intent = new Intent(getApplicationContext(), ChapterActivity.class);
                intent.putExtra("shapes", isShapesClicked);
                startActivity(intent);

                isShapesClicked = false;
                check(currentChapter);
            }
        });

        stillLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isStillLifeClicked = true;

                chapterId=4;
                if(currentChapter<chapterId){
                    currentChapter=chapterId;}

                Intent intent = new Intent(getApplicationContext(), ChapterActivity.class);
                intent.putExtra("stillLife", isStillLifeClicked);
                startActivity(intent);

                isStillLifeClicked = false;
                check(currentChapter);
            }
        });


        landscape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isLandscapeClicked = true;

                Intent intent = new Intent(getApplicationContext(), ChapterActivity.class);
                intent.putExtra("landscape", isLandscapeClicked);
                startActivity(intent);

                isLandscapeClicked = false;
            }
        });
    }

    public void check(int chapter) {
        switch (chapter) {
            case 2: {
                tools.setEnabled(true);
                shapes.setEnabled(true);
                break;
            }
            case 3: {
                tools.setEnabled(true);
                shapes.setEnabled(true);
                stillLife.setEnabled(true);
                break;
            }
            case 4: {
                tools.setEnabled(true);
                shapes.setEnabled(true);
                stillLife.setEnabled(true);
                landscape.setEnabled(true);
                break;
            }
            default:
                tools.setEnabled(true);
        }
    }
}