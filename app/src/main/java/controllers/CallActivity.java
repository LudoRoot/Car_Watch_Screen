package controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



public class CallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("You're calling right now!")
                .setMessage("Blah blah blaaah")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        setResult(0, intent);
                        finish();
                    }
                })
                .create()
                .show();

    }
}
