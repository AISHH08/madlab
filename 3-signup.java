package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;
public class MainActivity extends AppCompatActivity {
    EditText email_Sign, password_Sign;
    Button signUp_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email_Sign=(EditText)findViewById(R.id.SignUp_email);
        password_Sign=(EditText)findViewById(R.id.SignUp_Password);
        signUp_btn =(Button)findViewById(R.id.signUpBtn);

        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_Sign.getText().toString();
                String password = password_Sign.getText().toString();
                if(!isValidPassword(password)) {
                    Toast.makeText(MainActivity.this,"Password doesn't match rules",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this,loginActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }
    //regular expressions (regex patterns)
    Pattern lowerCase= Pattern.compile("^.*[a-z].*$"); // Checks if the string contains at least one lowercase letter (a-z)
    Pattern upperCase=Pattern.compile("^.*[A-Z].*$"); // Checks if the string contains at least one uppercase letter (A-Z)
    Pattern number = Pattern.compile("^.*[0-9].*$"); // Checks if the string contains at least one digit (0-9)
    Pattern special_Chara = Pattern.compile("^.*[^a-zA-Z0-9].*$"); // Checks if the string contains at least one special character (not a letter or digit)
    private Boolean isValidPassword(String password){
        if(password.length()<8) {
            return false;
        }
        if(!lowerCase.matcher(password).matches()) {
            return false;
        }
        if(!upperCase.matcher(password).matches()) {
            return false;
        }
        if(!number.matcher(password).matches()) {
            return false;
        }
        if(!special_Chara.matcher(password).matches()) {
            return false;
        }
        return true;
    }
}
