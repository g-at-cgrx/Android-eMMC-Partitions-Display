package com.ceguroxys.guillaume.android_emmc_partitions_display;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            // Run the command
//            Process process = Runtime.getRuntime().exec("df");
            Process process = Runtime.getRuntime().exec("ls /dev/block/platform/hi_mci.1/by-name/");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            // Grab the results
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
//                int i = line.indexOf(' ');
                log.append(line + "\n");
//                int i = line.indexOf(':');
//                log.append(line.substring(0, i:+) + "\n");
//                log.append(line + "\n");
            }

            // Update the view
            TextView tv = (TextView)findViewById(R.id.my_text_view);
            tv.setText(log.toString());
        } catch (IOException e) {
        }    }


}
