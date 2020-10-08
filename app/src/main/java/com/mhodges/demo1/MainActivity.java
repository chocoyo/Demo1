package com.mhodges.demo1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.btnVibrate)).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Vibrate(VibrationEffect.createOneShot(300, VibrationEffect.EFFECT_HEAVY_CLICK));
            }
        });

        ((Button) findViewById(R.id.btnVibePattern)).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                long[] vibePattern = new long[]{0, 400, 200, 400};
                Vibrate(vibePattern);
            }
        });
    }

    //Vibrate phone for X milliseconds
    private void Vibrate(VibrationEffect effect) {
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(effect);
        } else {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(300);
            Toast.makeText(this,"This Demo Is Not Fully Featured With APIS < 26", Toast.LENGTH_LONG).show();
        }
    }

    //Vibrate Phone With Effect
    private void Vibrate(long[] effect) {
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(effect, -1);
        } else {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(300);
            Toast.makeText(this,"This Demo Is Not Fully Featured With APIS < 26", Toast.LENGTH_LONG).show();
        }
    }
}