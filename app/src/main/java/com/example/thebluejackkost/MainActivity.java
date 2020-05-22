package com.example.thebluejackkost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etUsername = findViewById(R.id.etUsername);
        final EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnTempLogin = findViewById(R.id.btnMasuk);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText()+"";
                String password = etPassword.getText()+"";
                if(username.equals("")){
                    Toast.makeText(MainActivity.this, "Input username", Toast.LENGTH_LONG).show();
                    return;
                }
                if(password.equals("")){
                    Toast.makeText(MainActivity.this, "Input password", Toast.LENGTH_LONG).show();
                    return;
                }
//                if(UserDB.users.size() == 0){
//                    Toast.makeText(MainActivity.this, "Please register yourself first", Toast.LENGTH_LONG).show();
//                    return;
//                }
//                for (int i = 0; i < UserDB.users.size(); i++) {
//                    if(username.equals(UserDB.users.get(i).getUsername()) && password.equals(UserDB.users.get(i).getPassword())){
//                        Intent toKostList = new Intent(MainActivity.this, KostList.class);
//                        String userId = UserDB.users.get(i).getId();
//                        toKostList.putExtra("userData", userId);
//                        startActivity(toKostList);
//                        finish();
//                        return;
//                    }
//                }
                Toast.makeText(MainActivity.this, "Username/password not registered", Toast.LENGTH_LONG).show();
                return;
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterUser.class);
                startActivity(intent);
                finish();
            }
        });
        btnTempLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noLoginToKostList = new Intent(MainActivity.this, KostList.class);
                startActivity(noLoginToKostList);
            }
        });
    }

}
