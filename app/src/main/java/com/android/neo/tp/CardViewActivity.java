package com.android.neo.tp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.neo.tp.helpers.models.Article;
import com.android.neo.tp.helpers.adapters.CardViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CardViewActivity extends AppCompatActivity {
    @BindView(R.id.list_view_card)
    ListView list_view_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        ButterKnife.bind(this);
        ArrayList<Article> articles = new ArrayList<>();
        Article a1 = new Article("Article 1");
        Article a2 = new Article("Article 2");
        Article a3 = new Article("Article 3");
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);

        list_view_card.setAdapter(new CardViewAdapter(this, articles));
    }
}
