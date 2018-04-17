package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planets, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

        //Mis variables para llenar el objeto
        Planeta infoPlanet = new Planeta();
        Bundle bundle = new Bundle();

        infoPlanet.setTituloPlaneta(getResources().getStringArray(R.array.titlePlaneta));
        infoPlanet.setColorPlaneta(getResources().getStringArray(R.array.colorPlaneta));
        infoPlanet.setLugarSistSolar(getResources().getStringArray(R.array.lugarSolar));

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            newIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
            newIntent.setType("text/plain");
            //newIntent.putExtra(Intent.EXTRA_TEXT, adapterView.getItemAtPosition(i).toString());
            newIntent.putExtra("KEY", adapterView.getItemAtPosition(i).toString());
            newIntent.putExtra("TIT", infoPlanet.getTituloPlaneta()[i]);
            newIntent.putExtra("COL", infoPlanet.getColorPlaneta()[i]);
            newIntent.putExtra("LUG", infoPlanet.getLugarSistSolar()[i]);
            newIntent.putExtra("IMG", infoPlanet.getImgPlaneta()[i]);
            Log.d("Guarda?", adapterView.getItemAtPosition(i) + ", " +infoPlanet.getTituloPlaneta()[i]);
            startActivity(newIntent);
        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            //Mis codigos de bundle
            bundle.putString("KEY", adapterView.getItemAtPosition(i).toString());
            bundle.putString("TIT", infoPlanet.getTituloPlaneta()[i]);
            bundle.putString("COL", infoPlanet.getColorPlaneta()[i]);
            bundle.putString("LUG", infoPlanet.getLugarSistSolar()[i]);
            bundle.putInt("IMG", infoPlanet.getImgPlaneta()[i]);
            bundle.putString("KEY", adapterView.getItemAtPosition(i).toString());

            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundle);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }
    }
}
