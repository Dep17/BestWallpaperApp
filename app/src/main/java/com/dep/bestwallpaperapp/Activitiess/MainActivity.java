package com.dep.bestwallpaperapp.Activitiess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dep.bestwallpaperapp.Adapterss.SectionPageAdapter;
import com.dep.bestwallpaperapp.Fragments.FifthFragment_Random;
import com.dep.bestwallpaperapp.Fragments.FirstFragment_Category;
import com.dep.bestwallpaperapp.Fragments.ForthFragment_Popular;
import com.dep.bestwallpaperapp.Fragments.SecondFragment_Recent;
import com.dep.bestwallpaperapp.Fragments.ThirdFragment_Featured;
import com.dep.bestwallpaperapp.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ViewPager viewpager;
    private TabLayout tablLayout;
    private SectionPageAdapter adapter;
    private ImageView img_menu;
    private  DrawerLayout drawerLayout;
    private NavigationView navigationView ;
      TextView title_of_selected_fragments ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_menu = findViewById(R.id.image_menuuuuuu);
        drawerLayout = findViewById(R.id.drawer_layouttt);
        viewpager = findViewById(R.id.viewpager_backdrop);
        tablLayout = findViewById(R.id.tablayout_backdrop);
        title_of_selected_fragments = findViewById(R.id.txt_title_tabs2);

        adapter = new SectionPageAdapter(getSupportFragmentManager());

        // add fragment

        adapter.AddFragments(new FirstFragment_Category(), "Category");
        adapter.AddFragments(new SecondFragment_Recent(), "Recent");
        adapter.AddFragments(new ThirdFragment_Featured(), "Featured");
        adapter.AddFragments(new ForthFragment_Popular(), "Popular");
        adapter.AddFragments(new FifthFragment_Random(), "Random");

        // setup view pager
        viewpager.setAdapter(adapter);
        tablLayout.setupWithViewPager(viewpager);

        // add icons to the fragments
        /*
        tablLayout.getTabAt(0).setIcon(R.drawable.ic_globe);
        tablLayout.getTabAt(1).setIcon(R.drawable.ic_compass);
        tablLayout.getTabAt(2).setIcon(R.drawable.ic_montain);
        tablLayout.getTabAt(3).setIcon(R.drawable.ic_heart_favorite_empty);
        */
        // start from fragment 1

        viewpager.setCurrentItem(1);

        /// change title of toolbar when specific fragment are selected

       viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
               // to change title of selected fragment
               switch (position){

                   case 0 :
                       title_of_selected_fragments.setText("Category");
                       break;
                   case 1 :
                       title_of_selected_fragments.setText("Recent");
                       break;
                   case 2 :
                       title_of_selected_fragments.setText("Feature");
                       break;
                   case 3 :
                       title_of_selected_fragments.setText("Popular");
                       break;


               }

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

        /// Drawer


        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

          // navigation view
           navigationView = findViewById(R.id.navigation_viewww);

        setNavMenuItemThemeColors(0x4caf50);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();


        /////  /////
    }
    public void setNavMenuItemThemeColors(int color){
        //Setting default colors for menu item Text and Icon
        int navDefaultTextColor = Color.parseColor("#202020");
        int navDefaultIconColor = Color.parseColor("#737373");

        //Defining ColorStateList for menu item Text
        ColorStateList navMenuTextList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_checked},
                        new int[]{android.R.attr.state_enabled},
                        new int[]{android.R.attr.state_pressed},
                        new int[]{android.R.attr.state_focused},
                        new int[]{android.R.attr.state_pressed}
                },
                new int[] {
                        color,
                        navDefaultTextColor,
                        navDefaultTextColor,
                        navDefaultTextColor,
                        navDefaultTextColor
                }
        );

        //Defining ColorStateList for menu item Icon
        ColorStateList navMenuIconList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_checked},
                        new int[]{android.R.attr.state_enabled},
                        new int[]{android.R.attr.state_pressed},
                        new int[]{android.R.attr.state_focused},
                        new int[]{android.R.attr.state_pressed}
                },
                new int[] {
                        color,
                        navDefaultIconColor,
                        navDefaultIconColor,
                        navDefaultIconColor,
                        navDefaultIconColor
                }
        );

        navigationView.setItemTextColor(navMenuTextList);
        navigationView.setItemIconTintList(navMenuIconList);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

       switch (item.getItemId())
      {

          case R.id.Explore_item :
              drawerLayout.closeDrawer(GravityCompat.START);
              viewpager.setCurrentItem(1);

              break;
          case R.id.Favorite_item:

              Intent intent = new Intent(MainActivity.this,Favorite_Activity.class);
              startActivity(intent);
      }

        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }
///  ///  ///////
}