package com.example.coolweatherme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(this);
//        if(prefs.getString("weather",null)!=null){
//            Intent intent=new Intent(this,WeatherActivity.class);
//            startActivity(intent);
//            finish();
//        }

//        ChooseAreaFragment fragment=new ChooseAreaFragment();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fl_choose_area, fragment).commit();
    }
}
