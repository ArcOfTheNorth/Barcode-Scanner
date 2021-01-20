    package com.example.qrscanner;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class CaptureActivityResult extends AppCompatActivity {
    Button AddData;
    TextView barcodeint;
    TextView name;
    TextView clockingView;
    ListView listView;

    DataBaseHelper dataBaseHelper;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle readInstanceState) {


        super.onCreate(readInstanceState);
        setContentView(R.layout.capturedesign);
        barcodeint = findViewById(R.id.barcodeInt2);
        barcodeint.setText(EnterLeaveActivity.resultString);
        name = findViewById(R.id.nameId);
        AddData = findViewById(R.id.button_add);
        clockingView = findViewById(R.id.clockingView);
        listView = findViewById(R.id.List_view);


        if(EnterLeaveActivity.enterSchool == true){
            clockingView.setText("Entering School");
        }else if(EnterLeaveActivity.enterSchool == false) {
            clockingView.setText("Leaving School");
        }

         dataBaseHelper = new DataBaseHelper(CaptureActivityResult.this);
         arrayList = dataBaseHelper.getAllText();
         arrayAdapter = new ArrayAdapter(CaptureActivityResult.this, android.R.layout.simple_list_item_1, arrayList);

         listView.setAdapter(arrayAdapter);


        AddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text =name.getText().toString();
                if (!text.isEmpty()){
                    if (dataBaseHelper.addText(text,text)){
                        name.setText("");
                        Toast.makeText(getApplicationContext(),"Data Inserted..."
                        ,Toast.LENGTH_SHORT).show();
                        arrayList.clear();
                        arrayList.addAll(dataBaseHelper.getAllText());
                        arrayAdapter.notifyDataSetChanged();
                        listView.invalidateViews();
                        listView.refreshDrawableState();
                    }
                }
            }
        });

        }



        }


