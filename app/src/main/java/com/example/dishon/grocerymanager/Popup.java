package com.example.dishon.grocerymanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Popup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_item);

        Button add_new_item = findViewById(R.id.food_submit);


        add_new_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.food_input);
                EditText quantity = findViewById(R.id.food_quantity_input);
                MainActivity.addNewItemToList(name.toString(),Integer.parseInt(quantity.toString()));
            }

        });

    }
}
