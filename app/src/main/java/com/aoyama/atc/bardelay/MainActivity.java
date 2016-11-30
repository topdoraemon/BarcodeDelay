package com.aoyama.atc.bardelay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Explicit
    private Button signInButton;
    private EditText userEditText;
    private String userString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = (Button) findViewById(R.id.button);
        userEditText = (EditText) findViewById(R.id.editText);
        //ให้พิมพ์เป็นตัวใหญ่
        userEditText.setFilters(new InputFilter[]{
            new InputFilter.AllCaps()
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userString = userEditText.getText().toString().trim();

                if(userString.length()==0){
                    MyAlert myAlert = new MyAlert(MainActivity.this, R.drawable.s_warning, "User ID Emtry", "กรุณากรอก User ID");
                    myAlert.myDialog();
                }else{
                    startActivity(new Intent(MainActivity.this,MenuActivity.class));
                }

            }
        });
    }
}
