package com.govind.dhage.ekacareroomdatabase;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.govind.dhage.ekacareroomdatabase.databinding.ActivityMainBinding;
import com.govind.dhage.ekacareroomdatabase.model.MyInfo;
import com.govind.dhage.ekacareroomdatabase.repository.MyInfoRepository;
import com.govind.dhage.ekacareroomdatabase.viewmodel.MyInfoViewModel;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    MyInfoViewModel myInfoViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        MyInfoRepository repository = new MyInfoRepository(getApplication());
        MyInfoViewModel.MyInfoModelFactory myInfoModelFactory=new MyInfoViewModel.MyInfoModelFactory(repository);
        myInfoViewModel = new ViewModelProvider(MainActivity.this, myInfoModelFactory).get(MyInfoViewModel.class);


        mainBinding.edtDob.setOnClickListener(v->{showDatePickerDialogue();});

        mainBinding.btnSavaData.setOnClickListener(v -> {
            String name = mainBinding.edtName.getText().toString();
            String age = mainBinding.edtAge.getText().toString();
            String Dob = mainBinding.edtDob.getText().toString();
            String address = mainBinding.edtAddress.getText().toString();

            if (name.isEmpty()) {
                Toast.makeText(this, "Pls enter name", Toast.LENGTH_SHORT).show();
            } else if (age.isEmpty()) {
                Toast.makeText(this, "Pls enter age", Toast.LENGTH_SHORT).show();
            } else if (Dob.isEmpty()) {
                Toast.makeText(this, "Pls enter Dob", Toast.LENGTH_SHORT).show();
            } else if (address.isEmpty()) {
                Toast.makeText(this, "Pls enter address", Toast.LENGTH_SHORT).show();
            } else {
                // MyInfo myInfo = new MyInfo(Integer.parseInt(age),Integer.parseInt(Dob),address);
                MyInfo myInfo = new MyInfo(Integer.parseInt(age),Dob, name, address);
                myInfoViewModel.insert(myInfo);

                myInfoViewModel.getAllUsers().observe(this, new Observer<List<MyInfo>>() {
                    @Override
                    public void onChanged(List<MyInfo> myInfos) {
                        Toast.makeText(MainActivity.this, "New Data added", Toast.LENGTH_SHORT).show();
                    }

                });
            }
        });

    }
    public void showDatePickerDialogue(){
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthofyear, int dayofMonth) {
                mainBinding.edtDob.setText(dayofMonth + "/" + (monthofyear + 1) + "/" + year);
            }
        },year,month,date);
        datePickerDialog.show();
    }
}