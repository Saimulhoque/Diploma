package com.forbitbd.diploma.ui.main;

import com.forbitbd.diploma.api.ApiClient;
import com.forbitbd.diploma.api.ServiceGenerator;
import com.forbitbd.diploma.model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getResults(Result result) {
        mView.showProgressbar();
        ApiClient apiClient = ServiceGenerator.createService(ApiClient.class);
        apiClient.getResult(result)
                .enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        mView.hideProgressbar();
                        if (response.isSuccessful()) {
                            mView.openDialog(response.body());
                        } else {
                        }
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        mView.hideProgressbar();
                    }
                });
    }
}
