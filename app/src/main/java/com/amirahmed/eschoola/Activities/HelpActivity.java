package com.amirahmed.eschoola.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utils.MySpinnerAdapter;
import com.amirahmed.eschoola.Utils.MyUtilFile;
import com.amirahmed.eschoola.Utils.TinyDB;


import java.util.ArrayList;
import java.util.List;

public class HelpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner sp;

    List<String> requests = new ArrayList<>();

    EditText details;

    Button send;

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout sendinglayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        tinyDB = new TinyDB(this);

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
            textView.setText("المساعدة");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HelpActivity.super.onBackPressed();
                }
            });

            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Help");


            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HelpActivity.super.onBackPressed();
                }
            });


            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        }

        sp = findViewById(R.id.requests);

        details = findViewById(R.id.details);
        send = findViewById(R.id.sendbutton);

        sendinglayout = findViewById(R.id.sendinglayout);


        if(language==1)
        {

            requests.add("استفسار");
            requests.add("مشكلة");
            requests.add("اقتراح");

            details.setHint("تفاصيل الطلب");

            send.setText("ارسال");

            sendinglayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        }else
        {
            requests.add("Enquiry");
            requests.add("Problem");
            requests.add("Suggestion");

            details.setHint("Request Details");

            send.setText("Send");

            sendinglayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        }

        MySpinnerAdapter adapter = new MySpinnerAdapter(HelpActivity.this, android.R.layout.simple_spinner_item, requests);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);

        adapter.notifyDataSetChanged();


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.setSelection(0);
                details.setText("");
                if(language==1)
                {
                    if(sp.getSelectedItemPosition()==1)
                    {
                       new MyUtilFile(HelpActivity.this).showMessage("تم الارسال الاستفسار بنجاح");
                    }else if(sp.getSelectedItemPosition()==2)
                    {
                        new MyUtilFile(HelpActivity.this).showMessage("تم الارسال المشكلة بنجاح");
                    }else
                        {
                            new MyUtilFile(HelpActivity.this).showMessage("تم الارسال الاقتراح بنجاح");
                        }

                }else
                    {
                        if(sp.getSelectedItemPosition()==1)
                        {
                            new MyUtilFile(HelpActivity.this).showMessage("Enquiry Sent Successfully");
                        }else if(sp.getSelectedItemPosition()==2)
                        {
                            new MyUtilFile(HelpActivity.this).showMessage("Problem Sent Successfully");
                        }else
                        {
                            new MyUtilFile(HelpActivity.this).showMessage("Suggestion Sent Successfully");
                        }

                    }

            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
