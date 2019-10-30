package com.journaldev.loginphpmysql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    ImageButton park_komputer, park_biomedik, park_elektro;
    TextView text_park_komputer, text_park_biomedik, text_park_elektro;
    TextView username;

    //String URL= "https://sparksmartparking.000webhostapp.com/pilih_parkir.php";
    //String URL= "http://10.122.13.119/test_android/pilih_parkir.php";

    JSONParser1 jsonParser=new JSONParser1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        username = (TextView)findViewById(R.id.username);
        park_komputer=(ImageButton)findViewById(R.id.park_komputer);
        text_park_komputer=(TextView)findViewById(R.id.text_park_komputer);
        park_biomedik=(ImageButton)findViewById(R.id.park_biomed);
        text_park_biomedik=(TextView)findViewById(R.id.text_park_biomed);
        park_elektro=(ImageButton)findViewById(R.id.park_elektro);
        text_park_elektro=(TextView)findViewById(R.id.text_park_elektro);

        //menampilkan username dari activity sebelumnya
        username.setText(getIntent().getStringExtra("nama"));

        park_komputer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //komputer = text_park_komputer.getText().toString();

                //Insert insert = new Insert();
                //insert.execute(text_park_komputer.getText().toString());
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("tempat", text_park_komputer.getText().toString());
                //mengirim username ke activity selanjutnya
                intent.putExtra("nama", username.getText().toString());
                startActivity(intent);
            }
        });
        park_biomedik.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //komputer = text_park_komputer.getText().toString();

                //Insert insert = new Insert();
                //insert.execute(text_park_biomedik.getText().toString());
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("tempat", text_park_biomedik.getText().toString());
                intent.putExtra("nama", username.getText().toString());
                startActivity(intent);
            }
        });
        park_elektro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //komputer = text_park_komputer.getText().toString();

                //Insert insert = new Insert();
                //insert.execute(text_park_elektro.getText().toString());
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("tempat", text_park_elektro.getText().toString());
                intent.putExtra("nama", username.getText().toString());
                startActivity(intent);
            }
        });
    }
/*
    private class Insert extends AsyncTask<String, String, JSONObject>
    {
        @Override
        protected void onPreExecute() {

            super.onPreExecute();

        }
        @Override

        protected JSONObject doInBackground(String... args) {

            //deklarasi string
            String tempat = args[0];

            //bagian parsing data register ke API
            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
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
                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    intent.putExtra("nama", username.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Unable to retrieve any data from server", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }*/
}
