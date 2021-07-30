package com.example.sofitconsultancytask.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sofitconsultancytask.Activities.MainActivity;
import com.example.sofitconsultancytask.Adapters.ImagesAdapter;
import com.example.sofitconsultancytask.Adapters.PaymentAdapter;
import com.example.sofitconsultancytask.ModelClasses.ImagesModel;
import com.example.sofitconsultancytask.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ImageView btn_home, btn_services, btn_posts;
    private RecyclerView rv_images;
    private RecyclerView rv_paymentHistory;
    ImageView iv_service1, iv_service2, iv_service3, iv_service4;
    ImageView iv_otherservice1, iv_otherservice2, iv_otherservice3, iv_otherservice4;
    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btn_home = view.findViewById(R.id.btn_home);
        btn_services = view.findViewById(R.id.btn_services);
        btn_posts = view.findViewById(R.id.btn_posts);
        rv_images = view.findViewById(R.id.rv_top_images);
        rv_paymentHistory = view.findViewById(R.id.rv_paymentHistory);
        iv_service1 = view.findViewById(R.id.iv_img1);
        iv_service2 = view.findViewById(R.id.iv_img2);
        iv_service3 = view.findViewById(R.id.iv_img3);
        iv_service4 = view.findViewById(R.id.iv_img4);

        iv_otherservice1 = view.findViewById(R.id.iv_img11);
        iv_otherservice2 = view.findViewById(R.id.iv_img22);
        iv_otherservice3 = view.findViewById(R.id.iv_img33);
        iv_otherservice4 = view.findViewById(R.id.iv_img44);

        itemClickListeners();
        setRecyclerViewData();
        setGovtServices();
        setOtherServices();



        return view;
    }

    private void setGovtServices() {

        Picasso.get().load(getString(R.string.url1)).into(iv_service1);
        Picasso.get().load(getString(R.string.url2)).into(iv_service2);
        Picasso.get().load(getString(R.string.url3)).into(iv_service3);
        Picasso.get().load(getString(R.string.url4)).into(iv_service4);

    }

    private void setOtherServices() {

        Picasso.get().load(getString(R.string.url5)).into(iv_otherservice1);
        Picasso.get().load(getString(R.string.url6)).into(iv_otherservice2);
        Picasso.get().load(getString(R.string.url7)).into(iv_otherservice3);
        Picasso.get().load(getString(R.string.url8)).into(iv_otherservice4);

    }


    private void setRecyclerViewData() {

        callImagesRecyclerview();
        callPaymentHistoryRecyclerview();

    }


    private void callImagesRecyclerview() {
        final int[] images = {R.drawable.n7, R.drawable.n3, R.drawable.n4, R.drawable.n6, R.drawable.n1};
        final String description = getString(R.string.description);
        ArrayList<ImagesModel> arrayList = new ArrayList<>();

        for (int i = 0; i < images.length; i++) {
            ImagesModel model = new ImagesModel(images[i], description);
            arrayList.add(model);
        }

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv_images.setLayoutManager(layoutManager);
        rv_images.setHasFixedSize(true);
        ImagesAdapter adapter = new ImagesAdapter(arrayList, getActivity());
        rv_images.setAdapter(adapter);
    }

    private void callPaymentHistoryRecyclerview() {
        final int[] images = {R.drawable.onlinepayment, R.drawable.receipt, R.drawable.debitcard, R.drawable.creditcard};
        final String title = getString(R.string.paymentHistory);
        ArrayList<ImagesModel> arrayList = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            ImagesModel model = new ImagesModel(images[i], title);
            arrayList.add(model);
        }

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv_paymentHistory.setLayoutManager(layoutManager);
        rv_paymentHistory.setHasFixedSize(true);
        PaymentAdapter adapter = new PaymentAdapter(arrayList, getActivity());
        rv_paymentHistory.setAdapter(adapter);

    }


    private void itemClickListeners() {

        btn_posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new PostsFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                        .addToBackStack(null).commit();
            }
        });

        btn_services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ServicesFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                        .addToBackStack(null).commit();
            }
        });
    }
}