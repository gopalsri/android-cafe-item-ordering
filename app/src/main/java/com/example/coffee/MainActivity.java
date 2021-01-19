package com.example.coffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int totalprice=0;


    OrderItem icecream = new OrderItem(0, 100, "ice cream", 50);
    OrderItem chocolate = new OrderItem(0, 50, "chocolate", 100);
    OrderItem coffee = new OrderItem(0,50,"coffee",10);
    OrderItem selectedItem;

    public void changeSelectedItem(View view) {
        String itemName = view.getTag().toString();
        if (itemName.equals("iceCream")) {
            this.selectedItem = this.icecream;
        } else if (itemName.equals("coffee")) {
            this.selectedItem = this.coffee;
        } else {
            this.selectedItem = this.chocolate;
        }
        display(this.selectedItem.quantity);
        displayPrice(this.selectedItem.quantity*this.selectedItem.price);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void increment(View view) {
        selectedItem.quantity = selectedItem.quantity+1;
        display(selectedItem.quantity);
        displayPrice(selectedItem.quantity*selectedItem.price);
        totalprice=totalprice+this.selectedItem.price;
        displayTotalPrice(totalprice);
    }

    public void decrement(View view) {
        selectedItem.quantity=selectedItem.quantity-1;
        display(selectedItem.quantity);
        displayPrice(selectedItem.quantity*selectedItem.price);
        totalprice=totalprice-this.selectedItem.price;
        displayTotalPrice(totalprice);

    }

    public void submitOrder(View view) {
        display(selectedItem.quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.Quantity_textView);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView PriceTextView = (TextView) findViewById(
                R.id.Price_textView);
        PriceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayTotalPrice(int number) {
        TextView totalTextView = (TextView) findViewById(
                R.id.totalprice);
        totalTextView.setText("" + number);
    }
}

class OrderItem {
    int quantity = 0;
    int weight = 0;
    String name = "";
    int price = 0;
    OrderItem(int qty, int weight, String name, int price) {
        this.quantity = qty;
        this.weight = weight;
        this.name = name;
        this.price = price;
    }
}