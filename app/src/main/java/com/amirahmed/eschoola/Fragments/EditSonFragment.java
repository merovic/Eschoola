package com.amirahmed.eschoola.Fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

public class EditSonFragment extends DialogFragment {

    CardView cardView;

    Spinner stagesspinner,levelsspinner,genderspinner,lastspinner;

    List<String> genderlist = new ArrayList<>();
    List<String> stageslist = new ArrayList<>();
    List<String> levelslist = new ArrayList<>();
    List<String> lastslist = new ArrayList<>();

    TinyDB tinyDB;

    String sonPic,sonName,sonBirthDate,sonGender,sonStage,sonLevel,sonLastSchool;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_son, container);

        tinyDB = new TinyDB(getActivity());

        sonPic = tinyDB.getString("sonPic");
        sonName = tinyDB.getString("sonName");
        sonBirthDate = tinyDB.getString("sonBirthDate");
        sonGender = tinyDB.getString("sonGender");
        sonStage = tinyDB.getString("sonStage");
        sonLevel = tinyDB.getString("sonLevel");
        sonLastSchool = tinyDB.getString("sonLastSchool");

        cardView = rootView.findViewById(R.id.container);

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
