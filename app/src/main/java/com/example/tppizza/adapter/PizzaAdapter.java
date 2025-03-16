package com.example.tppizza.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.widget.ArrayAdapter;

import com.example.tppizza.R;
import com.example.tppizza.classes.Produit;

import java.util.List;

public class PizzaAdapter extends ArrayAdapter<Produit> {
    public PizzaAdapter(Context context, List<Produit> pizzas) {
        super(context, 0, pizzas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pizza, parent, false);
        }

        Produit pizza = getItem(position);

        // Find views
        ImageView pizzaImage = convertView.findViewById(R.id.pizzaImage);
        TextView pizzaName = convertView.findViewById(R.id.pizzaName);
        TextView pizzaRating = convertView.findViewById(R.id.pizzaRating);
        TextView pizzaTime = convertView.findViewById(R.id.pizzaTime);
        ImageView bookmarkIcon = convertView.findViewById(R.id.bookmarkIcon);

        // Set data
        pizzaImage.setImageResource(pizza.getImage());
        pizzaName.setText(pizza.getName());
        pizzaRating.setText(String.valueOf(pizza.getRating()));
        pizzaTime.setText(pizza.getTime());

        return convertView;
    }
}
