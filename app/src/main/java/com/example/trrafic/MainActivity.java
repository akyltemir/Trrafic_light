package com.example.trrafic;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout b_1, b_2, b_3;
    private Boolean start_stop = false;
    private Button button;
    private int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_1 = findViewById(R.id.semafor);
        b_2 = findViewById(R.id.semafor1);
        b_3 = findViewById(R.id.semafor2);
        button = findViewById(R.id.button);

    }

    public void onClickStart(View view) {
        if (!start_stop){
            start_stop = true;
            button.setText("Stop");


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (start_stop) {
                    counter++;
                    switch (counter){
                        case 1:
                            b_1.setBackgroundColor(getResources().getColor(R.color.green));
                            b_2.setBackgroundColor(getResources().getColor(R.color.grey));
                            b_3.setBackgroundColor(getResources().getColor(R.color.grey));
                            break;
                        case 2:
                            b_1.setBackgroundColor(getResources().getColor(R.color.grey));
                            b_2.setBackgroundColor(getResources().getColor(R.color.yellow));
                            b_3.setBackgroundColor(getResources().getColor(R.color.grey));
                            break;
                        case 3:
                            b_1.setBackgroundColor(getResources().getColor(R.color.grey));
                            b_2.setBackgroundColor(getResources().getColor(R.color.grey));
                            b_3.setBackgroundColor(getResources().getColor(R.color.red));
                            counter = 0;
                            break;




                    }



                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
        }
        else{
            start_stop = false;
            button.setText("Start");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        start_stop = false;
    }
}