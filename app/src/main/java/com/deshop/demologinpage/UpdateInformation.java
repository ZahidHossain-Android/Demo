package com.deshop.demologinpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateInformation extends AppCompatActivity {

    EditText fullName,FatherName,MotherName,NID,Address;
    Button addfire;
    TextView displayview;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference requestRF = db.getReference("User");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_information);


        fullName=findViewById(R.id.editname);
        FatherName=findViewById(R.id.editfather);
        MotherName=findViewById(R.id.editmother);
        NID=findViewById(R.id.editNID);
        Address=findViewById(R.id.editaddress);
        addfire=findViewById(R.id.Submit);
        displayview=findViewById(R.id.display_id);


        addfire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_fullName = fullName.getText().toString();
                String user_fatherName = FatherName.getText().toString();
                String user_motherName = MotherName.getText().toString();
                String user_nidnumber = NID.getText().toString();
                String user_address = Address.getText().toString();

                if (!TextUtils.isEmpty(user_fullName)
                        && !TextUtils.isEmpty(user_fatherName)
                        && !TextUtils.isEmpty(user_motherName)
                        && !TextUtils.isEmpty(user_nidnumber)
                        && !TextUtils.isEmpty(user_address) ||user_nidnumber.length() == 10 || user_nidnumber.length() == 17  ){


                    AddData sendData = new AddData(user_fullName,user_fatherName,user_motherName,user_nidnumber,user_address);
                    requestRF.push().setValue(sendData);

                    Toast.makeText(UpdateInformation.this, "Add Successful", Toast.LENGTH_SHORT).show();

                    fullName.setText("");
                    FatherName.setText("");
                    MotherName.setText("");
                    NID.setText("");
                    Address.setText("");

                }else {

                    Toast.makeText(UpdateInformation.this, "Error found", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}
