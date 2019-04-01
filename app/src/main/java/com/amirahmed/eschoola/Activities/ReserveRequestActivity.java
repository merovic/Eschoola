package com.amirahmed.eschoola.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;
import com.amirahmed.eschoola.Adapters.SonsSelectionAdapter;
import com.amirahmed.eschoola.Models.SonItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utiles.TinyDB;
import com.bumptech.glide.Glide;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReserveRequestActivity extends AppCompatActivity {

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    Spinner genderspinner,lastspinner;

    List<String> genderlist = new ArrayList<>();
    List<String> lastslist = new ArrayList<>();
    List<SonItem> kidslist = new ArrayList<>();

    RecyclerView rv;

    TextView to;

    LinearLayout container,sonlayout,nosonlayout;

    CheckBox lastschoolcheck,uniformcheck,bookscheck,busonewaycheck,bustwowaycheck,cashcheck,visacheck,discountcheck;

    EditText name,birthdate;

    TextView titlename,titlebirthdate,titlegender,titlekidname,son;

    Button submitbutton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserverequest);


        tinyDB = new TinyDB(getApplicationContext());
        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        to = findViewById(R.id.son);

        container = findViewById(R.id.container);
        sonlayout = findViewById(R.id.sonlayout);
        nosonlayout = findViewById(R.id.nosonlayout);

        lastschoolcheck = findViewById(R.id.books);
        uniformcheck = findViewById(R.id.uniform);
        bookscheck = findViewById(R.id.lastschoolcheck);
        busonewaycheck = findViewById(R.id.busoneway);
        bustwowaycheck = findViewById(R.id.bustwoway);
        cashcheck = findViewById(R.id.cash);
        visacheck = findViewById(R.id.credit);
        discountcheck = findViewById(R.id.discount);

        name = findViewById(R.id.kidname);
        birthdate = findViewById(R.id.birthdate);

        titlegender = findViewById(R.id.titlegender);
        titlebirthdate = findViewById(R.id.titlebirthdate);
        titlename = findViewById(R.id.titlename);
        titlekidname = findViewById(R.id.titlekidname);
        son = findViewById(R.id.son);

        submitbutton = findViewById(R.id.submitbutton);

        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("حجز جديد");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("حجز جديد");

            getActionBarTextView().setText("حجز جديد");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ReserveRequestActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (!isFinishing()){
                        new AlertDialog.Builder(ReserveRequestActivity.this)
                                .setTitle("أختر اولا")
                                .setMessage("هل قمت بتسجيل أبنك على تطبيق سكولا ؟")
                                .setCancelable(false)
                                .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        nosonlayout.setVisibility(View.GONE);
                                        rv.setVisibility(View.VISIBLE);
                                        sonlayout.setVisibility(View.VISIBLE);
                                        dialog.cancel();
                                    }
                                })

                                .setNegativeButton(
                                        "لا",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                nosonlayout.setVisibility(View.VISIBLE);
                                                rv.setVisibility(View.GONE);
                                                sonlayout.setVisibility(View.GONE);
                                                dialog.cancel();
                                            }
                                        }).show();
                    }
                }
            });

            container.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            lastschoolcheck.setText("أخر المدرسة");
            uniformcheck.setText("الزى");
            bookscheck.setText("الكتب");
            busonewaycheck.setText("الحافلة اتجاه واحد");
            bustwowaycheck.setText("الحافلة اتجاهين");
            cashcheck.setText("كاش");
            visacheck.setText("فيزا");
            discountcheck.setText("خصم اسكولا");

            name.setHint("اسم الأبن");
            birthdate.setHint("يوم-شهر-سنة");

            titlegender.setText("النوع");
            titlebirthdate.setText("تاريخ الميلاد");
            titlename.setText("الأسم");
            titlekidname.setText("أسم الطفل");
            son.setHint("اسم الأبن");

            submitbutton.setText("ارسال");

            genderlist.add("اختر النوع");
            genderlist.add("ذكر");
            genderlist.add("أنثى");

            lastslist.add("اختر اخر مدرسة");
            lastslist.add("مدرسة الأمل");
            lastslist.add("مدرسة الحياة");
            lastslist.add("مدرسة المستقبل");

        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Reservation");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Reservation");

            getActionBarTextView().setText("Reservation");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ReserveRequestActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            genderlist.add("Select Gender");
            genderlist.add("Male");
            genderlist.add("Female");

            lastslist.add("Select Last School");
            lastslist.add("El-Amaal School");
            lastslist.add("El-Hayaa School");
            lastslist.add("El-Mostakbal School");

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (!isFinishing()){
                        new AlertDialog.Builder(ReserveRequestActivity.this)
                                .setTitle("Choose First")
                                .setMessage("Do you already add your son on schoola ?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        nosonlayout.setVisibility(View.GONE);
                                        rv.setVisibility(View.VISIBLE);
                                        sonlayout.setVisibility(View.VISIBLE);
                                        dialog.cancel();
                                    }
                                })

                                .setNegativeButton(
                                        "No",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                nosonlayout.setVisibility(View.VISIBLE);
                                                rv.setVisibility(View.GONE);
                                                sonlayout.setVisibility(View.GONE);
                                                dialog.cancel();
                                            }
                                        }).show();
                    }
                }
            });

        }


        genderspinner = findViewById(R.id.gender);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genderlist);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderspinner.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        lastspinner = findViewById(R.id.last);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lastslist);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lastspinner.setAdapter(adapter2);

        adapter2.notifyDataSetChanged();

        rv = findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        kidslist = new ArrayList<>();

        if (language == 1) {

            kidslist.add(new SonItem("Mohameed"));
            kidslist.add(new SonItem("Ahmed"));
            kidslist.add(new SonItem("Ibrahim"));


        } else {

            kidslist.add(new SonItem("Mohameed"));
            kidslist.add(new SonItem("Ahmed"));
            kidslist.add(new SonItem("Ibrahim"));
        }
    }

    private void initializeAdapter() {

        SonsSelectionAdapter adapter = new SonsSelectionAdapter(kidslist,to);
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
