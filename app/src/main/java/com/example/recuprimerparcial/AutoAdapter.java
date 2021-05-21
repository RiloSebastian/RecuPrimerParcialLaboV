package com.example.recuprimerparcial;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AutoAdapter extends RecyclerView.Adapter<AutoViewHolder> {
    List<AutoModel> autos;
    OnClickItemView clickItem;
    public AutoAdapter(List<AutoModel> autos, OnClickItemView clickItem){
        this.autos = autos;
        this.clickItem = clickItem;
    }

    @Override
    public AutoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_auto,parent,false);
        AutoViewHolder uvh = new AutoViewHolder(v,clickItem);
        return uvh;
    }

    @Override
    public void onBindViewHolder(AutoViewHolder holder, int position) {
        AutoModel auto = this.autos.get(position);
        holder.rvMarca.setText(auto.getmarca());
        holder.rvModelo.setText(auto.getmodelo());
        holder.setIndex(position);
    }

    @Override
    public int getItemCount() {
        return this.autos.size();
    }
}
