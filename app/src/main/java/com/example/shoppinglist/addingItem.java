package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addingItem extends AppCompatActivity {
    public static final String EXTRA_ITEM = "com.example.shoppinglist.extra.ITEM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_item);
    }

    public void addItem(View view) {
        Intent addItem = new Intent(this, MainActivity.class);
        String item = ((Button) view).getText().toString();
        addItem.putExtra(EXTRA_ITEM,item);
        setResult(RESULT_OK,addItem);
        finish();
    }
}