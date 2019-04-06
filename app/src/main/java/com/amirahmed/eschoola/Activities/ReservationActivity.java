package com.amirahmed.eschoola.Activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.amirahmed.eschoola.Adapters.ComparisonAdapter;
import com.amirahmed.eschoola.Adapters.ReservationAdapter;
import com.amirahmed.eschoola.Models.ComparisonItem;
import com.amirahmed.eschoola.Models.ReservationItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utiles.MyUtilFile;
import com.amirahmed.eschoola.Utiles.TinyDB;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class ReservationActivity extends AppCompatActivity {

    private Toolbar mToolbar, mToolbar2;

    TinyDB tinyDB;

    int language;

    List<ReservationItem> reservationItemList;
    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

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
            textView.setText("قائمة الحجوزات");


            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ReservationActivity.super.onBackPressed();
                }
            });

            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        } else {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Reservations");


            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ReservationActivity.super.onBackPressed();
                }
            });


            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);

        }

        rv = findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();
        initializeAdapter();


    }

    private void initializeData() {

        reservationItemList = new ArrayList<>();

        reservationItemList.add(new ReservationItem());
        reservationItemList.add(new ReservationItem());
        reservationItemList.add(new ReservationItem());
        reservationItemList.add(new ReservationItem());
    }


    private void initializeAdapter() {

        ReservationAdapter adapter = new ReservationAdapter(reservationItemList);
        rv.setAdapter(adapter);

    }

}
