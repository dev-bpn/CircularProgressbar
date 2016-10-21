package com.mobotechnology.www.circularprogressbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.natasa.progressviews.CircleProgressBar;
import com.natasa.progressviews.utils.OnProgressViewListener;

public class MainActivity extends AppCompatActivity {

    private int counter = 1;
    private CircleProgressBar circleProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView next = (TextView) findViewById(R.id.next);
        TextView prev = (TextView) findViewById(R.id.prev);
        circleProgressBar = (CircleProgressBar) findViewById(R.id.circle_progress);

        initCircularProgressBar();
        handlingViewsOnClick(next, prev);
    }

    private void initCircularProgressBar() {
        circleProgressBar.setRoundEdgeProgress(false);
        circleProgressBar.setTextSize(62);
        circleProgressBar.setTextColor(Color.WHITE);
        circleProgressBar.setText("1");
        circleProgressBar.setMaximumProgress(100);
        circleProgressBar.setStartPositionInDegrees(90);
        //you can set listener for progress in every ProgressView
        circleProgressBar.setOnProgressViewListener(new OnProgressViewListener() {
            @Override
            public void onFinish() {
                //do something on progress finish
                circleProgressBar.setText("done!");
                // circleProgressBar.resetProgressBar();
            }

            @Override
            public void onProgressUpdate(float progress) {
                circleProgressBar.setText("" + (int) progress);

            }
        });
    }

    private void handlingViewsOnClick(TextView next, TextView prev) {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter < 100) {
                    circleProgressBar.setProgress(++counter);
                } else {
                    Toast.makeText(MainActivity.this, "No more next", Toast.LENGTH_LONG).show();
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter > 1) {
                    circleProgressBar.setProgress(--counter);
                } else {
                    Toast.makeText(MainActivity.this, "No more preview", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
