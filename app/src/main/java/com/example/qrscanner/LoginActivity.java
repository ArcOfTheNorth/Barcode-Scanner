package com.example.qrscanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button lgnbtn;
    private TextView usernameinput;
    private TextView passwordinput;
    private TextView incorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.logindesign);
        lgnbtn = findViewById(R.id.loginbtn);
        usernameinput = findViewById(R.id.usernameinput);
        passwordinput = findViewById(R.id.passwordinput);
        incorrect = findViewById(R.id.incorrectinfo);

    lgnbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(usernameinput.getText().toString().equals("admin") && passwordinput.getText().toString().equals("admin")) {

                Intent intent = new Intent(LoginActivity.this, EnterLeaveActivity.class);
                startActivity(intent);
                incorrect.setText("");
            } else {
                incorrect.setText("Incorrect username or password");
            }
        }
    });



    }

}
