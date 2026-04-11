package com.example.allexercises;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class TD2Ex14Activity extends AppCompatActivity {

    private static final int PERM_SMS = 1;
    private static final int PERM_CALL = 2;

    private TextView tvSmsContent;
    private EditText etPhoneNumber;
    private Button btnMakeCall;

    private BroadcastReceiver smsReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
                for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                    String messageBody = smsMessage.getMessageBody();
                    String address = smsMessage.getOriginatingAddress();
                    tvSmsContent.setText("SMS de: " + address + "\nContenu: " + messageBody);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex14);

        tvSmsContent = findViewById(R.id.tvSmsContent);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btnMakeCall = findViewById(R.id.btnMakeCall);

        // SMS Permissions check
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, PERM_SMS);
        }

        btnMakeCall.setOnClickListener(v -> {
            String number = etPhoneNumber.getText().toString();
            if (number.isEmpty()) {
                Toast.makeText(this, "Entrez un numéro", Toast.LENGTH_SHORT).show();
                return;
            }
            makePhoneCall(number);
        });
    }

    private void makePhoneCall(String number) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERM_CALL);
        } else {
            String dial = "tel:" + number;
            startActivity(intentWithAction(Intent.ACTION_CALL, dial));
        }
    }

    private Intent intentWithAction(String action, String uriString) {
        return new Intent(action, Uri.parse(uriString));
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(smsReceiver, new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(smsReceiver);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERM_SMS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission SMS accordée", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == PERM_CALL) {
             if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall(etPhoneNumber.getText().toString());
            }
        }
    }
}