package cn.smartsean.mvptest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final String PARAM_USERNAME = "username";

    public static void startAction(Context context, String username) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(PARAM_USERNAME, username);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String username = getIntent().getStringExtra(PARAM_USERNAME);
        Toast.makeText(this, "欢迎您" + username, Toast.LENGTH_SHORT).show();
    }
}
