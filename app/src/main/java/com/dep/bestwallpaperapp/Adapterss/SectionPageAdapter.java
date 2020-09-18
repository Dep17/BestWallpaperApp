package com.dep.bestwallpaperapp.Adapterss;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionPageAdapter extends FragmentPagerAdapter  {

    private List<Fragment> fragment_list = new ArrayList<>();
    private List<String> fragments_title = new ArrayList<>();

    public SectionPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragment_list.get(position);
    }

    @Override
    public int getCount() {
        return fragment_list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments_title.get(position);
    }

    public void AddFragments(Fragment fragmenttt , String title){

        fragment_list.add(fragmenttt);
        fragments_title.add(title);
    }


}
