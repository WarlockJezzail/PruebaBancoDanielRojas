package com.example.pruebabanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class CLIENTE_ACT extends AppCompatActivity {

    private EditText edCodigo, edNombre, edSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_l_i_e_n_t_e__a_c_t);

        edCodigo = (EditText) findViewById(R.id.etCodigo);
        edNombre = (EditText) findViewById(R.id.etNombre);
        edSalario = (EditText) findViewById(R.id.etSalario);

    }

    public void Guardar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();

        if (!codigo.isEmpty()) {
            ContentValues cont = new ContentValues();
            cont.put("codigo", edCodigo.getText().toString());
            cont.put("nombre", edNombre.getText().toString());
            cont.put("salario", edSalario.getText().toString());

            db.insert("cliente", null, cont);
            db.close();
            Toast.makeText(this, "Cliente ingresado", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Debe ingresar un codigo", Toast.LENGTH_LONG).show();
        }

    }

    public void Mostrar(View view) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();

        if (!codigo.isEmpty()) {
            Cursor fila = db.rawQuery("SELECT nombre, salario FROM cliente WHERE codigo=" + codigo, null);

            if (fila.moveToFirst()) {
                edNombre.setText(fila.getString(0));
                edSalario.setText(fila.getString(1));
            } else {
                Toast.makeText(this, "No hay datos asociados al codigo", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "No hay datos asociados al codigo", Toast.LENGTH_LONG).show();
        }

    }

    public void Editar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();

        if (!codigo.isEmpty()) {
            ContentValues cont = new ContentValues();
            cont.put("codigo", edCodigo.getText().toString());
            cont.put("nombre", edNombre.getText().toString());
            cont.put("salario", edSalario.getText().toString());

            if (!codigo.isEmpty()) {
                db.update("cliente", cont, "codigo=" + codigo, null);
                db.close();
                Toast.makeText(this, "Datos actualizados", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "No hay datos los cuales actualizar", Toast.LENGTH_LONG).show();
            }

        }
    }
        public void Eliminar (View view){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();

            String codigo = edCodigo.getText().toString();

            db.delete("cliente", "codigo=" + codigo, null);
            db.close();

            Toast.makeText(this, "Cliente eliminado", Toast.LENGTH_LONG).show();

            edCodigo.setText("");
            edSalario.setText("");
            edNombre.setText("");
        }
}
