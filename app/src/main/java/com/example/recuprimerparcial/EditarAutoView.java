package com.example.recuprimerparcial;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class EditarAutoView implements AdapterView.OnItemSelectedListener {
    private Activity activity;
    private AutoModel model;
    private EditText marca;
    private EditText modelo;
    private Spinner anio;
    private Button btnEditar;
    private int valorSpinner;
    private ArrayAdapter aa;

    public EditarAutoView(Activity a, AutoModel pm, EditarAutoController pc){
        activity = a;
        model = pm;
        marca = activity.findViewById(R.id.EdtAutoInpMarca);
        modelo = activity.findViewById(R.id.EdtAutoInpModelo);
       // anio = activity.findViewById(R.id.EditAutoSpinnerAnio);
        btnEditar = activity.findViewById(R.id.EdtAutoBtnEdit);
        btnEditar.setOnClickListener(pc);

        this.anio = (Spinner) activity.findViewById(R.id.EditAutoSpinnerAnio);
        this.aa = ArrayAdapter.createFromResource(activity,R.array.valueSpinner,R.layout.spinner_txt_view);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        anio.setAdapter(aa);
        anio.setOnItemSelectedListener(this);

    }

    public void cargarModelo(){
        if(validarFormulario()) {
            model.setmarca(marca.getText().toString());
            model.setmodelo(modelo.getText().toString());
            model.setanio(valorSpinner);
        }
    }

    public void mostrarModelo(){
        marca.setText(model.getmarca());
        modelo.setText(model.getmodelo());
        if(model.getanio()+"" != null) {
            int spinnerPosition = aa.getPosition(model.getanio()+"");
            anio.setSelection(spinnerPosition);
        }
    }

    public void mostrarMensaje(int mensajeId){
        String mensaje = activity.getResources().getString(mensajeId);
        Toast.makeText(activity,mensaje,Toast.LENGTH_LONG).show();
    }

    public void limpiarFormulario() {
        marca.getText().clear();
        modelo.getText().clear();
    }

    public boolean validarFormulario(){
        boolean retorno = false;
        if(!marca.getText().toString().isEmpty() && !modelo.getText().toString().isEmpty()){
            retorno = true;
        }
        return retorno;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        String txt = parent.getItemAtPosition(position).toString();
        valorSpinner = Integer.parseInt(txt);
        Toast.makeText(activity.getApplicationContext(),txt, Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
}
