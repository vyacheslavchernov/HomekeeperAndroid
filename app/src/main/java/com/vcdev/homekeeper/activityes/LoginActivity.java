package com.vcdev.homekeeper.activityes;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.vcdev.homekeeper.R;
import com.vcdev.homekeeper.api.requests.BaseRq;
import com.vcdev.homekeeper.api.requests.BaseRs;
import com.vcdev.homekeeper.api.requests.authorization.AuthRq;
import com.vcdev.homekeeper.api.utils.UsefulMethods;

public class LoginActivity extends AppCompatActivity {

    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = this.getWindow();
        UsefulMethods.setStatusBar(window, this);

        setContentView(R.layout.activity_login);

        TextInputEditText login =  findViewById(R.id.loginTextInput);
        TextInputEditText password = findViewById(R.id.authPasswordInput);

        Button button = (Button) findViewById(R.id.signinButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new AsyncRequest().execute(
                        new AuthRq()
                                .setPassword(password.getText().toString())
                                .setUser(login.getText().toString())
                );
            }
        });
    }

    class AsyncRequest extends AsyncTask<BaseRq, Integer, BaseRs> {

        @Override
        protected BaseRs doInBackground(BaseRq... arg) {
            return arg[0].post();
        }

        @Override
        protected void onPostExecute(BaseRs s) {
            super.onPostExecute(s);
            if (s.isSuccess()) {
                Intent intent = new Intent(context, DashboardActivity.class);
                startActivity(intent);
                finishAffinity();
            } else {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
                builder.setTitle(getResources().getString(R.string.error) + "!")
                        .setMessage(getResources().getString(R.string.wrongCredentials));
                builder.create().show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }
}