package com.example.tazhe.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tazhe.R;
import com.example.tazhe.beans.UserInfo;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.UserModel;
import com.example.tazhe.utils.MD5;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements RetrofitListener<UserInfo> {
    private EditText etname,etpass;
    private Button btnlogin,btnreg;
    private Switch sw;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        readLogin();
    }

    public void configLoginInfo(boolean checked) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("checked", sw.isChecked());
        if (checked) {
            editor.putString("username", etname.getText().toString());
            editor.putString("userpass", etpass.getText().toString());
        } else {
            editor.remove("username").remove("userpass");
        }
        editor.commit();
    }

    public Map<String, Object> readLogin() {
        Map<String, Object> m = new HashMap<>();
        String username = sp.getString("username", "");
        String password = sp.getString("userpass", "");
        m.put("username", username);
        m.put("userpass", password);
        return m;
    }

    private void initViews() {
        etname=findViewById(R.id.etname);
        etpass=findViewById(R.id.etpass);
        btnlogin=findViewById(R.id.btnlogin);
        btnreg=findViewById(R.id.btnreg);
        sw=findViewById(R.id.switch1);
        sp = getSharedPreferences("login", MODE_PRIVATE);

        boolean checked = sp.getBoolean("checked", false);
        if (checked) {
            Map<String, Object> m = readLogin();
            if (m != null) {
                etname.setText((CharSequence) m.get("username"));
                etpass.setText((CharSequence) m.get("userpass"));
                sw.setChecked(checked);
            }
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etname.getText().toString().trim().equals("")||etpass.getText().toString().trim().equals("")){
                    Toast.makeText(LoginActivity.this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    configLoginInfo(sw.isChecked());
                    String md5password = MD5.md5(etpass.getText().toString());
                    UserModel userModel = new UserModel();
                    userModel.userLogin(etname.getText().toString().trim(), md5password, LoginActivity.this);
                }
            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onSuccess(UserInfo user, int flag) {
        //System.out.print(user);
        if (user!=null&&user.getData().getUser_id().equals("0")) {
            Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFail() {
        Toast.makeText(LoginActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
    }

}
