package com.example.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khaija.Adapters.PizzaAdapter;
import com.example.khaija.Models.PizzaRecipie;
import com.example.khaija.R;
import com.example.khaija.databinding.FragmentPizzaBinding;

import java.util.ArrayList;


public class Pizza extends Fragment {




    public Pizza() {
        // Required empty public constructor
    }


    FragmentPizzaBinding binding;

//    RecyclerView recyclerView;
//    ArrayList<PizzaRecipie> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_pizza, container, false);
//        return view;

        binding = FragmentPizzaBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<PizzaRecipie> list = new ArrayList<>();
        list.add(new PizzaRecipie(R.drawable.bbqchicken,"BBQ CHICKEN PIZZA","100","BBQ CHICKEN PIZZA WITH EXTRA CHESSE"));
        list.add(new PizzaRecipie(R.drawable.pepperoni,"PEPPERONI PIZZA","110","PEPPERONI PIZZA WITH SOME EXTRA SPICES"));
        list.add(new PizzaRecipie(R.drawable.meat,"MEAT PIZZA","90","FRESH MEAT PIZZA"));
        list.add(new PizzaRecipie(R.drawable.chese,"CHESSE PIZZA","120","PIZZA WITH LOT OF CHESSE"));
        list.add(new PizzaRecipie(R.drawable.margherita,"MARGHERITA PIZZA","150","MARGHERITA PIZZA WITH DELICIOUS TASTE"));
        list.add(new PizzaRecipie(R.drawable.supreme,"SUPREME PIZZA","130","SUPREME PIZZA ACCORDING TO YOUR TASTE"));
        list.add(new PizzaRecipie(R.drawable.hawaiian,"HAWAIIAN PIZZA","170","HAWAIIAN PIZZA WITH EXTRA FUN"));
        list.add(new PizzaRecipie(R.drawable.veggie,"VEGETABLES PIZZA","85","PIZZA WITH FRESH VEGETABLES"));

        binding.pizzaRecycler.setAdapter(new PizzaAdapter(list,getContext()));
        binding.pizzaRecycler.setLayoutManager(new LinearLayoutManager(getContext()));


    }
}

//        recyclerView = view.findViewById(R.id.pizzaRecycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        list = new ArrayList<>();
//
//
//
//        PizzaRecipie ob1 = new PizzaRecipie(R.drawable.bbqchicken,"BBQ CHICKEN PIZZA");
//        list.add(ob1);
//        PizzaRecipie ob2 = new PizzaRecipie(R.drawable.chese,"CHEESE PIZZA");
//        list.add(ob2);
//        PizzaRecipie ob3 = new PizzaRecipie(R.drawable.meat,"MEAT PIZZA");
//        list.add(ob3);
//        PizzaRecipie ob4 = new PizzaRecipie(R.drawable.supreme,"SUPREME PIZZA");
//        list.add(ob4);
//        PizzaRecipie ob5 = new PizzaRecipie(R.drawable.pepperoni,"PEPPERONI PIZZA");
//        list.add(ob5);
//        PizzaRecipie ob6 = new PizzaRecipie(R.drawable.veggie,"VEGETABLES PIZZA");
//        list.add(ob6);
//        PizzaRecipie ob7 = new PizzaRecipie(R.drawable.margherita,"MARGHERITA PIZZA");
//        list.add(ob7);
//        PizzaRecipie ob8 = new PizzaRecipie(R.drawable.hawaiian,"HAWAIIAN PIZZA");
//        list.add(ob8);
//
//
//
//
//
//
//
//        recyclerView.setAdapter(new PizzaAdapter(list));
//
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
//                                Toast.makeText(getContext(), "Chesse Pizza Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 2:
//                                Toast.makeText(getContext(), "Meat Pizza Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 3:
//                                Toast.makeText(getContext(), "Supreme Pizza Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 4:
//                                Toast.makeText(getContext(), "Pepperoni Pizza Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 5:
//                                Toast.makeText(getContext(), "Vegetables Pizza Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 6:
//                                Toast.makeText(getContext(), "Margherita Pizza Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 7:
//                                Toast.makeText(getContext(), "Hawaiian Pizza Selected", Toast.LENGTH_SHORT).show();
//                                break;
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



