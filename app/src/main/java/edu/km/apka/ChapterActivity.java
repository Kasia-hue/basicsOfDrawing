package edu.km.apka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChapterActivity extends AppCompatActivity {

    Button theory, exercise, ref;
    boolean tools;
    boolean shapes;
    boolean stillLife;
    boolean landscape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        theory = findViewById(R.id.buttonTheory);
        exercise = findViewById(R.id.buttonExercise);
        ref = findViewById(R.id.buttonRef);

        theory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                tools= i.getBooleanExtra("tools", false);

                Intent in = getIntent();
                shapes= in.getBooleanExtra("shapes", false);

                Intent inte = getIntent();
                stillLife = inte.getBooleanExtra("stillLife", false);

                Intent inten = getIntent();
                landscape = inten.getBooleanExtra("landscape", false);

                Intent intent = new Intent(getApplicationContext(), TheoryActivity.class);
                intent.putExtra("tools", tools);
                intent.putExtra("shapes", shapes);
                intent.putExtra("stillLife", stillLife);
                intent.putExtra("landscape", landscape);
                startActivity(intent);
            }
        });

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                tools= i.getBooleanExtra("tools", false);

                Intent in = getIntent();
                shapes= in.getBooleanExtra("shapes", false);

                Intent inte = getIntent();
                stillLife = inte.getBooleanExtra("stillLife", false);

                Intent inten = getIntent();
                landscape = inten.getBooleanExtra("landscape", false);

                Intent intent = new Intent(getApplicationContext(), ExerciseActivity.class);
                intent.putExtra("tools", tools);
                intent.putExtra("shapes", shapes);
                intent.putExtra("stillLife", stillLife);
                intent.putExtra("landscape", landscape);
                startActivity(intent);
            }
        });

        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                tools= i.getBooleanExtra("tools", false);

                Intent in = getIntent();
                shapes= in.getBooleanExtra("shapes", false);

                Intent inte = getIntent();
                stillLife = inte.getBooleanExtra("stillLife", false);

                Intent inten = getIntent();
                landscape = inten.getBooleanExtra("landscape", false);

                Intent intent = new Intent(getApplicationContext(), RefActivity.class);
                intent.putExtra("tools", tools);
                intent.putExtra("shapes", shapes);
                intent.putExtra("stillLife", stillLife);
                intent.putExtra("landscape", landscape);
                startActivity(intent);
            }
        });
    }
}