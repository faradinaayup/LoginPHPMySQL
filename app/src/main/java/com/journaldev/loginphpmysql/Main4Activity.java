package com.journaldev.loginphpmysql;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    TextView username, tempat, lahan;
    Button btnconfirm;

    String URL= "http://10.122.11.161/test_android/transaksi.php";

    JSONParser1 jsonParser=new JSONParser1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        username = (TextView)findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("nama"));
        tempat = (TextView)findViewById(R.id.tempat);
        tempat.setText(getIntent().getStringExtra("tempat"));

        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insert insert = new Insert();
                insert.execute(username.getText().toString(), tempat.getText().toString());
            }
        });
    }
    private class Insert extends AsyncTask<String, String, JSONObject>
    {
        @Override
        protected void onPreExecute() {

            super.onPreExecute();

        }
        @Override

        protected JSONObject doInBackground(String... args) {

            //deklarasi string
            String username = args[1];
            String tempat = args[0];

            //bagian parsing data register ke API
            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("username", username));
            params.add(new BasicNameValuePair("tempat", tempat));

            JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);

            return json;
        }
        protected void onPostExecute(JSONObject result) {

            // dismiss the dialog once product deleted
            //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();

            try {
                if (result != null) {
                    Toast.makeText(getApplicationContext(),result.getString("message"),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
                    //intent.putExtra("nama", username.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Unable to retrieve any data from server", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    public void kembali (View view){
        Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
        startActivity(intent);
    }

    /*public void confirm(View view) {
        Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
        startActivity(intent);
    }*/
}
