package com.example.hepsisurada;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class ObjectRepository {

    private static ObjectRepository instance = null;
    public MutableLiveData<List<Object>> onBasketMut; //sepet
    public MutableLiveData<List<Object>> kisilerMut; //ürünler
    private List<Object> tempList;

    public ObjectRepository() {
        this.onBasketMut = new MutableLiveData<>();
        this.kisilerMut = new MutableLiveData<>();
    }

    public static ObjectRepository getInstance()
    {
        // eğer daha önce örnek oluşturulmamış ise sınıfın tek örneğini oluştur
        if(instance == null)
        {
            instance  = new ObjectRepository();
        }
        return instance;
    }

    public void objectADDRepo(Object obj) {
        if (this.onBasketMut.getValue() == null) {
            tempList = new ArrayList<>();
        } else {
            tempList = this.onBasketMut.getValue();
        }

        tempList.add(obj);
        this.onBasketMut.setValue(tempList);

        Log.i("liste" ,tempList.get(0).getName());
    }

    public MutableLiveData<List<Object>> returnProcuts() {

        return this.kisilerMut;
    }

    public MutableLiveData<List<Object>> returnBasket() {
        return this.onBasketMut;
    }

    public void del(int id) {
        Log.i("systemInfo","id"+id);
    }

    public List<Object> getCurrentBasketList() {
        return this.onBasketMut.getValue();
    }
}
