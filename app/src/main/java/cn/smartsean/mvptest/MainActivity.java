package cn.smartsean.mvptest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.smartsean.mvptest.login.LoginActivity;
import cn.smartsean.mvptest.login1.Login1Activity;

public class MainActivity extends AppCompatActivity {


    public static final String PARAM_USERNAME = "username";
    Button mButton;
    Button mButton1;
    TextView mShow;

    public static void startAction(Context context, String username) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(PARAM_USERNAME, username);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mButton1 = findViewById(R.id.button1);
        mShow = findViewById(R.id.show);
        String username = getIntent().getStringExtra(PARAM_USERNAME);
        if (!TextUtils.isEmpty(username)) {
            Toast.makeText(this, "欢迎您" + username, Toast.LENGTH_SHORT).show();
        }
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Login1Activity.class));
            }
        });
    }
}
