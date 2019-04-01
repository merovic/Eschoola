package com.amirahmed.eschoola.Fragments;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.amirahmed.eschoola.Activities.GuestLoginActivity;
import com.amirahmed.eschoola.Activities.RegistrationActivity;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utiles.TinyDB;
import mehdi.sakout.fancybuttons.FancyButton;

public class LoginFragment extends DialogFragment {

    TinyDB tinyDB;

    int language;

    LinearLayout mainlayout;

    TextView skiptext;

    Button reg,login;

    FancyButton facebookLogin,twitterLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container);

        tinyDB = new TinyDB(getActivity());

        language = tinyDB.getInt("language");

        mainlayout = rootView.findViewById(R.id.mainlayout);

        reg = rootView.findViewById(R.id.registrationbutton);
        login = rootView.findViewById(R.id.loginbutton);

        skiptext = rootView.findViewById(R.id.skiptext);

        facebookLogin = rootView.findViewById(R.id.facebook_login);
        twitterLogin = rootView.findViewById(R.id.twitter_login);

        if(language==1)
        {
            reg.setText("تسجيل جديد");
            login.setText("تسجيل الدخول");
            skiptext.setText("تخطى");

            facebookLogin.setText("تسجيل الدخول عن طريق فيس بوك");


            twitterLogin.setText("تسجيل الدخول عن طريق تويتر");

        }else
            {
                mainlayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            }

            reg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();

                    Intent intent = new Intent(getActivity(),RegistrationActivity.class);
                    getActivity().startActivity(intent);
                }
            });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();

                Intent intent = new Intent(getActivity(),GuestLoginActivity.class);
                getActivity().startActivity(intent);
            }
        });


        skiptext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });



        return rootView;
    }
}
