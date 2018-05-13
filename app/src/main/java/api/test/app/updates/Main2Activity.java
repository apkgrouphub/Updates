package api.test.app.updates;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class Main2Activity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button;
    //public static String file="new file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText=findViewById(R.id.editText_content);
        textView=findViewById(R.id.textView_content);
        textView.setVisibility(View.GONE);

    }
    public void save (View view) throws FileNotFoundException {

        File file=new File("D\\new.txt",editText.getText().toString());
        String text=editText.getText().toString();

        FileOutputStream outputStream=null;

        try{
            outputStream=openFileOutput("D\\new.txt",Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
            outputStream.close();
            Toast.makeText(this,"Saved to"+getFilesDir()+"/"+file,Toast.LENGTH_LONG).show();
            editText.setText("");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (outputStream != null) {
                try {outputStream.close();
                }
                catch (IOException e)
                {
                e.printStackTrace();
                }
            }
        }
    }
    public void view(View view) throws FileNotFoundException {
        FileInputStream inputStream = openFileInput("D\\new.txt");
        try {
            String text;
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            StringBuffer stringBuffer = new StringBuffer();

            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text + "\n");
            }

            textView.setText(stringBuffer.toString());
            textView.setVisibility(View.VISIBLE);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
