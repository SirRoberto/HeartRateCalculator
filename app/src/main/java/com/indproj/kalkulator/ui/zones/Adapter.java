package com.indproj.kalkulator.ui.zones;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.indproj.kalkulator.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ZoneViewHolder> {

    private TrainingZones zones;

    Adapter(TrainingZones zones) {
        this.zones = zones;
    }

    @NonNull
    @Override
    public ZoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.zone_item, parent, false);
        return new ZoneViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ZoneViewHolder holder, int position) {

        TrainingZones.Zone zone = zones.getZone(position);
        holder.nameTextView.setText(zone.name);

        String from = Integer.toString(zone.range[1]);
        String to = Integer.toString(zone.range[3]);
        holder.rangeTextView.setText(from + " - " + to);
        holder.rangeTextView.setTextColor(colorImitatingDifficultyLevel(position, zones.size()));

        from = Integer.toString(zone.range[0]);
        to = Integer.toString(zone.range[2]);
        holder.range_perTextView.setText(from + "% - " + to + "%");

        holder.descTextView.setText(zone.description);
        holder.intensityTextView.setText(zone.intensity);

        boolean isExpanded = zones.getZone(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return zones.size();
    }

    class ZoneViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout expandableLayout;
        TextView nameTextView, intensityTextView, range_perTextView, descTextView, rangeTextView;

         ZoneViewHolder(@NonNull final View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.name_zoneTextView);
            intensityTextView = itemView.findViewById(R.id.inten_TextView);
            range_perTextView = itemView.findViewById(R.id.range_perTextView);
            descTextView = itemView.findViewById(R.id.descTextView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            rangeTextView = itemView.findViewById(R.id.rangeTextView);

            nameTextView.setOnClickListener(view -> {
                TrainingZones.Zone zone = zones.getZone(getAdapterPosition());
                zone.setExpanded(!zone.isExpanded());
                notifyItemChanged(getAdapterPosition());
            });
        }
    }

    private int colorImitatingDifficultyLevel(int level, int maxLevel) {
        int val;
        int x = 0xFF/maxLevel * level;
        if(level < maxLevel/2) {
            val = 0xAA00FF00;
            val += x * 0x10000;
        } else {
            val = 0xAAFFFF00;
            val -= x * 0x100;
        }
        return val;
    }
}