package com.amirahmed.eschoola.Activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.amirahmed.eschoola.Adapters.SonsAdapter;
import com.amirahmed.eschoola.Adapters.SonsSelectionAdapter;
import com.amirahmed.eschoola.Fragments.AddSonFragment;
import com.amirahmed.eschoola.Models.SonItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utiles.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class GuestProfile extends AppCompatActivity {

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    List<SonItem> kidslist = new ArrayList<>();

    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guestprofile);

        tinyDB = new TinyDB(getApplicationContext());
        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);


        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("الصفحة الشخصية");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الصفحة الشخصية");

            getActionBarTextView().setText("الصفحة الشخصية");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GuestProfile.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);

        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Profile");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Profile");

            getActionBarTextView().setText("Profile");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GuestProfile.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);


        }

        rv = findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

        FloatingActionButton fab;
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final FragmentManager fm = getFragmentManager();
                AddSonFragment addTaskFragment = new AddSonFragment();

                addTaskFragment.show(fm,"TV_tag");
            }
        });
    }

    private void initializeData() {
        kidslist = new ArrayList<>();

        if (language == 1) {

            kidslist.add(new SonItem());
            kidslist.add(new SonItem());
            kidslist.add(new SonItem());


        } else {

            kidslist.add(new SonItem());
            kidslist.add(new SonItem());
            kidslist.add(new SonItem());
        }
    }

    private void initializeAdapter() {

        SonsAdapter adapter = new SonsAdapter(kidslist);
        rv.setAdapter(adapter);

    }

    private TextView getActionBarTextView() {
        TextView titleTextView = null;

        try {
            if(language==1)
            {
                Field f = mToolbar.getClass().getDeclaredField("mTitleTextView");
                f.setAccessible(true);
                titleTextView = (TextView) f.get(mToolbar);
            }else
            {
                Field f = mToolbar2.getClass().getDeclaredField("mTitleTextView");
                f.setAccessible(true);
                titleTextView = (TextView) f.get(mToolbar2);
            }

        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
        return titleTextView;
    }
}
