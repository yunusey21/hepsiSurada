package com.example.hepsisurada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hepsisurada.databinding.ObjectDesignBinding;
import com.example.hepsisurada.viewModel.HomeFragmentview;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ObjectsAdapter extends RecyclerView.Adapter<ObjectsAdapter.ObjectHolder> {

    private Context cnt;
    private List<Object> objectList;
    private HomeFragmentview viewModel;

    public ObjectsAdapter(Context cnt, List<Object> objectList, HomeFragmentview viewModel) {
        this.cnt = cnt;
        this.objectList = objectList;
        this.viewModel = viewModel;
    }

    public class ObjectHolder extends RecyclerView.ViewHolder {
        private ObjectDesignBinding designBinding;

        public ObjectHolder(ObjectDesignBinding designBinding) {
            super(designBinding.getRoot());
            this.designBinding = designBinding;
        }
    }

    @NonNull
    @Override
    public ObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(cnt);
        ObjectDesignBinding design = DataBindingUtil.inflate(layoutInflater,R.layout.object_design,parent,false);
        return new ObjectHolder(design);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjectHolder holder, int position) {
        Object obj = objectList.get(position);
        ObjectDesignBinding ob = holder.designBinding;
        ob.setObjectData(obj);

        ob.objImg.setImageResource(R.drawable.ic_baseline_home_24);
        ob.objName.setText(obj.getName());

        ob.addBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectRepository oRepo = new ObjectRepository();
                viewModel.oRepo.objectADDRepo(obj);
                Snackbar.make(v,"bu sepetten sil", Snackbar.LENGTH_SHORT)
                        .setAction("Evet", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                viewModel.del_basket(obj.getId());
                            }
                        }).show();
            }
        });

        ob.objLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.like_for_obj(obj.getId());
            }
        });

        ob.objImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //detay sayfasına geçilcek
            }
        });
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }


}
