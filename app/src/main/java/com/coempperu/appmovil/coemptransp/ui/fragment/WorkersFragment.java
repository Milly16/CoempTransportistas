package com.coempperu.appmovil.coemptransp.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.coempperu.appmovil.coemptransp.R;
import com.coempperu.appmovil.coemptransp.ui.AddWorkerActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkersFragment extends Fragment implements View.OnClickListener {


    public WorkersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_workers, container, false);

        Button btnAddWorker = (Button) v.findViewById(R.id.btnAddWorker);
        btnAddWorker.setOnClickListener(this);

        return  v;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), AddWorkerActivity.class);

        startActivity(intent);
    }
}
