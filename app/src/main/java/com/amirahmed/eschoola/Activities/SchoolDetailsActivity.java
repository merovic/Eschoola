package com.amirahmed.eschoola.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;


import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utils.MyUtilFile;
import com.amirahmed.eschoola.Utils.TinyDB;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;

public class SchoolDetailsActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener,OnMapReadyCallback, View.OnClickListener {

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout vision,about,terms,fees,bottommenu;

    TextView visiontext,abouttext,termstext,feestext;

    RelativeLayout iv_trigger;

    CoordinatorLayout coordinatorLayout;

    ImageView logo,male,female,sun,moon,acsw;

    TextView schoolname,cityname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_details);

        tinyDB = new TinyDB(getApplicationContext());
        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        visiontext = findViewById(R.id.visiontext);
        abouttext = findViewById(R.id.abouttext);
        termstext = findViewById(R.id.termstext);
        feestext = findViewById(R.id.feestext);

        coordinatorLayout = findViewById(R.id.coordinator);

        init_persistent_bottomsheet();

        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("تفاصيل المدرسة");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SchoolDetailsActivity.super.onBackPressed();
                }
            });

            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);


        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("School Details");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SchoolDetailsActivity.super.onBackPressed();
                }
            });


            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);

            visiontext.setText("Vision");
            abouttext.setText("About");
            termstext.setText("Terms");
            feestext.setText("Fees");
        }

        SliderLayout mDemoSlider = findViewById(R.id.slider);

        mDemoSlider.setClipToOutline(true);

        HashMap<String,String> url_maps = new HashMap<>();
        url_maps.put("Banner 1", "https://image.shutterstock.com/image-photo/teacher-asking-question-her-class-450w-309241172.jpg");
        url_maps.put("Banner 2", "https://image.shutterstock.com/image-photo/kids-raising-hands-teacher-elementary-450w-667966174.jpg");
        url_maps.put("Banner 3", "https://image.shutterstock.com/image-photo/kids-showing-hands-during-lesson-450w-667978948.jpg");
        url_maps.put("Banner 4", "https://image.shutterstock.com/image-photo/teacher-asking-question-her-class-450w-309241172.jpg");
        url_maps.put("Banner 5", "https://image.shutterstock.com/image-photo/kids-raising-hands-teacher-elementary-450w-667966174.jpg");


        HashMap<String,Integer> file_maps = new HashMap<>();
        file_maps.put("School-1",R.drawable.school);
        file_maps.put("School-2",R.drawable.school2);
        file_maps.put("School-3",R.drawable.school3);
        file_maps.put("School-4",R.drawable.school4);
        file_maps.put("School-5",R.drawable.school5);

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

        vision = findViewById(R.id.visionlayout);
        about = findViewById(R.id.aboutlayout);
        fees = findViewById(R.id.feeslayout);
        terms = findViewById(R.id.termslayout);
        bottommenu = findViewById(R.id.bottommenu);

        if(language!=1)
        {
            bottommenu.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        }

        vision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchoolDetailsActivity.this , SchoolVisionActivity.class );
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchoolDetailsActivity.this , AboutSchoolActivity.class );
                startActivity(intent);
            }
        });

        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchoolDetailsActivity.this , ComparisionActivity.class );
                startActivity(intent);
            }
        });


        fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchoolDetailsActivity.this , FeesActivity.class );
                startActivity(intent);
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        // create marker
        MarkerOptions marker = new MarkerOptions().position(new LatLng(24.638007, 46.712315)).title("El-Eleem School");

        MarkerOptions marker2 = new MarkerOptions().position(new LatLng(24.821367, 46.780950));

        // Changing marker icon
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.locationsocial));

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(24.638007, 46.712315);
        LatLng sydney2 = new LatLng(24.821367, 46.780950);

        googleMap.addMarker(marker);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        googleMap.addMarker(marker2);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney2));

        googleMap.animateCamera( CameraUpdateFactory.zoomTo( 10.0f ));
    }

    public void init_persistent_bottomsheet() {

        View persistentbottomSheet = coordinatorLayout.findViewById(R.id.bottomsheet);
        iv_trigger = persistentbottomSheet.findViewById(R.id.iv_fab);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(persistentbottomSheet);

        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        }, 3000 );//time in milisecond


        logo = persistentbottomSheet.findViewById(R.id.logo);

        schoolname = persistentbottomSheet.findViewById(R.id.name);
        cityname = persistentbottomSheet.findViewById(R.id.citytext);

        if(language==1)
        {

        }else
            {
                schoolname.setText("El-Amaal Language School");
                cityname.setText("ElMonsyaa City | Riyadh");
            }

        male = persistentbottomSheet.findViewById(R.id.male);
        female = persistentbottomSheet.findViewById(R.id.female);
        sun = persistentbottomSheet.findViewById(R.id.sun);
        moon = persistentbottomSheet.findViewById(R.id.moon);
        acsw = persistentbottomSheet.findViewById(R.id.acsw);

        iv_trigger.setOnClickListener(this);

        iv_trigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });


        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //showing the different states
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events

            }
        });

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.iv_fab)
        {
            //show
        }
    }
}
