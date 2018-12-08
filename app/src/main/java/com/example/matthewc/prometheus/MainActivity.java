package com.example.matthewc.prometheus;


import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private Camera mCamera;
    private CameraPreview mPreview;


    public static Camera getCameraInstance(){
        Camera c = null;

        try{
            c = Camera.open();
        }catch (Exception e){

        }

        return c;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCamera = getCameraInstance();

        mPreview = new CameraPreview(this, mCamera);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FrameLayout preview = findViewById(R.id.camera_preview);
        preview.addView(mPreview);

    }
}
