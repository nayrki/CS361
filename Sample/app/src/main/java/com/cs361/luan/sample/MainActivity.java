package com.cs361.luan.sample;

import android.os.*;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        triggerActivityView();
    }

    private void triggerActivityView() {
        setContentView(R.layout.activity_main);

        Button mainRegisterButton = (Button) findViewById(R.id.main_register_button);
        mainRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerRegisterView();
            }
        });

        Button mainLoginButton = (Button) findViewById(R.id.main_login_button);
        mainLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerLoginView();
            }
        });
    }

    private void triggerRegisterView() {
        setContentView(R.layout.register_view);

        Button registerHomeButton = (Button) findViewById(R.id.register_home_button);
        registerHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerActivityView();
            }
        });
    }

    private void triggerLoginView() {
        setContentView(R.layout.login_view);

        Button loginQuitButton = (Button) findViewById(R.id.login_quit_button);
        loginQuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Process.killProcess(Process.myPid());
                System.exit(0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
