package com.deshop.demologinpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class User_Login extends AppCompatActivity {

  CheckBox checkBox;
  EditText numberPhone;
  Button Verify;
  boolean flag = false;
  FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__login);

        checkBox=findViewById(R.id.checkbox);
        numberPhone=findViewById(R.id.etnum);
        Verify=findViewById(R.id.btnsend);
        mAuth=FirebaseAuth.getInstance();

        Verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = numberPhone.getText().toString().trim();
                Intent intent =new Intent(User_Login.this,Verify_Number.class);
                intent.putExtra("Mobile", mobile);
                startActivity(intent);
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String mobile = numberPhone.getText().toString().trim();
                int length=numberPhone.length();

                if (b) {
                    flag=true;
                    Verify.setEnabled(!mobile.isEmpty() && length == 11 && flag == true);
                }

                else {
                    Verify.setEnabled(false);
                    flag = false;
                }

                flag = false;
            }
        });

        numberPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String mobile = numberPhone.getText().toString().trim();
                int length = numberPhone.length();
                if (checkBox.isChecked()){

                    checkBox.setChecked(false);
                    Verify.setEnabled(!mobile.isEmpty() &&  length == 11 && flag == true);
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            SendUserToMainmenu();
        }
    }

    private void SendUserToMainmenu() {

        Intent intent = new Intent(User_Login.this,Register_Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK  | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        finish();

    }
}
