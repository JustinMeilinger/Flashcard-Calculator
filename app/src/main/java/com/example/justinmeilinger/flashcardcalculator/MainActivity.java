package com.example.justinmeilinger.flashcardcalculator;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private static Deck deck = new Deck();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void sendInfo(View v){
        RegularEquations reg = new RegularEquations();

        EditText e = (EditText) findViewById(R.id.inputEquationEditText);
        TextView out = (TextView) findViewById(R.id.outputTextView);

       try{
           out.setTextColor(Color.BLACK);
           out.setText("" + reg.solveProblem(e.getText().toString(), deck));
       }catch(NullPointerException error){
           out.setTextColor(Color.RED);
           out.setText("Incorrect input please try again, please enter all negatives inside parenthesis");
       }catch (NumberFormatException error){
           out.setTextColor(Color.RED);
           out.setText("Incorrect input. Found character that is not a number or a function sign." +
                   " Please Note: negatives should be (-3) and signs are: + - * /");
       }

    }

    public void goDeck(View v){
        Intent intent = new Intent(this, showCardsActivity.class);
        Object o = deck;
        intent.putExtra("Deck", (Bundle) o);
        startActivity(intent);
    }
}
