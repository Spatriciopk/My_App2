package com.example.my_app2;

import android.os.Bundle;
import android.widget.TextView;

public class MiThread extends Thread {
    TextView et1;
    MainActivity2 ac;

    public MiThread(TextView et1_t, MainActivity2 ac_ac) {
        this.et1 = et1_t;
        this.ac = ac_ac;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int time = 5;
        while( time != 0){
            try {
                if(time >9)
                    et1.setText("0:" + String.valueOf(time));
                else
                    et1.setText("0:0" + String.valueOf(time));
                time = time - 1;
                sleep(1000);
                if(time == 0){
                    ac.reload();
                    time=59;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
