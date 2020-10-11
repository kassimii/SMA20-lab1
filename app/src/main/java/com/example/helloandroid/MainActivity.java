package com.example.helloandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText eName;
    private Button bClick, positiveButton, negativeButton;
    private TextView tName, tNameDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sayHello();
    }

    public void sayHello(){
        eName = (EditText)findViewById(R.id.eName);
        bClick = (Button)findViewById(R.id.bClick);
        //tName = (TextView)findViewById(R.id.tName);

        bClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eName.getText().toString();
                String greeting = "Hello " + name;
//                tName.setText(greeting);
                createDialog(greeting);
            }
        });
    }

    public void createDialog(String greeting){
        final Dialog myDialog = new Dialog(MainActivity.this);
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        myDialog.setContentView(R.layout.dialog);

        tNameDialog = (TextView)myDialog.findViewById(R.id.tNameDialog);
        positiveButton = (Button)myDialog.findViewById(R.id.positiveButton);
        negativeButton = (Button)myDialog.findViewById(R.id.negativeButton);

        tNameDialog.setEnabled(true);
        positiveButton.setEnabled(true);
        negativeButton.setEnabled(true);

        tNameDialog.setText(greeting);

        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Be positive!", Toast.LENGTH_SHORT).show();
            }
        });

        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Don't be negative!", Toast.LENGTH_SHORT).show();
            }
        });

        myDialog.show();
    }

//    public void clicked(View view){
//        eName = (EditText)findViewById(R.id.eName);
//        bClick = (Button)findViewById(R.id.bClick);
//        tName = (TextView)findViewById(R.id.tName);
//
//        switch(view.getId()){
//            case R.id.bClick:
//                String name = eName.getText().toString();
//                String greeting = "Hi " + name;
//                tName.setText(greeting);
//                break;
//
//        }
//    }


}