package com.example.to_dolistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.to_dolistapp.databinding.ActivityDataInsertBinding;

public class Data_Insert_Activity extends AppCompatActivity {
ActivityDataInsertBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String type=getIntent().getStringExtra("type");
        if(type.equals("update")){
           setTitle("update");
           binding.title.setText(getIntent().getStringExtra("title"));
            binding.disp.setText(getIntent().getStringExtra("disp"));
            int id=getIntent().getIntExtra("id",0);
            binding.add.setText("update note");
            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent();
                    intent.putExtra("title",binding.title.getText().toString());
                    intent.putExtra("disp",binding.disp.getText().toString());
                    intent.putExtra("id",id);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            });
        }else{
            setTitle("Add Note");
            binding.title.setText(getIntent().getStringExtra("title"));
            binding.disp.setText(getIntent().getStringExtra("disp"));
            if(binding.title.toString().equals("")&& binding.disp.toString().equals("")){
                binding.add.setEnabled(false);
                Toast.makeText(this, "please insert the text", Toast.LENGTH_SHORT).show();

            }else{
                binding.add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent=new Intent();
                        intent.putExtra("title",binding.title.getText().toString());
                        intent.putExtra("disp",binding.disp.getText().toString());
                        setResult(RESULT_OK,intent);
                        finish();

                    }
                });
            }

        }

    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class));
    }
}
//if(s.toString().equals("")){
//        newTaskSaveButton.setEnabled(false);
//        newTaskSaveButton.setTextColor(Color.GRAY);
//        }
//        else{
//        newTaskSaveButton.setEnabled(true);
//        newTaskSaveButton.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
//        }
//        }