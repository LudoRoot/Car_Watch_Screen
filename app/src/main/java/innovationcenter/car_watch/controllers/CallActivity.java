package innovationcenter.car_watch.controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import controllers.R;


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
                        Toast.makeText(getApplicationContext(), "Leaving the call area...", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .create()
                .show();

    }
}
