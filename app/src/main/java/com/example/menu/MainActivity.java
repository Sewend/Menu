package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        if(menu.getClass().getSimpleName()
                .equals("MenuBuilder")){
            try{
                Method m = menu.getClass()
                        .getDeclaredMethod (
                                "setOptionalIconsVisible",
                                Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(menu, true);
            }
            catch(NoSuchMethodException e){
                System.err.println("onCreateOptionsMenu");
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public void onHelpClick(MenuItem item)
    {
        Toast.makeText(getApplicationContext(),
                "Help clicked", Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        String msg = "";
        int itemId = item.getItemId();
        if (itemId == R.id.CART) {
            msg = "Cart clicked";
        } else if (itemId == R.id.callPhone) {
            msg = "Call clicked";
        } else if (itemId == R.id.card) {
            item.setChecked(true);
            msg = "Camera clicked";
        } else if (itemId == R.id.video) {
            item.setChecked(true);
            msg = "Video clicked";
        } else if (itemId == R.id.EMAIL) {
            msg = "Email clicked";
        } else if (itemId == R.id.ADD) {
            msg = "Add clicked";
        } else if (itemId == R.id.COPY) {
            msg = "Copy clicked";
        } else if (itemId == R.id.PASTE) {
            msg = "Paste clicked";
        } else {
            super.onOptionsItemSelected(item);
        }
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        return true;
    }
}