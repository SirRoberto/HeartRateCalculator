package com.indproj.kalkulator.ui.heart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.indproj.kalkulator.R;
import com.indproj.kalkulator.ui.data.MeViewModel;
import com.indproj.kalkulator.utils.ItemClickSupport;

public class HeartRateFragment extends Fragment {

    private HeartViewModel heartViewModel;
    private MeViewModel meViewModel;
    private FormulaContainer formulaContainer;

    @SuppressWarnings("ConstantConditions")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_heart, container, false);

        RecyclerView recyclerView1 = root.findViewById(R.id.zone_recyclerView);
        Adapter adapter = new Adapter(getContext(), formulaContainer, meViewModel);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView1.setAdapter(adapter);

        heartViewModel.setMaxHeartRate(formulaContainer.getList().get(0).calculateMaxHeartRate(
                meViewModel.isMan().getValue(),
                meViewModel.getAge().getValue(),
                meViewModel.getWeight().getValue()));
        heartViewModel.setRestMaxRate(meViewModel.getRestHeartRate().getValue());

        ItemClickSupport.addTo(recyclerView1)
                .setOnItemClickListener((recyclerView, position, v) -> {
                    heartViewModel.setMaxHeartRate(formulaContainer.getList().get(position)
                            .calculateMaxHeartRate(meViewModel.isMan().getValue(),
                                    meViewModel.getAge().getValue(),
                                    meViewModel.getWeight().getValue()));

                    Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                            .navigate(R.id.action_nav_heart_to_navigation_zone);
                });


        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        meViewModel = MeViewModel.getInstance();
        heartViewModel = HeartViewModel.getInstance();
        formulaContainer = new FormulaContainer();
    }
}
