package edu.km.apka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class TheoryActivity extends AppCompatActivity {

    TextView textViewTheoryTitle, textViewTheoryText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        textViewTheoryTitle = findViewById(R.id.textViewTheoryTitle);
        textViewTheoryText = findViewById(R.id.textViewTheoryText);
        textViewTheoryText.setMovementMethod(new ScrollingMovementMethod());

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
            textViewTheoryTitle.setText(R.string.tools_theory_title);
            textViewTheoryText.setText(R.string.tools_theory_text);
        }else if(shapes){
            textViewTheoryTitle.setText(R.string.shapes_theory_title);
            textViewTheoryText.setText(R.string.shapes_theory_text);
        }else if(stillLife){
            textViewTheoryTitle.setText(R.string.stillLife_theory_title);
            textViewTheoryText.setText(R.string.stillLife_theory_text);
        }else if(landscape) {
            textViewTheoryTitle.setText(R.string.landscape_theory_title);
            textViewTheoryText.setText(R.string.landscape_theory_text);
        }
    }
}