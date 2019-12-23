package com.deshop.demologinpage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserLogin extends AppCompatActivity {

    ImageView imageView;
    EditText editText,editText1;
    Button button;
    private FirebaseAuth firebaseAuth;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        imageView=findViewById(R.id.imageView);
        editText=findViewById(R.id.editTextEmail);
        editText1=findViewById(R.id.editTextPassword);
        button=findViewById(R.id.buttonLogin);
        progressBar = findViewById(R.id.progressBar);
        firebaseAuth=FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email = editText.getText().toString();
                String password =editText1.getText().toString();

                if (email.isEmpty()){
                    editText.setError("Please enter email id");
                    editText.requestFocus();
                }
                else if (password.isEmpty()){
                    editText1.setError("Please enter your password");
                    editText1.requestFocus();
                }

                else if (email.isEmpty() && password.isEmpty()) {

                    Toast.makeText(UserLogin.this, "Fields are empty!",Toast.LENGTH_SHORT).show();
                }

                else  {

                    firebaseAuth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(UserLogin.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Intent intent = new Intent(UserLogin.this,User_Login.class);
                                startActivity(intent);
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(UserLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();

                            }

                            else {
                                Toast.makeText(UserLogin.this, "Email and Password are not found", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
                }


            }
        });





    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null){
            Intent intent = new Intent(UserLogin.this,MainManu.class);
            startActivity(intent);
            finish();
        }
    }
}
