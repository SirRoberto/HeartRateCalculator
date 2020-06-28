package com.indproj.kalkulator.ui.heart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.indproj.kalkulator.R;

import java.util.Objects;

public class InfoDialogFragment extends DialogFragment {

    private Formula formula;

    InfoDialogFragment(Formula formula) {
        this.formula = formula;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.formula_info_dialog, container, false);

        TextView descTextView = view.findViewById(R.id.desc_dialog);
        descTextView.setText(formula.getDescription());

        TextView titleTextView = view.findViewById(R.id.title_dialog);
        titleTextView.setText(formula.getName());

        TextView patternTextView = view.findViewById(R.id.pattern_dialog);
        patternTextView.setText(formula.getPattern());

        TextView errorTitleTextView =  view.findViewById(R.id.error_title);
        TextView errorTextView = view.findViewById(R.id.error_dialog);
        if(formula.getError() == null) {
            errorTitleTextView.setVisibility(View.INVISIBLE);
            errorTextView.setVisibility(View.INVISIBLE);
            errorTextView.setHeight(0);
            errorTitleTextView.setHeight(0);
        } else {
            errorTextView.setText(formula.getError());
        }

        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogStyle);
        TextView positiveButton = view.findViewById(R.id.ok_dialog);
        positiveButton.setOnClickListener(v -> Objects.requireNonNull(getDialog()).dismiss());
        return view;
    }

}
