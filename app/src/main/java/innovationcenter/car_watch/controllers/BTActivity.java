package innovationcenter.car_watch.controllers;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Set;

import controllers.R;

public class BTActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LOG_TAG = "textextext";

    //    private final static int REQUEST_CODE_ENABLE_BLUETOOTH = 0;
    private Button mExitButton;
    private Button mListDevicesButton;
    private Button mSearchDevicesButton;

    private BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    private Set<BluetoothDevice> devices;


                                                                                         // a developper c'est pas clair
    private final BroadcastReceiver mBluetoothReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                Toast.makeText(BTActivity.this, "New Device = " + device.getName(), Toast.LENGTH_SHORT).show();

            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        // checkes if the device has bluetooth
//
//        if (bluetoothAdapter == null) {
//            Toast.makeText(this, "Pas de Bluetooth", Toast.LENGTH_SHORT).show();
//        } else
//            Toast.makeText(this, "Avec Bluetooth", Toast.LENGTH_SHORT).show();
//        // checkes if the device has bluetooth
//
//        // checkes if the bluetooth is off, then it asks for permission to turn it on, then turns it on
//        if (!bluetoothAdapter.isEnabled()) {
//            Intent enableBlueTooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivityForResult(enableBlueTooth, REQUEST_CODE_ENABLE_BLUETOOTH);
//        }
//        // end of authorisation check

        // activates the bluetooth without asking
        if (!bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.enable();
            Toast.makeText(this, "Bluetooth activated", Toast.LENGTH_SHORT).show();

            setContentView(R.layout.activity_bt);

            mExitButton = (Button) findViewById(R.id.exitButton);
            mExitButton.setOnClickListener(this);
            mExitButton.setTag("exit");

            mListDevicesButton = (Button) findViewById(R.id.listDevButton);
            mListDevicesButton.setOnClickListener(this);
            mListDevicesButton.setTag("list");

            mSearchDevicesButton = (Button) findViewById(R.id.searchButton);
            mSearchDevicesButton.setOnClickListener(this);
            mSearchDevicesButton.setTag("search");

            // prevoir des actions avec le bluetooth ici

        } else {
            bluetoothAdapter.disable();
            Toast.makeText(this, "Bluetooth deactivated", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            setResult(5, intent);
            finish();
        }


    }

    @Override
    public void onClick(View v) {
        String mTag = (String) v.getTag();

        switch (mTag) {
            case "exit":

                Intent intent = new Intent();
                setResult(5, intent);
                finish();

                break;

            case "list":

                devices = bluetoothAdapter.getBondedDevices();
                for (BluetoothDevice blueDevice : devices) {
                    Toast.makeText(this, "Device = " + blueDevice.getName(), Toast.LENGTH_SHORT).show();
                }

                break;

            case "search":

                                                                    // a developper, c'est pas clair

                if (bluetoothAdapter.isDiscovering()) {
                    bluetoothAdapter.cancelDiscovery();
                }
                bluetoothAdapter.startDiscovery();
                IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                registerReceiver(mBluetoothReceiver, filter);
                Log.i(LOG_TAG, "Point reached #################################");


                break;
        }
    }


                                        // a developper, c'est pas clair
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        bluetoothAdapter.cancelDiscovery();
//        unregisterReceiver(mBluetoothReceiver);
//    }

}
