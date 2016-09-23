package com.kidz.views.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.kidz.presenter.VideoListPresenter;
import com.kidz.utils.Dialogs;
import com.kidz.R;
import com.kidz.modal.pojo.restclient.RestClient;
import com.kidz.adapter.RecyclerTrainAdapter;
import com.kidz.modal.pojo.VideoList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VedioTrain extends AppCompatActivity {
private RecyclerView videotrain;
private RecyclerTrainAdapter recyclerTrainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio_train);

        videotrain=(RecyclerView)findViewById(R.id.recyclertrain);
        recyclerTrainAdapter=new RecyclerTrainAdapter(this);
        LinearLayoutManager ll=new LinearLayoutManager(this);
        ll.setOrientation(LinearLayoutManager.HORIZONTAL);
        videotrain.setLayoutManager(ll);
        videotrain.setAdapter(recyclerTrainAdapter);

        VideoListPresenter presenter=new VideoListPresenter();
        presenter.callPresenter(this);

        Button b=(Button)findViewById(R.id.watched);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),WatchedVideos.class);
                startActivity(i);
            }
        });

    }


    public void setAdapter(List<VideoList> list)
    {
        recyclerTrainAdapter.setData(list);
    }


}
