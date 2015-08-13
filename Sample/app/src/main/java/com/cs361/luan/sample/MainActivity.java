package com.cs361.luan.sample;

import android.os.*;
import android.os.Process;
import android.provider.ContactsContract;
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
                    boolean isSucc = DatabaseFunctions.create(username.getText().toString(), password.getText().toString(), null, email.getText().toString());
                    System.out.println((isSucc) ? "Success to Register" : "Fail to Register");
                } else
                    System.out.println("Both input passwords are not the same, and please enter again.");
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
                System.out.println((isSucc) ? "Success to Login" : "Fail to Login.");
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
