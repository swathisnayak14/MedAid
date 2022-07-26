package com.example.med_aid_app;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.textfield.TextInputLayout;

public class PatientActivity extends AppCompatActivity {
        EditText name,contact,medicine,time;
//    FloatingActionButton fb;
    Button sbmt, fbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        name =  findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        medicine =  findViewById(R.id.medicine);
        time =  findViewById(R.id.time);
        fbtn =  findViewById(R.id.fbtn);
        sbmt = findViewById(R.id.sbmt);

        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert(name.getText().toString(),contact.getText().toString(),medicine.getText().toString(),time.getText().toString());
            }
        });

        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),fetchdata.class));
            }
        });
    }

    private void processinsert(String n, String c, String m, String t) {
        String res=new dbmanager(this).addrecord(n,c,m,t);
        name.setText("");
        contact.setText("");
        medicine.setText("");
        time.setText("");
        Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();

    }
}