package com.insignia.agrosei.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.insignia.agrosei.R;
import com.insignia.agrosei.adapter.ChatAdapter;
import com.insignia.agrosei.model.ChatData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;



public class ChatBot extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText ed1;
    ImageButton ib1;
    RecyclerView.Adapter adapter;
    ArrayList<ChatData> Data=new ArrayList<ChatData>();
    int eid1;
    int i= 0,j;
    String s;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    Date currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);
        recyclerView = findViewById(R.id.card_recycle);
        ed1 = findViewById(R.id.chatedit);
        ib1 = findViewById(R.id.img3);
        recyclerView.setHasFixedSize(true);
        currentTime= Calendar.getInstance().getTime();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        mFirebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=mFirebaseDatabase.getReference("Messaging");
        eid1=0;
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = ed1.getText().toString();
                Log.d("Test",s);
                String mdata=databaseReference.push().getKey();
                Map<String, String> data = new HashMap<>();
                data.put("datetime",currentTime.toString());
                data.put("id", firebaseAuth.getCurrentUser().getUid());
                data.put("message", s);
                data.put("order","user");

                JSONObject jsonData = new JSONObject(data);
                databaseReference.child(mdata).setValue(jsonData);
                //databaseReference.push().setValue(data);
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                i=0;
                Data.clear();

                for(DataSnapshot Child:snapshot.getChildren()){
                    try {
                        Data.add(new ChatData(Child.child("message").getValue().toString(),Child.child("order").getValue().toString()));
                        adapter= new ChatAdapter(Data);
                        recyclerView.setAdapter(adapter);


                    }
                    catch (Exception e){
                        Toast.makeText(getApplicationContext(),"gatCaught",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}