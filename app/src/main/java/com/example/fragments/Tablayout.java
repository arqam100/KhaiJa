package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khaija.PageAdapter;
import com.example.khaija.R;
import com.google.android.material.tabs.TabLayout;


public class Tablayout extends Fragment {


    View view;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pagerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_tablayout, container, false);
        tabLayout = view.findViewById(R.id.tabLayout1);
//        tabLayout.addTab(tabLayout.newTab().setText("Pizza"));
//        tabLayout.addTab(tabLayout.newTab().setText("Pizza"));
//        tabLayout.addTab(tabLayout.newTab().setText("Pizza"));

//        tabLayout.addTab(new TabLayout.Tab().setText("abc"));
//        tabLayout.addTab(new TabLayout.Tab().setText("sns"));

        viewPager = view.findViewById(R.id.vPager);

        pagerAdapter = new PageAdapter(getFragmentManager());
        pagerAdapter.addFrag(new Pizza(), "Pizza");
        pagerAdapter.addFrag(new Burger(), "Burger");
        pagerAdapter.addFrag(new Shakes(), "Shakes");

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}