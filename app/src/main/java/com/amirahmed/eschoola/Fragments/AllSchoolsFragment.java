package com.amirahmed.eschoola.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.amirahmed.eschoola.Adapters.SchoolsListAdapter;
import com.amirahmed.eschoola.Models.SchoolsListItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utils.TinyDB;
import com.daimajia.slider.library.SliderLayout;

import java.util.List;

public class AllSchoolsFragment extends Fragment {

    View view;

    private SliderLayout mDemoSlider;

    TinyDB tinyDB;

    int language;

    private List<SchoolsListItem> schoolsListItems;
    private RecyclerView rv2;

    SchoolsListAdapter adapter;

    ImageView culture,news;

    ImageView filter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_allschools, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
