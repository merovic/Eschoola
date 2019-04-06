package com.amirahmed.eschoola.Utiles;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MyUtilFile {

    private int language;
    private android.support.v7.widget.Toolbar mToolbar,mToolbar2;
    private Context context;

    public MyUtilFile(int language, android.support.v7.widget.Toolbar mToolbar, android.support.v7.widget.Toolbar mToolbar2) {

        this.language = language;
        this.mToolbar = mToolbar;
        this.mToolbar2 = mToolbar2;
    }

    public MyUtilFile(Context context) {
        this.context = context;
    }

    public TextView getActionBarTextView() {
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

    public void showMessage(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
