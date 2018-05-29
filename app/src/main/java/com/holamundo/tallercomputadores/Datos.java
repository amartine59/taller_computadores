package com.holamundo.tallercomputadores;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by android on 28/05/2018.
 */

public class Datos {
   private static String datab = "computadores";
   private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
   private static ArrayList<Computador> computadores;

   public static void guardar_computador(Computador c){
       databaseReference.child(datab).child(c.getId()).setValue(c);
   }

   public static ArrayList<Computador> obtener(){
       return computadores;
   }

   public static int imagenAleatoria(ArrayList<Integer> imagenes){
       int imagenSeleccionada;
       Random r = new Random();
       imagenSeleccionada = r.nextInt(imagenes.size());
       return imagenes.get(imagenSeleccionada);
   }

   public static String getId(){
       return databaseReference.push().getKey();
   }

    public static void setComputadores(ArrayList<Computador> computadores) {
        Datos.computadores = computadores;
    }

    public static void eliminar(Computador c){
       databaseReference.child(datab).child(c.getId()).removeValue();
    }
}
