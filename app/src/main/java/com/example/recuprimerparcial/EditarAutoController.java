package com.example.recuprimerparcial;

import android.util.Log;
import android.view.View;

public class EditarAutoController implements View.OnClickListener {
    private EditarAutoView pv;
    private AutoModel pm;

    public EditarAutoController(AutoModel pm){
        this.pm = pm;
    }

    public void setPv(EditarAutoView pv) {
        this.pv = pv;
        this.pv.mostrarModelo();
    }

    @Override
    public void onClick(View v){
        pv.cargarModelo();
        if(pv.validarFormulario()){
            EditarAuto.setAuto(pm);
            pv.mostrarMensaje(R.string.tstExito);
            Log.d("auto",pm.toString());
        }else{
            pv.mostrarMensaje(R.string.tstError);
        }
    }

}
