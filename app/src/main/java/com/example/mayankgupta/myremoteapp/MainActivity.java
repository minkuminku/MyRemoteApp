package com.example.mayankgupta.myremoteapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ConsumerIrManager mCIR;
    // SparseArray<String> irData;
    List<String> irData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        irData = new ArrayList<>();
        irData.add(

                hex2dec("0000 0066 0000 0015 0060 0018 0030 0018 0030 0018 0018 0018 0030 0018 0030 0018 0018 0018 0018 0018 0018 0018 0030 0018 0018 0018 0030 0018 0030 0018 0030 0018 0018 0018 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0018 01fb"));
        irData.add(

                hex2dec("0000 0067 0000 000d 0061 0018 0031 0018 0018 0018 0031 0018 0031 0018 0018 0018 0018 0018 0031 0018 0031 0018 0031 0018 0018 0018 0031 0018 0018 03c1"));
        irData.add(

                hex2dec("0000 0066 0000 0015 0060 0018 0031 0018 0018 0018 0018 0018 0031 0018 0031 0018 0031 0018 0031 0018 0018 0018 0031 0018 0018 0018 0031 0018 0031 0018 0031 0018 0031 0018 0018 0018 0018 0018 0031 0018 0018 0018 0031 0018 0018 01bd"));


        irData.add(
                hex2dec("0000 0067 0000 000d 0060 0018 0030 0018 0018 0018 0030 0018 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0018 0018 0018 0018 0018 0018 0018 0408"));


        irData.add(
                hex2dec("0000 0067 0000 000d 0061 0017 0019 0017 0019 0017 0019 0017 0019 0017 0019 0017 0031 0017 0031 0017 0031 0017 0019 0017 0019 0017 0019 0017 0019 041e"));

        irData.add(
                hex2dec("0000 0067 0000 000d 0060 0018 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0018 0018 0018 0018 0018 0018 0018 041f"));

        irData.add(
                hex2dec("0000 0067 0000 000d 0060 0018 0031 0017 0019 0017 0031 0017 0019 0017 0031 0017 0019 0017 0019 0017 0031 0017 0019 0017 0019 0017 0019 0017 0019 03fc"));
        irData.add(
                hex2dec("0000 0067 0000 000d 0060 0018 0019 0017 0031 0017 0019 0017 0019 0017 0031 0017 0019 0017 0019 0017 0031 0017 0019 0017 0019 0017 0019 0017 0019 0414"));
        irData.add(
                hex2dec("0000 0067 0000 000d 0061 0018 0018 0018 0018 0018 0018 0018 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0018 0018 0018 0018 0018 0018 0018 0432"));
        irData.add(
                hex2dec("0000 0068 0000 000d 0060 0018 0018 0018 0018 0018 0018 0018 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0018 0018 0018 0018 0018 0018 0018 0434"));
        irData.add(
                hex2dec("0000 0067 0000 000d 0060 0017 0018 0017 0030 0017 0018 0017 0018 0017 0030 0017 0018 0017 0018 0017 0030 0017 0018 0017 0018 0017 0018 0017 0018 0407"));
        irData.add(
                hex2dec("0000 0022 0000 0010 0129 0048 0048 0048 0048 0048 0090 0048 0048 0048 0090 0048 0048 0048 0048 0048 0048 0048 0048 0048 0090 0048 0048 0048 0090 0048 0048 0048 0090 0048 0048 0a29"));


        irData.add(
                hex2dec("0000 0067 0020 0010 0060 001a 0030 0018 0030 0018 0030 0018 0018 0019 0030 0018 0018 0018 0018 0018 0018 0019 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0030 0018 0030 0318 0060 001a 0030 0018 0030 0018 0030 0018 0018 0019 0030 0018 0018 0018 0018 0018 0018 0019 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0030 0018 0030 0318 0060 001a 0030 0018 0030 0018 0030 0018 0018 0019 0030 0018 0018 0018 0018 0018 0018 0019 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0030 0018 0030 0315"));

        irData.add(
                hex2dec("0000 0067 0020 0010 0060 001a 0030 0018 0030 0018 0018 0018 0018 0019 0030 0018 0018 0018 0018 0018 0018 0019 0018 0019 0030 0018 0018 0018 0018 0018 0030 0018 0030 0018 0030 0330 0060 001a 0030 0018 0030 0018 0018 0018 0018 0019 0030 0018 0018 0018 0018 0018 0018 0019 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0030 0018 0030 0330 0060 001a 0030 0018 0030 0018 0018 0018 0018 0019 0030 0018 0018 0018 0018 0018 0018 0019 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0030 0018 0030 032d"));
        irData.add(
                hex2dec("0000 0067 0000 000d 0060 0018 0018 0018 0018 0018 0030 0018 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0018 0018 0018 0018 0018 0018 0018 041e"));
        irData.add(
                hex2dec("0000 0067 0000 0010 005f 0018 0030 0018 0018 0018 0018 0018 0018 0018 0018 0018 0018 0018 0030 0018 0030 0018 0030 0018 0030 0018 0018 0018 0030 0018 0030 0018 0018 0018 0030 0316"));


        mCIR = (ConsumerIrManager) getSystemService(Context.CONSUMER_IR_SERVICE);

        Toast.makeText(getApplicationContext(), "Jjjjj    jjj", Toast.LENGTH_SHORT).show();
    }


    public void onButtonAction(View view) throws InterruptedException {

        //Toast.makeText(getApplicationContext(), "CLICKED", Toast.LENGTH_SHORT).show();

        if (!mCIR.hasIrEmitter()) {
            Log.e("IR TEST", "No IR Emitter found\n");
            Toast.makeText(getApplicationContext(), "NOT ENABLED FUCK OFF", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(getApplicationContext(), "IR IS ENABLED GOOD", Toast.LENGTH_SHORT).show();

        int x = 0;

        Toast.makeText(getApplicationContext(), "START START", Toast.LENGTH_SHORT).show();

        for (String data : irData) {

         //   Toast.makeText(getApplicationContext(), "POS : " + x++, Toast.LENGTH_SHORT).show();

            Log.v("REMOTEAPP", "Data is:" + data.length() + ":" + data);
            Log.v("REMOTEAPP", "Pos : " + x++ + "  of " + irData.size());
            if (data != null) {
                String values[] = data.split(",");
                int[] pattern = new int[values.length - 1];

                for (int i = 0; i < pattern.length; i++) {
                    pattern[i] = Integer.parseInt(values[i + 1]);
                }

                Log.v("REMOTEAPP", "FREQ is" + values[0]);
                // Log.v("REMOTEAPP","FREQ is" + values[0]);

                try {
                    mCIR.transmit(Integer.parseInt(values[0]), pattern);
                } catch (Throwable t) {


                    Log.v("REMOTEAPP", "Exception " + t.getMessage());
                   // Toast.makeText(getApplicationContext(), "Exception Occured MAN*********", Toast.LENGTH_SHORT).show();
                    Thread.sleep(1000);

                }


                Log.v("REMOTEAPP", "Transmitted is : " + values[0]);
            }

            Thread.sleep(6000);

        }

        Log.v("REMOTEAPP", "TRANSMISSION FINISHED !!!---------!!!!!!!!!!!!!!!!!!!!!!");
        Toast.makeText(getApplicationContext(), "TRANSMISSION FINISHED !!!---------!!!", Toast.LENGTH_LONG).show();


    }

  /*  protected String hex2dec(String irData) {
        List<String> list = new ArrayList<String>(Arrays.asList(irData
                .split(" ")));
        list.remove(0); // dummy
        int frequency = Integer.parseInt(list.remove(0), 16); // frequency
       // int frequency = 38000; // frequency
        list.remove(0); // seq1
        list.remove(0); // seq2

        for (int i = 0; i < list.size(); i++) {
            list.set(i, Integer.toString(Integer.parseInt(list.get(i), 16)));
        }

        frequency = (int) (1000000 / (frequency * 0.241246));
        list.add(0, Integer.toString(frequency));

        irData = "";
        for (String s : list) {
            irData += s + ",";
        }

        Log.v("REMOTEAPP","IR Data len " + irData.length() + ": " + irData);
        return irData;
    }*/


    protected String hex2dec(String irData) {
        List<String> list = new ArrayList<String>(Arrays.asList(irData
                .split(" ")));
        list.remove(0); // dummy
        int frequency = Integer.parseInt(list.remove(0), 16); // frequency
        list.remove(0); // seq1
        list.remove(0); // seq2

        for (int i = 0; i < list.size(); i++) {
            list.set(i, Integer.toString(Integer.parseInt(list.get(i), 16)));
        }

        frequency = (int) (1000000 / (frequency * 0.241246));
        list.add(0, Integer.toString(frequency));

        irData = "";
        for (String s : list) {
            irData += s + ",";
        }

        Log.v("REMOTEAPP", "IR Data len " + irData.length() + ": " + irData);
        return irData;
    }


}
