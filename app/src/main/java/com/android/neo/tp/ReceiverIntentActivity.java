package com.android.neo.tp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.android.neo.tp.helpers.models.Article;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReceiverIntentActivity extends AppCompatActivity {
    private int i = 0 ;
    @BindView(R2.id.firstBar)
    ProgressBar firstBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_intent);
        ButterKnife.bind(this);
        firstBar.setProgress(0);

    }

    @OnClick(R2.id.receiver_secret_btn) void give_secret_code(){

        Intent intent = new Intent();
        Article a = new Article("Article Transferred");
        intent.putExtra("secret", "This Is My Most Secret Password");
        setResult(RESULT_OK, intent);
        finish();
    }
}
