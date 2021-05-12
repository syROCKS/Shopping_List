package com.example.shoppinglist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView[] textView = new TextView[10];
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView[0] = findViewById(R.id.item1);
        textView[1] = findViewById(R.id.item2);
        textView[2] = findViewById(R.id.item3);
        textView[3] = findViewById(R.id.item4);
        textView[4] = findViewById(R.id.item5);
        textView[5] = findViewById(R.id.item6);
        textView[6] = findViewById(R.id.item7);
        textView[7] = findViewById(R.id.item8);
        textView[8] = findViewById(R.id.item9);
        textView[9] = findViewById(R.id.item10);
        if(savedInstanceState!=null) {
            textView[0].setText(savedInstanceState.getString("item1"));
            textView[1].setText(savedInstanceState.getString("item2"));
            textView[2].setText(savedInstanceState.getString("item3"));
            textView[3].setText(savedInstanceState.getString("item4"));
            textView[4].setText(savedInstanceState.getString("item5"));
            textView[5].setText(savedInstanceState.getString("item6"));
            textView[6].setText(savedInstanceState.getString("item7"));
            textView[7].setText(savedInstanceState.getString("item8"));
            textView[8].setText(savedInstanceState.getString("item9"));
            textView[9].setText(savedInstanceState.getString("item10"));
            count = savedInstanceState.getInt("count");
        }
    }

    public void listItem(View view) {
        Intent listItem = new Intent(this, addingItem.class);
        startActivityForResult(listItem, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra(addingItem.EXTRA_ITEM);
                textView[count].setText(item);
                count++;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
            outState.putString("item1", textView[0].getText().toString());
            outState.putString("item2", textView[1].getText().toString());
            outState.putString("item3", textView[2].getText().toString());
            outState.putString("item4", textView[3].getText().toString());
            outState.putString("item5", textView[4].getText().toString());
            outState.putString("item6", textView[5].getText().toString());
            outState.putString("item7", textView[6].getText().toString());
            outState.putString("item8", textView[7].getText().toString());
            outState.putString("item9", textView[8].getText().toString());
            outState.putString("item10", textView[9].getText().toString());
            outState.putInt("count",count);
    }
}