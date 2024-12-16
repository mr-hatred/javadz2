package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private Button btn;
    private int counter = 0;
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCounter();
            }
        });
    }

    private void startCounter() {
        counter = 0;
        btn.setEnabled(false);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (counter <= 30) {
                    tv.setText(String.valueOf(counter));
                    counter++;
                    handler.postDelayed(this, 1000);
                } else {
                    btn.setEnabled(true);
                }
            }
        };
        handler.post(runnable);
    }
}
