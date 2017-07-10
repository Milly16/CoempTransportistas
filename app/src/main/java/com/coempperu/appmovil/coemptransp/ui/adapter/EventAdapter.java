package com.coempperu.appmovil.coemptransp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.coempperu.appmovil.coemptransp.R;
import com.coempperu.appmovil.coemptransp.model.Event;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private ArrayList<Event> mDataSet;

    // Obtener referencias de los componentes visuales
    static class ViewHolder extends RecyclerView.ViewHolder {
        // en este ejemplo cada elemento consta solo de un título
        TextView tvRemaining, tvProductType, tvWeight, tvFrom, tvTo, tvPrice;
        Button btnShowEvent;
        ViewHolder(View v) {
            super(v);
            tvRemaining = (TextView) v.findViewById(R.id.tvRemaining);
            tvProductType = (TextView) v.findViewById(R.id.tvProductType);
            tvWeight = (TextView) v.findViewById(R.id.tvWeight);
            tvFrom = (TextView) v.findViewById(R.id.tvFrom);
            tvTo = (TextView) v.findViewById(R.id.tvTo);
            tvPrice = (TextView) v.findViewById(R.id.tvPrice);

            btnShowEvent = (Button) v.findViewById(R.id.btnShowEvent);
        }
    }

    // Este es nuestro constructor
    public EventAdapter(ArrayList<Event> events) {
        mDataSet = events;
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // Creamos una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);

        // Aquí podemos definir tamaños, márgenes, paddings
        return new ViewHolder(v);
    }

    // Este método reemplaza el contenido de cada view,
    // para cada elemento de la lista (nótese el argumento position)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido de los views según tales datos

        final Event event = mDataSet.get(position);
        holder.tvRemaining.setText(event.getRemaining());
        holder.tvProductType.setText(event.getProductType());
        holder.tvWeight.setText(event.getWeight());
        holder.tvFrom.setText("Recojo: " + event.getFrom());
        holder.tvTo.setText("Entrega: " + event.getTo());
        holder.tvPrice.setText(event.getPrice());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}