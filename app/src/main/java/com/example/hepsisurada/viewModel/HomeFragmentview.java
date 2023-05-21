package com.example.hepsisurada.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hepsisurada.Object;
import com.example.hepsisurada.ObjectRepository;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentview  extends ViewModel {

    //public MutableLiveData<List<Object>> kisilerMut;
    public MutableLiveData<List<Object>> products = new MutableLiveData();

    public ObjectRepository oRepo;

    public HomeFragmentview() {
        //this.kisilerMut = new MutableLiveData<>();
        //this.onBasketMut = new MutableLiveData<>();
        this.oRepo = new ObjectRepository();
        getObj();
        this.products = oRepo.returnProcuts();
    }

    public void basketADD(String img_id,String name, int like_count, int id , boolean basket) {
        Object newobj  = new Object(img_id,name, like_count, id, basket);
        oRepo.objectADDRepo(newobj);
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

        oRepo.kisilerMut.setValue(lis);
    }

    public void add_basket(int id) {

    }

    public  void del_basket(int id) {
        oRepo.del(id);
    }

    public void like_for_obj(int id) {

    }
}
