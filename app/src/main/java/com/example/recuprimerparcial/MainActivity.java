package com.example.recuprimerparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickItemView {
    List<AutoModel> autos = new ArrayList<AutoModel>();
    AutoAdapter autoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autos.add(new AutoModel("marca1","modelo1",2001));
        autos.add(new AutoModel("marca2","modelo2",2002));
        autos.add(new AutoModel("marca3","modelo3",2003));
        autos.add(new AutoModel("marca4","modelo4",2004));
        autos.add(new AutoModel("marca5","modelo5",2005));
        autos.add(new AutoModel("marca6","modelo6",2006));
        autos.add(new AutoModel("marca7","modelo7",2007));
        autos.add(new AutoModel("marca8","modelo8",2008));
        autos.add(new AutoModel("marca9","modelo9",2009));
        autos.add(new AutoModel("marca10","modelo10",2010));

        this.autoAdapter = new AutoAdapter(autos,this);
        RecyclerView rv = super.findViewById(R.id.rvListaAutos);

        rv.setAdapter(autoAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rv.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void onRestart(){
        AutoModel autoEditado = EditarAuto.getAuto();
        int index = EditarAuto.getIndex();
        if(autoEditado != null){
            this.autos.set(index, autoEditado);
            EditarAuto.setAuto(null);
            this.autoAdapter.notifyItemChanged(index);
        }
        super.onRestart();
    }

    @Override
    public void onItemClick(int index) {
        AutoModel auto = autos.get(index);
        Intent irEdicionUsuario = new Intent(this,EditarAuto.class);
        irEdicionUsuario.putExtra("auto",auto);
        irEdicionUsuario.putExtra("index",index);
        startActivity(irEdicionUsuario);
    }




}