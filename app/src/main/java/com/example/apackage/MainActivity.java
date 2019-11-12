package com.example.apackage;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EdgeEffect;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edHeight;
    private EditText edWidth;
    private EditText edLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edLength = findViewById(R.id.length);
        edWidth = findViewById(R.id.width);
        edHeight = findViewById(R.id.height);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void reset(){
        edLength.setText("");
        edWidth.setText("");
        edHeight.setText("");
    }

    public void calculate (View view){

        DialogInterface.OnClickListener listner = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();
            }
        };

        float length = Float.parseFloat(edLength.getText().toString());
        float width = Float.parseFloat(edWidth.getText().toString());
        float height = Float.parseFloat(edHeight.getText().toString());
        float cm = length+width+height;
        
        if(cm<=60){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("價錢")
                    .setMessage("本島互寄(常溫)：130元\n本島互寄(低溫)：160元\n本島寄往離島(常溫)：220元\n本島寄往離島(低溫)：260元")
                    .setPositiveButton("OK",listner)
                    .show();
        }else if(cm>=61 && cm<=90){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("價錢")
                    .setMessage("本島互寄(常溫)：170元\n本島互寄(低溫)：225元\n本島寄往離島(常溫)：280元\n本島寄往離島(低溫)：340元")
                    .setPositiveButton("OK",listner)
                    .show();
        }else if(cm>=91 && cm<=120){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("價錢")
                    .setMessage("本島互寄(常溫)：210元\n本島互寄(低溫)：290元\n本島寄往離島(常溫)：320元\n本島寄往離島(低溫)：400元")
                    .setPositiveButton("OK",listner)
                    .show();
        }else if(cm>=121 && cm<=150){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("價錢")
                    .setMessage("本島互寄(常溫)：250元\n本島互寄(低溫)：-1\n本島寄往離島(常溫)：360元\n本島寄往離島(低溫)：-1")
                    .setPositiveButton("OK",listner)
                    .show();
        }
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
