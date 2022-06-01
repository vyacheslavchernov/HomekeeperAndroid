package com.vych.homekeeper;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vych.homekeeper.api.requests.BaseRs;
import com.vych.homekeeper.api.requests.authorization.AuthRq;
import com.vych.homekeeper.api.requests.montData.GetRq;
import com.vych.homekeeper.api.responses.monthData.GetRs;
import com.vych.homekeeper.databinding.FragmentSecondBinding;

import okhttp3.Response;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AuthRq authRq = new AuthRq();
                BaseRs authRs = authRq
                        .setUser("admin")
                        .setPassword("747798")
                        .post();


                GetRq getRq = new GetRq();
                GetRs getRs = getRq.setId("202203").post();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}