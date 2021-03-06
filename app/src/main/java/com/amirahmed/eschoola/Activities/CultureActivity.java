package com.amirahmed.eschoola.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amirahmed.eschoola.Adapters.CultureAdapter;
import com.amirahmed.eschoola.Models.CultureItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utils.TinyDB;


import java.util.ArrayList;
import java.util.List;

public class CultureActivity extends Fragment {

    View view;

    TinyDB tinyDB;

    int language;

    private List<CultureItem> cultureItems;
    private RecyclerView rv2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_culture, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tinyDB = new TinyDB(getActivity());

        language = tinyDB.getInt("language");

        rv2 = view.findViewById(R.id.culture_rv);

        rv2.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

    }



    private void initializeData() {
        cultureItems = new ArrayList<>();

        if (language == 1) {

            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));
            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));
            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));
            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));
            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));



        } else {

            cultureItems.add(new CultureItem("The origins of the practice of punishment towards the son","A series of turbulent things","October 2014","The origins of the practice of punishment towards the son"));
            cultureItems.add(new CultureItem("The origins of the practice of punishment towards the son","A series of turbulent things","October 2014","The origins of the practice of punishment towards the son"));
            cultureItems.add(new CultureItem("The origins of the practice of punishment towards the son","A series of turbulent things","October 2014","The origins of the practice of punishment towards the son"));
            cultureItems.add(new CultureItem("The origins of the practice of punishment towards the son","A series of turbulent things","October 2014","The origins of the practice of punishment towards the son"));
        }
    }

    private void initializeAdapter() {

        CultureAdapter adapter = new CultureAdapter(cultureItems);
        rv2.setAdapter(adapter);

    }

}