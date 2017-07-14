package com.coempperu.appmovil.coemptransp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.coempperu.appmovil.coemptransp.R;
import com.coempperu.appmovil.coemptransp.model.Units;

import java.util.ArrayList;

public class UnitsAdapter extends RecyclerView.Adapter<UnitsAdapter.ViewHolder> {
    private ArrayList<Units> mDataSet;

    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // en este ejemplo cada elemento consta solo de un título
        TextView tvType, tvModel, tvPT, tvPC;
        Button btnViewDetails, btnDelete;

        public ViewHolder(View v) {
            super(v);
            tvType = (TextView) v.findViewById(R.id.tvType);
            tvModel = (TextView) v.findViewById(R.id.tvModel);
            tvPT = (TextView) v.findViewById(R.id.tvPT);
            tvPC = (TextView) v.findViewById(R.id.tvPC);

            btnViewDetails = (Button) v.findViewById(R.id.btnViewDetails);
            btnViewDetails = (Button) v.findViewById(R.id.btnDelete);

        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public UnitsAdapter(ArrayList<Units> units) {
        mDataSet = units;
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public UnitsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // Creamos una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_unit, parent, false);

        // Aquí podemos definir tamaños, márgenes, paddings
        // ...

        return new ViewHolder(v);
    }

    // Este método reemplaza el contenido de cada view,
    // para cada elemento de la lista (nótese el argumento position)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido de los views según tales datos

        final Units units = mDataSet.get(position);
        holder.tvType.setText(units.getTvType());
        holder.tvModel.setText(units.getTvModel());
        holder.tvPT.setText(units.getTvPT());
        holder.tvPC.setText(units.getTvPC());
    }

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo en RecyclerViews que implementar filtros o búsquedas
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}