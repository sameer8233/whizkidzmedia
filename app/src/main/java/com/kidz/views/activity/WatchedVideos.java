package com.kidz.views.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kidz.utils.Dialogs;
import com.kidz.R;
import com.kidz.adapter.WatchedRecyclerAdapter;
import com.kidz.database.DatabaseHandler;
import com.kidz.modal.pojo.Dbpojo;

import java.util.List;

public class WatchedVideos extends AppCompatActivity {
private RecyclerView watchedrecycler;
    private WatchedRecyclerAdapter watchedRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watched_videos);

        DatabaseHandler db=new DatabaseHandler(this);
        List<Dbpojo> videolist = db.getAllVideos();
        if (videolist.size()>0)
        {
            watchedrecycler=(RecyclerView)findViewById(R.id.watchedrecyclerview);
            watchedRecyclerAdapter=new WatchedRecyclerAdapter(this,videolist);
            LinearLayoutManager ll=new LinearLayoutManager(this);
            ll.setOrientation(LinearLayoutManager.VERTICAL);
            watchedrecycler.setLayoutManager(ll);
            watchedrecycler.setAdapter(watchedRecyclerAdapter);

        }else {
            Dialogs.showMessage(this,"No Watched Videos");
        }

    }
}
