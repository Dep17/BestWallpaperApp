package com.dep.bestwallpaperapp.Activitiess;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;

import android.accounts.OnAccountsUpdateListener;
import android.animation.Animator;
import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dep.bestwallpaperapp.Databases.DB_sqlit;
import com.dep.bestwallpaperapp.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class Details_img_Activity extends AppCompatActivity {
    final static Random RANDOM = new Random();
    private ImageView img_author, img_menu;
    private TextView txt_v_name_author;
    private TextView txt_v_img_title;
    private TextView txt_v_img_Description;
    private TextView txt_v_downloads;
    private TextView txt_v_dimension;
    private TextView txt_v_category;
    private TextView txt_v_img_size;
    private TextView txt_category_details;
    private TextView text_color_tst;
    private NestedScrollView nestedscrolview_big;
    private ImageView img_wallpaper;
    private CheckBox mychechbox;
    private DownloadManager downloadManager;
    private LinearLayout ln_download;
    private LinearLayout ln_set;
    private LinearLayout linearLayout_uppp;
    private AppBarLayout appBarLayout;
    private ConstraintLayout constraintLayout_big_dwn, constraintLayout_dwn1;
    private FloatingActionButton fab;
    private ImageView imgback;
    private BottomSheetBehavior mbottomSheetBehavior;
    private TextView txt_category_details2;
    private ImageView img_share , img_downld , img_set_img;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_img_);
        // ini


        img_author = findViewById(R.id.img_of_author);
        img_wallpaper = findViewById(R.id.img_wallpaperrrr);
        txt_v_name_author = findViewById(R.id.name_of_author);
        txt_v_img_title = findViewById(R.id.name_of_img);
        txt_v_img_Description = findViewById(R.id.txt_description_of_wallpaper);
        txt_v_downloads = findViewById(R.id.txt_download_number_of_wallpaper);
        txt_v_dimension = findViewById(R.id.txt_dimension_of_wallpaper);
        txt_v_category = findViewById(R.id.txt_category_of_wallpaper);
        txt_v_img_size = findViewById(R.id.txt_size_of_wallpaper);
        ln_download = findViewById(R.id.ln_Save);
        ln_set = findViewById(R.id.ln_set);
        mychechbox = findViewById(R.id.myCompatCheckBox_id);
        constraintLayout_big_dwn = findViewById(R.id.cnstrn_layout_img_details_down_big);
        linearLayout_uppp = findViewById(R.id.linearLayout_uppp);
        constraintLayout_dwn1 = findViewById(R.id.constraintLayout_dwn1);
        text_color_tst = findViewById(R.id.text_color_tst);
        imgback = findViewById(R.id.img_back);
        // Default visible
        txt_category_details = findViewById(R.id.textView_category_details_wallpaper);
        // Default gone
        txt_category_details2 = findViewById(R.id.textView_category_details_wallpaper2);
        img_share = findViewById(R.id.share_details);
        img_downld = findViewById(R.id.downloadd);
        img_set_img = findViewById(R.id.sett_wallpaper);
        final View bottomsheet = findViewById(R.id.botttoms_sheet);

        // Method of  buttons ( share , download , fav... )

        config_buttons ();

        // bottom sheet stup

        mbottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);


        // back button

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Details_img_Activity.this.finish();


            }
        });

        // run the big method that contains: floating button , load imgs , downloading , favorite checkbox ...

        big_method();


///////// end main method ///////
    }


