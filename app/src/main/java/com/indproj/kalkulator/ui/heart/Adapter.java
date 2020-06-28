package com.indproj.kalkulator.ui.heart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.indproj.kalkulator.R;
import com.indproj.kalkulator.ui.data.MeViewModel;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context aContext;
    private FormulaContainer formulaContainer;
    private MeViewModel viewModel;

    Adapter(Context aContext, FormulaContainer formulaContainer, MeViewModel viewModel) {
        this.aContext = aContext;
        this.formulaContainer = formulaContainer;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(aContext).inflate(R.layout.formula_item, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        boolean isMan = viewModel.isMan().getValue();
        int age = viewModel.getAge().getValue();
        int weight = viewModel.getWeight().getValue();
        String result = String.valueOf(formulaContainer.getList().get(position)
                .calculateMaxHeartRate(isMan, age, weight));

        holder.nameView.setText(formulaContainer.getList().get(position).getName());
        holder.resultView.setText(result);

        holder.infoView.setOnClickListener(v -> {
            InfoDialogFragment dialogFragment = new InfoDialogFragment(formulaContainer.getList().get(position));
            FragmentActivity activity = (FragmentActivity)(aContext);
            FragmentManager fm = activity.getSupportFragmentManager();
            dialogFragment.show(fm, "");
        });
    }

    @Override
    public int getItemCount() {
        return formulaContainer.getList().size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameView;
        private TextView resultView;
        private ImageView infoView;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.formula_name);
            resultView = itemView.findViewById(R.id.formula_result);
            infoView = itemView.findViewById(R.id.more_info);
        }
    }
}