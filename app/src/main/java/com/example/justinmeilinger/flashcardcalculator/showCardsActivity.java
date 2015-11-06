package com.example.justinmeilinger.flashcardcalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class showCardsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cards);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_cards, menu);
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

    public void showAllCards(View view) {
        Intent i = new Intent(this, viewCardsActivity.class);
        i.putExtra("type", "all flashcards");
        startActivity(i);
    }

    public void regCards(View v){
        Intent i = new Intent(this, viewCardsActivity.class);
        i.putExtra("type", "reg flashcards");
        startActivity(i);
    }
    public void goEquations(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
