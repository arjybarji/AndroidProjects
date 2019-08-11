/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.arjun.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    int price;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        price = 4;
        number = 0;
    }

    public void increaseQuantity(View view) {
        if(number == 100){
            number = 100;
            Toast.makeText(getApplicationContext(),"MAX 100 Coffees",Toast.LENGTH_LONG).show();
        }else{
            number = number+1;
        }
        display(number);
    }

    public void decreaseQuantity(View view) {
        if (number == 0) {
            number = 0;
            Toast.makeText(getApplicationContext(),"Min 0 Coffees",Toast.LENGTH_LONG).show();
        } else {
            number = number - 1;

        }
        display(number);
    }

    public boolean getWhippedState(){
        CheckBox box = findViewById(R.id.whippedCheckbox);
        return box.isChecked();
    }

    public boolean getChocolateState(){
        CheckBox box = findViewById(R.id.chocolateCheckbox);
        return box.isChecked();
    }

    public String getName(){
        EditText name =  findViewById(R.id.name);
        return name.getText().toString();
    }

    public String createOrderSummary(){
        return "Name: " + getName() +  "\n" +
                "Add whipped cream? " + getWhippedState() + "\n" +
                "Add chocolate? " + getChocolateState() + "\n" +
                "Quantity: " + number + "\n" +
                "Total: £" + totalPrice() + "\n" +
                "Thank you!";
    }

    public int totalPrice(){
        int chocoPrice;
        int creamPrice;
        int coffeePrice = number * price;
        if(getWhippedState()){
            creamPrice = number *1;
        }else{
            creamPrice = 0;
        }
        if(getChocolateState()){
            chocoPrice = number *2;
        }else{
            chocoPrice = 0;
        }

        return chocoPrice + creamPrice + coffeePrice;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //displayMessage(createOrderSummary());
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + getName());
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantityValue);
        quantityTextView.setText("" + number);

    }




}