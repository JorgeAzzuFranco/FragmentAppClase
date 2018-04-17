package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentViewer extends Fragment {
    TextView textNom;
    TextView textTitulo;
    TextView textLugar;
    TextView textColor;
    ImageView imgPlaneta;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        textNom = view.findViewById(R.id.textId);
        textTitulo = view.findViewById(R.id.textTitulo);
        textLugar = view.findViewById(R.id.textLugar);
        textColor = view.findViewById(R.id.textColor);
        imgPlaneta = view.findViewById(R.id.imgPlaneta);

        Bundle bundle = this.getArguments();


        if(bundle != null){
            Toast.makeText(getActivity(), "Item: " + bundle.getString("KEY"), Toast.LENGTH_SHORT).show();

            textNom.setText(bundle.getString("KEY"));
            textTitulo.setText(bundle.getString("TIT"));
            textColor.setText(bundle.getString("COL"));
            textLugar.setText(bundle.getString("LUG"));
            imgPlaneta.setImageResource((int) bundle.getInt("IMG"));
        }

        return view;
    }


}
