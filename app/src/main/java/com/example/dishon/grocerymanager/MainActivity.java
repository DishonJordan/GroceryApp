package com.example.dishon.grocerymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.AdapterView;
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
import android.widget.Toast;

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
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        grocery_array_list = new ArrayList<>();

        fab = findViewById(R.id.fab);

        final ListView grocery_list = findViewById(R.id.grocery_list);

        grocery_array_list.add(new GroceryItem("Potato", 5));
        grocery_array_list.add(new GroceryItem("Lettuce", 9));
        grocery_array_list.add(new GroceryItem("Tomato", 100));
        grocery_array_list.add(new GroceryItem("Squash", 4));
        grocery_array_list.add(new GroceryItem("Eggs", 12));

        grocery_adapter = new CustomListAdapter(this, grocery_array_list);
        grocery_list.setAdapter(new CustomListAdapter(this, grocery_array_list));

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, Popup.class), 1);
            }

        });

        grocery_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Please enter a valid name and quantity",
                        Toast.LENGTH_SHORT);

                toast.show();
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


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

}
