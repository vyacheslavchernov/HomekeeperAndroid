package com.vych.homekeeper.views.dashboard;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.vych.homekeeper.R;
import com.vych.homekeeper.api.requests.montData.GetCalcRq;
import com.vych.homekeeper.api.requests.montData.GetLastRq;
import com.vych.homekeeper.api.responses.monthData.GetCalcRs;
import com.vych.homekeeper.api.responses.monthData.GetLastRs;
import com.vych.homekeeper.api.utils.AppContext;
import com.vych.homekeeper.databinding.DashboardBinding;

public class DashboardView extends Fragment {

    private DashboardBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = DashboardBinding.inflate(inflater, container, false);
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

        GetLastRs getLastRs = new GetLastRq().post();
        GetCalcRs getCalcRs = new GetCalcRq().setId(getLastRs.getId()).post();

        Double totalSum = getCalcRs.getColdwater() +
                getCalcRs.getHotwater() +
                getCalcRs.getElectricity() +
                getCalcRs.getDrainage() +
                getLastRs.getRent() +
                getLastRs.getEthernet();

        AppContext.detailMonthId = getLastRs.getId();

        binding.header.setText("Последний\nрасчёт (10." + getLastRs.getMonth() + "." + getLastRs.getYear() + ")");
        binding.sum.setText(totalSum + "₽");

        binding.lastMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DashboardView.this)
                        .navigate(R.id.action_dashboardView_to_dashboardDetailView);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
