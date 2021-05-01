package com.example.schoo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolender.R;

import java.util.ArrayList;

public class SubAdapter extends RecyclerView.Adapter {

    Context context;
    String id;
    ArrayList<madah> arrayList;

    public SubAdapter(Context context, String id, ArrayList<madah> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
        this.id = id;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvlayout2, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
            ((ViewHolder) holder).name.setText(arrayList.get(position).getName().toString());
            ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,tasklist.class);
                intent.putExtra("id",arrayList.get(position).getId());
                context.startActivity(intent);
                try {
                    ((ViewHolder) holder).rl.setBackgroundColor(Color.parseColor(arrayList.get(position).getColor()));
                } catch (Exception e) {

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void filterList(ArrayList<madah> filterList) {
        arrayList = filterList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public View view;
        public RelativeLayout rl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            rl = itemView.findViewById(R.id.subColor);

            name = itemView.findViewById(R.id.textView);


        }


    }


}
