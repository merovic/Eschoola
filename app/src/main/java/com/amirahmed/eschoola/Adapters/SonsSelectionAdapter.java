package com.amirahmed.eschoola.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.amirahmed.eschoola.Models.SonItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utiles.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

public class SonsSelectionAdapter extends RecyclerView.Adapter<SonsSelectionAdapter.SonsSelectionViewHolder> {

    List<SonItem> sonItems;

    int language;

    Context context;

    TextView to;

    TinyDB tinyDB;


    public SonsSelectionAdapter(List<SonItem> sonItems, TextView to) {
        this.sonItems = sonItems;
        this.to = to;
    }

    @NonNull
    @Override
    public SonsSelectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {


        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sons_selection, parent, false);

        return new SonsSelectionAdapter.SonsSelectionViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final SonsSelectionViewHolder holder, int position) {

       // Glide.with(context).load(sonItems.get(position).getSonPic()).into(holder.sonpic);

        holder.sonname.setText(sonItems.get(position).getSonName());
     //   holder.sonlevel.setText(sonItems.get(position).getSonLevel());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                to.setText(holder.sonname.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return sonItems.size();
    }

    class SonsSelectionViewHolder extends RecyclerView.ViewHolder {

        LinearLayout container;
        ImageView sonpic;
        TextView sonname,sonlevel;

        SonsSelectionViewHolder(@NonNull View itemView) {
            super(itemView);

            container = itemView.findViewById(R.id.container);
            sonpic = itemView.findViewById(R.id.sonpic);
            sonname = itemView.findViewById(R.id.sonname);
            sonlevel = itemView.findViewById(R.id.sonlevel);

            if(language==1)
            {
                container.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            }

        }
    }
}
