package com.dep.bestwallpaperapp.Activitiess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.dep.bestwallpaperapp.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class Test_Activity extends AppCompatActivity {

    private BottomSheetBehavior mbottomSheetBehavior ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_);

        View bottomsheet = findViewById(R.id.botttoms_sheet);

        mbottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);


     ///main ends

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
     mbottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    }

    // class end
}