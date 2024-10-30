package com.example.choresplit;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChoreAdapter extends RecyclerView.Adapter<ChoreAdapter.ChoreViewHolder> {

    private List<Chore> choresList;

    public ChoreAdapter(List<Chore> choresList) {
        this.choresList = choresList;
    }

    @NonNull
    @Override
    public ChoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chore, parent, false);
        return new ChoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChoreViewHolder holder, int position) {
        Chore chore = choresList.get(position);
        holder.tvTaskName.setText(chore.getTask());
        holder.tvDay.setText(chore.getDay() + " - " + chore.getAssignedPerson());
    }

    @Override
    public int getItemCount() {
        return choresList.size();
    }

    public static class ChoreViewHolder extends RecyclerView.ViewHolder {
        TextView tvTaskName;
        TextView tvDay;

        public ChoreViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTaskName = itemView.findViewById(R.id.tvTaskName);
            tvDay = itemView.findViewById(R.id.tvDay);
        }
    }
}
