package innovationcenter.car_watch.controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import controllers.R;

public class BTActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("You're turning the bluetooth on right now!")
                .setMessage("BT IS ON")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        setResult(4, intent);
                        finish();
                    }
                })
                .create()
                .show();
    }
}
