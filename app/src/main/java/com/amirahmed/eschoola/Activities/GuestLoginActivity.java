package com.amirahmed.eschoola.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utiles.MyUtilFile;
import com.amirahmed.eschoola.Utiles.TinyDB;


import java.lang.reflect.Field;

public class GuestLoginActivity extends AppCompatActivity {

    private Toolbar mToolbar, mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout email,password;

    EditText emailedit,passwordedit;

    Button login;

    TextView forget;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_guest);

        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        email = findViewById(R.id.emaillayout);
        password = findViewById(R.id.passwordlayout);

        emailedit = findViewById(R.id.email);
        passwordedit = findViewById(R.id.password);

        login = findViewById(R.id.sendbutton);

        forget = findViewById(R.id.forgettext);

        if (language == 1) {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);


            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("تسجيل الدخول");


            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GuestLoginActivity.super.onBackPressed();
                }
            });

            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);


        } else {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("login");


            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GuestLoginActivity.super.onBackPressed();
                }
            });


            new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);

            email.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            password.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            emailedit.setHint("Email");
            passwordedit.setHint("Password");

            login.setText("Login");

            forget.setText("Forget Password ?");

        }

    }

}
