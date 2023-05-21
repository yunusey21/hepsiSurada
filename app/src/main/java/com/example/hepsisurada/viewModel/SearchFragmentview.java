package com.example.hepsisurada.viewModel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.hepsisurada.Object;
import com.example.hepsisurada.ObjectRepository;
import com.example.hepsisurada.R;
import com.example.hepsisurada.databinding.FragmentPersonBinding;

import java.util.ArrayList;
import java.util.List;

public class SearchFragmentview extends ViewModel {
    public ObjectRepository oRepo;
    public MutableLiveData<List<Object>> basket = new MutableLiveData();
    public SearchFragmentview() {
        this.oRepo = new ObjectRepository();
        getObj();
        basket = oRepo.returnBasket();
    }

    public void getObj() {
        Object o1 = new Object("id","patates soyucu",3,1,true);
        Object o2 = new Object("id1","ütü",4,2,false);
        Object o3 = new Object("id2","ekmek bıç",5,3,false);
        Object o4 = new Object("id3","soğanlık",2,4,true);
        Object o5 = new Object("id4","paratoner",1,5,false);

        ArrayList<Object> lis = new ArrayList<>();
        lis.add(o1);
        lis.add(o2);
        lis.add(o3);
        lis.add(o4);
        lis.add(o5);

        oRepo.onBasketMut.setValue(lis);
    }
}
