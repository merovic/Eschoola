package com.amirahmed.eschoola.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.amirahmed.eschoola.Models.ComparisonItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

public class ComparisonAdapter extends RecyclerView.Adapter<ComparisonAdapter.ComparisonViewHolder> {

    List<ComparisonItem> comparisonItemList;

    Context context;

    TinyDB tinyDB;

    int language;

    public ComparisonAdapter(List<ComparisonItem> comparisonItemList) {
        this.comparisonItemList = comparisonItemList;
    }

    @NonNull
    @Override
    public ComparisonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_compariosn, parent, false);

        return new ComparisonAdapter.ComparisonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComparisonViewHolder holder, int position) {

        holder.point1.setText(comparisonItemList.get(position).getPoint1());
        holder.pointCompariosn.setText(comparisonItemList.get(position).getPointComparison());
        holder.point2.setText(comparisonItemList.get(position).getPoint2());

        if(position==0)
        {
            Glide.with(context).load(R.drawable.distance_yellow_90x90).into(holder.icon);
        }else if(position==1)
        {
            Glide.with(context).load(R.drawable.grade_level_yellow_90x90).into(holder.icon);
        }else if(position==2)
        {
            Glide.with(context).load(R.drawable.gender_yellow_90x90).into(holder.icon);
        }
        else if(position==3)
        {
            Glide.with(context).load(R.drawable.district_yellow_90x90).into(holder.icon);
        }
        else if(position==4)
        {
            Glide.with(context).load(R.drawable.time_yellow_90x90).into(holder.icon);
        }else if(position==5)
        {
            Glide.with(context).load(R.drawable.books_yellow_90x90).into(holder.icon);
        }else if(position==6)
        {
            Glide.with(context).load(R.drawable.certification_yellow_90x90).into(holder.icon);
        }else if(position==7)
        {
            Glide.with(context).load(R.drawable.average_student_yellow_90x90).into(holder.icon);
        }else if(position==8)
        {
            Glide.with(context).load(R.drawable.pitch_yellow_90x90).into(holder.icon);
        }else if(position==9)
        {
            Glide.with(context).load(R.drawable.pool_yellow_90x90).into(holder.icon);
        }else if(position==10)
        {
            Glide.with(context).load(R.drawable.books_yellow_90x90).into(holder.icon);
        }else if(position==11)
        {
            Glide.with(context).load(R.drawable.online_registration_yellow_90x90).into(holder.icon);
        }else if(position==12)
        {
            Glide.with(context).load(R.drawable.discount_yellow_90x90).into(holder.icon);
        }else if(position==13)
        {
            Glide.with(context).load(R.drawable.group_discount_yellow_90x90).into(holder.icon);
        }else
        {
            Glide.with(context).load(R.drawable.cash_yellow_90x90).into(holder.icon);
        }


    }

    @Override
    public int getItemCount() {
        return comparisonItemList.size();
    }

    public class ComparisonViewHolder extends RecyclerView.ViewHolder {

        TextView point1;
        TextView pointCompariosn;
        TextView point2;
        ImageView icon;

        LinearLayout layout;

        public ComparisonViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.iconcompare);
            point1 = itemView.findViewById(R.id.point1);
            pointCompariosn = itemView.findViewById(R.id.pointcomparison);
            point2 = itemView.findViewById(R.id.point2);
            layout = itemView.findViewById(R.id.layout);

            if(language==1)
            {

            }else
                {
                    layout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                }
        }
    }
}
