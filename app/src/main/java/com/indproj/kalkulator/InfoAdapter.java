package com.indproj.kalkulator;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {

    private InfoContainer infoContainer;

    InfoAdapter(InfoContainer container) {
        infoContainer = container;
    }

    @NonNull
    @Override
    public InfoAdapter.InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_item, parent, false);
        return new InfoAdapter.InfoViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull InfoAdapter.InfoViewHolder holder, int position) {

        InfoContainer.Info info = infoContainer.getInfo(position);
        holder.titleTextView.setText(info.title);

        holder.bodyTextView.setText(info.bodyText);

        boolean isExpanded = infoContainer.getInfo(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return infoContainer.size();
    }

    class InfoViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout expandableLayout;
        TextView titleTextView, bodyTextView;

        public InfoViewHolder(@NonNull final View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.title_info);
            bodyTextView = itemView.findViewById(R.id.info_bodyText);
            expandableLayout = itemView.findViewById(R.id.info_expandableLayout);

            titleTextView.setOnClickListener(view -> {
                InfoContainer.Info info = infoContainer.getInfo(getAdapterPosition());
                info.setExpanded(!info.isExpanded());
                notifyItemChanged(getAdapterPosition());
            });
        }
    }

}
