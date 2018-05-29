package com.holamundo.tallercomputadores;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements adpComputador.OnComputadorClickListener {
    private Intent i;
    private RecyclerView lst_op;
    private ArrayList<Computador> computadores;
    private adpComputador adp;
    private LinearLayoutManager llm;
    private DatabaseReference databaseReference;
    private String db = "computadores";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lst_op = findViewById(R.id.lst_op);
        computadores = new ArrayList<>();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adp = new adpComputador(computadores,this);

        lst_op.setLayoutManager(llm);
        lst_op.setAdapter(adp);


       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             crearComputadores(view);
            }
        });*/

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(db).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                computadores.clear();
                if (dataSnapshot.exists()){
                    for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Computador c = snapshot.getValue(Computador.class);
                        computadores.add(c);
                    }
                }
                adp.notifyDataSetChanged();
                Datos.setComputadores(computadores);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void crearComputadores(View v){
        i = new Intent(Principal.this,CrearComputador.class);
        startActivity(i);
    }

    @Override
    public void onComputadorClick(Computador c) {
        Intent i = new Intent(Principal.this,DetallePc.class);
        Bundle b = new Bundle();

        b.putString("id",c.getId());
        b.putString("marca",c.getMarca());
        b.putInt("ram",c.getRam());
        b.putString("color",c.getColor());
        b.putString("tipo",c.getTipo());
        b.putString("sistema_operativo",c.getSistemaOperativo());
        b.putInt("imagen",c.getimagen());

        i.putExtra("datos",b);
        startActivity(i);

    }



   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
