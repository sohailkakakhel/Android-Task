package com.example.sofitconsultancytask.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.sofitconsultancytask.R;

public class Splash extends AppCompatActivity {
    private final int PERMISSION_ALL = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final String[] PERMISSIONS = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
        };


        if(!hasPermissions(Splash.this, PERMISSIONS)){
            ActivityCompat.requestPermissions(Splash.this, PERMISSIONS, PERMISSION_ALL);
        }
        else {
            callHandler();
        }

    }

    private void callHandler() {
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this, MainActivity.class));
                finish();

            }
        }, 3000);

    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissionsList[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissionsList, grantResults);
        switch (requestCode) {
            case PERMISSION_ALL: {
                if (grantResults.length > 0) {
                    boolean flag = true;
                    for (int i = 0; i < permissionsList.length; i++) {
                        if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                            flag = false;
                        }
                    }

                    if (flag) {
                        callHandler();
                    }
                    else {
                        Toast.makeText(this, "Permissions Denied", Toast.LENGTH_SHORT).show();
                    }

                }
                return;
            }
        }
    }

}