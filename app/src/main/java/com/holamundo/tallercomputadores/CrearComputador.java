package com.holamundo.tallercomputadores;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearComputador extends AppCompatActivity {
    private EditText txtRam;
    private Spinner spn_marca,spn_color,spn_tipo,spn_sistemaO;
    private ArrayAdapter<String> adp_marca,adp_color,adp_tipo,adp_sistemaO;
    private String [] opc_marca,opc_color,opc_tipo,opc_sistemaO;
    private ArrayList<Integer> imagenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_computador);

        spn_marca = findViewById(R.id.spn_marca);
        opc_marca = this.getResources().getStringArray(R.array.marcas);
        adp_marca = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_marca);
        spn_marca.setAdapter(adp_marca);

        txtRam = findViewById(R.id.txtRam);

        spn_color = findViewById(R.id.spn_color);
        opc_color = this.getResources().getStringArray(R.array.colores);
        adp_color = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_color);
        spn_color.setAdapter(adp_color);

        spn_tipo = findViewById(R.id.spn_tipo);
        opc_tipo = this.getResources().getStringArray(R.array.tipos);
        adp_tipo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_tipo);
        spn_tipo.setAdapter(adp_tipo);

        spn_sistemaO = findViewById(R.id.spn_sistemaO);
        opc_sistemaO = this.getResources().getStringArray(R.array.sistemas_operativos);
        adp_sistemaO = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_sistemaO);
        spn_sistemaO.setAdapter(adp_sistemaO);

        imagenes = new ArrayList<Integer>();
        imagenes.add(R.drawable.dell);
        imagenes.add(R.drawable.hp);
        imagenes.add(R.drawable.acer);
        imagenes.add(R.drawable.acer_mesa);

    }

    public String ObtenerCadena(Spinner spn){
        String item = "";
        item = spn.getSelectedItem().toString();
        return item;
    }

    public void guardar(View v){
        if (validar()){
            String id,marca,color,tipo,sistema_operativo;
            int imagen, ram;
            id = Datos.getId();
            marca = ObtenerCadena(spn_marca);
            ram = Integer.parseInt(txtRam.getText().toString());
            color = ObtenerCadena(spn_color);
            tipo = ObtenerCadena(spn_tipo);
            sistema_operativo = ObtenerCadena(spn_sistemaO);
            imagen = Datos.imagenAleatoria(imagenes);

            Computador c = new Computador(id,marca,ram,color,tipo,sistema_operativo,imagen);
            c.guardar();
            Snackbar.make(v,getResources().getString(R.string.guardado_exitoso),Snackbar.LENGTH_SHORT).setAction("Action",null).show();
            limpiar();
        }




    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        spn_marca.setSelection(0);
        txtRam.setText("");
        spn_color.setSelection(0);
        spn_tipo.setSelection(0);
        spn_sistemaO.setSelection(0);
    }

    public boolean validar(){
        if (txtRam.getText().toString().trim().isEmpty()){
            txtRam.requestFocus();
            txtRam.setError(getResources().getString(R.string.error_vacio));
            return false;
        }
        return true;
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(CrearComputador.this,Principal.class);
        startActivity(i);
    }


}
