package com.example.thebluejackkost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Calendar;

public class KostDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kost_detail);
        TextView tvKostName = findViewById(R.id.tvKostName);
        ImageView imgKost = findViewById(R.id.imgKost);
        TextView tvKostPrice = findViewById(R.id.kostsPrice);
        TextView tvKostFacility = findViewById(R.id.kostsFacilities);
        TextView tvKostAddress = findViewById(R.id.kostsAddress);
        TextView tvKostLat = findViewById(R.id.kostsLat);
        TextView tvKostLng = findViewById(R.id.kostsLng);
        Button btnBooking = findViewById(R.id.btnBooking);

        final TextView tvBookingDate = findViewById(R.id.tvBookingDate);

        Intent fromKostList = getIntent();
        String position = fromKostList.getStringExtra("arr");
//
        int pos = Integer.parseInt(position);
//        Toast.makeText(KostDetail.this, "position: " + KostDataDB.kostData.size() + " string: " + pos, Toast.LENGTH_LONG).show();
        String kostName = KostDataDB.kostData.get(pos).getName();
        String kostPrice = String.valueOf(KostDataDB.kostData.get(pos).getPrice());
        String thekostAddress = KostDataDB.kostData.get(pos).getAddress();
        String kostFacility = KostDataDB.kostData.get(pos).getFacilities();
        String kostLat = String.valueOf(KostDataDB.kostData.get(pos).getLatitude());
        String kostLng = String.valueOf(KostDataDB.kostData.get(pos).getLongitude());
        String kostImage = KostDataDB.kostData.get(pos).getImage();
//        Toast.makeText(KostDetail.this, "addr: " + thekostAddress, Toast.LENGTH_LONG).show();
        Glide.with(KostDetail.this).load(kostImage).into(imgKost);
        tvKostName.setText(kostName);
        tvKostPrice.setText(kostPrice);
        tvKostAddress.setText(thekostAddress);
        tvKostFacility.setText(kostFacility);
        tvKostLat.setText(kostLat);
        tvKostLng.setText(kostLng);
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
    }
}
