package com.amirahmed.eschoola.Fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.amirahmed.eschoola.Activities.DiscountRequestActivity;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utiles.TinyDB;

import java.util.ArrayList;
import java.util.List;


public class AddSonFragment extends DialogFragment {

    TinyDB tinyDB;

    int language;

    CardView cardView;

    LinearLayout lastlayout;

    Spinner stagesspinner,levelsspinner,genderspinner,lastspinner;

    List<String> genderlist = new ArrayList<>();
    List<String> stageslist = new ArrayList<>();
    List<String> levelslist = new ArrayList<>();
    List<String> lastslist = new ArrayList<>();

    TextView title,titleName,titleBirthdate,titleGender,titleStage,titleLevel,titleLastSchool;

    CheckBox lastSchoolCheck;

    EditText nameEdit,birthdateEdit;

    Button submit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_son, container);

        tinyDB = new TinyDB(getActivity());

        language = tinyDB.getInt("language");

        cardView = rootView.findViewById(R.id.container);

        lastlayout = rootView.findViewById(R.id.lastlayout);

        title = rootView.findViewById(R.id.title);
        titleName = rootView.findViewById(R.id.titlename);
        titleBirthdate = rootView.findViewById(R.id.titlebirthdate);
        titleGender = rootView.findViewById(R.id.titlegender);
        titleStage = rootView.findViewById(R.id.titlestage);
        titleLevel = rootView.findViewById(R.id.titlelevel);
        titleLastSchool = rootView.findViewById(R.id.titlelastschool);

        lastSchoolCheck = rootView.findViewById(R.id.lastschoolcheck);

        nameEdit = rootView.findViewById(R.id.kidname);
        birthdateEdit = rootView.findViewById(R.id.birthdate);

        submit = rootView.findViewById(R.id.submitbutton);

        lastSchoolCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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

        if(language==1)
        {

            cardView.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            title.setText("أضافة أبن");
            titleName.setText("الأسم");
            titleBirthdate.setText("تاريخ الميلاد");
            titleGender.setText("النوع");
            titleStage.setText("المرحلة");
            titleLevel.setText("الصف");
            titleLastSchool.setText("اخر مدرسة");

            lastSchoolCheck.setText("اخر مدرسة");

            nameEdit.setHint("اسم الأبن بالكامل");
            birthdateEdit.setHint("يوم-شهر-عام");

            submit.setText("أضافة");


            genderlist.add("أختر النوع");
            genderlist.add("ذكر");
            genderlist.add("أنثى");

            stageslist.add("أختر المرحلة");
            stageslist.add("المرحلة الأبتدائية");
            stageslist.add("المرحلة الأعدادية");
            stageslist.add("المرحلة الثانوية");

            levelslist.add("اختر الصف");
            levelslist.add("KG1");
            levelslist.add("KG2");
            levelslist.add("KG3");

            lastslist.add("أختر المدرسة");
            lastslist.add("مدرسة الأمل");
            lastslist.add("مدرسة الحياة");
            lastslist.add("مدرسة المستقبل");
        }else
            {
                genderlist.add("Select Gender");
                genderlist.add("Male");
                genderlist.add("Female");

                stageslist.add("Select Stage");
                stageslist.add("Primary Stage");
                stageslist.add("Intermediate Stage");
                stageslist.add("Secondary Stage");

                levelslist.add("Select Level");
                levelslist.add("KG1");
                levelslist.add("KG2");
                levelslist.add("KG3");

                lastslist.add("Select Last School");
                lastslist.add("El-Amaal School");
                lastslist.add("El-Hayaa School");
                lastslist.add("El-Mostakbal School");
            }


            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dismiss();
                }
            });



        genderspinner = rootView.findViewById(R.id.gender);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, genderlist);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderspinner.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        stagesspinner = rootView.findViewById(R.id.stage);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, stageslist);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stagesspinner.setAdapter(adapter2);

        adapter2.notifyDataSetChanged();

        levelsspinner = rootView.findViewById(R.id.level);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, levelslist);

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelsspinner.setAdapter(adapter3);

        adapter3.notifyDataSetChanged();

        lastspinner = rootView.findViewById(R.id.last);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, lastslist);

        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lastspinner.setAdapter(adapter4);

        adapter4.notifyDataSetChanged();

        return rootView;
    }
}
