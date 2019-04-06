package com.amirahmed.eschoola.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utiles.MyUtilFile;
import com.amirahmed.eschoola.Utiles.TinyDB;

import java.lang.reflect.Field;

public class SchoolVisionActivity extends AppCompatActivity {

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout container;

    TextView schoolname,schoollevels;

    TextView visiontext,goalstext,messagetext,mangertext,visioncontent,goalscontent,messagecontent,mangercontent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision);

        tinyDB = new TinyDB(getApplicationContext());
        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        container = findViewById(R.id.containerlayout);

        schoolname = findViewById(R.id.schoolname);

        schoollevels = findViewById(R.id.schoollevels);


        visiontext = findViewById(R.id.visiontext);
        goalstext = findViewById(R.id.goalstext);
        messagetext = findViewById(R.id.messagetext);
        mangertext = findViewById(R.id.mangertext);
        visioncontent = findViewById(R.id.visioncontent);
        goalscontent = findViewById(R.id.goalscontent);
        messagecontent = findViewById(R.id.messagecontent);
        mangercontent = findViewById(R.id.mangercontent);



        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);


            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الرؤية");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SchoolVisionActivity.super.onBackPressed();
                }
            });

            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);


        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Vision");


            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SchoolVisionActivity.super.onBackPressed();
                }
            });


            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);

            container.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            schoolname.setText("EL-Eleem Educational School");

            schoollevels.setText("International | All Levels");

            visiontext.setText("School Vision");
            goalstext.setText("School Goals");
            messagetext.setText("School Message");
            mangertext.setText("School Manger");

            visioncontent.setText("Vision statements outline a school’s objectives, and mission statements indicate how the school aims to achieve that vision. Schools might have one or both.\n" +
                    "\n" +
                    "Vision and mission statements in schools make a public declaration of the values of the school. But are such statements useful, or just nice to look at but of little substance? They can be useful – but it depends on what they include and how they’re used.");

            goalscontent.setText("Vision statements outline a school’s objectives, and mission statements indicate how the school aims to achieve that vision. Schools might have one or both.\n" +
                    "\n" +
                    "Vision and mission statements in schools make a public declaration of the values of the school. But are such statements useful, or just nice to look at but of little substance? They can be useful – but it depends on what they include and how they’re used.");

            messagecontent.setText("Vision statements outline a school’s objectives, and mission statements indicate how the school aims to achieve that vision. Schools might have one or both.\n" +
                    "\n" +
                    "Vision and mission statements in schools make a public declaration of the values of the school. But are such statements useful, or just nice to look at but of little substance? They can be useful – but it depends on what they include and how they’re used.");

            mangercontent.setText("Vision statements outline a school’s objectives, and mission statements indicate how the school aims to achieve that vision. Schools might have one or both.\n" +
                    "\n" +
                    "Vision and mission statements in schools make a public declaration of the values of the school. But are such statements useful, or just nice to look at but of little substance? They can be useful – but it depends on what they include and how they’re used.");

        }


}


}
