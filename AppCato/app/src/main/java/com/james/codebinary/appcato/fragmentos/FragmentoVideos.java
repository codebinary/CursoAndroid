package com.james.codebinary.appcato.fragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.james.codebinary.appcato.R;

/**
 * Created by James on 23/06/16.
 */
public class FragmentoVideos extends Fragment {

    private static final String API_KEY_YOUTUBE = "AIzaSyAkGu10t3H_5VqI0k972nb7AaZ6xKSpxGw";

    private static String VIDEO_ID = "EGy39OMyHzw";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_videos, container, false);

        YouTubePlayerSupportFragment youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout, youTubePlayerSupportFragment).commit();

        youTubePlayerSupportFragment.initialize(API_KEY_YOUTUBE, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if(!b){
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    youTubePlayer.loadVideo(VIDEO_ID);
                    youTubePlayer.play();
                }
            }


            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
                //Youtube Error
                String messageError = error.toString();
                Toast.makeText(getContext().getApplicationContext(), messageError, Toast.LENGTH_SHORT).show();
                Log.d("MessageError", messageError);
            }
        });

        return view;
    }
}
