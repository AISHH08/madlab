package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class loginActivity extends AppCompatActivity {
    EditText emailEditText,passwordEditText;
    Button login_btn;
    int counter=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText=(EditText)findViewById(R.id.EmaileditText);
        passwordEditText=(EditText)findViewById(R.id.passEditText);
        login_btn=(Button)findViewById(R.id.loginBtn);

        String registeredEmail = getIntent().getStringExtra("email");
        String registeredPassword= getIntent().getStringExtra("password");

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if(registeredEmail.equals(email) && registeredPassword.equals(password))
                {   Intent intent = new Intent(loginActivity.this, loginsuccessActivity.class);
                   // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // This clears previous activities
                    startActivity(intent);
                }
                else {
                    Toast.makeText(loginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }
                counter--;
                if(counter==0){
                    Toast.makeText(getBaseContext(),"failed to login attempts",Toast.LENGTH_SHORT).show();
                            login_btn.setEnabled(false); //disables a UI component — like a button, textbox, etc.It means the user cannot click or interact with it anymore.
                }
            }
        });
    }
}
