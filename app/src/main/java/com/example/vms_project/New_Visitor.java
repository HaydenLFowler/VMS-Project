package com.example.vms_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class New_Visitor extends Activity {

    Button btn_home, btn_submit;
    EditText name;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_visitor);


        btn_home = findViewById(R.id.home_3);
        btn_submit = findViewById(R.id.btn_submit);
        name = findViewById(R.id.enterNameTV);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityHome();
                finish();
            }

        });


        databaseHelper = new DatabaseHelper(New_Visitor.this);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserModel userModel;

                try {
                    userModel = new UserModel(-1, name.getText().toString(), "Visitor", "False");
                    Toast.makeText(New_Visitor.this, "User succesfully added", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(New_Visitor.this, "Error adding user", Toast.LENGTH_SHORT).show();
                    userModel = new UserModel(-1, "error", "", "false");
                }

                DatabaseHelper databaseHelper = new DatabaseHelper(New_Visitor.this);

                boolean success = databaseHelper.addOneVisitor(userModel);



            }
        });
    }

        public void openActivityHome() {

            Intent intent = new Intent(this, Initial_Screen.class);
            startActivity(intent);
        }

        /**Spinner staticSpinner = (Spinner) findViewById(R.id.static_spinner);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.visit_reason,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);

        /*Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);

        String[] items = new String[] { "Grounds", "Gas", "Construction" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);

        dynamicSpinner.setAdapter(adapter);

        dynamicSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });*/
    }
