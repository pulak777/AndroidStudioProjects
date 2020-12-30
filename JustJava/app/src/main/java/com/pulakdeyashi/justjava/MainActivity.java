package com.pulakdeyashi.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private Integer quantity = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void increment(View view){
        if(quantity < 100)
            quantity++;
        else
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
        display(quantity);
    }
    public void decrement(View view){
        if(quantity > 1)
            quantity--;
        else
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
        display(quantity);
    }

    public void submitOrder(View view) {
        createOrderSummery(calculatePrice(5));
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void createOrderSummery(int number) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.checked_whipped_cream);
        Boolean whippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCreamCheckBox = (CheckBox) findViewById(R.id.checked_chocolate_cream);
        Boolean chocolateCream = chocolateCreamCheckBox.isChecked();
        EditText buyerName = (EditText) findViewById(R.id.buyer_name);
        String buyer = buyerName.getText().toString();
        String orderSummery = "Name: "
                + buyer
                + "\n"
                + "Add whipped cream? "
                + whippedCream.toString()
                + "\nAdd chocolate cream? "
                + chocolateCream.toString()
                + "\nQuantity: "
                + quantity
                + "\n"
                + "Total "
                + NumberFormat.getCurrencyInstance().format(number)
                + "\nThank you!";
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "odzzod01@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JustJava order for " + buyer);
        emailIntent.putExtra(Intent.EXTRA_TEXT, orderSummery);
        startActivity(Intent.createChooser(emailIntent, "send email..."));
    }
    private int calculatePrice(int priceOfOneCup) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.checked_whipped_cream);
        if(whippedCreamCheckBox.isChecked())
            priceOfOneCup += 1;
        CheckBox chocolateCreamCheckBox = (CheckBox) findViewById(R.id.checked_chocolate_cream);
        if(chocolateCreamCheckBox.isChecked())
            priceOfOneCup += 2;
        return quantity * priceOfOneCup;
    }
}