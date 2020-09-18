package com.dep.bestwallpaperapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dep.bestwallpaperapp.Adapterss.Rv_Adapter_Collections;
import com.dep.bestwallpaperapp.Modelss.Model_collections;
import com.dep.bestwallpaperapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment_Category#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment_Category extends Fragment {

    private List<Model_collections> mlist = new ArrayList<>();
    private RecyclerView rv_collections ;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

     private String mParam1;
    private String mParam2;

    public FirstFragment_Category() {
        // Required empty public constructor
    }

    public static FirstFragment_Category newInstance(String param1, String param2) {
        FirstFragment_Category fragment = new FirstFragment_Category();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_first__category, container, false);

       rv_collections = v.findViewById(R.id.rv_rv_collections_first_fragment);


        rv_collections =  v.findViewById(R.id.rv_rv_collections_first_fragment);

        mlist.add(new Model_collections("https://i.ibb.co/sgSDPgH/collections2.jpg"
                ,"FLUIDITY",
                "Exclusive imgs for pro users"));

        mlist.add(new Model_collections("https://i.ibb.co/HYXdzmM/collections1.jpg"
                ,"SPACE",
                "Best Collections of SPACE imagery from satellite"));

        mlist.add(new Model_collections("https://i.ibb.co/W0TLpxT/pexels-sindre-str-m-1106437-1.jpg"
                ,"EARTH",
                "Beautiful Collections of Sattelit imagery from google Earth"));




        setRvadapter(mlist);












/////////////////////////// Main

        return v;

/////////////////////////// Main

    }
///////////////////////////Welcome To Class

    private void setRvadapter (List<Model_collections> lst) {

        Rv_Adapter_Collections myAdapter = new Rv_Adapter_Collections(getActivity(), mlist);
        rv_collections.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rv_collections.setAdapter(myAdapter);
    }




}