///////// Methods///////////////


    private void config_buttons (){

        img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Details_img_Activity.this, "sharing..", Toast.LENGTH_SHORT).show();
            }
        });

        img_downld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Details_img_Activity.this, "Downloading...", Toast.LENGTH_SHORT).show();
            }
        });

        img_set_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Details_img_Activity.this, "Img Set !", Toast.LENGTH_SHORT).show();
            }
        });



    }

    //   big method that contains: floating button , load imgs , downloading , favorite checkbox ...

    private void big_method() {

        // collaps bottom sheet when text category is clicked

        txt_category_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mbottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                txt_category_details.setVisibility(View.GONE);
                txt_category_details2.setVisibility(View.VISIBLE);


            }

        });

        txt_category_details2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mbottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                txt_category_details2.setVisibility(View.GONE);
                txt_category_details.setVisibility(View.VISIBLE);


            }

        });


        // get extra

        final String urll_view = getIntent().getStringExtra("Img_url");
        final String url_img_authorrrrr = getIntent().getStringExtra("img_author");
        final String txt_img_titttle = getIntent().getStringExtra("img_title");
        final String txt_author_nameeee = getIntent().getStringExtra("author_name");
        final String url_download = getIntent().getStringExtra("url_Donwload");


        // fetch data to xml of gallery_details Activity

        txt_v_name_author.setText(txt_author_nameeee);
        txt_v_img_title.setText(txt_img_titttle);


        //load img author profile :


        Glide.with(this)
                .load(url_img_authorrrrr)
                .apply(new RequestOptions()
                                .placeholder(R.drawable.ic_user).centerInside()
                        //.fitCenter() // no need for this
                )
                .into(img_author);


        // load imgview :

        Glide.with(this)
                .load(urll_view)
                .apply(new RequestOptions()
                                .placeholder(R.drawable.ic_loading_wallpaper).centerInside()
                        //.fitCenter() // no need for this
                )
                .into(img_wallpaper);


        // downloading img

        ln_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplication(), "Start Downloading ... ", Toast.LENGTH_SHORT).show();


                downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);

                Uri uri = Uri.parse(getIntent().getStringExtra("url_Donwload"));

                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                Long reference = downloadManager.enqueue(request);


            }
        });

        mychechbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mychechbox.isChecked()) {

                    DB_sqlit db = new DB_sqlit(getApplication());

                    boolean Result = db.InsertData(urll_view, url_download,
                            txt_img_titttle, txt_author_nameeee, url_img_authorrrrr);

                    if (Result == true) {

                        Toast.makeText(getApplication(), "Added to Favorite ", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplication(), "! Alredy  Exist  !", Toast.LENGTH_SHORT).show();

                    }
                } else {


                    DB_sqlit db2 = new DB_sqlit(getApplication());

                    db2.DeleteContact(urll_view);

                    if (db2.DeleteContact(urll_view) == 0) {

                        Toast.makeText(getApplication(), "..Deleted", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(getApplication(), "Error on Delete Method", Toast.LENGTH_SHORT).show();

                    }


                }

            }
        });


    }

    // run method with delay
    public void run_method_after_delay() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {

                color_changer();

            }
        }, 1);
    }


    // animation of colors
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void animateRevealShow(View viewRoot) {
        int cx = (viewRoot.getLeft() + viewRoot.getRight()) / 6;
        int cy = (viewRoot.getTop() + viewRoot.getBottom()) / 2;
        int finalRadius = Math.max(viewRoot.getWidth(), viewRoot.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(viewRoot, cx, cy, 0, finalRadius);
        viewRoot.setVisibility(View.VISIBLE);
        anim.setDuration(800);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.start();
    }

    // change color randomly
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void color_changer() {

        String color_up1 = "#002338";
        String color_up2 = "#38475C";
        String color_up3 = "#555538";
        String color_up4 = "#231515";
        String color_up5 = "#006A86";
        String color_up6 = "#703E8C";
        String color_up7 = "#231C31";

        // Array of colors
        String[] colors = {color_up1, color_up2, color_up3, color_up4, color_up5, color_up6, color_up7};

        // random object
        Random rand = new Random();
        int n = rand.nextInt(colors.length);

        // text test to display random color
        text_color_tst.setText(colors[n]);

        // conditions to set background colors
        switch (text_color_tst.getText().toString()) {


            case "#231C31":
                animateRevealShow(constraintLayout_big_dwn);


                linearLayout_uppp.setBackgroundColor(Color.parseColor("#231C31"));

                constraintLayout_big_dwn.setBackgroundColor(Color.parseColor("#282038"));
                constraintLayout_dwn1.setBackgroundColor(Color.parseColor("#282038"));
                break;

            case "#002338":
                animateRevealShow(constraintLayout_big_dwn);

                linearLayout_uppp.setBackgroundColor(Color.parseColor("#002338"));

                constraintLayout_big_dwn.setBackgroundColor(Color.parseColor("#002840"));
                constraintLayout_dwn1.setBackgroundColor(Color.parseColor("#002840"));
                break;
            case "#38475C":
                animateRevealShow(constraintLayout_big_dwn);

                linearLayout_uppp.setBackgroundColor(Color.parseColor("#38475C"));

                constraintLayout_big_dwn.setBackgroundColor(Color.parseColor("#405068"));
                constraintLayout_dwn1.setBackgroundColor(Color.parseColor("#405068"));

                break;


            case "#555538":
                animateRevealShow(constraintLayout_big_dwn);

                linearLayout_uppp.setBackgroundColor(Color.parseColor("#555538"));

                constraintLayout_big_dwn.setBackgroundColor(Color.parseColor("#606040"));
                constraintLayout_dwn1.setBackgroundColor(Color.parseColor("#606040"));

                break;


            case "#231515":
                animateRevealShow(constraintLayout_big_dwn);

                linearLayout_uppp.setBackgroundColor(Color.parseColor("#231515"));

                constraintLayout_big_dwn.setBackgroundColor(Color.parseColor("#281818"));
                constraintLayout_dwn1.setBackgroundColor(Color.parseColor("#281818"));

                break;

            case "#006A86":
                animateRevealShow(constraintLayout_big_dwn);

                linearLayout_uppp.setBackgroundColor(Color.parseColor("#006A86"));

                constraintLayout_big_dwn.setBackgroundColor(Color.parseColor("#007898"));
                constraintLayout_dwn1.setBackgroundColor(Color.parseColor("#007898"));

                break;

            case "#703E8C":
                animateRevealShow(constraintLayout_big_dwn);

                linearLayout_uppp.setBackgroundColor(Color.parseColor("#703E8C"));

                constraintLayout_big_dwn.setBackgroundColor(Color.parseColor("#A476C7"));
                constraintLayout_dwn1.setBackgroundColor(Color.parseColor("#A476C7"));

                break;

            default:

                linearLayout_uppp.setBackgroundColor(Color.parseColor("#231C31"));

                constraintLayout_big_dwn.setBackgroundColor(Color.parseColor("#282038"));
                constraintLayout_dwn1.setBackgroundColor(Color.parseColor("#282038"));

        }


    }


    ///// class   //////

}