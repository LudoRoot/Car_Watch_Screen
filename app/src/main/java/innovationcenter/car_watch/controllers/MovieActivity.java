package innovationcenter.car_watch.controllers;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.concurrent.TimeUnit;

import controllers.R;


public class MovieActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextMessage;
    private ImageButton mPlay;
    private ImageButton mPause;
    private ImageButton mFastForward;
    private ImageButton mFastRewind;
    private ImageButton mSkipNext;
    private ImageButton mSkipPrevious;
    private ImageButton mStop;
    private VideoView mVideoView;
    private MediaController mediaController;

    private LinearLayout mLinearLayout;
    private int position = 0;

    private Button mExitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        builder.setTitle("You're watching a movie right now!")
//                .setMessage("The End")
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent();
//                        setResult(2, intent);
//                        finish();
//                    }
//                })
//                .create()
//                .show();
//    }
        mTextMessage = (TextView) findViewById(R.id.message);
        mPlay = (ImageButton) findViewById(R.id.play);
        mPause = (ImageButton) findViewById(R.id.pause);
        mStop = (ImageButton) findViewById(R.id.stop);
        mFastForward = (ImageButton) findViewById(R.id.fast_forward);
        mFastRewind = (ImageButton) findViewById(R.id.fast_rewind);
        mSkipPrevious = (ImageButton) findViewById(R.id.skip_previous);
        mSkipNext = (ImageButton) findViewById(R.id.skip_next);
        mLinearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        mExitButton = (Button) findViewById(R.id.exitButton);


        // Nom de la video
        String fileName = "video";

        // Chemin complet de la video
        String filePath = "android.resource://" + getPackageName() + "/raw/" + fileName;
        System.out.print(filePath);
        // Définition de la videoView
        mVideoView = (VideoView) findViewById(R.id.videoView);
        mVideoView.setVideoURI(Uri.parse(filePath));

        // Définition du média controller
        if (mediaController == null) {
            mediaController = new MediaController(MovieActivity.this);

            // Set the videoView that acts as the anchor for the MediaController.
            mediaController.setAnchorView(mVideoView);


            // Set MediaController for VideoView
            mVideoView.setMediaController(mediaController);
        }
        mVideoView.requestFocus();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoView.seekTo(position);
                if (position == 0) {
                    mVideoView.start();
                }
            }
        });

        mPlay.setOnClickListener(this);
        mPause.setOnClickListener(this);
        mStop.setOnClickListener(this);
        mFastForward.setOnClickListener(this);
        mFastRewind.setOnClickListener(this);
        mSkipPrevious.setOnClickListener(this);
        mSkipNext.setOnClickListener(this);
        mExitButton.setOnClickListener(this);

        mPlay.setTag("play");
        mPause.setTag("pause");
        mStop.setTag("stop");
        mFastForward.setTag("fastforward");
        mFastRewind.setTag("fastrewind");
        mSkipPrevious.setTag("skipprevious");
        mSkipNext.setTag("skipnext");
        mVideoView.setTag("video");
        mExitButton.setTag("exit");

    }

    @Override
    public void onClick(View v) {
        String mTag = (String) v.getTag();

        switch (mTag) {
            case "exit":

                Intent intent = new Intent();
                setResult(2, intent);
                mVideoView.stopPlayback();
                Toast.makeText(getApplicationContext(), "Leaving the movie area...", Toast.LENGTH_SHORT).show();
                finish();

                break;
            case "play":
                mVideoView.start();
                break;
            case "pause":
                mVideoView.pause();
                break;
            case "stop":
                mVideoView.stopPlayback();
                break;
            case "fastforward":
                mTextMessage.setText("Forward");
                break;
            case "fastrewind":
                mTextMessage.setText("Rewind");
                break;
            case "skipprevious":
                mTextMessage.setText("Previous");
                break;
            case "skipnext":
                mTextMessage.setText("Next");
                break;
        }
    }


    // Convert millisecond to string.
    private String millisecondsToString(int milliseconds) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes((long) milliseconds);
        long seconds = TimeUnit.MILLISECONDS.toSeconds((long) milliseconds);
        return minutes + ":" + seconds;
    }
}
