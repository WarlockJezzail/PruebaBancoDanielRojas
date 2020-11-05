package Clases;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    //Llamar a la base de datos
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Este sirve para definir la configuracion inicial de la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE cliente(codigo int primary key,nombre text, salario int)");
    }
    // Permite realizar cambios a nivel de esquema de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
