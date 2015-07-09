package com.example.progressbartest;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private ColorsBar colorsBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorsBar= (ColorsBar) findViewById(R.id.spring_progress_view);
        colorsBar.setOnClickListener(this);

        colorsBar.setBgColorBean(new ColorBean(Color.GRAY, 100));
        List<ColorBean> colorBeans = new ArrayList<>();
        colorBeans.add(new ColorBean(Color.GREEN, 21));
        colorBeans.add(new ColorBean(Color.BLUE, 41));
        colorBeans.add(new ColorBean(Color.RED, 11));
        colorsBar.setColorBeans(colorBeans);

        colorsBar.invalidate();
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

    @Override
    public void onClick(View v) {
        colorsBar.setBgColorBean(new ColorBean(Color.GRAY, 100));
        List<ColorBean> colorBeans = new ArrayList<>();
        colorBeans.add(new ColorBean(Color.GREEN, 21));
        colorBeans.add(new ColorBean(Color.BLUE, 41));
        colorBeans.add(new ColorBean(Color.RED, 11));
        colorsBar.setColorBeans(colorBeans);

        colorsBar.invalidate();
    }
}
