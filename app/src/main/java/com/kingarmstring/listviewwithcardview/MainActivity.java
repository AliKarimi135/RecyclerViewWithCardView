package com.kingarmstring.listviewwithcardview;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvCards)
    RecyclerView rvCards;

    List<Drawable> images = new ArrayList<>();
    List<String> names = new ArrayList<>();
    List<String> desc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mockData();
        setupList();
    }


    private void setupList() {
        BirdsAdapter birdsAdapter = new BirdsAdapter(images, names, desc);
        rvCards.setLayoutManager(new LinearLayoutManager(this));
        rvCards.setAdapter(birdsAdapter);
    }

    private void mockData() {
        for(int i = 0; i < 10; i++) {
            images.add(getResources().getDrawable(R.drawable.bird));
            names.add(getResources().getString(R.string.red));
            desc.add(getResources().getString(R.string.img_desc));
        }

    }
}


//BindView is used instead of "findViewById(R.id.evCards)"
//we can use as many BindView as we want for our layout items
//BUT don't forget after the list setContentView(R.layout.activity_main) to add "ButterKnife.bind(this)"
