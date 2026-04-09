package com.example.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khaija.Adapters.BurgerAdapter;
import com.example.khaija.Models.BurgerRecipie;
import com.example.khaija.R;
import com.example.khaija.databinding.FragmentBurgerBinding;

import java.util.ArrayList;


public class Burger extends Fragment {


    public Burger() {
        // Required empty public constructor
    }

    FragmentBurgerBinding binding;


//    RecyclerView recyclerView;
//    ArrayList<BurgerRecipie> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_burger, container, false);
//        return view;

        binding = FragmentBurgerBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<BurgerRecipie> list = new ArrayList<>();
        list.add(new BurgerRecipie(R.drawable.bison, "BISON BURGER", "50", "BISON BURGER WITH LOT OF SPICES"));
        list.add(new BurgerRecipie(R.drawable.beef, "BEEF BURGER", "55", "FRESH BEEF BURGER WITH FRIES"));
        list.add(new BurgerRecipie(R.drawable.blackbean, "BLACK BEAN BURGER", "40", "BLACK BEAN BURGER WITH DRINK AND FRIES"));
        list.add(new BurgerRecipie(R.drawable.zinger, "ZINGER BURGER", "35", "HOT&SPICY ZINGER BURGER"));
        list.add(new BurgerRecipie(R.drawable.vegetable, "VEGETABLES BURGER", "60", "FRESH VEGETABLES BURGER WITH INCLUDING CHICKEN"));
        list.add(new BurgerRecipie(R.drawable.wildsalmon, "WILDSALMON BURGER", "45", "WILDSALMON BURGER WITH REGULAR DRINK AND FRIES"));


        binding.burgerRecycler.setAdapter(new BurgerAdapter(list, getContext()));
        binding.burgerRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
//        recyclerView = view.findViewById(R.id.burgerRecycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        list = new ArrayList<>();
//
//        BurgerRecipie ob1 = new BurgerRecipie(R.drawable.zinger,"ZINGER BURGER");
//        list.add(ob1);
//        BurgerRecipie ob2 = new BurgerRecipie(R.drawable.bison,"BISON BURGER");
//        list.add(ob2);
//        BurgerRecipie ob3 = new BurgerRecipie(R.drawable.beef,"BEEF BURGER");
//        list.add(ob3);
//        BurgerRecipie ob4 = new BurgerRecipie(R.drawable.blackbean,"BLACK BEAN BURGER");
//        list.add(ob4);
//        BurgerRecipie ob5 = new BurgerRecipie(R.drawable.wildsalmon,"WILD SALMON BURGER");
//        list.add(ob5);
//
//
//        recyclerView.setAdapter(new BurgerAdapter(list));
//
//        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener
//                (getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, int position) {
//                        switch (position){
//                            case 0:
//                                Intent intent = new Intent(getContext(), ScrollingActivity.class);
//                                startActivity(intent);
//                                break;
//                            case 1:
//                                Toast.makeText(getContext(), "Bison Burger Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 2:
//                                Toast.makeText(getContext(), "Beef Burger Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 3:
//                                Toast.makeText(getContext(), "Black Bean Burger Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 4:
//                                Toast.makeText(getContext(), "Wild Salmon Burger Selected", Toast.LENGTH_SHORT).show();
//                                break;
//
//
//                            default:
//                        }
//
//                    }
//
//                    @Override
//                    public void onLongItemClick(View view, int position) {
//
//                    }
//                }
//
//                ));
//
//
//
//    }
