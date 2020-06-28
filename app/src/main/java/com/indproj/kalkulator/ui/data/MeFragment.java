package com.indproj.kalkulator.ui.data;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.indproj.kalkulator.R;
import com.ramotion.fluidslider.FluidSlider;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import kotlin.Unit;

public class MeFragment extends Fragment {

    private MeViewModel viewModel;
    private FluidSlider fluidSliderAge;
    private FluidSlider fluidSliderWeight;
    private FluidSlider fluidSliderRestHeartRate;
    private TextView selectedSex;
    private ImageView imageView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_me, container,false);

        viewModel = MeViewModel.getInstance();

        initFluidSliderAge(root, viewModel);
        initFluidSliderWeight(root, viewModel);
        initFluidSliderRestHeartRate(root, viewModel);
        initImageView(root);

        return root;
    }

    private void initFluidSliderAge(@NotNull View root, @NotNull MeViewModel model) {
        int start = Objects.requireNonNull(model.getSliderSettings().getValue()).ageStart;
        int stop = model.getSliderSettings().getValue().ageStop;
        float position = model.getSliderSettings().getValue().agePos;
        fluidSliderAge = root.findViewById(R.id.fluidSliderAge);
        fluidSliderAge.setBeginTrackingListener(() -> Unit.INSTANCE);
        fluidSliderAge.setEndTrackingListener(() -> Unit.INSTANCE);

        fluidSliderAge.setPositionListener(pos -> {
            final String value = String.valueOf( (int)(start + (stop-start) * pos) );
            fluidSliderAge.setBubbleText(value + " lat");
            viewModel.setAge(Integer.parseInt(value));
            model.getSliderSettings().getValue().agePos = fluidSliderAge.getPosition();
            return Unit.INSTANCE;
        });
        fluidSliderAge.setPosition(position);
        fluidSliderAge.setStartText(String.valueOf(start));
        fluidSliderAge.setEndText(String.valueOf(stop));
    }

    private void initFluidSliderWeight(@NotNull View root, @NotNull MeViewModel model) {
        int start = Objects.requireNonNull(model.getSliderSettings().getValue()).weightStart;
        int stop = model.getSliderSettings().getValue().weightStop;
        float position = model.getSliderSettings().getValue().weightPos;
        fluidSliderWeight = root.findViewById(R.id.fluidSliderWeight);
        fluidSliderWeight.setBeginTrackingListener(() -> Unit.INSTANCE);
        fluidSliderWeight.setEndTrackingListener(() -> Unit.INSTANCE);

        fluidSliderWeight.setPositionListener(pos -> {
            final String value = String.valueOf( (int)(start + (stop-start) * pos) );
            fluidSliderWeight.setBubbleText(value + " kg");
            viewModel.setWeight(Integer.parseInt(value));
            model.getSliderSettings().getValue().weightPos = fluidSliderWeight.getPosition();
            return Unit.INSTANCE;
        });
        fluidSliderWeight.setPosition(position);
        fluidSliderWeight.setStartText(String.valueOf(start));
        fluidSliderWeight.setEndText(String.valueOf(stop));
    }

    private void initFluidSliderRestHeartRate(@NotNull View root, @NotNull MeViewModel model) {
        int start = Objects.requireNonNull(model.getSliderSettings().getValue()).restRateStart;
        int stop = model.getSliderSettings().getValue().restRateStop;
        float position = model.getSliderSettings().getValue().restPos;
        fluidSliderRestHeartRate = root.findViewById(R.id.fluidSliderRestRate);
        fluidSliderRestHeartRate.setBeginTrackingListener(() -> Unit.INSTANCE);
        fluidSliderRestHeartRate.setEndTrackingListener(() -> Unit.INSTANCE);

        fluidSliderRestHeartRate.setPositionListener(pos -> {
            String value = String.valueOf( (int)(start + (stop-start) * pos) );
            fluidSliderRestHeartRate.setBubbleText(value);
            viewModel.setRestHeartRate(Integer.parseInt(value));
            model.getSliderSettings().getValue().restPos = fluidSliderRestHeartRate.getPosition();
            return Unit.INSTANCE;
        });
        fluidSliderRestHeartRate.setPosition(position);
        fluidSliderRestHeartRate.setStartText(String.valueOf(start));
        fluidSliderRestHeartRate.setEndText(String.valueOf(stop));
    }

    @SuppressWarnings("ConstantConditions")
    private void initImageView(View root) {
        imageView = root.findViewById(R.id.imageSex);
        selectedSex = root.findViewById(R.id.typedSex);

        if(viewModel.isMan().getValue()) {
            imageView.setImageResource(R.drawable.man);
            selectedSex.setText(R.string.man);
        } else {
            imageView.setImageResource(R.drawable.woman);
            selectedSex.setText(R.string.woman);
        }

        imageView.setOnClickListener(v -> {
            if(viewModel.isMan().getValue() ) {
                viewModel.setIsMan(false);
                imageView.setImageResource(R.drawable.woman);
                selectedSex.setText(R.string.woman);
            } else {
                viewModel.setIsMan(true);
                imageView.setImageResource(R.drawable.man);
                selectedSex.setText(R.string.man);
            }
        });
    }
}
