package edu.km.apka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ExerciseActivity extends AppCompatActivity {

    TextView textViewExerciseTitle, textViewExerciseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        textViewExerciseTitle = findViewById(R.id.textViewExerciseTitle);
        textViewExerciseText = findViewById(R.id.textViewExerciseText);
        textViewExerciseText.setMovementMethod(new ScrollingMovementMethod());

        boolean tools;
        boolean shapes;
        boolean stillLife;
        boolean landscape;

        Intent i = getIntent();
        tools = i.getBooleanExtra("tools", false);

        Intent intent = getIntent();
        shapes = intent.getBooleanExtra("shapes", false);

        Intent iStillLife = getIntent();
        stillLife = iStillLife.getBooleanExtra("stillLife", false);

        Intent isLandscape = getIntent();
        landscape = isLandscape.getBooleanExtra("landscape", false);



        if(tools){
            textViewExerciseTitle.setText(R.string.tools_exercise_title);
            textViewExerciseText.setText(R.string.tools_exercise_text);
        }else if(shapes){
            textViewExerciseTitle.setText(R.string.shapes_exercise_title);
            textViewExerciseText.setText(R.string.shapes_exercise_text);
        }else if(stillLife){
            textViewExerciseTitle.setText(R.string.stillLife_exercise_title);
            textViewExerciseText.setText(R.string.stillLife_exercise_text);
        }else if(landscape) {
            textViewExerciseTitle.setText(R.string.landscape_exercise_title);
            textViewExerciseText.setText(R.string.landscape_exercise_text);
        }
    }
}