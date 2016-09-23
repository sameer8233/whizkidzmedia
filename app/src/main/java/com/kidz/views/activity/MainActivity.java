package com.kidz.views.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.kidz.views.fragment.DFragment;
import com.kidz.R;
import com.kidz.adapter.RecyclerAdapter;
import com.kidz.modal.pojo.VideoList;

import java.util.ArrayList;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, DFragment.OnCompleteListener, View.OnClickListener {
    private YouTubePlayerView youTubeView;
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    private FrameLayout frame;
    private boolean fullscreen;
    private TextView playme, closerecycler;
    private String videoid = "";
    private RelativeLayout layout;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<VideoList> list;
    private ArrayList<VideoList> newlist = new ArrayList<>();
    private int startindex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent i = getIntent();
        videoid = i.getStringExtra("videoId");
        list = (ArrayList<VideoList>) i.getSerializableExtra("data");
        startindex = i.getIntExtra("position", 0);
        int j = 0;
        startindex++;
        while (j < 4) {
            if(startindex<list.size())
            {
                newlist.add(j, list.get(startindex++));
                j++;
            }else
            {
                j++;
            }
        }


        layout = (RelativeLayout) findViewById(R.id.layout);
        youTubeView = (YouTubePlayerView) findViewById(R.id.player);
        youTubeView.initialize("AIzaSyB4TLQov-pfcYGbjSzCPRQlrLFqxolUoA8", this);

        layout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE);
        RelativeLayout.LayoutParams playerParams = (RelativeLayout.LayoutParams) youTubeView.getLayoutParams();
        playerParams.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        playerParams.height = RelativeLayout.LayoutParams.MATCH_PARENT;


    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

            youTubePlayer.loadVideo(videoid);
            youTubePlayer.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_CUSTOM_LAYOUT);
            youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);


            FragmentManager fm = getFragmentManager();
            DFragment dFragment = new DFragment();
            Bundle args = new Bundle();
            args.putSerializable("oldlist", list);
            args.putSerializable("newlist", newlist);
            dFragment.setArguments(args);
            dFragment.show(fm, "Fragment");

        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            getYouTubePlayerProvider().initialize("AIzaSyB4TLQov-pfcYGbjSzCPRQlrLFqxolUoA8", this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.player);
    }

    @Override
    public void onComplete(String msg) {

        if (msg.equals("showSuggestions")) {

          /*  RelativeLayout.LayoutParams playerParams = (RelativeLayout.LayoutParams) youTubeView.getLayoutParams();
            playerParams.width = RelativeLayout.LayoutParams.MATCH_PARENT;
            playerParams.height = 400;*/


        } else if (msg.equals("closeSuggestion")) {

            /*RelativeLayout.LayoutParams playerParams = (RelativeLayout.LayoutParams) youTubeView.getLayoutParams();
            playerParams.width = RelativeLayout.LayoutParams.MATCH_PARENT;
            playerParams.height = RelativeLayout.LayoutParams.MATCH_PARENT;*/

        }

    }


    @Override
    public void onClick(View view) {

    }


    /*private void doLayout() {
        RelativeLayout.LayoutParams playerParams =
                (RelativeLayout.LayoutParams) youTubeView.getLayoutParams();
        if (fullscreen) {
            // When in fullscreen, the visibility of all other views than the player should be set to
            // GONE and the player should be laid out across the whole screen.
            playerParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
            playerParams.height = LinearLayout.LayoutParams.MATCH_PARENT;

            frame.setVisibility(View.VISIBLE);
            doLayout();


        } else {
            // This layout is up to you - this is just a simple example (vertically stacked boxes in
            // portrait, horizontally stacked in landscape).
            frame.setVisibility(View.INVISIBLE);
            ViewGroup.LayoutParams otherViewsParams = frame.getLayoutParams();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                playerParams.width = otherViewsParams.width = 0;
                playerParams.height = WRAP_CONTENT;
                otherViewsParams.height = MATCH_PARENT;
                //playerParams.weight = 1;
                //baseLayout.setOrientation(LinearLayout.HORIZONTAL);
            } else {
                playerParams.width = otherViewsParams.width = MATCH_PARENT;
                playerParams.height = WRAP_CONTENT;
                // playerParams.weight = 0;
                //otherViewsParams.height = 0;
                //baseLayout.setOrientation(LinearLayout.VERTICAL);
            }
        }
    }*/


}
