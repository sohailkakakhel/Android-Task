package com.example.sofitconsultancytask.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sofitconsultancytask.Adapters.DumyDataAdapter;
import com.example.sofitconsultancytask.ApiInterface.DummyDataApi;
import com.example.sofitconsultancytask.ApiResponse.DumyDataResponse;
import com.example.sofitconsultancytask.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsFragment extends Fragment {

    String url = "https://jsonplaceholder.typicode.com";
    ProgressDialog progressDialog;
    RecyclerView recyclerViewPosts;


    public PostsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        recyclerViewPosts = view.findViewById(R.id.rv_posts);
        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPosts.setHasFixedSize(true);


        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Fetching Data");
        progressDialog.setMessage("Please Wait..");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client1 = new OkHttpClient();
        client1 = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client1)
                .build();

        DummyDataApi dumyDataApi = retrofit.create(DummyDataApi.class);
        Call<List<DumyDataResponse>> call2 = dumyDataApi.getDumyData();
        call2.enqueue(new Callback<List<DumyDataResponse>>() {
            @Override
            public void onResponse(Call<List<DumyDataResponse>> call, Response<List<DumyDataResponse>> response) {

                List<DumyDataResponse> dumyDataResponse = response.body();
                progressDialog.cancel();

                if (!response.isSuccessful()){
                    Toast.makeText(getActivity(), response.body().toString(), Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Toast.makeText(getContext(), "Response Successful", Toast.LENGTH_SHORT).show();

                    DumyDataAdapter adapter = new DumyDataAdapter(dumyDataResponse, getContext());
                    recyclerViewPosts.setAdapter(adapter);

                }

            }

            @Override
            public void onFailure(Call<List<DumyDataResponse>> call, Throwable t) {
                progressDialog.cancel();
                Toast.makeText(getContext(), "Failure Called", Toast.LENGTH_SHORT).show();
                call.cancel();

            }
        });

        return view;
    }
}