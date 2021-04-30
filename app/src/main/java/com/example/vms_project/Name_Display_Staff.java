package com.example.vms_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Name_Display_Staff extends AppCompatActivity {

    Button btn_home;
    ArrayAdapter userSL;
    ListView lv_userList_Display;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_display);
        lv_userList_Display = findViewById(R.id.lv_userList_display);
        btn_home = findViewById(R.id.home_1);

        Intent intent = getIntent();
        String initial = intent.getExtras().getString("initial");
        DatabaseHelper databaseHelper = new DatabaseHelper(Name_Display_Staff.this);
        List<UserModel> getSpecificUserStaff = databaseHelper.getSpecificUserStaff(initial);
        ShowUsersonListView(getSpecificUserStaff);



        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityHome();
                finish();
            }

        });

        lv_userList_Display.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserModel chosenUser = (UserModel) parent.getItemAtPosition(position);
                databaseHelper.signIn(chosenUser);
                ShowUsersonListView(getSpecificUserStaff);
                Toast.makeText(Name_Display_Staff.this, "Updated",Toast.LENGTH_SHORT).show();

            }

        });



    }

    public void openActivityHome() {

        Intent intent = new Intent(this, Initial_Screen.class);
        startActivity(intent);
    }

    private void ShowUsersonListView(List<UserModel> users) {
        userSL = new ArrayAdapter<UserModel>(Name_Display_Staff.this, android.R.layout.simple_list_item_1, users);
        lv_userList_Display.setAdapter(userSL);
    }

}
