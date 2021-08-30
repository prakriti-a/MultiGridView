package com.prakriti.mutigridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.widget.VerticalGridView;

import android.os.Bundle;

import com.prakriti.mutigridview.adapters.VerticalGridAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // collection of HGVs
        String[] titles = new String[] {"Movies", "TV Shows", "Streaming Platforms"};

        // multiple HGVs in one VGV
        VerticalGridView verticalGrid = findViewById(R.id.verticalGrid);
        VerticalGridAdapter adapter = new VerticalGridAdapter(this, titles);
        verticalGrid.setAdapter(adapter);
    }
    
}