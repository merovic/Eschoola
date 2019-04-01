package com.amirahmed.eschoola.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amirahmed.eschoola.Activities.DiscountRequestActivity;
import com.amirahmed.eschoola.Activities.ReserveRequestActivity;
import com.amirahmed.eschoola.Models.FeesItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utiles.TinyDB;


import java.util.List;

public class FeesAdapter extends RecyclerView.Adapter<FeesAdapter.FeesViewHolder> {

    List<FeesItem> feesItemList;

    Context context;

    TinyDB tinyDB;

    int language;

    public FeesAdapter(List<FeesItem> feesItemList) {
        this.feesItemList = feesItemList;
    }

    @NonNull
    @Override
    public FeesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fees, parent, false);

        return new FeesAdapter.FeesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeesViewHolder holder, int position) {

        holder.total.setText(feesItemList.get(position).getTotal());
        holder.level.setText(feesItemList.get(position).getTitle());
        holder.uniformamount.setText(feesItemList.get(position).getUniform());
        holder.booksamount.setText(feesItemList.get(position).getBooks());
        holder.bus1amount.setText(feesItemList.get(position).getBus());
        holder.bus2amount.setText(feesItemList.get(position).getBus2());
        holder.comment.setText(feesItemList.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return feesItemList.size();
    }

    public class FeesViewHolder extends RecyclerView.ViewHolder {

        LinearLayout container;
        TextView uniformtext,bustext,bus2text,bookstext,notiestext,comment,uniformamount,booksamount,bus1amount,bus2amount,total,level;
        Button additonal;

        public FeesViewHolder(@NonNull View itemView) {
            super(itemView);

            container = itemView.findViewById(R.id.cotainer);

            uniformtext = itemView.findViewById(R.id.uniformtext);
            bustext = itemView.findViewById(R.id.bustext);
            bus2text = itemView.findViewById(R.id.bus2text);
            bookstext = itemView.findViewById(R.id.bookstext);
            notiestext = itemView.findViewById(R.id.notiestext);
            comment = itemView.findViewById(R.id.comment);
            additonal = itemView.findViewById(R.id.additional);
            uniformamount = itemView.findViewById(R.id.uniformamount);
            booksamount = itemView.findViewById(R.id.booksamount);
            bus1amount = itemView.findViewById(R.id.bus1amount);
            bus2amount = itemView.findViewById(R.id.bus2amount);
            total = itemView.findViewById(R.id.total);
            level = itemView.findViewById(R.id.level);


            if(language!=1)
            {
                container.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                uniformtext.setText("Uniform");
                bustext.setText("Bus One Direction (Optional)");
                bus2text.setText("Bus Two Directions (Optional)");
                bookstext.setText("Books");
                notiestext.setText("Notes");

                additonal.setText("Apply Now");
            }

            additonal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context,ReserveRequestActivity.class);
                    context.startActivity(intent);
                }
            });

        }
    }
}
