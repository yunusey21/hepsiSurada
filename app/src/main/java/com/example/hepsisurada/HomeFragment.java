package com.example.hepsisurada;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hepsisurada.databinding.FragmentHomeBinding;
import com.example.hepsisurada.databinding.FragmentSearchBinding;
import com.example.hepsisurada.viewModel.HomeFragmentview;
import com.example.hepsisurada.viewModel.SearchFragmentview;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding design;
    private HomeFragmentview viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        viewModel.products.observe(getViewLifecycleOwner(), my_list -> {
            ObjectsAdapter adapter = new ObjectsAdapter(getContext(),my_list,viewModel);
            design.recyclerView.setAdapter(adapter);
            design.recyclerView.setHasFixedSize(true);
        } );


        return design.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomeFragmentview.class);
    }

}