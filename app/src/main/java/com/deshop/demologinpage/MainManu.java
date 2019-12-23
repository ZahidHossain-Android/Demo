package com.deshop.demologinpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainManu extends AppCompatActivity {
    Button logout,update;
    FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_manu);
        logout= findViewById(R.id.logout_button_id);
        mauth= FirebaseAuth.getInstance();

        update=findViewById(R.id.update_Information_button);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainManu.this,UpdateInformation.class);
                startActivity(intent);
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mauth.signOut();
                Intent intent = new Intent(MainManu.this,UserLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
