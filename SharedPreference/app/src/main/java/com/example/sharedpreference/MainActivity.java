package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_name,et_roll,et_email,et_phone,et_password;
    RadioButton r_male,r_female;
    String gender;
    CheckBox ch_c,ch_android,ch_python;
    Spinner sp_branches;
    Spinner sp_year;

    String name;
    String roll;
    String email;
    String phone;
    String password;
    String branch;

    Button saveButton;

    SharedPreferences sp;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.name);
        et_roll=findViewById(R.id.roll);
        et_email=findViewById(R.id.email);
        et_phone=findViewById(R.id.phone);
        et_password=findViewById(R.id.password);
        r_male=findViewById(R.id.male);
        r_female=findViewById(R.id.female);
        ch_c=findViewById(R.id.c);
        ch_android=findViewById(R.id.android);
        ch_python=findViewById(R.id.python);
        sp_branches=findViewById(R.id.branch);
        sp_year=findViewById(R.id.year);
        sp=getSharedPreferences("ap",MODE_PRIVATE);
    }

    public void SaveData(View view) {
        name=et_name.getText().toString();
        roll=et_roll.getText().toString();
        email=et_email.getText().toString();
        phone=et_phone.getText().toString();
        password=et_password.getText().toString();

        if (r_male.isChecked())
        {
            gender=r_male.getText().toString();
        }
        else if (r_female.isChecked())
        {
            gender=r_female.getText().toString();
        }

        /*StringBuilder builder=new StringBuilder();
        if (ch_c.isChecked())
        {
            builder.append(ch_c.getText().toString());
        }
        if (ch_android.isChecked())
        {
            builder.append(ch_android.getText().toString());
        }
        if (ch_python.isChecked())
        {
            builder.append(ch_python.getText().toString());
        }
        branch=sp_branches.getSelectedItem().toString();*/



        editor=sp.edit();
        editor.putString("nam",name);
        editor.putString("mail",email);
        editor.putString("rono", roll);
        editor.putString("pho",phone);
        editor.putString("pass",password);
        editor.putString("gen",gender);
        //editor.putString("bran",branch);
        editor.apply();
        Toast.makeText(this, ""+name+"\n"+password, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        editor=sp.edit();
        editor.putString("nam",name);
        editor.putString("mail",email);
        editor.putString("pho",phone);
        editor.putString("rono", roll);
        editor.putString("pass",password);
        editor.putString("gen", gender);
        //editor.putString("bran", branch);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String res_name=sp.getString("nam","");
        String res_mail=sp.getString("mail","");
        String res_phone=sp.getString("pho","");
        String res_roll=sp.getString("rono","");
        String res_pass=sp.getString("pass","");
        String res_gen=sp.getString("gen","");
        //String res_bran=sp.getString("bran","");
        et_name.setText(res_name);
        et_email.setText(res_mail);
        et_phone.setText(res_phone);
        et_roll.setText(res_roll);
        et_password.setText(res_pass);

    }
}