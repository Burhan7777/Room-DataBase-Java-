package com.example.room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.room.database.ContactEntity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<ContactEntity> myList;
    List<ContactEntity> myList1;

    // ====== ViewHolder class starts ===== //

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView email;
        TextView placeOfBirth;
        TextView gender;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            placeOfBirth = itemView.findViewById(R.id.place);
            gender = itemView.findViewById(R.id.gender);

        }
    }

    // ===== ViewHolder class ends ===== //


    // ==== Adapter class starts ===== //


    public MyAdapter(List<ContactEntity> contactEntities) {
        this.myList = contactEntities;
        myList1 = new ArrayList<>(contactEntities);
    }

    public void updateMethod(List<ContactEntity> myList) {
        this.myList = myList;
        notifyDataSetChanged();
    }

    public void setData(List<ContactEntity> contactEntities) {
        this.myList = contactEntities;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_xml, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(myList.get(position).getName());
        holder.email.setText(myList.get(position).getEmail());
        holder.placeOfBirth.setText(myList.get(position).getPlaceOfBirth());
        holder.gender.setText(myList.get(position).getGender());

    }

    @Override
    public int getItemCount() {

        return myList.size();
    }


    // ===== Adapter class ends ===== //
}
