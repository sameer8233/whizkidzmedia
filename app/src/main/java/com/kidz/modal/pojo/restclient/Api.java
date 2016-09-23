package com.kidz.modal.pojo.restclient;




import com.kidz.modal.pojo.VideoList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sameer on 7/2/2016.
 */

public interface Api {



    @GET("41")
    Call<List<VideoList>> getVideos();


}
