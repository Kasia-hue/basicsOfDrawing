package edu.km.apka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import edu.km.apka.mvvm.AppUser;
import edu.km.apka.mvvm.AppUserViewModel;

public class WelcomeActivity extends AppCompatActivity {

    EditText name, editTextRegister;
    Button start, register;
    AppUserViewModel appUserViewModel, appUserViewModel2;
    boolean an = true ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String registerToast = getResources().getString(R.string.register_toast) ;
        String enterName = getResources().getString(R.string.enter_name) ;
        String added =  getResources().getString(R.string.added) ;
        String another =  getResources().getString(R.string.another) ;

        name = findViewById(R.id.editTextName);
        start = findViewById(R.id.buttonStart);
        register = findViewById(R.id.buttonRegister);
        editTextRegister = findViewById(R.id.editTextRegister);

        appUserViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication())
                .create(AppUserViewModel.class);

        appUserViewModel2 = new ViewModelProvider.AndroidViewModelFactory(getApplication())
                .create(AppUserViewModel.class);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username1 = editTextRegister.getText().toString();
                if(username1.isEmpty()){
                    Toast.makeText(getApplicationContext(), enterName, Toast.LENGTH_SHORT).show();
                }else{
                    appUserViewModel2.getUsernames().observe(WelcomeActivity.this,
                            new Observer<List<String>>() {
                        @Override
                        public void onChanged(List<String> strings) {
                            boolean a = strings.contains(username1);
                            if(!a){
                                an = false;
                            }
                            if(!a){
                                AppUser appUser = new AppUser(username1);
                                appUserViewModel2.insert(appUser);
                                Toast.makeText(getApplicationContext(), added, Toast.LENGTH_SHORT)
                                        .show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.putExtra("name", username1);
                                startActivity(intent);
                                finish();
                            }
                            if (a && an) {
                                    Toast.makeText(getApplicationContext(), another, Toast.LENGTH_SHORT).show();
                                }

                        }
                    });
                }
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();

                if(userName.isEmpty()){
                    Toast.makeText(WelcomeActivity.this, enterName,
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    appUserViewModel.getUsernames().observe(WelcomeActivity.this, new Observer<List<String>>() {
                        @Override
                        public void onChanged(List<String> strings) {
                            if(strings.contains(userName)){
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.putExtra("name",userName);
                                startActivity(intent);
                                finish();
                            }else {
                                Toast.makeText(getApplicationContext(), registerToast, Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
    }
}




