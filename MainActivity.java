package com.sari3food.sari3fooooooooood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pbar;
    private int a = 0;
    private Handler handler = new Handler();
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);
        pbar = findViewById(R.id.p_Bar);
        a = pbar.getProgress();
       pbar.setScaleY(4f);
        final Intent intent = new Intent(MainActivity.this,loginactivity.class);

        new Thread(new Runnable() {
            public void run() {
                while (a < 100) {
                    a += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            pbar.setProgress(a);

                           // textView.setText(a + "/" + pbar.getMax());
                           if (a == 100) {
                               startActivity(intent);
                           }
                              // textView.setText(" Your Progess has been Completed");
                        }
                    });
                    try {
                        // Sleep for 50 ms to show progress you can change it as well.
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
