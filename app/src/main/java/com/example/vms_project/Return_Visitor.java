package com.example.vms_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Return_Visitor extends Activity implements View.OnClickListener {

    Button btn_home;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.return_visitor);
        databaseHelper = new DatabaseHelper(Return_Visitor.this);

        btn_home = findViewById(R.id.home_2);


        Button a = findViewById(R.id.btnA);
        a.setOnClickListener(this);
        Button b = findViewById(R.id.btnBv);
        b.setOnClickListener(this);
        Button c = findViewById(R.id.btnCv);
        c.setOnClickListener(this);
        Button d = findViewById(R.id.btnDv);
        d.setOnClickListener(this);
        Button e = findViewById(R.id.btnEv);
        e.setOnClickListener(this);
        Button f = findViewById(R.id.btnFv);
        f.setOnClickListener(this);
        Button g = findViewById(R.id.btnGv);
        g.setOnClickListener(this);
        Button h = findViewById(R.id.btnHv);
        h.setOnClickListener(this);
        Button i = findViewById(R.id.btnIv);
        i.setOnClickListener(this);
        Button j = findViewById(R.id.btnJv);
        j.setOnClickListener(this);
        Button k = findViewById(R.id.btnKv);
        k.setOnClickListener(this);
        Button l = findViewById(R.id.btnLv);
        l.setOnClickListener(this);
        Button m = findViewById(R.id.btnMv);
        m.setOnClickListener(this);
        Button n = findViewById(R.id.btnNv);
        n.setOnClickListener(this);
        Button o = findViewById(R.id.btnOv);
        o.setOnClickListener(this);
        Button p = findViewById(R.id.btnPv);
        p.setOnClickListener(this);
        Button q = findViewById(R.id.btnQv);
        q.setOnClickListener(this);
        Button r = findViewById(R.id.btnRv);
        r.setOnClickListener(this);
        Button s = findViewById(R.id.btnSv);
        s.setOnClickListener(this);
        Button t = findViewById(R.id.btnTv);
        t.setOnClickListener(this);
        Button u = findViewById(R.id.btnUv);
        u.setOnClickListener(this);
        Button v = findViewById(R.id.btnVv);
        v.setOnClickListener(this);
        Button w = findViewById(R.id.btnWv);
        w.setOnClickListener(this);
        Button x = findViewById(R.id.btnXv);
        x.setOnClickListener(this);
        Button y = findViewById(R.id.btnYv);
        y.setOnClickListener(this);
        Button z = (Button) findViewById(R.id.btnZv);
        z.setOnClickListener(this);


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


    @Override
    public void onClick(View v) {

        DatabaseHelper databaseHelper = new DatabaseHelper(Return_Visitor.this);
        Button c = (Button)v;
        String initial = c.getText().toString();

        Intent j = new Intent(this, Name_Display_Visitor.class);
        j.putExtra("initial", initial);
        startActivity(j);



    }


}
