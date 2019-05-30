package com.apps.memorizame.Adapters;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.apps.memorizame.Entitys.CategoriasEntity;
import com.apps.memorizame.R;
import java.util.ArrayList;

public class categoriasAdapter extends RecyclerView.Adapter<categoriasHolder> {

    //declaracion de variables
    private ArrayList<CategoriasEntity> entities;
    private Context context;
    private OnItemCLickListener clickItem;

    public categoriasAdapter(ArrayList<CategoriasEntity> entities, Context context){
        //setear datos desde el constructor
        this.entities = entities;
        this.context = context;
    }

    @NonNull
    @Override
    public categoriasHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflar las vistas del cardview
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inicio_frg_categorias_cv,viewGroup, false);
        return new categoriasHolder(itemView, clickItem);
    }

    @Override
    public void onBindViewHolder(@NonNull final categoriasHolder holder, int i) {
        //dato exacto
        final CategoriasEntity data = entities.get(i);

        //obtener imagen por el nombre
        @DrawableRes
        int res = context.getResources().getIdentifier(data.getImagen(), "drawable", context.getPackageName());
        holder.imagen.setBackgroundResource(res);

        holder.nombre.setText(data.getNombre());

        //si es igual a 1 que es completo, oculta el candado
        if(data.getIdEstado() == 1){
            holder.bloqueo.setVisibility(View.GONE);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //habilita el click
                    clickItem.OnClickItem(data.getIdCategoria());
                }
            });
        }else{
            holder.bloqueo.setVisibility(View.VISIBLE);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Elemento bloqueado.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public interface OnItemCLickListener{
        void OnClickItem(int position);
    }

    public void setClickItem(OnItemCLickListener clickItem){ this.clickItem = clickItem; }

    @Override
    public int getItemCount() { return entities.size(); }
}
