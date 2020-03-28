package com.example.mycontactbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    ArrayList<ClassContact> contactsList;
    public EditText name,number_account,type_account,balance;
    public Button save;
    public RadioGroup selected;
    public RadioButton rbAS,rbCA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        name = (EditText) findViewById(R.id.editText_name);
        number_account = (EditText) findViewById(R.id.editText_account_number);
        balance = (EditText) findViewById(R.id.editText_balance);
        selected = (RadioGroup) findViewById(R.id.account_type);
        rbAS = (RadioButton) findViewById(R.id.savings_account);
        rbCA = (RadioButton) findViewById(R.id.current_account);


        save = (Button) findViewById(R.id.button_add_account);
        save.setOnClickListener(this);


        Intent intent = getIntent();
        ArrayList<ClassContact> arrayParents = intent.getParcelableArrayListExtra("Person");

        if(arrayParents != null && arrayParents.size() > 0) {
            contactsList = arrayParents;
        }else {
            contactsList = new ArrayList<ClassContact>();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add_account:
                save();
                break;
        }
    }

    public String Type(RadioButton rbAS, RadioButton rbCA){
        String data="";
        if(rbAS.isChecked()){
            data = "savings account";
        }
        if(rbCA.isChecked()){
            data = "current account";
        }
        return data;
    }

    public boolean check(RadioButton rbAS, RadioButton rbCA){
        boolean data =false;
        if(rbAS.isChecked()){
            data = true;
        }
        if(rbCA.isChecked()){
            data = true;
        }
        return data;
    }


    private void save() {
        if(!name.getText().toString().trim().isEmpty() && !number_account.getText().toString().trim().isEmpty() &&check(rbAS,rbCA) && !balance.getText().toString().trim().isEmpty()){
            ClassContact newAccount;

            String Name = name.getText().toString().trim();
            String numberA = number_account.getText().toString().trim();
            String Balance = balance.getText().toString().trim();

            newAccount = new ClassContact(Name, numberA, Type(rbAS,rbCA),Balance);
            contactsList.add(newAccount);

            Intent intent = new Intent(this,View_List.class);
            intent.putParcelableArrayListExtra("Person",contactsList);
            startActivity(intent);
            Log.e("check","SIRVE" + Type(rbAS,rbCA));
            Log.e("Informacion","Sirve" + contactsList);

            Toast.makeText(getApplicationContext(), "Success, Added Account", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"All Field are required", Toast.LENGTH_LONG).show();
        }

    }
}
