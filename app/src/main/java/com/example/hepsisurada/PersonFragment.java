package com.example.hepsisurada;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hepsisurada.databinding.FragmentPersonBinding;
import com.example.hepsisurada.viewModel.PersonFragmentview;

import java.util.ArrayList;

public class PersonFragment extends Fragment {
    private FragmentPersonBinding design;
    private PersonFragmentview viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_person, container, false);

        return design.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PersonFragmentview.class);
    }

}
