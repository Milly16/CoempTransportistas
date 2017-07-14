package com.coempperu.appmovil.coemptransp.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.coempperu.appmovil.coemptransp.R;
import com.coempperu.appmovil.coemptransp.model.Units;
import com.coempperu.appmovil.coemptransp.ui.AddUnitsActivity;
import com.coempperu.appmovil.coemptransp.ui.adapter.UnitsAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UnitsFragment extends Fragment implements View.OnClickListener {

    private RecyclerView mRecyclerViewUnits;
    private UnitsAdapter mAdapter;

    public UnitsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_units, container, false);

        Button btnAddUnits = (Button) v.findViewById(R.id.btnAddUnits);
        btnAddUnits.setOnClickListener(this);

        mRecyclerViewUnits = (RecyclerView) v.findViewById(R.id.my_recycler_units);

        // Usar esta línea para mejorar el rendimiento
        mRecyclerViewUnits.setHasFixedSize(true);

        // Nuestro RecyclerView usará un linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewUnits.setLayoutManager(layoutManager);

        // Asociamos un adapter (ver más adelante cómo definirlo)

        ArrayList units = new ArrayList();
        Units units1 = new Units();
        units1.setTvType("Plataforma - Toyota - PlaToy");
        units1.setTvModel("Blanco - 2012");
        units1.setTvPT("Placa Tracto: PlatToy1-1");
        units1.setTvPC("Placa Carreta: PlatToy1-3");
        units.add(units1);
        units.add(units1);
        units.add(units1);
        mAdapter = new UnitsAdapter(units);
        mRecyclerViewUnits.setAdapter(mAdapter);

        return  v;



    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), AddUnitsActivity.class);

        startActivity(intent);
    }
}
