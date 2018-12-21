package com.example.dishon.grocerymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public FloatingActionButton fab;
    public static ArrayList<GroceryItem> grocery_array_list;
    public static CustomListAdapter grocery_adapter;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grocery_array_list = new ArrayList<>();

        fab = findViewById(R.id.fab);

        ListView grocery_list = findViewById(R.id.grocery_list);

        grocery_array_list.add(new GroceryItem("Potato",5));
        grocery_array_list.add(new GroceryItem("Lettuce",9));
        grocery_array_list.add(new GroceryItem("Tomato",100));
        grocery_array_list.add(new GroceryItem("Squash",4));
        grocery_array_list.add(new GroceryItem("Eggs",12));
        grocery_array_list.add(new GroceryItem("Potato",5));
        grocery_array_list.add(new GroceryItem("Lettuce",9));
        grocery_array_list.add(new GroceryItem("Tomato",100));
        grocery_array_list.add(new GroceryItem("Squash",4));
        grocery_array_list.add(new GroceryItem("Eggs",12));
        grocery_array_list.add(new GroceryItem("Potato",5));
        grocery_array_list.add(new GroceryItem("Lettuce",9));
        grocery_array_list.add(new GroceryItem("Tomato",100));
        grocery_array_list.add(new GroceryItem("Squash",4));
        grocery_array_list.add(new GroceryItem("Eggs",12));
        grocery_array_list.add(new GroceryItem("Potato",5));
        grocery_array_list.add(new GroceryItem("Lettuce",9));
        grocery_array_list.add(new GroceryItem("Tomato",100));
        grocery_array_list.add(new GroceryItem("Squash",4));
        grocery_array_list.add(new GroceryItem("Eggs",12));
        grocery_array_list.add(new GroceryItem("Potato",5));
        grocery_array_list.add(new GroceryItem("Lettuce",9));
        grocery_array_list.add(new GroceryItem("Tomato",100));
        grocery_array_list.add(new GroceryItem("Squash",4));
        grocery_array_list.add(new GroceryItem("Eggs",12));

        grocery_adapter = new CustomListAdapter(this,grocery_array_list);
        grocery_list.setAdapter(new CustomListAdapter(this,grocery_array_list));

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,Popup.class),1);
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == RESULT_OK){
            data.getExtras();
            grocery_array_list.add(
                    new GroceryItem(data.getStringExtra("NAME"),
                            data.getIntExtra("QUANTITY",1)));

            grocery_adapter.notifyDataSetChanged();
        }
    }

    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.add_item, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                fab.show();
                return true;
            }

        });

    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
