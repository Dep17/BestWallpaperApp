package com.dep.bestwallpaperapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dep.bestwallpaperapp.Adapterss.RecyclerView_Adapter_gallery;
import com.dep.bestwallpaperapp.Modelss.Model_Gallery;
import com.dep.bestwallpaperapp.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.List;


public class SecondFragment_Recent extends Fragment {

      private RecyclerView rv_gallery ;
    private List<Model_Gallery> mlist_gallery = new ArrayList<>();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondFragment_Recent() {
        // Required empty public constructor
    }

    public static SecondFragment_Recent newInstance(String param1, String param2) {
        SecondFragment_Recent fragment = new SecondFragment_Recent();
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
        View v = inflater.inflate(R.layout.fragment_second__recent, container, false);




        rv_gallery =  v.findViewById(R.id.rv_rv_gallery_second_fragment);





        /// setup gallery recyclerview ///

        /// fetch img for gallery inside liste ///

        mlist_gallery.add(new Model_Gallery("Ocean","Kxnt",
                "https://i.ibb.co/K9X7Pvw/cold-dawn-dusk-2088200.jpg"
                ,"https://i.ibb.co/W2wmJLW/sunyu-kim-258.jpg",""));

        mlist_gallery.add(new Model_Gallery("Ocean","Kxnt",
                "https://i.ibb.co/SQbtYC3/wally3.jpg"
                ,"https://i.ibb.co/W2wmJLW/sunyu-kim-258.jpg",""));

        mlist_gallery.add(new Model_Gallery("Ocean","Kxnt",
                "https://i.ibb.co/JcxMbrX/wally1.jpg"
                ,"https://i.ibb.co/W2wmJLW/sunyu-kim-258.jpg",""));

        mlist_gallery.add(new Model_Gallery("Ocean","Kxnt",
                "https://i.ibb.co/tD91Dmn/wally2.jpg"
                ,"https://i.ibb.co/W2wmJLW/sunyu-kim-258.jpg",""));


        mlist_gallery.add(new Model_Gallery("Ocean","Kxnt",
                "https://i.ibb.co/xghwWtT/above-aerial-aerial-view-931018.jpg"
                ,"https://i.ibb.co/W2wmJLW/sunyu-kim-258.jpg",""));


        mlist_gallery.add(new Model_Gallery("Ocean","Kxnt",
                "https://i.ibb.co/bmJkPPj/dawn-evening-gradation.jpg"
                ,"https://i.ibb.co/W2wmJLW/sunyu-kim-258.jpg",""));


        mlist_gallery.add(new Model_Gallery("Ocean","Kxnt",
                "https://i.ibb.co/W0TLpxT/pexels-sindre-str-m-1106437-1.jpg"
                ,"https://i.ibb.co/W2wmJLW/sunyu-kim-258.jpg",""));

        mlist_gallery.add(new Model_Gallery("Ocean","Kxnt",
                "https://i.ibb.co/HYXdzmM/collections1.jpg"
                ,"https://i.ibb.co/W2wmJLW/sunyu-kim-258.jpg",""));

        mlist_gallery.add(new Model_Gallery("Ocean","Kxnt",
                "https://i.ibb.co/hZ2Cj0j/architecture-buildings-cobblestone-street-1294671.jpg"
                ,"https://i.ibb.co/W2wmJLW/sunyu-kim-258.jpg",""));
        mlist_gallery.add(new Model_Gallery("Ocean","Kxnt",
                "https://i.ibb.co/4PMPPJ9/4k-wallpaper-autumn-clouds-2310641.jpg"
                ,"https://i.ibb.co/W2wmJLW/sunyu-kim-258.jpg",""));






        setRvadapter(mlist_gallery);





        return v ;
    // end method
    }

    private void setRvadapter (List<Model_Gallery> lst) {

        RecyclerView_Adapter_gallery myAdapter = new RecyclerView_Adapter_gallery(getActivity(), lst);
        rv_gallery.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rv_gallery.setAdapter(myAdapter);
    }


 ////// end class
}