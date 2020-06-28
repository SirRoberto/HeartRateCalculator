package com.indproj.kalkulator.ui.zones;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.indproj.kalkulator.InfoActivity;
import com.indproj.kalkulator.R;
import com.indproj.kalkulator.ui.heart.HeartViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

public class ZonesFragment extends Fragment {

    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;


    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_zone, container, false);
        HeartViewModel heartViewModel = HeartViewModel.getInstance();

        if(heartViewModel.getMaxHeartRate().getValue() == null) {
            //noinspection ConstantConditions
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.nav_heart);
            Toast.makeText(root.getContext(), "Wybierz wartość tętna maksymalnego!", Toast.LENGTH_SHORT).show();
        } else {
            TrainingZones trainingZones = new TrainingZones(heartViewModel.getMaxHeartRate().getValue());

            @SuppressWarnings("ConstantConditions")
            OptimalHeartRate optimalHeartRate = new OptimalHeartRate(heartViewModel.getMaxHeartRate().getValue(),
                    heartViewModel.getRestMaxRate().getValue());

            recyclerView = root.findViewById(R.id.zone_recyclerView);
            Adapter adapter = new Adapter(trainingZones);
            recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
            recyclerView.setAdapter(adapter);

            initFloatingActionButton(root);

            TextView intenOptimalPulse = root.findViewById(R.id.intensityTraining_zones);
            TextView longOptimalPulse = root.findViewById(R.id.longTraining_zones);
            TextView basicOptimalPulse = root.findViewById(R.id.basicTraining_zones);

            intenOptimalPulse.setText(Integer.toString(optimalHeartRate.getIntensityTrainingPulse()));
            longOptimalPulse.setText(Integer.toString(optimalHeartRate.getLongTrainingPulse()));
            basicOptimalPulse.setText(Integer.toString(optimalHeartRate.getBasicTrainingPulse()));
        }
        return root;
    }

    private void initFloatingActionButton(View view) {
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy){
                if (dy<0 && !floatingActionButton.isShown())
                    floatingActionButton.show();
                else if(dy>0 && floatingActionButton.isShown())
                    floatingActionButton.hide();
            }

            @Override
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), InfoActivity.class);
            startActivity(intent);
        });
    }

}