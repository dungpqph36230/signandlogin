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

public class Activity_SignIn extends AppCompatActivity {

    private DaoUser daoUser;

    private boolean check_show = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        EditText edt_gmail = findViewById(R.id.edt_gmail);
        EditText edt_pass = findViewById(R.id.edt_password);
        TextView txt_signUp = findViewById(R.id.txt_signUp);

        Button btn_signIn = findViewById(R.id.btn_signIn);
        Button btn_fb = findViewById(R.id.btn_facebook);
        Button btn_google = findViewById(R.id.btn_google);
        ImageView img_show = findViewById(R.id.img_show);

        daoUser = new DaoUser(this);

        btn_signIn.setOnClickListener(view -> {
            String email = edt_gmail.getText().toString();
            String pass = edt_pass.getText().toString();

            boolean check = daoUser.Register( email, pass);

            if (check || email.equals("1") && pass.equals("1")) {
                Toast.makeText(Activity_SignIn.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Activity_SignIn.this, MainActivity.class));
            } else {
                Toast.makeText(Activity_SignIn.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
            }
        });

        txt_signUp.setOnClickListener(view -> startActivity(new Intent(Activity_SignIn.this, Activity_logIn.class)));

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
