package com.example.recuprimerparcial;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class EditarAuto extends AppCompatActivity {
    public static AutoModel autoEditado;
    public static Integer index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_auto);
        ActionBar actBar = getSupportActionBar();
        actBar.setDisplayHomeAsUpEnabled(true);
        Bundle extras = super.getIntent().getExtras();

        AutoModel model = (AutoModel) extras.get("auto");
        this.setIndex(extras.getInt("index"));
        Log.d("auto",model.toString());
        EditarAutoController controller = new EditarAutoController(model);
        EditarAutoView view = new EditarAutoView(this, model, controller);
        controller.setPv(view);
        autoEditado = new AutoModel();
    }

    public static AutoModel getAuto(){
        return autoEditado;
    }

    public static int getIndex(){
        return index;
    }

    public static void setAuto(AutoModel a){
        autoEditado = a;
    }

    public void setIndex(Integer i){
        index = i;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }


}