package com.dep.bestwallpaperapp.Activitiess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dep.bestwallpaperapp.Adapterss.Rv_Adapter_fav;
import com.dep.bestwallpaperapp.Databases.DB_sqlit;
import com.dep.bestwallpaperapp.R;

public class Favorite_Activity extends AppCompatActivity {
  private   RecyclerView rv_fav;
  private ImageView img_back_fav ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_);

        rv_fav = findViewById(R.id.rv_favv);

        img_back_fav = findViewById(R.id.img_back_fav);

        // back button pressed

        img_back_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Favorite_Activity.this.finish();
            }
        });


        //  setup_RecyclerView_fav();


        DB_sqlit dbb = new DB_sqlit(Favorite_Activity.this);

        int g = dbb.Get_Selected_Imgs().size();

        if (g > 0) {

            Rv_Adapter_fav adapter_backup = new Rv_Adapter_fav(Favorite_Activity.this, dbb.Get_Selected_Imgs());
            rv_fav.setLayoutManager(new GridLayoutManager(Favorite_Activity.this, 3));
            rv_fav.setAdapter(adapter_backup);
        } else {

            rv_fav.setVisibility(View.INVISIBLE);


        }




        /// end main
    }

    /// end class
}