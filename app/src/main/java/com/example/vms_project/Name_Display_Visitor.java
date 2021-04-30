package com.example.vms_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Name_Display_Visitor extends AppCompatActivity {

    Button btn_home;
    ArrayAdapter userVL;
    ListView lv_userList_Display;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_display);
        lv_userList_Display = findViewById(R.id.lv_userList_display);
        btn_home = findViewById(R.id.home_1);

        Intent intent = getIntent();
        String initial = intent.getExtras().getString("initial");
        DatabaseHelper databaseHelper = new DatabaseHelper(Name_Display_Visitor.this);
        List<UserModel> getSpecificUserVisitor = databaseHelper.getSpecificUserVisitor(initial);

        ShowUsersonListView(getSpecificUserVisitor);



        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityHome();
                finish();
            }

        });


    }

    public void openActivityHome() {

        Intent intent = new Intent(this, Initial_Screen.class);
        startActivity(intent);
    }

    private void ShowUsersonListView(List<UserModel> users) {
        userVL = new ArrayAdapter<UserModel>(Name_Display_Visitor.this, android.R.layout.simple_list_item_1, users);
        lv_userList_Display.setAdapter(userVL);
    }

}
