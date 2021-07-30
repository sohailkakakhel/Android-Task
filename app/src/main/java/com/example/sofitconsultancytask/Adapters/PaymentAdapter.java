package com.example.sofitconsultancytask.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sofitconsultancytask.ModelClasses.ImagesModel;
import com.example.sofitconsultancytask.R;

import java.util.ArrayList;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.MyViewHolder> {

    ArrayList<ImagesModel> arrayList;
    Context context;

    public PaymentAdapter(ArrayList<ImagesModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_layout, parent, false);
        return new PaymentAdapter.MyViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ImagesModel model = arrayList.get(position);
        holder.imageView.setImageResource(model.getImageId());
        holder.tv_title.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tv_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv_payment);
            tv_title = itemView.findViewById(R.id.tv_paymentHistory);
        }
    }
}
