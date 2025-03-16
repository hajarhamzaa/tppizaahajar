package com.example.tppizza;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.tppizza.classes.Produit;

public class PizzaDetailActivity extends AppCompatActivity {
    private Produit selectedPizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        // Setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pizza recipes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enable back button


        selectedPizza = (Produit) getIntent().getSerializableExtra("pizza");

        ((ImageView) findViewById(R.id.pizzaImage)).setImageResource(selectedPizza.getImage());
        ((TextView) findViewById(R.id.pizzaName)).setText(selectedPizza.getName());
        ((TextView) findViewById(R.id.pizzaTime)).setText("Time: " + selectedPizza.getTime());
        ((TextView) findViewById(R.id.pizzaIngredients)).setText("Ingredients:\n" + selectedPizza.getIngredients());
        ((TextView) findViewById(R.id.pizzaDescription)).setText("Description:\n" + selectedPizza.getDescription());
        ((TextView) findViewById(R.id.pizzaSteps)).setText("Steps:\n" + selectedPizza.getSteps());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_share) {
            shareOnWhatsApp();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareOnWhatsApp() {
        String message = "Try this pizza recipe! 🍕\n" + selectedPizza.getName() + "\n" + selectedPizza.getIngredients();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setPackage("com.whatsapp"); // Ensures WhatsApp is used
        startActivity(intent);
    }
}

