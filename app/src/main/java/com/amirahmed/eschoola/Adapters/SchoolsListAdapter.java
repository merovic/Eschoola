package com.amirahmed.eschoola.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amirahmed.eschoola.Activities.SchoolDetailsActivity;
import com.amirahmed.eschoola.Models.SchoolsListItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utils.TinyDB;
import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

public class SchoolsListAdapter extends RecyclerView.Adapter<SchoolsListAdapter.SchoolsListViewHolder> {

    private List<SchoolsListItem> schoolsListItems;

    private Context context;

    private int language;

    public SchoolsListAdapter(List<SchoolsListItem> schoolsListItems) {
        this.schoolsListItems = schoolsListItems;
    }

    @NonNull
    @Override
    public SchoolsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

        TinyDB tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;


        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schoolslist, parent, false);


        return new SchoolsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SchoolsListViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.name.setText(schoolsListItems.get(position).getSchoolName());
        holder.distance.setText(schoolsListItems.get(position).getSchoolDistance());
        holder.type.setText(schoolsListItems.get(position).getSchoolType());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context , SchoolDetailsActivity.class);
                context.startActivity(intent);

            }
        });

        if((position%2)==0)
        {
            // even
            Glide.with(context).load(R.drawable.male_active_90x90).into(holder.male);
            Glide.with(context).load(R.drawable.girl_active_90x90).into(holder.female);
            Glide.with(context).load(R.drawable.daytime_active_90x90).into(holder.sun);
            Glide.with(context).load(R.drawable.night_time_active_90x90).into(holder.moon);
            Glide.with(context).load(R.drawable.acswasc_active_90x90).into(holder.certificate);
        }else
            {
                // odd
                Glide.with(context).load(R.drawable.male_active_90x90).into(holder.male);
                Glide.with(context).load(R.drawable.girls_inactive_90x90).into(holder.female);
                Glide.with(context).load(R.drawable.daytime_inactive_90x90).into(holder.sun);
                Glide.with(context).load(R.drawable.night_time_active_90x90).into(holder.moon);
                Glide.with(context).load(R.drawable.acswasc_inactive_90x90).into(holder.certificate);
            }


        holder.compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.compare.setBackgroundResource(R.drawable.rounded_fill_yellow);
            }
        });


        if(position==0 || position==3 || position==6 || position==9 || position==12 || position==15)
        {
         holder.image.setImageResource(R.drawable.trail1);
        }else if(position==1 || position==4 || position==7 || position==10 || position==13 || position==16)
        {
            holder.image.setImageResource(R.drawable.trail2);
        }else if(position==2 || position==5 || position==8 || position==11 || position==14)
        {
            holder.image.setImageResource(R.drawable.trail3);
        }

    }


    public void setFilter(List<SchoolsListItem> schoolsListItems1) {
        schoolsListItems = new ArrayList<>();
        schoolsListItems.addAll(schoolsListItems1);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return schoolsListItems.size();
    }

    class SchoolsListViewHolder extends RecyclerView.ViewHolder {

        TextView name,distance,type;
        ImageView image,moon,sun,male,female,certificate;
        LinearLayout mainlayout;
        Button compare;

        @SuppressLint("SetTextI18n")
        SchoolsListViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.logo);
            name = itemView.findViewById(R.id.name);
            distance = itemView.findViewById(R.id.distance);
            type = itemView.findViewById(R.id.leveltext);
            mainlayout = itemView.findViewById(R.id.mainlayout);
            compare = itemView.findViewById(R.id.visitorbutton);
            moon = itemView.findViewById(R.id.moon);
            sun = itemView.findViewById(R.id.sun);
            male = itemView.findViewById(R.id.male);
            female = itemView.findViewById(R.id.female);
            certificate = itemView.findViewById(R.id.certificate);

            if(language!=1)
            {
                mainlayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                compare.setText("Compare");
                compare.setTextSize(8);

            }

        }
    }
}
