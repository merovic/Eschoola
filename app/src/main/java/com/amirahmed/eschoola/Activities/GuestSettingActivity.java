package com.amirahmed.eschoola.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utils.MyUtilFile;
import com.amirahmed.eschoola.Utils.TinyDB;

public class GuestSettingActivity extends AppCompatActivity {

    RadioGroup languagesgroup;
    RadioButton selectedlanguage,arabic,english;

    Button submitbutton;

    Switch notifications;

    TextView languagetitle;

    TinyDB tinyDB;

    int language;

    private Toolbar mToolbar,mToolbar2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

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

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الاعدادات");


            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(GuestSettingActivity.this , VisitorActivity.class);
                    startActivity(intent);
                }
            });

            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Setting");


            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(GuestSettingActivity.this , VisitorActivity.class);
                    startActivity(intent);
                }
            });


            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        }

        languagetitle = findViewById(R.id.languagetitle);

        submitbutton = findViewById(R.id.submitbutton);

        languagesgroup = findViewById(R.id.languagesgroup);

        notifications = findViewById(R.id.notifications);

        arabic = findViewById(R.id.arabic);
        english = findViewById(R.id.english);

        notifications.isEnabled();

        if(language==1)
        {
            arabic.setChecked(true);

            languagesgroup.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            languagetitle.setText("اللغة");
            submitbutton.setText("حفظ");
            arabic.setText("اللغة العربية");
            english.setText("اللغة الانجليزية");

        }else
        {
            english.setChecked(true);

            languagetitle.setText("Language");
            submitbutton.setText("Submit");
            arabic.setText("Arabic");
            english.setText("English");
        }

        int selected = languagesgroup.getCheckedRadioButtonId();

        selectedlanguage = findViewById(selected);


        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arabic.isChecked())
                {
                    tinyDB.putInt("language",1);
                }else if (english.isChecked())
                {
                    tinyDB.putInt("language",2);
                }

                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        LinearLayout layout = findViewById(R.id.layout);

        TextView textView = findViewById(R.id.text);

        Button english = findViewById(R.id.englishbutton);

        Button arabic = findViewById(R.id.arabicbutton);

        if(language==1)
        {
            layout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            textView.setText("اللغة");

            english.setBackgroundColor(Color.WHITE);

            english.setTextColor(Color.parseColor("#0D4874"));

            arabic.setBackgroundColor(Color.parseColor("#0D4874"));

            arabic.setTextColor(Color.WHITE);

        }else
        {
            layout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            textView.setText("Language");

            arabic.setBackgroundColor(Color.WHITE);

            arabic.setTextColor(Color.parseColor("#0D4874"));

            english.setBackgroundColor(Color.parseColor("#0D4874"));

            english.setTextColor(Color.WHITE);
        }

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tinyDB.putInt("language",2);
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tinyDB.putInt("language",1);
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

    }


    @Override
    public void onBackPressed() {

        Intent intent = new Intent(GuestSettingActivity.this , VisitorActivity.class);
        startActivity(intent);

    }


}
