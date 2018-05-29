package com.holamundo.tallercomputadores;

/**
 * Created by android on 28/05/2018.
 */

public class Computador {
    private String id,marca,color,tipo,sistemaOperativo;
    private int imagen,ram;

    public Computador() {

    }

    public Computador(String id, String marca,int ram, String color, String tipo, String sistemaOperativo, int imagen) {
        this.id = id;
        this.marca = marca;
        this.ram = ram;
        this.color = color;
        this.tipo = tipo;
        this.sistemaOperativo = sistemaOperativo;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getimagen() {
        return imagen;
    }

    public void setimagen(int imagen) {
        this.imagen = imagen;
    }

    public void guardar(){
        Datos.guardar_computador(this);
    }

    public void eliminar(){
        Datos.eliminar(this);
    }
}
