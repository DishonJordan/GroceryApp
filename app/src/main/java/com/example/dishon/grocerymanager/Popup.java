package com.example.dishon.grocerymanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Popup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_item);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width* 0.9) ,(int)(height * 0.4));


        Button add_new_item = findViewById(R.id.food_submit);
        add_new_item.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText name_text = findViewById(R.id.food_input);
                EditText quantity_text = findViewById(R.id.food_quantity_input);

                if(name_text.getText().toString().isEmpty() || quantity_text.getText().toString().isEmpty()) {

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Please enter a valid name and quantity",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }else{
                    String name = name_text.getText().toString();
                    int quantity = Integer.parseInt(quantity_text.getText().toString());

                    Bundle resulting_item = new Bundle();
                    resulting_item.putString("NAME", name);
                    resulting_item.putInt("QUANTITY", quantity);

                    Intent intent = new Intent(Popup.this, MainActivity.class);
                    intent.putExtras(resulting_item);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }

        });

    }
}
