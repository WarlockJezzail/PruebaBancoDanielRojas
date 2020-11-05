package com.example.pruebabanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private EditText nombre,clave;
    private ProgressBar barra;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.et1);
        clave = (EditText)findViewById(R.id.et2);
        barra = (ProgressBar)findViewById(R.id.pb);
        boton = (Button)findViewById(R.id.bIniciar);

        barra.setVisibility(View.INVISIBLE);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Task().execute();
            }
        });
    }
    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            barra.setVisibility(View.VISIBLE);
        }
        @Override
        protected String doInBackground(String... strings) {
            for (int i= 1 ; i <=10; i++);
            {
                try {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            String n=nombre.getText().toString();
            Integer c=Integer.parseInt(clave.getText().toString());
            barra.setVisibility(View.INVISIBLE);
            if (n.equalsIgnoreCase("android")&&c==123) {
                Intent i = new Intent(getBaseContext(), HOME_ACT.class);
                startActivity(i);
            }
        }
    }
}