package com.holamundo.tallercomputadores;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.holamundo.tallercomputadores.R.id.lblMarca;

/**
 * Created by android on 28/05/2018.
 */

public class adpComputador extends RecyclerView.Adapter<adpComputador.ComputadorViewHolder>{
    private ArrayList<Computador> computadores;
    private OnComputadorClickListener clickListener;

    public adpComputador(ArrayList<Computador> computadores, OnComputadorClickListener clickListener) {
        this.computadores = computadores;
        this.clickListener = clickListener;
    }

    @Override
    public ComputadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_computador,parent,false);
        return new ComputadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ComputadorViewHolder holder, int position) {
        final Computador c = computadores.get(position);
        holder.imagen.setImageResource(c.getimagen());
        holder.marca.setText(c.getMarca());
        holder.ram.setText(String.valueOf(c.getRam()));
        holder.color.setText(c.getColor());
        holder.tipo.setText(c.getTipo());
        holder.sistema_operativo.setText(c.getSistemaOperativo());


        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onComputadorClick(c);
            }
        });
    }

    @Override
    public int getItemCount() {
        return computadores.size();
    }


    public static class ComputadorViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagen;
        private TextView marca,ram,color,tipo,sistema_operativo;
        private View v;

        public ComputadorViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            imagen = v.findViewById(R.id.imgPc);
            marca = v.findViewById(R.id.lblMarca);
            ram = v.findViewById(R.id.lblRam);
            color = v.findViewById(R.id.lblColor);
            tipo = v.findViewById(R.id.lblTipo);
            sistema_operativo = v.findViewById(R.id.lblSistemaO);
        }

    }
    public interface OnComputadorClickListener{
        void onComputadorClick(Computador c);
    }

}
