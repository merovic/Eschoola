package com.amirahmed.eschoola.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amirahmed.eschoola.Models.ReservationItem;
import com.amirahmed.eschoola.R;
import com.amirahmed.eschoola.Utils.TinyDB;

import java.util.List;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ReservationViewHolder> {

    List<ReservationItem> reservationItems;

    TinyDB tinyDB;

    Context context;

    int language;

    public ReservationAdapter(List<ReservationItem> reservationItems) {
        this.reservationItems = reservationItems;
    }

    @NonNull
    @Override
    public ReservationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reservation, parent, false);

        return new ReservationAdapter.ReservationViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ReservationViewHolder holder, int position) {

        //Uncomment that part after implementing the network layer (it supports both arabic and english) and feel free to modify it based on your needs

        /*if(language==1)
        {
         holder.reqNumber.setText(reservationItems.get(position).getNumber() + "طلب رقم. ");
         switch (reservationItems.get(position).getStatus())
         {
             case "فحص":
                 holder.reqStatus.setBackgroundResource(R.drawable.roundedsemicircle);
             case "مكتمل":
                 holder.reqStatus.setBackgroundResource(R.drawable.roundedsemicircle);
             case "مرفوض":
                 holder.reqStatus.setBackgroundResource(R.drawable.roundedsemicircle);
         }

         holder.totalAmount.setText(reservationItems.get(position).getTotalAmount() + " ر.س");
         holder.discountAmount.setText(reservationItems.get(position).getDiscountAmount() + " ر.س");
         holder.paidAmount.setText(reservationItems.get(position).getPaidAmount() + " ر.س");



         if(reservationItems.get(position).getPayment().equals("visa"))
         {
             holder.visa.setText("فيزا");
         }else
             {
                 holder.visa.setText("كاش");
             }

             if(reservationItems.get(position).getUniform())
             {
                 holder.uniform.setText("الزى");
                 holder.uniform.setVisibility(View.VISIBLE);
             }else
                 {
                     holder.uniform.setVisibility(View.GONE);
                 }

            if(reservationItems.get(position).getBooks())
            {
                holder.books.setText("الحافلة");
                holder.books.setVisibility(View.VISIBLE);
            }else
            {
                holder.books.setVisibility(View.GONE);
            }

            if(reservationItems.get(position).getAdditinalDiscount())
            {
                holder.discount.setText("خصم");
                holder.discount.setVisibility(View.VISIBLE);
            }else
            {
                holder.discount.setVisibility(View.GONE);
            }

            switch (reservationItems.get(position).getTransportation()) {
                case "خط واحد":
                    holder.bus.setText("خط واحد");
                    break;
                case "خطين":
                    holder.bus.setText("خطين");
                    break;
                default:
                    holder.bus.setVisibility(View.GONE);
                    break;
            }

            holder.totalAmount.setText("الأجمالى: "+reservationItems.get(position).getTotalAmount()+" ر.س");
            holder.discountAmount.setText("الأجمالى: "+reservationItems.get(position).getDiscountAmount()+" ر.س");
            holder.paidAmount.setText("الأجمالى: "+reservationItems.get(position).getPaidAmount()+" ر.س");

        }else
        {
            holder.reqNumber.setText("REQUEST NO. " + reservationItems.get(position).getNumber());

            switch (reservationItems.get(position).getStatus())
            {
                case "Processing":
                    holder.reqStatus.setBackgroundResource(R.drawable.rounded_grayempty);
                case "Completed":
                    holder.reqStatus.setBackgroundResource(R.drawable.roundedsemigreen);
                case "Rejected":
                    holder.reqStatus.setBackgroundResource(R.drawable.roundedsemired);
            }

            holder.totalAmount.setText(reservationItems.get(position).getTotalAmount() + " S.R");
            holder.discountAmount.setText(reservationItems.get(position).getDiscountAmount() + " S.R");
            holder.paidAmount.setText(reservationItems.get(position).getPaidAmount() + " S.R");


            if(reservationItems.get(position).getPayment().equals("visa"))
            {
                holder.visa.setText("Visa");
            }else
            {
                holder.visa.setText("Cash");
            }

            if(reservationItems.get(position).getUniform())
            {
                holder.uniform.setText("Uniform");
                holder.uniform.setVisibility(View.VISIBLE);
            }else
            {
                holder.uniform.setVisibility(View.GONE);
            }

            if(reservationItems.get(position).getBooks())
            {
                holder.books.setText("Bus");
                holder.books.setVisibility(View.VISIBLE);
            }else
            {
                holder.books.setVisibility(View.GONE);
            }

            if(reservationItems.get(position).getAdditinalDiscount())
            {
                holder.discount.setText("Discount");
                holder.discount.setVisibility(View.VISIBLE);
            }else
            {
                holder.discount.setVisibility(View.GONE);
            }

            switch (reservationItems.get(position).getTransportation()) {
                case "One Way":
                    holder.bus.setText("One Way Bus");
                    break;
                case "Two Way":
                    holder.bus.setText("Two Way Bus");
                    break;
                default:
                    holder.bus.setVisibility(View.GONE);
                    break;
            }

            holder.totalAmount.setText("TOTAL: "+reservationItems.get(position).getTotalAmount()+" S.R");
            holder.discountAmount.setText("TOTAL: "+reservationItems.get(position).getDiscountAmount()+" S.R");
            holder.paidAmount.setText("TOTAL: "+reservationItems.get(position).getPaidAmount()+" S.R");
        }

        holder.reqStatus.setText(reservationItems.get(position).getStatus());
        holder.reqDate.setText(reservationItems.get(position).getDate());
        holder.schoolName.setText(reservationItems.get(position).getSchoolName());
        holder.studentName.setText(reservationItems.get(position).getKidName());
        holder.genderandlevel.setText(reservationItems.get(position).getKidGender() + " | " + reservationItems.get(position).getKidLevel());
        Glide.with(context).load(reservationItems.get(position).getSchoolLogo()).into(holder.logo);*/
    }

    @Override
    public int getItemCount() {
        return reservationItems.size();
    }

    class ReservationViewHolder extends RecyclerView.ViewHolder {

        LinearLayout containerlayout;
        TextView reqNumber,reqStatus,reqDate,schoolName,studentName,genderandlevel,totalAmount,discountAmount,paidAmount;
        ImageView delete,logo;
        CheckBox books,uniform,bus,visa,discount;

        ReservationViewHolder(@NonNull View itemView) {
            super(itemView);

            containerlayout = itemView.findViewById(R.id.containerlayout);
            reqNumber = itemView.findViewById(R.id.requestname);
            reqStatus = itemView.findViewById(R.id.requeststatus);
            reqDate = itemView.findViewById(R.id.requestdate);
            schoolName = itemView.findViewById(R.id.schoolname);
            studentName = itemView.findViewById(R.id.studentname);
            genderandlevel = itemView.findViewById(R.id.genderandlevel);
            totalAmount = itemView.findViewById(R.id.totalamount);
            discountAmount = itemView.findViewById(R.id.discountamount);
            paidAmount = itemView.findViewById(R.id.paidamount);
            delete = itemView.findViewById(R.id.delete);
            logo = itemView.findViewById(R.id.logo);
            books = itemView.findViewById(R.id.books);
            uniform = itemView.findViewById(R.id.uniform);
            bus = itemView.findViewById(R.id.bus);
            visa = itemView.findViewById(R.id.visa);
            discount = itemView.findViewById(R.id.discount);


            if(language==1)
            {
                containerlayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            }

        }
    }
}
