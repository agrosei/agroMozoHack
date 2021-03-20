package com.insignia.agrosei;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.insignia.agrosei.activity.TimeLineActivity;
import com.insignia.agrosei.fragment.HomeFragment;
import com.insignia.agrosei.fragment.ProfileFragment;
import com.insignia.agrosei.fragment.statisticsFragment;
import com.insignia.agrosei.model.CustomBottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    final Fragment fragment1 = new HomeFragment();
    final Fragment fragment2 = new statisticsFragment();
    final Fragment fragment3 = new ProfileFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;
    CustomBottomNavigationView navBar;
    FloatingActionButton timeline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm.beginTransaction().add(R.id.frameLayout,fragment1, "1").commit();

        navBar = findViewById(R.id.navigation);
        timeline = findViewById(R.id.fab);
        timeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(), TimeLineActivity.class);
                startActivity(i);
            }
        });

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }else{
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
        setLocation();


        navBar.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    fm.beginTransaction().replace(R.id.frameLayout,fragment1).commit();
                    return true;

                case R.id.Profile:
                    fm.beginTransaction().replace(R.id.frameLayout,fragment3).commit();
                    return true;

                case R.id.Stats:
                    fm.beginTransaction().replace(R.id.frameLayout,fragment2).commit();
                    return true;

            }
            return false;
        });

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions,
                                           @NotNull int[] grantResults){
        switch (requestCode){
            case 1: {
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    private void setLocation() {
        GPSTracker gps = new GPSTracker(MainActivity.this);
        double latitude1 = gps.getLatitude();
        double longitude1= gps.getLongitude();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("lat",Double.toString(latitude1));
        hashMap.put("lng",Double.toString(longitude1));
       reference.updateChildren(hashMap).addOnSuccessListener(aVoid -> Toast.makeText(MainActivity.this, "location updated", Toast.LENGTH_SHORT).show());
    }
//    @Override
//    protected void onStop () {
//        super.onStop();
//        if (requestQueue != null) {
//            requestQueue.cancelAll(TAG);
//        }
//    }
}