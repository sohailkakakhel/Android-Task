package com.example.sofitconsultancytask.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sofitconsultancytask.Adapters.ServicesAdapter;
import com.example.sofitconsultancytask.R;

public class ServicesFragment extends Fragment {

    RecyclerView recyclerViewServices;
    ServicesAdapter adapter;
    public ServicesFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services, container, false);

        recyclerViewServices = view.findViewById(R.id.rv_services);
        adapter = new ServicesAdapter(getActivity());
        recyclerViewServices.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewServices.setHasFixedSize(true);
        recyclerViewServices.setAdapter(adapter);



        return view;
    }
}