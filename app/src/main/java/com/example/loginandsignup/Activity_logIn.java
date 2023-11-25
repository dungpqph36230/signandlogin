package com.example.loginandsignup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_logIn extends AppCompatActivity {

    private boolean check_show = false;

    private DaoUser daoUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_activity);

        EditText edt_gmail = findViewById(R.id.edt_gmail);
        EditText edt_pass = findViewById(R.id.edt_password);
        EditText edt_er_enter_pass = findViewById(R.id.edt_re_enter_password);
        TextView txt_signIn = findViewById(R.id.txt_signIn);

        Button btn_logIn = findViewById(R.id.btn_getStarted);
        Button btn_fb = findViewById(R.id.btn_facebook);
        Button btn_google = findViewById(R.id.btn_google);
        ImageView img_show = findViewById(R.id.img_show);
        ImageView img_show2 = findViewById(R.id.img_show2);

        daoUser = new DaoUser(this);

        btn_logIn.setOnClickListener(view -> {
            String email = edt_gmail.getText().toString();
            String pass = edt_pass.getText().toString();
            String er_pass = edt_er_enter_pass.getText().toString();

            boolean check = daoUser.CheckLogin(email, pass, er_pass);

            if (check){
                Toast.makeText(Activity_logIn.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                finish();
            }else {
                Toast.makeText(Activity_logIn.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
            }
        });

        txt_signIn.setOnClickListener(view -> startActivity(new Intent(Activity_logIn.this, Activity_SignIn.class)));

        img_show.setOnClickListener(view -> {
            check_show = !check_show;
            if (check_show) {
                img_show.setImageResource(R.drawable.eye_hide);
                edt_pass.setInputType(InputType.TYPE_CLASS_TEXT);
            } else {
                img_show.setImageResource(R.drawable.baseline_remove_red_eye_24);
                edt_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });

        img_show2.setOnClickListener(view -> {
            check_show = !check_show;
            if (check_show) {
                img_show2.setImageResource(R.drawable.eye_hide);
                edt_er_enter_pass.setInputType(InputType.TYPE_CLASS_TEXT);
            } else {
                img_show2.setImageResource(R.drawable.baseline_remove_red_eye_24);
                edt_er_enter_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });

        btn_fb.setOnClickListener(v -> {
            String facebookUrl = "https://www.facebook.com";
            Uri uri = Uri.parse(facebookUrl);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        btn_google.setOnClickListener(v -> {
            String googleUrl = "https://www.google.com";
            Uri uri = Uri.parse(googleUrl);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

    }
}
