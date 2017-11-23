package com.android.neo.tp.helpers.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.neo.tp.R;
import com.android.neo.tp.helpers.models.Test;

import java.util.List;



public class AndroidAdapter extends ArrayAdapter<Test> {

    public AndroidAdapter(Context context, List<Test> tests ){
        super(context, 0, tests);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Test item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_advanced_item_list, parent, false);
        }
        TextView text = (TextView) convertView.findViewById(R.id.android_text);
        ImageView image = (ImageView) convertView.findViewById(R.id.android_image);
        text.setText(item.getText());
        image.setImageResource(item.getImage());
        return convertView;
    }



}
