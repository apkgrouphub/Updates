package api.test.app.updates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editUsrname,editPasswrd,editContent;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsrname=findViewById(R.id.editText_usrname);
        editPasswrd=findViewById(R.id.editText_passwrd);
        btnLogin=findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(editUsrname.getText().toString(),editPasswrd.getText().toString());
            }
        });
    }

    public void login(String usrname,String passwrd){

        if((usrname.equals("maher"))&&(passwrd.equals("pass"))){
            Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Connection Error",Toast.LENGTH_LONG).show();
        }
    }
}
