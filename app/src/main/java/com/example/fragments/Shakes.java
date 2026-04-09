package com.example.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khaija.Adapters.ShakesAdapter;
import com.example.khaija.Models.ShakesRecipie;
import com.example.khaija.R;
import com.example.khaija.databinding.FragmentShakesBinding;

import java.util.ArrayList;


public class Shakes extends Fragment {


    public Shakes() {
        // Required empty public constructor
    }

    FragmentShakesBinding binding;

//    RecyclerView recyclerView;
//    ArrayList<ShakesRecipie> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_shakes, container, false);
//        return view;

        binding = FragmentShakesBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<ShakesRecipie> list = new ArrayList<>();
        list.add(new ShakesRecipie(R.drawable.apple, "APPLE SHAKE", "10", "FRESH APPLE JUICE"));
        list.add(new ShakesRecipie(R.drawable.banana, "BANANA SHAKE", "12", "FRESH BANANA MILK SHAKE WITH PROTIENS"));
        list.add(new ShakesRecipie(R.drawable.mango, "MANGO SHAKE", "13", "DELICIOUS MANGO SHAKE"));
        list.add(new ShakesRecipie(R.drawable.choclate, "CHOCLATE SHAKE", "15", "CHOCLATE SHAKE WITH PROTIENS"));
        list.add(new ShakesRecipie(R.drawable.coconutmint, "COCOMINT SHAKE", "20", "COCONUT MINT SHAKE WITH ALMONDS"));
        list.add(new ShakesRecipie(R.drawable.almond, "ALMOND SHAKE", "22", "PURE ALMOND SHAKE"));
        list.add(new ShakesRecipie(R.drawable.rasberry, "RASBERRY", "25", "FRESH RASEBERRY SHAKE"));
        list.add(new ShakesRecipie(R.drawable.rice, "RICE PROTIEN SHAKE", "30", "PURE PROTIEN RICE SHAKE INCLUDING PROTIEN POWDER"));
        list.add(new ShakesRecipie(R.drawable.strwabery, "STRAWBERRY SHAKE", "19", "SWEET STRAWBERRY SHAKE WITH MILK"));
        list.add(new ShakesRecipie(R.drawable.vanila, "VANILLA SHAKE", "14", "CREAMY VANILLA SHAKE "));

        binding.shakesRecycler.setAdapter(new ShakesAdapter(list, getContext()));
        binding.shakesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}
//        recyclerView = view.findViewById(R.id.shakesRecycler);
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
//        list = new ArrayList<>();
//
//        list.add(new ShakesRecipie(R.drawable.banana,"BANANA SHAKE"));
//        list.add(new ShakesRecipie(R.drawable.mango,"MANGO SHAKE "));
//        list.add(new ShakesRecipie(R.drawable.apple,"APPLE SHAKE"));
//        list.add(new ShakesRecipie(R.drawable.choclate,"CHOCLATE SHAKE"));
//        list.add(new ShakesRecipie(R.drawable.strwabery,"STRWABERY SHAKE"));
//        list.add(new ShakesRecipie(R.drawable.almond,"ALMOND SHAKE"));
//        list.add(new ShakesRecipie(R.drawable.vanila,"VANILLA SHAKE "));
//        list.add(new ShakesRecipie(R.drawable.rasberry,"RASPBERRY SHAKE"));
//        list.add(new ShakesRecipie(R.drawable.coconutmint,"COCONUT MINT SHAKE"));
//        list.add(new ShakesRecipie(R.drawable.rice,"RICE PROTIEN SHAKE"));
//
//
//
//        recyclerView.setAdapter(new ShakesAdapter(list));
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
//                                Toast.makeText(getContext(), "Mango Shake Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 2:
//                                Toast.makeText(getContext(), "Apple Shake Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 3:
//                                Toast.makeText(getContext(), "Choclate Shake Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 4:
//                                Toast.makeText(getContext(), "Strwabery Shake Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 5:
//                                Toast.makeText(getContext(), "Almond Shake Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 6:
//                                Toast.makeText(getContext(), "Vanila Shake Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 7:
//                                Toast.makeText(getContext(), "Raspberry Shake Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 8:
//                                Toast.makeText(getContext(), "Coconut Mint Shake Selected", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 9:
//                                Toast.makeText(getContext(), "Rice Protien Shake Selected", Toast.LENGTH_SHORT).show();
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
//
//
//
//    }
