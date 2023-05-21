package com.example.hepsisurada;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hepsisurada.databinding.FragmentSearchBinding;
import com.example.hepsisurada.viewModel.SearchFragmentview;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding design;
    private SearchFragmentview viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
            viewModel.basket.observe(getViewLifecycleOwner(),my_basket-> {

            BasketAdapter adapter2 = new BasketAdapter(getContext(),my_basket,viewModel);
            design.recView.setAdapter(adapter2);
            design.recView.setHasFixedSize(true);

        });

        return design.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SearchFragmentview.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(),"resume",Toast.LENGTH_SHORT).show();

    }
}