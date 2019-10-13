package com.abhilekh.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.List;

public class ActivityRecognitionService extends IntentService {


    private static final String TAG = "ActivityRecognition";

    public ActivityRecognitionService()
    {
        super("AcitivityRecognitionService");
    }
    public ActivityRecognitionService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if(ActivityRecognitionResult.hasResult(intent))
        {
            ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent);
            handleDetectedActivity(result.getProbableActivities());
        }
    }

    private void handleDetectedActivity(List<DetectedActivity> detectedActivityList)
    {
        for (DetectedActivity detectedActivity: detectedActivityList)
        {
            switch (detectedActivity.getType())
            {
                case DetectedActivity.IN_VEHICLE:
                {
                    Log.d(TAG, "handleDetectedActivity: IN_VEHICLE" + detectedActivity.getConfidence());
                    break;
                }
                case DetectedActivity.ON_BICYCLE:
                {
                    Log.d(TAG, "handleDetectedActivity: ON_BICYCLE" + detectedActivity.getConfidence());
                    break;
                }
                case DetectedActivity.ON_FOOT:
                {
                    Log.d(TAG, "handleDetectedActivity: ON_FOOT" + detectedActivity.getConfidence());
                    break;
                }
                case DetectedActivity.RUNNING:
                {
                    Log.d(TAG, "handleDetectedActivity: RUNNING" + detectedActivity.getConfidence());
                    break;
                }
                case DetectedActivity.WALKING:
                {
                    Log.d(TAG, "handleDetectedActivity: WALKING" + detectedActivity.getConfidence());
                    break;
                }
                case DetectedActivity.STILL:
                {
                    Log.d(TAG, "handleDetectedActivity: STILL" + detectedActivity.getConfidence());
                    break;
                }
                case DetectedActivity.UNKNOWN:
                {
                    Log.d(TAG, "handleDetectedActivity: UNKNOWN" + detectedActivity.getConfidence());
                    break;
                }
            }
        }
    }
}
