package app.ewtc.masterung.demoshowtext;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private boolean aBoolean = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Start Controller
        startController();

        //Stop Controller
        stopController();


    }   // Main Method

    private void stopController() {
        Button button = (Button) findViewById(R.id.btnStop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aBoolean = false;
            }
        });
    }

    private void startController() {
        Button button = (Button) findViewById(R.id.btnStart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aBoolean = true;
                myLoop();

            }
        });
    }

    private void myLoop() {

        String tag = "3octV1";
        String tag2 = "3octV2";
        String urlJSON = "http://androidthai.in.th/3oct/getAllDataMaster.php";

        //Todo
        try {

            Log.d(tag, "Loop Work");
            MySynChronize mySynChronize = new MySynChronize(MainActivity.this);
            mySynChronize.execute(urlJSON);
            String strJSON = mySynChronize.get();
            Log.d(tag2, "JSON ==> " + strJSON);

        } catch (Exception e) {
            Log.d(tag2, "e myLoop ==> " + e.toString());
        }




        //Delay
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (aBoolean) {
                    myLoop();
                }
            }
        }, 1000);


    }   // myLoop

}   // Main Class
