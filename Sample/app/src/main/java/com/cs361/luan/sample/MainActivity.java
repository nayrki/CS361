package com.cs361.luan.sample;

import android.os.*;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        final EditText username = (EditText) findViewById(R.id.register_username_text);
        final EditText password = (EditText) findViewById(R.id.register_password_text);
        final EditText confirm = (EditText) findViewById(R.id.register_confirm_text);
        final EditText email = (EditText) findViewById(R.id.register_email_text);
        final EditText phone = (EditText) findViewById(R.id.register_phone_text);

        Button registerSubmitButton = (Button) findViewById(R.id.regster_submit_button);
        registerSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().equals(confirm.getText().toString())) {
                    System.out.println("Username: " + username.getText());
                    System.out.println("Password: " + password.getText());
                    System.out.println("Email: " + email.getText());
                    System.out.println("Phone: " + phone.getText());
                }
            }
        });
    }

    private void triggerLoginView() {
        setContentView(R.layout.login_view);

        final EditText username = (EditText) findViewById(R.id.login_username_text);
        final EditText password = (EditText) findViewById(R.id.login_password_text);

        Button loginSubmitButton = (Button) findViewById(R.id.login_login_button);
        loginSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSucc = DatabaseFunctions.login(username.getText().toString(), password.getText().toString());
                System.out.println(isSucc);
            }
        });

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
