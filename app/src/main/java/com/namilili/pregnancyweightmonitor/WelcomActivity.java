package com.namilili.pregnancyweightmonitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class WelcomActivity extends Activity {

    private String TAG  = WelcomActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);

        String strBMI = SharedPreferencesEdit.querySharedPreferencesString(getApplicationContext(),SharedPreferencesEdit.SP_BMI);

        Log.d(TAG,strBMI);
        if (strBMI.isEmpty())
        {
            startActivity(new Intent(WelcomActivity.this,BMIActivity.class));
            finish();
        }
        else
        {
            startActivity(new Intent(WelcomActivity.this,AddWeightActivity.class));
            finish();
        }
    }
}
