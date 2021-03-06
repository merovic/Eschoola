package com.amirahmed.eschoola.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.amirahmed.eschoola.Adapters.FeesTabsAdapter;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utils.MyUtilFile;
import com.amirahmed.eschoola.Utils.TinyDB;
import com.athbk.ultimatetablayout.UltimateTabLayout;

import java.util.ArrayList;
import java.util.List;

public class FeesActivity extends AppCompatActivity {

    private Toolbar mToolbar, mToolbar2;

    TinyDB tinyDB;

    int language;

    UltimateTabLayout tabLayout;
    ViewPager viewPager;

    FeesTabsAdapter adapter;

    List<String> titles = new ArrayList<>();

    List<String> names = new ArrayList<>();

    LinearLayout container;

    TextView schoolname,cash,notcash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees);

        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        container = findViewById(R.id.containerlayout);

        schoolname = findViewById(R.id.schoolname);
        cash = findViewById(R.id.cash);
        notcash = findViewById(R.id.notcash);


        if (language == 1) {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);


            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("المصروفات");


            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FeesActivity.super.onBackPressed();
                }
            });

            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);

            titles.add("المرحلة الثانوية");
            titles.add("المرحلة الأعدادية");
            titles.add("المرحلة الأبتدائية");
            titles.add("المرحلة التمهيدية");

            names.add("المرحلة الثانوية");
            names.add("المرحلة الأعدادية");
            names.add("المرحلة الأبتدائية");
            names.add("المرحلة التمهيدية");

        } else {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Fees");


            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FeesActivity.super.onBackPressed();
                }
            });


            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);

            container.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            cash.setText("Premiums");

            notcash.setText("Payment Methods");

            schoolname.setText("International School");

            titles.add("Secondary Stage");
            titles.add("Preparatory Stage");
            titles.add("Primary Stage");
            titles.add("Kids Stage");

            names.add("Secondary Stage");
            names.add("Preparatory Stage");
            names.add("Primary Stage");
            names.add("Kids Stage");
        }


        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        adapter = new FeesTabsAdapter(getSupportFragmentManager(),4);
        viewPager.setAdapter(adapter);

        if(language==1)
        {
            viewPager.setCurrentItem(3);
        }else
            {
                viewPager.setCurrentItem(0);
            }

        adapter.setTITLES(titles);
        adapter.setNAMES(names);

        tabLayout.setViewPager(viewPager, adapter);

    }


}
