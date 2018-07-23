package innovationcenter.car_watch.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import controllers.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mCallButton;
    private Button mRadioButton;
    private Button mMovieButton;
    private Button mNavButton;
    private Button mConfButton;
    private Button mBTButton;

    // boutons à ajouter une fois les fonctionnalités définies

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                mCallButton.setBackgroundResource(R.drawable.baseline_phone_black_36dp);
                break;
            case 1:
                mRadioButton.setBackgroundResource(R.drawable.baseline_radio_black_36dp);
                break;
            case 2:
                mMovieButton.setBackgroundResource(R.drawable.baseline_movie_black_36dp);
                break;
            case 3:
                mNavButton.setBackgroundResource(R.drawable.baseline_navigation_black_36dp);
                break;
            case 4:
                mConfButton.setBackgroundResource(R.drawable.baseline_configuration_icon);
                break;
            case 5:
                mBTButton.setBackgroundResource(R.drawable.baseline_bluetooth_black_36dp);
                break;

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCallButton = (Button) findViewById(R.id.activity_main_call_btn);
        mRadioButton = (Button) findViewById(R.id.activity_main_radio_btn);
        mMovieButton = (Button) findViewById(R.id.activity_main_movie_btn);
        mNavButton = (Button) findViewById(R.id.activity_main_nav_btn);
        mConfButton = (Button) findViewById(R.id.activity_main_conf_btn);
        mBTButton = (Button) findViewById(R.id.activity_main_bt_btn);


        mCallButton.setTag(0);
        mRadioButton.setTag(1);
        mMovieButton.setTag(2);
        mNavButton.setTag(3);
        mConfButton.setTag(4);
        mBTButton.setTag(5);

        mCallButton.setOnClickListener(this);
        mRadioButton.setOnClickListener(this);
        mMovieButton.setOnClickListener(this);
        mNavButton.setOnClickListener(this);
        mConfButton.setOnClickListener(this);
        mBTButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch ((int) v.getTag()) {
            case 0:
                Intent CallActivity = new Intent(MainActivity.this, CallActivity.class);
                v.setBackgroundResource(R.drawable.baseline_phone_black_36dp3);
                startActivityForResult(CallActivity, 0);
                break;
            case 1:
                Intent RadioActivity = new Intent(MainActivity.this, RadioActivity.class);
                v.setBackgroundResource(R.drawable.baseline_radio_black_36dp3);
                startActivityForResult(RadioActivity, 1);
                break;
            case 2:
                Intent MovieActivity = new Intent(MainActivity.this, MovieActivity.class);
                v.setBackgroundResource(R.drawable.baseline_movie_black_36dp3);
                startActivityForResult(MovieActivity, 2);
                break;
            case 3:
                Intent NavActivity = new Intent(MainActivity.this, NavActivity.class);
                v.setBackgroundResource(R.drawable.baseline_navigation_black_36dp3);
                startActivityForResult(NavActivity, 3);
                break;
            case 4:
                Intent ConfActivity = new Intent(MainActivity.this, ConfActivity.class);
                v.setBackgroundResource(R.drawable.baseline_configuration_icon3);
                startActivityForResult(ConfActivity, 4);
                break;
            case 5:
                Intent BTActivity = new Intent(MainActivity.this, BTActivity.class);
                v.setBackgroundResource(R.drawable.baseline_bluetooth_black_36dp3);
                startActivityForResult(BTActivity, 5);
                break;

        }

    }
}
