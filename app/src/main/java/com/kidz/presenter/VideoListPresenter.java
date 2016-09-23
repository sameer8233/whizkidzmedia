package com.kidz.presenter;

import android.app.ProgressDialog;
import android.content.Context;

import com.kidz.modal.pojo.VideoList;
import com.kidz.modal.pojo.restclient.RestClient;
import com.kidz.utils.Dialogs;
import com.kidz.views.activity.VedioTrain;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 23-09-2016.
 */
public class VideoListPresenter {

    private VedioTrain context;
    private List<VideoList> data=new ArrayList<>();

    public void vediolistapi()
    {
        final ProgressDialog d = Dialogs.showLoading(context);
        d.setCanceledOnTouchOutside(false);
        Call<List<VideoList>> call = RestClient.get().getVideos();

        call.enqueue(new Callback<List<VideoList>>() {
            @Override
            public void onResponse(Call<List<VideoList>> call, Response<List<VideoList>> response) {

                data=response.body();
                publish(context);
                d.dismiss();

            }
            @Override
            public void onFailure(Call<List<VideoList>> call, Throwable t) {
                d.dismiss();
                Dialogs.showMessage(context,"Server Connectivity Issue");
            }

        });
    }


    public void callPresenter(VedioTrain context)
    {
        this.context=context;
        vediolistapi();
    }

    public void publish(VedioTrain view) {
        if (view != null) {
            if (data != null) {
                view.setAdapter(data);

            }
        }
    }


}
