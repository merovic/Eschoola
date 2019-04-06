package com.amirahmed.eschoola.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.*;
import com.amirahmed.eschoola.Adapters.SonsSelectionAdapter;
import com.amirahmed.eschoola.Models.SonItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utiles.MyUtilFile;
import com.amirahmed.eschoola.Utiles.TinyDB;
import com.bumptech.glide.Glide;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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

    LinearLayout container,sonlayout,nosonlayout,lastlayout;

    CheckBox lastschoolcheck,uniformcheck,bookscheck,busonewaycheck,bustwowaycheck,cashcheck,visacheck,discountcheck;

    EditText name,birthdate;

    TextView titlename,titlebirthdate,titlegender,titlekidname,son;

    Button submitbutton;

    Calendar myCalendar;

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
        lastlayout = findViewById(R.id.lastlayout);

        lastschoolcheck = findViewById(R.id.lastschoolcheck);
        uniformcheck = findViewById(R.id.uniform);
        bookscheck = findViewById(R.id.books);
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

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("حجز جديد");


            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ReserveRequestActivity.super.onBackPressed();
                }
            });

            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);

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

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Reservation");


            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ReserveRequestActivity.super.onBackPressed();
                }
            });


            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);

            genderlist.add("Select Gender");
            genderlist.add("Male");
            genderlist.add("Female");

            lastslist.add("Select Last School");
            lastslist.add("El-Amaal School");
            lastslist.add("El-Hayaa School");
            lastslist.add("El-Mostakbal School");

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

        lastschoolcheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    lastlayout.setVisibility(View.VISIBLE);
                }else
                    {
                        lastlayout.setVisibility(View.GONE);
                    }
            }
        });

        busonewaycheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    bustwowaycheck.setChecked(false);
                }
            }
        });

        bustwowaycheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    busonewaycheck.setChecked(false);
                }
            }
        });

        cashcheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    visacheck.setChecked(false);
                }
            }
        });

        visacheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    cashcheck.setChecked(false);
                }
            }
        });

        myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        birthdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ReserveRequestActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        ViewDialog alert = new ViewDialog();
        alert.showDialog(this);

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        birthdate.setText(sdf.format(myCalendar.getTime()));
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

    public class ViewDialog {

        void showDialog(Activity activity){
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog);

            TextView title0 = dialog.findViewById(R.id.title);

            TextView title = dialog.findViewById(R.id.titledialog);

            Button yes = dialog.findViewById(R.id.yesbutton);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nosonlayout.setVisibility(View.GONE);
                    rv.setVisibility(View.VISIBLE);
                    sonlayout.setVisibility(View.VISIBLE);
                    dialog.dismiss();
                }
            });

            Button no = dialog.findViewById(R.id.nobutton);
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nosonlayout.setVisibility(View.VISIBLE);
                    rv.setVisibility(View.GONE);
                    sonlayout.setVisibility(View.GONE);
                    dialog.dismiss();
                }
            });

            if(language==1)
            {
                title0.setText("أضافة أبن");
                title.setText("هل قمت بتسجيل إبنك على تطبيق إسكولا من قبل ؟");
                yes.setText("نعم");
                no.setText("لا");
            }

            dialog.show();

        }
    }

}
