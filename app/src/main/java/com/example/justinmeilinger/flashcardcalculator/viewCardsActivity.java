package com.example.justinmeilinger.flashcardcalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class viewCardsActivity extends ActionBarActivity {

    private Flashcard[] flashcards;
    private int sub = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cards);

        Button b = (Button) findViewById(R.id.nextButton);
        b.callOnClick();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_cards, menu);
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
    public void goEquations(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void goDeck(View v){
        Intent intent = new Intent(this, showCardsActivity.class);
        startActivity(intent);

    }
    public void flipAndSwitchCard(View v){
        TextView t = (TextView) findViewById(R.id.flashCard);
        t.setText("The answer is: " + flashcards[sub].getBack());

    }
    public void nextCard(View v){
        sub++;
        TextView t = (TextView) findViewById(R.id.flashCard);
        t.setText("" + flashcards[sub].getFront());
    }
}
