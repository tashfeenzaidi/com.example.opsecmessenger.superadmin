package com.example.opsecmessenger.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.opsecmessenger.R;
import com.example.opsecmessenger.models.LanguageModel;

import java.util.List;

public class LanguageArrayAdapter extends ArrayAdapter {

    List<LanguageModel> lanList;
    public LanguageArrayAdapter(@NonNull Context context, int resource, @NonNull List languageList) {
        super(context, 0, languageList);
        lanList = languageList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.choose_language_dropdown_layout, parent, false
            );
        }

        TextView textViewName = convertView.findViewById(R.id.text_view_name);

        LanguageModel item = (LanguageModel) getItem(position);

        if (item != null) {
            textViewName.setText(item.getCountryName());
        }

        return convertView;
    }

}
