package com.amirahmed.eschoola.Utils;


import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;


import com.amirahmed.eschoola.R;
import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class SplashScreen extends Activity {

    TinyDB tinydb;
    ImageView english,arabic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        tinydb = new TinyDB(getApplicationContext());

        english = findViewById(R.id.englishlang);
        arabic = findViewById(R.id.arabiclang);

        Glide.with(this).load(R.drawable.langeng).into(english);
        Glide.with(this).load(R.drawable.langarab).into(arabic);


        YoYo.with(Techniques.Pulse)
                .duration(1350)
                .repeat(999999999)
                .playOn(english);

        YoYo.with(Techniques.Pulse)
                .duration(1350)
                .repeat(999999999)
                .playOn(arabic);


    }
}
