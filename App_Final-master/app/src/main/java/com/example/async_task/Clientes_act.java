package com.example.async_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Planes;

public class Clientes_act extends AppCompatActivity {
    private Spinner sp1, sp2;
    private TextView txt;
    private EditText text;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        sp1 = (Spinner) findViewById(R.id.spinCliente);
        sp2 = (Spinner) findViewById(R.id.spinPlanes);
        text = (EditText) findViewById(R.id.plano);
        txt = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.btn);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        sp1.setAdapter(adapt);

        ArrayList<String> listaPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listaPlanes");
        ArrayAdapter<String> adapt2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPlanes);
        sp2.setAdapter(adapt2);
    }


    public void Calcular(View v) {
        String cliente = sp1.getSelectedItem().toString();
        String plan = sp2.getSelectedItem().toString();
        Planes costo = new Planes();

        String monto= text.getText().toString();

        if(!monto.isEmpty()){
            int pagar= Integer.parseInt(monto);

            if (cliente.equals("Pepe")) {
                switch (plan) {
                    case "Norte":
                        txt.setText("El costo del plan es $" + costo.getNorte());
                        if(pagar<costo.getNorte()){
                            int faltante=costo.getNorte()-pagar;
                            txt.setText("Has cancelado: $"+pagar+ " te quedan por cancelar: $"+ faltante+
                            "  El costo del plan es $" + costo.getNorte());
                        }
                        else if(pagar>costo.getNorte()){
                            txt.setText("Estas intentando pagar mas del precio del plan."+
                            "  El costo del plan es $" + costo.getNorte());
                        }
                        else{
                            txt.setText("Felicidades has contratado el plan.");
                        }
                        break;
                    case "Cordillera":
                        if(pagar<costo.getCordillera()){
                            int faltante=costo.getCordillera()-pagar;
                            txt.setText("Has cancelado: $"+pagar+ " te quedan por cancelar: $"+ faltante+
                                    "  El costo del plan es $" + costo.getCordillera());
                        }
                        else if(pagar>costo.getCordillera()){
                            txt.setText("Estas intentando pagar mas del precio del plan."+
                            "  El costo del plan es $" + costo.getCordillera());
                        }
                        else{
                            txt.setText("Felicidades has contratado el plan.");
                        }
                        break;
                    case "Costa":
                        if(pagar<costo.getCosta()){
                            int faltante=costo.getCosta()-pagar;
                            txt.setText("Has cancelado: $"+pagar+ " te quedan por cancelar: $"+ faltante+
                            "  El costo del plan es $" + costo.getCosta());
                        }
                        else if(pagar>costo.getCosta()){
                            txt.setText("Estas intentando pagar mas del precio del plan."+
                            "  El costo del plan es $" + costo.getCosta());
                        }
                        else{
                            txt.setText("Felicidades has contratado el plan.");
                        }
                        break;
                    case "Sur":
                        if(pagar<costo.getSur()){
                            int faltante=costo.getSur()-pagar;
                            txt.setText("Has cancelado: $"+pagar+ " te quedan por cancelar: $"+ faltante+
                            "  El costo del plan es $" + costo.getSur());
                        }
                        else if(pagar>costo.getSur()){
                            txt.setText("Estas intentando pagar mas del precio del plan."+
                            "  El costo del plan es $" + costo.getSur());
                        }
                        else{
                            txt.setText("Felicidades has contratado el plan.");
                        }
                        break;
                    default:
                        txt.setText("No ingresaste ningun plan");
                        break;
                }
            } else if (cliente.equals("Pancho")) {
                switch (plan) {
                    case "Norte":
                        txt.setText("El costo del plan es $" + costo.getNorte());
                        if(pagar<costo.getNorte()){
                            int faltante=costo.getNorte()-pagar;
                            txt.setText("Has cancelado: $"+pagar+ " te quedan por cancelar: $"+ faltante+
                                    "  El costo del plan es $" + costo.getNorte());
                        }
                        else if(pagar>costo.getNorte()){
                            txt.setText("Estas intentando pagar mas del precio del plan."+
                                    "  El costo del plan es $" + costo.getNorte());
                        }
                        else{
                            txt.setText("Felicidades has contratado el plan.");
                        }
                        break;
                    case "Cordillera":
                        if(pagar<costo.getCordillera()){
                            int faltante=costo.getCordillera()-pagar;
                            txt.setText("Has cancelado: $"+pagar+ " te quedan por cancelar: $"+ faltante+
                                    "  El costo del plan es $" + costo.getCordillera());
                        }
                        else if(pagar>costo.getCordillera()){
                            txt.setText("Estas intentando pagar mas del precio del plan."+
                                    "  El costo del plan es $" + costo.getCordillera());
                        }
                        else{
                            txt.setText("Felicidades has contratado el plan.");
                        }
                        break;
                    case "Costa":
                        if(pagar<costo.getCosta()){
                            int faltante=costo.getCosta()-pagar;
                            txt.setText("Has cancelado: $"+pagar+ " te quedan por cancelar: $"+ faltante+
                                    "  El costo del plan es $" + costo.getCosta());
                        }
                        else if(pagar>costo.getCosta()){
                            txt.setText("Estas intentando pagar mas del precio del plan."+
                                    "  El costo del plan es $" + costo.getCosta());
                        }
                        else{
                            txt.setText("Felicidades has contratado el plan.");
                        }
                        break;
                    case "Sur":
                        if(pagar<costo.getSur()){
                            int faltante=costo.getSur()-pagar;
                            txt.setText("Has cancelado: $"+pagar+ " te quedan por cancelar: $"+ faltante+
                                    "  El costo del plan es $" + costo.getSur());
                        }
                        else if(pagar>costo.getSur()){
                            txt.setText("Estas intentando pagar mas del precio del plan."+
                                    "  El costo del plan es $" + costo.getSur());
                        }
                        else{
                            txt.setText("Felicidades has contratado el plan.");
                        }
                        break;
                    default:
                        txt.setText("No ingresaste ningun plan");
                        break;
                }
            } else if (cliente.equals("Adrian")) {
                switch (plan) {
                    case "Norte":
                        txt.setText("El costo del plan es $" + costo.getNorte());
                        if(pagar<costo.getNorte()){
                            int faltante=costo.getNorte()-pagar;
                            txt.setText("Has cancelado: $"+pagar+ " te quedan por cancelar: $"+ faltante+
                                    "  El costo del plan es $" + costo.getNorte());
                        }
                        else if(pagar>costo.getNorte()){
                            txt.setText("Estas intentando pagar mas del precio del plan."+
                                    "  El costo del plan es $" + costo.getNorte());
                        }
                        else{
                            txt.setText("Felicidades has contratado el plan.");
                        }
                        break;
                    case "Cordillera":
                        if(pagar<costo.getCordillera()){
                            int faltante=costo.getCordillera()-pagar;
                            txt.setText("Has cancelado: $"+pagar+ " te quedan por cancelar: $"+ faltante+
                                    "  El costo del plan es $" + costo.getCordillera());
                        }
                        else if(pagar>costo.getCordillera()){
                            txt.setText("Estas intentando pagar mas del precio del plan."+
                                    "  El costo del plan es $" + costo.getCordillera());
                        }
                        else{
                            txt.setText("Felicidades has contratado el plan.");
                        }
                        break;
                    case "Costa":
                        if(pagar<costo.getCosta()){
                            int faltante=costo.getCosta()-pagar;
                            txt.setText("Has cancelado: $"+pagar+ " te quedan por cancelar: $"+ faltante+
                                    "  El costo del plan es $" + costo.getCosta());
                        }
                        else if(pagar>costo.getCosta()){
                            txt.setText("Estas intentando pagar mas del precio del plan."+
                                    "  El costo del plan es $" + costo.getCosta());
                        }
                        else{
                            txt.setText("Felicidades has contratado el plan.");
                        }
                        break;
                    case "Sur":
                        if(pagar<costo.getSur()){
                            int faltante=costo.getSur()-pagar;
                            txt.setText("Has cancelado: $"+pagar+ " te quedan por cancelar: $"+ faltante+
                                    "  El costo del plan es $" + costo.getSur());
                        }
                        else if(pagar>costo.getSur()){
                            txt.setText("Estas intentando pagar mas del precio del plan."+
                                    "  El costo del plan es $" + costo.getSur());
                        }
                        else{
                            txt.setText("Felicidades has contratado el plan.");
                        }
                        break;
                    default:
                        txt.setText("No ingresaste ningun plan");
                        break;
                }
            } else {
                txt.setText("No ingresaste ningun cliente");
            }
        }
        else{
            txt.setText("No ingresaste monto a pagar");
        }

    }
}