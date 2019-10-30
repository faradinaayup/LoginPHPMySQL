package com.journaldev.loginphpmysql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {

    Button A1, A2, A3, A4, A5, btnconfirm;
    TextView txtA5, username, tempat, lahan;
    private CheckBox cbA1, cbA2;
    int i=1;
    //String URL= "https://sparksmartparking.000webhostapp.com/index.php";

    JSONParser1 jsonParser=new JSONParser1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        username = (TextView)findViewById(R.id.username);
        username.setVisibility(View.GONE);
        tempat = (TextView)findViewById(R.id.tempat);
        //tempat.setVisibility(View.GONE);
        //menampilkan tempat dari activity sebelumnya
        tempat.setText(getIntent().getStringExtra("tempat"));
        lahan = (TextView)findViewById(R.id.lahan);

        cbA1 = (CheckBox) findViewById(R.id.cbA1);
        A1 = (Button)findViewById(R.id.A1);
        cbA2 = (CheckBox) findViewById(R.id.cbA2);
        A2 = (Button)findViewById(R.id.A2);
        A3 = (Button)findViewById(R.id.A3);
        A4 = (Button)findViewById(R.id.A4);
        A5 = (Button)findViewById(R.id.A5);
        //txtA5 = (TextView)findViewById(R.id.txtA5);
        //button9 = (Button)findViewById(R.id.A1);
        btnconfirm = (Button)findViewById(R.id.btnconfirm);
        username.setText(getIntent().getStringExtra("nama"));

        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    i=1;
                    btnconfirm.setVisibility(View.GONE);
                }
                else{
                    btnconfirm.setVisibility(View.VISIBLE);
                    i=0;
                }
            }
        });
        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    i=1;
                    btnconfirm.setVisibility(View.GONE);
                }
                else{
                    btnconfirm.setVisibility(View.VISIBLE);
                    i=0;
                }
            }
        });
        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    i=1;
                    btnconfirm.setVisibility(View.GONE);
                }
                else{
                    btnconfirm.setVisibility(View.VISIBLE);
                    i=0;
                }
            }
        });
        A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    i=1;
                    btnconfirm.setVisibility(View.GONE);
                }
                else{
                    btnconfirm.setVisibility(View.VISIBLE);
                    i=0;
                }
            }
        });
        A5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    i=1;
                    btnconfirm.setVisibility(View.GONE);
                }
                else{
                    btnconfirm.setVisibility(View.VISIBLE);
                    i=0;
                }
            }
        });

    }


    public void confirm(View view) {
        Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
        intent.putExtra("nama", username.getText().toString());
        intent.putExtra("tempat", tempat.getText().toString());
        startActivity(intent);
    }

    public void onCheckboxClicked(View view) {
        switch (view.getId()){
            case R.id.cbA1:
                cbA2.setChecked(false);
                break;
            case R.id.cbA2:
                cbA1.setChecked(false);
                break;
        }
    }
}
