package controllers;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


public class RadioActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer;
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
    private Button mExitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

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
        mExitButton = (Button) findViewById(R.id.exitButton);


        mPlay.setOnClickListener(this);
        mPlay1.setOnClickListener(this);
        mPlay2.setOnClickListener(this);
        mPlay3.setOnClickListener(this);
        mPlay4.setOnClickListener(this);
        mPlay5.setOnClickListener(this);
        mPlay6.setOnClickListener(this);
        mExitButton.setOnClickListener(this);

        mPlay.setTag("play");
        mPlay1.setTag("play1");
        mPlay2.setTag("play2");
        mPlay3.setTag("play3");
        mPlay4.setTag("play4");
        mPlay5.setTag("play5");
        mPlay6.setTag("play6");
        mExitButton.setTag("exit");


        this.mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bosco);
        mediaPlayer.start();
        frequency.setText("102.5");
        radio.setText("RFM");
        paused = false;
        singer.setText("Placebo");




      /*  AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("You're listening to the radio right now!")
                .setMessage("Et les nouvelles du jour sont ...")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        setResult(1, intent);
                        finish();
                    }
                })
                .create()
                .show();*/
    }

    @Override
    public void onClick(View v) {
        String mTag = (String) v.getTag();

        switch (mTag) {
            case "exit":

                Intent intent = new Intent();
                setResult(1, intent);
                mediaPlayer.pause();
                paused = true;
                mPlay.setImageResource(R.drawable.play_white);
                Toast.makeText(getApplicationContext(), "Leaving the radio area...", Toast.LENGTH_SHORT).show();
                finish();

                break;


            case "play":
                if (paused) {
                    mediaPlayer.start();
                    paused = false;
                    mPlay.setImageResource(R.drawable.baseline_pause_circle_outline_24);

                } else {
                    mediaPlayer.pause();
                    paused = true;
                    mPlay.setImageResource(R.drawable.play_white);
                }
                break;

            case "play1":
                if (this.mediaPlayer.isPlaying()) {
                    this.mediaPlayer.stop();
                    try {
                        this.mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                this.mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.police);
                mediaPlayer.start();
                frequency.setText("103.3");
                radio.setText("RMC");
                paused = false;
                singer.setText("Sting");
                break;

            case "play2":
                if (this.mediaPlayer.isPlaying()) {
                    this.mediaPlayer.stop();
                    try {
                        this.mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                this.mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.muse);
                mediaPlayer.start();
                frequency.setText("92.8");
                radio.setText("France Inter");
                paused = false;
                singer.setText("Muse");
                break;

            case "play3":
                if (this.mediaPlayer.isPlaying()) {
                    this.mediaPlayer.stop();
                    try {
                        this.mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                this.mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bosco);
                mediaPlayer.start();
                frequency.setText("102.5");
                radio.setText("RFM");
                paused = false;
                singer.setText("Placebo");
                break;

            case "play4":
                if (this.mediaPlayer.isPlaying()) {
                    this.mediaPlayer.stop();
                    try {
                        this.mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                this.mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.hallowed_be_thy_name);
                mediaPlayer.start();
                frequency.setText("666.0");
                radio.setText("Beast Radio");
                paused = false;
                singer.setText("Maiden");
                break;

            case "play5":
                if (this.mediaPlayer.isPlaying()) {
                    this.mediaPlayer.stop();
                    try {
                        this.mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                this.mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.noirdes);
                mediaPlayer.start();
                frequency.setText("98.6");
                radio.setText("Le Mou'v");
                paused = false;
                singer.setText("Noir Désir");
                break;

            case "play6":
                if (this.mediaPlayer.isPlaying()) {
                    this.mediaPlayer.stop();
                    try {
                        this.mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                this.mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.maroon);
                mediaPlayer.start();
                frequency.setText("101.2");
                radio.setText("Virgin Radio");
                paused = false;
                singer.setText("Maroon 5");
                break;
        }
    }
}
