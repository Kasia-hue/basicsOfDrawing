package edu.km.apka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class RefActivity extends AppCompatActivity {

    TextView textViewReferenceTitle;
    GridView gridView;
    ArrayList<Integer> image = new ArrayList<>();

    boolean tools;
    boolean shapes;
    boolean stillLife;
    boolean landscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ref);

        textViewReferenceTitle = findViewById(R.id.textViewReferenceTittle);
        textViewReferenceTitle.setText(R.string.references_title);

        gridView = findViewById(R.id.gridView);

        Intent i = getIntent();
        tools = i.getBooleanExtra("tools", false);

        Intent intent = getIntent();
        shapes = intent.getBooleanExtra("shapes", false);

        Intent iStillLife = getIntent();
        stillLife = iStillLife.getBooleanExtra("stillLife", false);

        Intent isLandscape = getIntent();
        landscape = isLandscape.getBooleanExtra("landscape", false);

        if(tools){
            fillArrayTools();
            GridAdapter adapter = new GridAdapter(this, image);
            gridView.setAdapter(adapter);
        }else if(shapes){
            fillArrayShapes();
            GridAdapter adapter = new GridAdapter(this, image);
            gridView.setAdapter(adapter);
        }else if(stillLife){
            fillArrayStill();
            GridAdapter adapter = new GridAdapter(this, image);
            gridView.setAdapter(adapter);
        }else if(landscape){
            fillArrayLandscape();
            GridAdapter adapter = new GridAdapter(this, image);
            gridView.setAdapter(adapter);
        }
    }

    public void fillArrayTools(){
        image.clear();
        image.add(R.drawable.t1);
        image.add(R.drawable.t2);
        image.add(R.drawable.t3);
        image.add(R.drawable.t4);
        image.add(R.drawable.t5);
    }

    public void fillArrayShapes(){
        image.clear();
        image.add(R.drawable.s1);
        image.add(R.drawable.s2);
        image.add(R.drawable.s3);
        image.add(R.drawable.s4);
        image.add(R.drawable.s5);
        image.add(R.drawable.s6);
        image.add(R.drawable.s7);
        image.add(R.drawable.s8);
        image.add(R.drawable.s9);
        image.add(R.drawable.s10);
        image.add(R.drawable.s11);
        image.add(R.drawable.s12);
    }

    public void fillArrayStill(){
        image.clear();
        image.add(R.drawable.sl0);
        image.add(R.drawable.sl1);
        image.add(R.drawable.sl2);
        image.add(R.drawable.sl3);
        image.add(R.drawable.sl4);
        image.add(R.drawable.sl5);
        image.add(R.drawable.sl6);
        image.add(R.drawable.sl7);
        image.add(R.drawable.sl8);
        image.add(R.drawable.sl9);
    }

    public void fillArrayLandscape(){
        image.clear();
        image.add(R.drawable.l1);
        image.add(R.drawable.l2);
        image.add(R.drawable.l3);
        image.add(R.drawable.l4);
        image.add(R.drawable.l5);
        image.add(R.drawable.l6);
        image.add(R.drawable.l7);
        image.add(R.drawable.l8);
        image.add(R.drawable.l9);
        image.add(R.drawable.l10);
        image.add(R.drawable.l11);
        image.add(R.drawable.l12);
        image.add(R.drawable.l13);
    }

}