package com.kidz.views.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kidz.R;
import com.kidz.adapter.RecyclerAdapter;
import com.kidz.modal.pojo.VideoList;

import java.util.ArrayList;

public class DFragment extends DialogFragment {
    private RecyclerView recyclerView;
    private OnCompleteListener mListener;
    private ArrayList<VideoList> list=new ArrayList<>();
    private ArrayList<VideoList> newlist=new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialogfragment, container, false);

       list= (ArrayList<VideoList>) getArguments().getSerializable("oldlist");
       newlist= (ArrayList<VideoList>) getArguments().getSerializable("newlist");

        final RelativeLayout layout=(RelativeLayout)rootView.findViewById(R.id.layout);
        layout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE);
       // final TextView play=(TextView)rootView.findViewById(R.id.play);
       // final TextView pause=(TextView)rootView.findViewById(R.id.pause);
        final ImageView closerecycler=(ImageView)rootView.findViewById(R.id.closerecycler);
        closerecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onComplete("closeSuggestion");
               // play.setVisibility(View.GONE);
               // pause.setVisibility(View.GONE);
                closerecycler.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);


            }
        });



        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onComplete("showSuggestions");

                //play.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.VISIBLE);
              //  pause.setVisibility(View.VISIBLE);
                closerecycler.setVisibility(View.VISIBLE);



            }
        });

       /* play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onComplete("play");
              //  play.setVisibility(View.GONE);
              //  pause.setVisibility(View.VISIBLE);


            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onComplete("pause");
               // play.setVisibility(View.VISIBLE);
              //  pause.setVisibility(View.GONE);


            }
        });*/


        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler);
        recyclerView.setVisibility(View.GONE);
        recyclerAdapter = new RecyclerAdapter(getActivity());
        LinearLayoutManager ll = new LinearLayoutManager(getActivity());
        ll.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(ll);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.setData(newlist,list);
        return rootView;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new Dialog(getActivity(), getTheme()){
            @Override
            public void onBackPressed() {
                getActivity().finish();
            }
        };
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Translucent_NoTitleBar);

    }

    public static interface OnCompleteListener {
        public abstract void onComplete(String msg);
    }


    // make sure the Activity implemented it
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.mListener = (OnCompleteListener)activity;
        }
        catch (final ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCompleteListener");
        }
    }

}