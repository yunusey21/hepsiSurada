package com.example.hepsisurada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.hepsisurada.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding design;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        design = DataBindingUtil.setContentView(this, R.layout.activity_main);
        design.setMainAct(this);

        bindingElements();
    }

    private void bindingElements() {

        NavHostFragment navHostFragment = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.navhost);

        NavigationUI.setupWithNavController(design.botMenu, navHostFragment.getNavController());

    }
}