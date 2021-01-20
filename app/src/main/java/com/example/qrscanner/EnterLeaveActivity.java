package com.example.qrscanner;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class EnterLeaveActivity extends AppCompatActivity implements View.OnClickListener {

    public static boolean enterSchool = true;
    private Button enteringSchool;
    private Button leavingSchool;
    public static String resultString;
    public static boolean captureActive = false;
    public static boolean clockingIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterleavedesign);
        enteringSchool = findViewById(R.id.enteringbtn);
        leavingSchool = findViewById(R.id.leavingbtn);


        enteringSchool.setOnClickListener(this);
        leavingSchool.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.enteringbtn:
                enterSchool = true;
                break;


            case R.id.leavingbtn:
                enterSchool = false;
                break;
        }

        scanCode();
    }

    private void scanCode() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(CaptureActivity.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scanning Code");
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(result.getContents());
                resultString = result.getContents();
                Intent intent = new Intent(EnterLeaveActivity.this, CaptureActivityResult.class);
                startActivity(intent);
                captureActive = true;

            }
        }
    }
}
