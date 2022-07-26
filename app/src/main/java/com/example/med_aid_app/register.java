package com.example.med_aid_app;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class register extends AppCompatActivity {
    TextView signup;
    EditText username;
    EditText confirmPassword;
    EditText password;
    DBHelper DB;
    Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirmPassword);
        signup=findViewById(R.id.signup);
        registerBtn=findViewById(R.id.registerBtn);
        DB=new DBHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(register.this,login.class);
                Toast.makeText(register.this, "Welcome to login page", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String repass=confirmPassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(register.this, "Please enter all the details", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkUser=DB.checkusername(user);
                        if(checkUser==false){
                            Boolean insert=DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(register.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),login.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(register.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(register.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }
}