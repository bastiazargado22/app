package com.example.async_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {
    private ViewFlipper vf;
    private int image[]={R.drawable.sure,R.drawable.pampa,R.drawable.lago};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf=(ViewFlipper)findViewById(R.id.slider);

        for(int i=0;i<image.length;i++){
            flip_image(image[i]);
        }
    }
    public void flip_image(int i){
        ImageView toque= new ImageView(this );
        toque.setBackgroundResource(i);
        vf.addView(toque);
        vf.setFlipInterval(1500);
        vf.setAutoStart(true);

        vf.setInAnimation(this,android.R.anim.slide_in_left);
        vf.setOutAnimation(this,android.R.anim.slide_out_right);
    }
    public void Maps(View v){
        Intent i =new Intent(this,Maps_act.class);
        startActivity(i);
    }

    public void Clientes(View v){
        ArrayList<String> clientes=new ArrayList<String>();
        clientes.add("Cliente");
        clientes.add("Pepe");
        clientes.add("Pancho");
        clientes.add("Adrian");
        ArrayList<String> planes=new ArrayList<String>();
        planes.add("Plan");
        planes.add("Sur");
        planes.add("Norte");
        planes.add("Cordillera");
        planes.add("Costa");

        Intent i =new Intent(this, Clientes_act.class);
        i.putExtra("listaClientes",clientes);
        i.putExtra("listaPlanes",planes);
        startActivity(i);
    }

    public void Info(View v){
        Intent i =new Intent(this,Info_act.class);
        startActivity(i);
    }
    public void Base(View v){
        Intent i=new Intent(this,Insumos_act.class);
        startActivity(i);
    }
}