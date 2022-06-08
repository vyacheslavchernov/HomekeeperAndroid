package com.vcdev.homekeeper.activityes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.vcdev.homekeeper.R;
import com.vcdev.homekeeper.api.requests.BaseRq;
import com.vcdev.homekeeper.api.requests.BaseRs;
import com.vcdev.homekeeper.api.requests.montData.GetLastRq;
import com.vcdev.homekeeper.api.requests.pages.DashboardRq;

public class LoadingActivity extends AppCompatActivity {

    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        new AsyncRequest().execute(new DashboardRq());
    }

    class AsyncRequest extends AsyncTask<BaseRq, Integer, BaseRs>{

        @Override
        protected BaseRs doInBackground(BaseRq... arg) {
            return arg[0].post();
        }

        @Override
        protected void onPostExecute(BaseRs s) {
            super.onPostExecute(s);
            Intent intent;
            if (s != null && s.isSuccess()) {
                intent = new Intent(context, DashboardActivity.class);
            } else {
                intent = new Intent(context, LoginActivity.class);
            }
            startActivity(intent);
            finishAffinity();
        }
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }
}