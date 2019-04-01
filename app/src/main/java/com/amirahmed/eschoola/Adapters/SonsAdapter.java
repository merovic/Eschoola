package com.amirahmed.eschoola.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amirahmed.eschoola.Fragments.EditSonFragment;
import com.amirahmed.eschoola.Models.SonItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utiles.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

public class SonsAdapter extends RecyclerView.Adapter<SonsAdapter.SonsViewHolder> {

    List<SonItem> sonItems;

    Context context;

    TinyDB tinyDB;

    int language;

    public SonsAdapter(List<SonItem> sonItems) {
        this.sonItems = sonItems;
    }

    @NonNull
    @Override
    public SonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {


        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sons, parent, false);

        return new SonsAdapter.SonsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SonsViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        /*Glide.with(context).load(sonItems.get(position).getSonPic()).into(holder.sonpic);

        holder.sonname.setText(sonItems.get(position).getSonName());
        holder.sonlevel.setText(sonItems.get(position).getSonLevel());*/

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tinyDB.putString("sonPic",sonItems.get(position).getSonPic());
                tinyDB.putString("sonName",sonItems.get(position).getSonName());
                tinyDB.putString("sonBirthDate",sonItems.get(position).getSonBirthDate());
                tinyDB.putString("sonGender",sonItems.get(position).getSonGender());
                tinyDB.putString("sonStage",sonItems.get(position).getSonStage());
                tinyDB.putString("sonLevel",sonItems.get(position).getSonLevel());
                tinyDB.putString("sonLastSchool",sonItems.get(position).getSonLastSchool());

                final FragmentManager fm = ((Activity) context).getFragmentManager();
                EditSonFragment editPostFragment = new EditSonFragment();

                editPostFragment.show(fm,"TV_tag");
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Delete Function
            }
        });
    }

    @Override
    public int getItemCount() {
        return sonItems.size();
    }

    class SonsViewHolder extends RecyclerView.ViewHolder {

        ImageView sonpic,edit,delete;
        TextView sonname,sonlevel;

        LinearLayout container;


        SonsViewHolder(@NonNull View itemView) {
            super(itemView);

            container = itemView.findViewById(R.id.container);
            sonpic = itemView.findViewById(R.id.sonpic);
            edit = itemView.findViewById(R.id.edit);
            delete = itemView.findViewById(R.id.delete);
            sonname = itemView.findViewById(R.id.sonname);
            sonlevel = itemView.findViewById(R.id.sonlevel);

            if(language==1)
            {
              container.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            }

        }
    }
}
