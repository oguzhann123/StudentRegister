package com.example.studentregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.studentregister.data.entity.Student;
import com.example.studentregister.databinding.ActivityListBinding;
import com.example.studentregister.room.Database;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    private ActivityListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        binding = ActivityListBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Database db = new Database(getApplicationContext());

        java.util.List<Student> studentList = new ArrayList<Student>();

        studentList = db.allRegister();






StringBuilder stringBuilder = new StringBuilder();

for (Student student:studentList){
    stringBuilder.append(student.getInfo()+"\n"+student.getEmail()+"\n"+student.getAddress()+"\n");
}
binding.textView.setText(stringBuilder);












    }

}