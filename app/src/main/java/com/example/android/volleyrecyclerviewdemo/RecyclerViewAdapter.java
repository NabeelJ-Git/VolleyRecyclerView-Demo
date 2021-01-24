package com.example.android.volleyrecyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<DataPOJO> retrievedResponses;
    private Context context;

    public RecyclerViewAdapter(List<DataPOJO> retrievedResponses, Context context) {
        this.retrievedResponses = retrievedResponses;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView id_field;
        private TextView email_field;
        private TextView first_name_field;
        private TextView last_name_field;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id_field = itemView.findViewById(R.id.id_field);
            email_field = itemView.findViewById(R.id.email_field);
            first_name_field = itemView.findViewById(R.id.first_name_field);
            last_name_field = itemView.findViewById(R.id.last_name_field);
        }

        public void setId_field(String id) {
            id_field.setText(id);
        }

        public void setEmail_field(String email) {
            email_field.setText(email);
        }

        public void setFirst_name_field(String firstName) {
            first_name_field.setText(firstName);
        }

        public void setLast_name_field(String lastName) {
            last_name_field.setText(lastName);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setId_field(String.valueOf(retrievedResponses.get(position).getId()));
        holder.setEmail_field(retrievedResponses.get(position).getEmail());
        holder.setFirst_name_field(retrievedResponses.get(position).getFirstName());
        holder.setLast_name_field(retrievedResponses.get(position).getLastName());
    }

    @Override
    public int getItemCount() {
        return retrievedResponses.size();
    }
}
