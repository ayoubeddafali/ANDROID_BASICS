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
import com.android.neo.tp.helpers.models.Article;

import java.util.List;

public class CardViewAdapter extends ArrayAdapter<Article>{
    public CardViewAdapter(Context context, List<Article> articles){
        super(context, 0, articles);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Article article = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_view_layout, parent, false);
        }
        TextView text = (TextView) convertView.findViewById(R.id.card_text);
        ImageView image = (ImageView) convertView.findViewById(R.id.card_image);
        text.setText(article.getText());
        image.setImageResource(article.getImage());
        return convertView;
    }
}
