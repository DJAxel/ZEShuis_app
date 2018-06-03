package com.axelkohler.axelszeshuisapp;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button toggleBluetooth;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleBluetooth = findViewById(R.id.toggleBluetooth);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if( bluetoothAdapter == null ) {
            Toast.makeText(this, "Bluetooth is not supported", Toast.LENGTH_LONG).show();
            finish();
        }

        String bluetoothToggleBtnText = bluetoothAdapter.isEnabled() ?
                getResources().getString(R.string.disable_bluetooth_btn) :
                getResources().getString(R.string.enable_bluetooth_btn);
        toggleBluetooth.setText(bluetoothToggleBtnText);

        // Set bluetooth toggle button click event
        toggleBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bluetoothAdapter.isEnabled()) {
                    bluetoothAdapter.disable();
                    toggleBluetooth.setText( getResources().getString(R.string.enable_bluetooth_btn) );
                } else {
                    bluetoothAdapter.enable();
                    toggleBluetooth.setText( getResources().getString(R.string.disable_bluetooth_btn) );
                }
            }
        });
    }
}
