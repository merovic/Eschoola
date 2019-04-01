package com.amirahmed.eschoola.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.amirahmed.eschoola.Adapters.NewsAdapter;
import com.amirahmed.eschoola.Models.NewsItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utiles.TinyDB;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends Fragment {

    View view;

    TinyDB tinyDB;

    int language;

    private List<NewsItem> newsItems;
    private RecyclerView rv2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_news, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tinyDB = new TinyDB(getActivity());

        language = tinyDB.getInt("language");

        rv2 = view.findViewById(R.id.news_rv);

        rv2.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();


    }

    private void initializeData() {
        newsItems = new ArrayList<>();

        if (language == 1) {

            newsItems.add(new NewsItem("المشاركة فى اليوم العالمى للطفل","المشاركة فى اليوم العالمى للطفل","اكتوبر ٢٠١٤"));
            newsItems.add(new NewsItem("المشاركة فى اليوم العالمى للطفل","المشاركة فى اليوم العالمى للطفل","اكتوبر ٢٠١٤"));
            newsItems.add(new NewsItem("المشاركة فى اليوم العالمى للطفل","المشاركة فى اليوم العالمى للطفل","اكتوبر ٢٠١٤"));
            newsItems.add(new NewsItem("المشاركة فى اليوم العالمى للطفل","المشاركة فى اليوم العالمى للطفل","اكتوبر ٢٠١٤"));

        } else {

            newsItems.add(new NewsItem("Kids international day sharing","Kids international day sharing","October 2014"));
            newsItems.add(new NewsItem("Kids international day sharing","Kids international day sharing","October 2014"));
            newsItems.add(new NewsItem("Kids international day sharing","Kids international day sharing","October 2014"));
            newsItems.add(new NewsItem("Kids international day sharing","Kids international day sharing","October 2014"));
            newsItems.add(new NewsItem("Kids international day sharing","Kids international day sharing","October 2014"));
        }
    }

    private void initializeAdapter() {

        NewsAdapter adapter = new NewsAdapter(newsItems);
        rv2.setAdapter(adapter);

    }

}
