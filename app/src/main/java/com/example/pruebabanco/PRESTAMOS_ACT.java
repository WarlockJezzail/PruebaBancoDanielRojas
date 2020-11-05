package com.example.pruebabanco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.VideoView;

public class PRESTAMOS_ACT extends AppCompatActivity {

    private Spinner spnombre, spcredito;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_r_e_s_t_a_m_o_s__a_c_t);

        spnombre=(Spinner)findViewById(R.id.sp1);
        spcredito=(Spinner)findViewById(R.id.sp2);
        textView=(TextView)findViewById(R.id.tv);

        String[] listan = {"Selecciona un cliente...", "AXEL", "ROXANA",};
        String[] listap = {"Selecciona un credito...", "CREDITO HIPOTECARIO", "CREDITO AUTOMOTRIS",};

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listan);
        spnombre.setAdapter(adapt);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listap);
        spcredito.setAdapter(adapts);
    }

        public void Prestamo(View v){
        String n=spnombre.getSelectedItem().toString();
        String c=spcredito.getSelectedItem().toString();

        if(n.equals("AXEL")&&c.equals("CREDITO HIPOTECARIO")) {

            int suma = 750000 + 1000000;
            textView.setText("Su prestamo es de "+suma);
            }
        if(n.equals("ROXANA")&&c.equals("CREDITO HIPOTECARIO")) {

            int suma = 900000 + 1000000;
            textView.setText("Su prestamo es de "+suma);
            }
            if(n.equals("AXEL")&&c.equals("CREDITO AUTOMOTRIS")) {

                int suma = 750000 + 500000;
                textView.setText("Su prestamo es de "+suma);
            }
            if(n.equals("ROXANA")&&c.equals("CREDITO AUTOMOTRIS")) {

                int suma = 900000 + 500000;
                textView.setText("Su prestamo es de "+suma);
            }
        }
    public void Deuda(View v){
        String n=spnombre.getSelectedItem().toString();
        String c=spcredito.getSelectedItem().toString();

        if(n.equals("AXEL")&&c.equals("CREDITO HIPOTECARIO")) {

            int suma = (750000 + 1000000)/12;
            textView.setText("Su deuda es de "+suma);
        }
        if(n.equals("ROXANA")&&c.equals("CREDITO HIPOTECARIO")) {

            int suma = (900000 + 1000000)/12;
            textView.setText("Su deuda es de "+suma);
        }
        if(n.equals("AXEL")&&c.equals("CREDITO AUTOMOTRIS")) {

            int suma = (750000 + 500000)/8;
            textView.setText("Su deuda es de "+suma);
        }
        if(n.equals("ROXANA")&&c.equals("CREDITO AUTOMOTRIS")) {

            int suma = (900000 + 500000)/8;
            textView.setText("Su deuda es de "+suma);
        }
    }

    }