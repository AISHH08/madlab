package com.example.calculatorcomplex;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    TextView tv;
    Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI elements
        e1 = findViewById(R.id.editText1);
        e2 = findViewById(R.id.editText2);
        tv = findViewById(R.id.tv1);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        // Set button click listeners
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub();
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mul();
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                div();
            }
        });
    }

    private boolean validateInput() {
        if (e1.getText().toString().trim().isEmpty() || e2.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void add() {
        if (!validateInput()) return;
        int a1 = Integer.parseInt(e1.getText().toString());
        int a2 = Integer.parseInt(e2.getText().toString());
        int result = a1 + a2;
        tv.setText(String.valueOf(result));
    }

    private void sub() {
        if (!validateInput()) return;
        int a1 = Integer.parseInt(e1.getText().toString());
        int a2 = Integer.parseInt(e2.getText().toString());
        int result = a1 - a2;
        tv.setText(String.valueOf(result));
    }

    private void mul() {
        if (!validateInput()) return;
        int a1 = Integer.parseInt(e1.getText().toString());
        int a2 = Integer.parseInt(e2.getText().toString());
        int result = a1 * a2;
        tv.setText(String.valueOf(result));
    }

    private void div() {
        if (!validateInput()) return;
        float a1 = Float.parseFloat(e1.getText().toString());
        float a2 = Float.parseFloat(e2.getText().toString());
        if (a2 == 0) {
            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            return;
        }
        float result = a1 / a2;
        tv.setText(String.valueOf(result));
    }
}

