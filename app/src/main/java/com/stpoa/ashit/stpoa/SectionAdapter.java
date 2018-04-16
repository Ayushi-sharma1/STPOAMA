package com.stpoa.ashit.stpoa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by krsin on 05-04-2018.
 */

public class SectionAdapter extends ArrayAdapter<Sections> {

    public SectionAdapter(@NonNull Context context, ArrayList<Sections> sections) {
        super(context, 0, sections);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_view__laws_,parent,false);
        }
        Sections currentSection = getItem(position);
        TextView chapter_no = (TextView) listItemView.findViewById(R.id.nav_view_law);
        chapter_no.setText(currentSection.getChapter_no());
        return listItemView;
    }
}
