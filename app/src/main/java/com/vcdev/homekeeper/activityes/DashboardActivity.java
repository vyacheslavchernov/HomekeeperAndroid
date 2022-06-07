package com.vcdev.homekeeper.activityes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vcdev.homekeeper.R;
import com.vcdev.homekeeper.api.requests.BaseRq;
import com.vcdev.homekeeper.api.requests.BaseRs;
import com.vcdev.homekeeper.api.requests.montData.GetCalcRq;
import com.vcdev.homekeeper.api.requests.montData.GetLastRq;

public class DashboardActivity extends AppCompatActivity {

    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        new AsyncRequest().execute(new GetCalcRq().setId("202202"));
    }

    class AsyncRequest extends AsyncTask<BaseRq, Integer, BaseRs> {

        @Override
        protected BaseRs doInBackground(BaseRq... arg) {
            return arg[0].post();
        }

        @Override
        protected void onPostExecute(BaseRs s) {
            super.onPostExecute(s);

            if(s.isSuccess()) {
                TextView text = (TextView) findViewById(R.id.textView5);
                ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);

                text.setText(s.getRawContent());
                progressBar.setVisibility(View.GONE);
            }

        }
    }
}