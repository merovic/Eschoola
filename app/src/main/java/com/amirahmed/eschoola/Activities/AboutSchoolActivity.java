package com.amirahmed.eschoola.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.amirahmed.eschoola.Adapters.SchoolFeathersAdapter;
import com.amirahmed.eschoola.Models.SchoolsFeathersItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utils.MyUtilFile;
import com.amirahmed.eschoola.Utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

public class AboutSchoolActivity extends AppCompatActivity {

    private Toolbar mToolbar, mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout header;

    TextView schoolname,statsticstext,schoolfeatchures,studentsno,studentsaverage,size,areaofschool,termstext,term1,term2,term3,term4,term5;


    private RecyclerView mRecyclerView;
    private List<SchoolsFeathersItem> schoolsFeathersItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutschool_guest);

        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        header = findViewById(R.id.headlayout);

        schoolname = findViewById(R.id.schoolname);
        statsticstext = findViewById(R.id.statsticstext);
        schoolfeatchures = findViewById(R.id.schoolfeatchures);
        studentsno = findViewById(R.id.studentsno);
        studentsaverage = findViewById(R.id.studentsaverage);
        size = findViewById(R.id.size);
        areaofschool = findViewById(R.id.areaofschool);
        term1 = findViewById(R.id.term1);
        term2 = findViewById(R.id.term2);
        term3 = findViewById(R.id.term3);
        term4 = findViewById(R.id.term4);
        term5 = findViewById(R.id.term5);
        termstext = findViewById(R.id.termstext);

        mRecyclerView = findViewById(R.id.rv);

        mRecyclerView.setHasFixedSize(true);

        GridLayoutManager mGridlayoutManager = new GridLayoutManager(getApplicationContext(),2);
        mRecyclerView.setLayoutManager(mGridlayoutManager);


        if (language == 1) {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);


            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("عن المدرسة");


            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AboutSchoolActivity.super.onBackPressed();
                }
            });

            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);

            term1.setText("أجتياز اختبار اللغة الأنجليزية");
            term2.setText("أجتياز اختبارات القبول");
            term3.setText("أجتياو المقابلة الشخصية");
            term4.setText("حصول على درجة كاملة فى السلوك");
            term5.setText("اخر تقدير جيد جدا على الأقل");

        } else {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("About School");


            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AboutSchoolActivity.super.onBackPressed();
                }
            });


            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);

            header.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            schoolname.setText("EL-Eleem Educational School");
            statsticstext.setText("Statistics about School");
            schoolfeatchures.setText("School Features");
            studentsno.setText("Students in Class");
            studentsaverage.setText("Average Number");
            size.setText("School Size");
            termstext.setText("Apply Terms");
            areaofschool.setText("2300 Meter");


        }

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {

        //The Backgrounds and logos will be provided later

        schoolsFeathersItems = new ArrayList<>();

        schoolsFeathersItems.add(new SchoolsFeathersItem("https://res.cloudinary.com/dtec9smtu/image/upload/v1553440360/bg1.png","https://res.cloudinary.com/dtec9smtu/image/upload/v1553440348/boygirlblue.png","Boys and Girls"));
        schoolsFeathersItems.add(new SchoolsFeathersItem("https://res.cloudinary.com/dtec9smtu/image/upload/v1553440360/bg1.png","https://res.cloudinary.com/dtec9smtu/image/upload/v1553440348/boygirlblue.png","Boys and Girls"));
        schoolsFeathersItems.add(new SchoolsFeathersItem("https://res.cloudinary.com/dtec9smtu/image/upload/v1553440360/bg1.png","https://res.cloudinary.com/dtec9smtu/image/upload/v1553440348/boygirlblue.png","Boys and Girls"));
        schoolsFeathersItems.add(new SchoolsFeathersItem("https://res.cloudinary.com/dtec9smtu/image/upload/v1553440360/bg1.png","https://res.cloudinary.com/dtec9smtu/image/upload/v1553440348/boygirlblue.png","Boys and Girls"));

    }

    private void initializeAdapter() {

        SchoolFeathersAdapter adapter = new SchoolFeathersAdapter(schoolsFeathersItems);
        mRecyclerView.setAdapter(adapter);
    }

}
