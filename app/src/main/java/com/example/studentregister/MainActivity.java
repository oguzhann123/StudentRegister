package com.example.studentregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import com.example.studentregister.data.entity.Student;
import com.example.studentregister.databinding.ActivityMainBinding;
import com.example.studentregister.room.Database;

public class MainActivity extends AppCompatActivity {
 private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = binding.info.getText().toString();
                String email = binding.email.getText().toString();
                String address = binding.address.getText().toString();

                Student student = new Student();// we created new object
                student.setInfo(info);
                student.setEmail(email);
                student.setAddress(address);

try {
    Database db = new Database(getApplicationContext());

    long id =   db.registerAdd(student);

    if (id ==-1) {
        Toast.makeText(MainActivity.this, "ERROR5353", Toast.LENGTH_SHORT).show();
    }else{
        Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
    }
} catch (Exception e) {
    Toast.makeText(MainActivity.this, "THERE IS A PROBLEM\n"+e.getMessage().toString(), Toast.LENGTH_SHORT).show();
}
 binding.info.setText("");
binding.email.setText("");
binding.address.setText("");


binding.list.setOnClickListener(v1 -> {
    Intent intent = new Intent(getApplicationContext(),List.class);
    startActivity(intent);
});


            }
        });
    }
}