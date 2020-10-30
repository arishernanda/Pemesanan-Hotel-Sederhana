package id.activity.cobatubes1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText namap,passp;
    Button tombolKirim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namap = (EditText) findViewById(R.id.username);
        passp = (EditText) findViewById(R.id.password);
        tombolKirim = (Button) findViewById(R.id.buttonSend);

        tombolKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameKey = namap.getText().toString();
                String passwordKey = passp.getText().toString();

                if (usernameKey.equals("arishernanda") && passwordKey.equals("aris12")){
                    Toast.makeText(getApplicationContext(), "Login Berhasil",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Username atau Password salah!")
                            .setNegativeButton("Retry", null).create().show();
                }
            }

        });

    }
}