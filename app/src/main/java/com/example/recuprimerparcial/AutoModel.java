package com.example.recuprimerparcial;

import java.io.Serializable;

public class AutoModel implements Serializable {
    private String marca;
    private String modelo;
    private Integer anio;

    public AutoModel() {}
    public AutoModel(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = Integer.valueOf(anio);
    }

    public String getmarca() {
        return marca;
    }

    public void setmarca(String marca) {
        this.marca = marca;
    }

    public String getmodelo() {
        return modelo;
    }

    public void setmodelo(String modelo) {
        this.modelo = modelo;
    }

    public int getanio() {
        return anio.intValue();
    }

    public void setanio(int anio) {
        this.anio = Integer.valueOf(anio);
    }

    @Override
    public boolean equals(Object o){
        boolean retorno= false;
        if(o != null && o.getClass().equals(this.getClass())){
            AutoModel p = (AutoModel)o;
            if(p.getmarca() == this.marca){
                retorno = true;
            }
        }
        return retorno;
    }

    @Override
    public int hashCode(){
        final int primo = 7;
        int retorno = primo * this.marca.hashCode();
        return retorno;
    }

    @Override
    public String toString() {
        return "nombre: "+this.marca.concat(", contraseña: ").concat(this.modelo).concat(", tipo: ")+this.anio;
    }
}