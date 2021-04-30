package com.example.vms_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Visitor_Option_Selection extends Activity {

    Button btn_return, btn_new, btn_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visitor_option_selection);

        btn_new = findViewById(R.id.newVisitorbtn);
        btn_return = findViewById(R.id.returnVisbtn);
        btn_home=findViewById(R.id.home_5);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityHome();
                finish();
            }

        });

        btn_new.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitynewVisitor();
                finish();
            }

        });
        btn_return.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityReturn();
                finish();
            }

        });
    }

    public void openActivitynewVisitor() {

        Intent intent = new Intent(this, New_Visitor.class);
        startActivity(intent);
    }

    public void openActivityHome() {

        Intent intent = new Intent(this, Initial_Screen.class);
        startActivity(intent);
    }

    public void openActivityReturn() {

        Intent intent = new Intent(this, Return_Visitor.class);
        startActivity(intent);
    }


}
