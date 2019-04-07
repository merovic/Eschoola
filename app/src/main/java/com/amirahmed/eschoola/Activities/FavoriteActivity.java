package com.amirahmed.eschoola.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.amirahmed.eschoola.Adapters.FavoriteAdapter;
import com.amirahmed.eschoola.Models.SchoolsListItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utils.MyUtilFile;
import com.amirahmed.eschoola.Utils.TinyDB;


import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    private Toolbar mToolbar, mToolbar2;

    TinyDB tinyDB;

    int language;

    private List<SchoolsListItem> schoolsListItems;
    private RecyclerView rv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);



        if (language == 1) {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);


            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("المفضلة");


            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FavoriteActivity.super.onBackPressed();
                }
            });

            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        } else {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Favorite");


            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FavoriteActivity.super.onBackPressed();
                }
            });


            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);

        }


        rv2 = findViewById(R.id.rv2);

        rv2.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        schoolsListItems = new ArrayList<>();

        if(language==1)
        {
            schoolsListItems.add(new SchoolsListItem("مدرسة الأمل للغات","مفتوح من ٧ص - ٢م","١٥ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة المستقبل الحديثة","مفتوح من ٧ص - ٢م","٣٧ كم","دولية | جميع المراحل"));
        }else
        {
            schoolsListItems.add(new SchoolsListItem("El Amal Modern School","Open from 7pm - 3am","15 KM","International | All Levels"));
            schoolsListItems.add(new SchoolsListItem("El Amal Modern School","Open from 7pm - 3am","15 KM","International | All Levels"));
        }


    }

    private void initializeAdapter() {

        FavoriteAdapter adapter = new FavoriteAdapter(schoolsListItems);
        rv2.setAdapter(adapter);

    }

}
