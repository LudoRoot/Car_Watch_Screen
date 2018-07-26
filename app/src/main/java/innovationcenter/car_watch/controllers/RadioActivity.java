package innovationcenter.car_watch.controllers;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import controllers.R;


public class RadioActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LOG_TAG = "textextext";

    private MediaPlayer mMediaPlayer;
    private boolean paused = false;
    private ImageButton mPlay;
    private Button mPlay1;
    private Button mPlay2;
    private Button mPlay3;
    private Button mPlay4;
    private Button mPlay5;
    private Button mPlay6;
    private TextView frequency;
    private TextView radio;
    private TextView singer;
    private ImageButton mExit;
    private ImageButton mEqualizer;
    int mAudioSessId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        mPlay = (ImageButton) findViewById(R.id.play_music);
        mPlay.setImageResource(R.drawable.baseline_pause_circle_outline_24);
        mPlay1 = (Button) findViewById(R.id.preset1);
        mPlay2 = (Button) findViewById(R.id.preset2);
        mPlay3 = (Button) findViewById(R.id.preset3);
        mPlay4 = (Button) findViewById(R.id.preset4);
        mPlay5 = (Button) findViewById(R.id.preset5);
        mPlay6 = (Button) findViewById(R.id.preset6);
        frequency = (TextView) findViewById(R.id.frequency);
        radio = (TextView) findViewById(R.id.radio);
        singer = (TextView) findViewById(R.id.singer);
        mExit = (ImageButton) findViewById(R.id.exitButton);
        mEqualizer = (ImageButton) findViewById(R.id.equalizerIButton);


        mPlay.setOnClickListener(this);
        mPlay1.setOnClickListener(this);
        mPlay2.setOnClickListener(this);
        mPlay3.setOnClickListener(this);
        mPlay4.setOnClickListener(this);
        mPlay5.setOnClickListener(this);
        mPlay6.setOnClickListener(this);
        mExit.setOnClickListener(this);
        mEqualizer.setOnClickListener(this);

        mPlay.setTag("play");
        mPlay1.setTag("play1");
        mPlay2.setTag("play2");
        mPlay3.setTag("play3");
        mPlay4.setTag("play4");
        mPlay5.setTag("play5");
        mPlay6.setTag("play6");
        mExit.setTag("exit");
        mEqualizer.setTag("equal");

        this.mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bosco);
        //mMediaPlayer.start();
        frequency.setText("");
        radio.setText("");
        paused = true;
        singer.setText("");

    }

    @Override
    public void onClick(View v) {
        String mTag = (String) v.getTag();

        switch (mTag) {
            case "exit":

                Intent intent = new Intent();
                setResult(1, intent);
                mMediaPlayer.stop();
                paused = true;
                mPlay.setImageResource(R.drawable.play_white);
                Toast.makeText(getApplicationContext(), "Leaving the radio area...", Toast.LENGTH_SHORT).show();
                //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);                                      //inefficace
                finish();

                break;

            case "equal":
                Intent EqualizerActivity = new Intent(this, AudioFxActivity.class);
                mAudioSessId = mMediaPlayer.getAudioSessionId();
                //Log.i(LOG_TAG, "audioSessID_RA = " + mAudioSessId);                                   //pour le dev, à enlever avant release
                EqualizerActivity.putExtra("audioSessID", mAudioSessId);
                startActivity(EqualizerActivity);

                break;


            case "play":
                if (paused) {
                    mMediaPlayer.start();
                    paused = false;
                    mPlay.setImageResource(R.drawable.baseline_pause_circle_outline_24);

                } else {
                    mMediaPlayer.pause();
                    paused = true;
                    mPlay.setImageResource(R.drawable.play_white);
                }
                break;

            case "play1":
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                try {
                    mMediaPlayer.reset();
                    mMediaPlayer.setDataSource(getApplicationContext(), Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.police));
                    mMediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mMediaPlayer.start();
                frequency.setText("103.3");
                radio.setText("RMC");
                paused = false;
                singer.setText("Sting");
                break;

            case "play2":
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                try {
                    mMediaPlayer.reset();
                    mMediaPlayer.setDataSource(getApplicationContext(), Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.muse));
                    mMediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mMediaPlayer.start();
                frequency.setText("92.8");
                radio.setText("France Inter");
                paused = false;
                singer.setText("Muse");
                break;

            case "play3":
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                try {
                    mMediaPlayer.reset();
                    mMediaPlayer.setDataSource(getApplicationContext(), Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.bosco));
                    mMediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mMediaPlayer.start();
                frequency.setText("102.5");
                radio.setText("RFM");
                paused = false;
                singer.setText("Placebo");
                break;

            case "play4":
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                try {
                    mMediaPlayer.reset();
                    mMediaPlayer.setDataSource(getApplicationContext(), Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.hallowed_be_thy_name));
                    mMediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mMediaPlayer.start();
                frequency.setText("666.0");
                radio.setText("Beast Radio");
                paused = false;
                singer.setText("Maiden");
                break;

            case "play5":
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                try {
                    mMediaPlayer.reset();
                    mMediaPlayer.setDataSource(getApplicationContext(), Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.noirdes));
                    mMediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mMediaPlayer.start();
                frequency.setText("98.6");
                radio.setText("Le Mou'v");
                paused = false;
                singer.setText("Noir Désir");
                break;

            case "play6":
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                try {
                    mMediaPlayer.reset();
                    mMediaPlayer.setDataSource(getApplicationContext(), Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.maroon));
                    mMediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mMediaPlayer.start();
                frequency.setText("101.2");
                radio.setText("Virgin Radio");
                paused = false;
                singer.setText("Maroon 5");
                break;
        }
    }


}
