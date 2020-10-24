package com.example.async_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Insumos_act extends AppCompatActivity {

    private EditText text1,text2,text3,text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos_act);

        text1=(EditText)findViewById(R.id.codigoInsumo);
        text2=(EditText)findViewById(R.id.NombreInsumo);
        text3=(EditText)findViewById(R.id.PrecioInsumo);
        text4=(EditText)findViewById(R.id.StockInsumo);
    }
    public void Anadir(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db =admin.getWritableDatabase();//Permite permisos de esritura sobre la bbdd

        String codigo=text1.getText().toString();
        String nombre=text2.getText().toString();
        String precio=text3.getText().toString();
        String stock=text4.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty() && !precio.isEmpty() && !stock.isEmpty()){
            ContentValues cont =new ContentValues();

            cont.put("codigo",text1.getText().toString());
            cont.put("nombre",text2.getText().toString());
            cont.put("precio",text3.getText().toString());
            cont.put("stock",text4.getText().toString());

            db.insert("insumos", null,cont);
            db.close();

            Toast.makeText(this,"Has guardado un producto",Toast.LENGTH_LONG).show();
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");

        }
        else{
            Toast.makeText(this,"Todos los campos deben estar llenos.", Toast.LENGTH_LONG).show();
        }
    }
    public void Motrar(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();//Permisos de sobreescritura

        String codigo=text1.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila=db.rawQuery("SELECT nombre,precio,stock,codigo FROM insumos WHERE codigo="+codigo,null);
            if(fila.moveToFirst()){ //Si no hay campos devuelve vacio
                text2.setText(fila.getString(0));
                text3.setText(fila.getString(1));
                text4.setText(fila.getString(2));
            }
            else{
                Toast.makeText(this,"Solo se puede mostrar a travez del codigo del producto",Toast.LENGTH_LONG).show();
            }
        }
        else{
        Toast.makeText(this,"No existe producto asociado al codigo ingresado",Toast.LENGTH_LONG).show();
        }
    }
    public void Eliminar(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();

        String codigo=text1.getText().toString();
        if(!codigo.isEmpty()){
            db.delete("insumos","codigo="+codigo,null);
            db.close();

            Toast.makeText(this,"Has eliminado un producto",Toast.LENGTH_LONG).show();
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");
        }
        else{
            Toast.makeText(this,"Solo se puede eliminar un producto a traves de su codigo",Toast.LENGTH_LONG).show();
        }

    }
    public void Actualizar(View v){
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();

        String codigo=text1.getText().toString();
        String nombre=text2.getText().toString();
        String precio=text3.getText().toString();
        String stock=text4.getText().toString();

        ContentValues cont=new ContentValues();

        cont.put("codigo",text1.getText().toString());
        cont.put("nombre",text2.getText().toString());
        cont.put("precio",text3.getText().toString());
        cont.put("stock",text4.getText().toString());

        if(!codigo.isEmpty() && !nombre.isEmpty() && !precio.isEmpty() && !stock.isEmpty()){

            db.update("insumos",cont,"codigo="+codigo,null);
            db.close();

            Toast.makeText(this, "Has actualizado un producto", Toast.LENGTH_SHORT).show();
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");

        }
        else{
            Toast.makeText(this,"El codigo ingresado no existe o hay un campo vacio", Toast.LENGTH_LONG).show();
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");
        }
    }
    public void Limpiar(View v){
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
    }
}