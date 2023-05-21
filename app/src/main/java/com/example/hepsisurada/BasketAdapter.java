package com.example.hepsisurada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hepsisurada.databinding.ObjectDesignBinding;
import com.example.hepsisurada.viewModel.SearchFragmentview;

import java.util.ArrayList;
import java.util.List;


public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.HolderDesign> {

    private Context cnt;
    private List<Object> datas;
    private SearchFragmentview view;

    public BasketAdapter(Context cnt, List<Object> datas, SearchFragmentview view) {
        this.cnt = cnt;
        this.datas = datas;
        this.view = view;
    }

    @NonNull
    @Override
    public HolderDesign onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.object_names,parent,false);
        return new HolderDesign(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BasketAdapter.HolderDesign holder, int position) {
        Object obj = datas.get(position);
        holder.tx.setText(obj.getName());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class HolderDesign extends RecyclerView.ViewHolder {

        private CardView cv;
        private TextView tx;

        public HolderDesign(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.names_card);
            tx = itemView.findViewById(R.id.name_text);


        }
    }
}

