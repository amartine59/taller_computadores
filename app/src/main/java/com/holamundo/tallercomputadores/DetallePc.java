package com.holamundo.tallercomputadores;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePc extends AppCompatActivity {
    private TextView txtMarca,txtRam,txtColor,txtTipo,txtSistemaO;
    private ImageView imgv;
    private String id,marca,ram,color,tipo,sistema_operativo;
    private int imagen;
    private Intent i;
    private Bundle bndl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pc);

        txtMarca = findViewById(R.id.txtMarca);
        txtRam = findViewById(R.id.txtRam);
        txtColor = findViewById(R.id.txtColor);
        txtTipo = findViewById(R.id.txtTipo);
        txtSistemaO = findViewById(R.id.txtSistemaO);

        imgv = findViewById(R.id.imagen);

        i=getIntent();

        bndl = i.getBundleExtra("datos");
        marca = bndl.getString("marca");
        ram = bndl.getString("ram");
        color = bndl.getString("color");
        tipo = bndl.getString("tipo");
        sistema_operativo= bndl.getString("sistema_operativo");
        imagen = bndl.getInt("imagen");
        id = bndl.getString("id");

        txtMarca.setText(marca);
        txtRam.setText(ram);
        txtColor.setText(color);
        txtTipo.setText(tipo);
        txtSistemaO.setText(sistema_operativo);
        imgv.setImageResource(imagen);


    }

    public void eliminar_seleccionado(View v){
        String pos, neg;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminar));
        pos = getResources().getString(R.string.eliminar_si);
        neg = getResources().getString(R.string.eliminar_no);

        builder.setPositiveButton(pos, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Computador c = new Computador(id);
                c.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(neg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
