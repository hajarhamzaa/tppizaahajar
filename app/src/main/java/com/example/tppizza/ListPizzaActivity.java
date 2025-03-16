package com.example.tppizza;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.tppizza.adapter.PizzaAdapter;
import com.example.tppizza.classes.Produit;
import com.example.tppizza.service.ProduitService;
import java.util.List;

public class ListPizzaActivity extends AppCompatActivity {
    private ListView listView;
    private ProduitService ps = new ProduitService();
    private List<Produit> pizzaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pizza Recipes");

        listView = findViewById(R.id.liste);

        // Adding pizzas to the list
        populatePizzaList();

        PizzaAdapter adapter = new PizzaAdapter(this, pizzaList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(ListPizzaActivity.this, PizzaDetailActivity.class);
            intent.putExtra("pizza", pizzaList.get(i));
            startActivity(intent);
        });
    }

    private void populatePizzaList() {
        pizzaList = ps.findAll();

        ps.create(new Produit("FOUR CHEESE PIZZA", 4, R.mipmap.pizza1, "30 min",
                "- 1 prebaked pizza crust\n- 1/2 cup tomato sauce\n- 1/2 cup shredded mozzarella\n- 1/2 cup shredded cheddar\n- 1/2 cup crumbled feta\n- 1/2 cup grated Parmesan\n- 1/2 teaspoon oregano",
                "A cheese lover's dream, this four-cheese pizza is gooey, flavorful, and easy to make.",
                "STEP 1:\nPreheat oven to 450°F. Spread tomato sauce over crust.\n\nSTEP 2:\nSprinkle all cheeses evenly over the sauce.\n\nSTEP 3:\nBake for 12-15 minutes or until cheese is bubbly and golden.\n\nSTEP 4:\nSprinkle oregano on top before serving."));

        ps.create(new Produit("HAWAIIAN PIZZA", 3, R.mipmap.pizza2, "25 min",
                "- 1 pizza dough\n- 1/2 cup pizza sauce\n- 1 cup shredded mozzarella\n- 1/2 cup cooked ham, chopped\n- 1/2 cup pineapple chunks\n- 1 teaspoon dried basil",
                "A delicious mix of sweet and savory, Hawaiian pizza combines juicy pineapple with ham.",
                "STEP 1:\nRoll out pizza dough and spread pizza sauce.\n\nSTEP 2:\nSprinkle mozzarella, then add ham and pineapple.\n\nSTEP 3:\nBake at 425°F for 15 minutes until golden brown.\n\nSTEP 4:\nSprinkle dried basil before serving."));

        ps.create(new Produit("MEDITERRANEAN VEGGIE PIZZA", 5, R.mipmap.pizza3, "35 min",
                "- 1 pizza crust\n- 1/2 cup tomato sauce\n- 1/2 cup black olives, sliced\n- 1/2 cup cherry tomatoes, halved\n- 1/2 cup spinach leaves\n- 1/2 cup crumbled feta cheese\n- 1 teaspoon dried oregano",
                "A healthy and fresh pizza loaded with Mediterranean flavors.",
                "STEP 1:\nPreheat oven to 400°F. Spread tomato sauce over crust.\n\nSTEP 2:\nLayer olives, cherry tomatoes, spinach, and feta.\n\nSTEP 3:\nBake for 15-18 minutes until crust is crispy.\n\nSTEP 4:\nSprinkle oregano and serve."));

        ps.create(new Produit("BBQ BEEF PIZZA", 4, R.mipmap.pizza4, "40 min",
                "- 1 pizza dough\n- 1/2 cup barbecue sauce\n- 1 cup cooked shredded beef\n- 1/2 cup red onion, sliced\n- 1/2 cup shredded gouda cheese\n- 1/2 teaspoon black pepper",
                "A smoky, savory pizza perfect for BBQ lovers.",
                "STEP 1:\nRoll out pizza dough and spread barbecue sauce.\n\nSTEP 2:\nTop with shredded beef, red onion, and gouda.\n\nSTEP 3:\nBake at 425°F for 18 minutes until cheese is melted.\n\nSTEP 4:\nSprinkle black pepper before serving."));

        ps.create(new Produit("PESTO MARGHERITA PIZZA", 5, R.mipmap.pizza5, "30 min",
                "- 1 pizza crust\n- 1/3 cup pesto sauce\n- 1 cup fresh mozzarella slices\n- 1/2 cup cherry tomatoes, halved\n- 1/4 cup fresh basil leaves",
                "A fresh twist on the classic Margherita pizza with rich pesto flavor.",
                "STEP 1:\nPreheat oven to 425°F. Spread pesto sauce over crust.\n\nSTEP 2:\nLayer mozzarella and cherry tomatoes.\n\nSTEP 3:\nBake for 12-15 minutes until cheese melts.\n\nSTEP 4:\nTop with fresh basil before serving."));

        ps.create(new Produit("SPICY PEPPERONI PIZZA", 4, R.mipmap.pizza6, "20 min",
                "- 1 pizza dough\n- 1/2 cup marinara sauce\n- 1 cup shredded mozzarella\n- 1/2 cup pepperoni slices\n- 1/2 teaspoon crushed red pepper flakes",
                "A fiery take on the classic pepperoni pizza with an extra kick of spice.",
                "STEP 1:\nPreheat oven to 450°F. Spread marinara sauce over crust.\n\nSTEP 2:\nTop with mozzarella and pepperoni slices.\n\nSTEP 3:\nBake for 12 minutes until crispy.\n\nSTEP 4:\nSprinkle red pepper flakes and serve."));

        ps.create(new Produit("TRUFFLE MUSHROOM PIZZA", 5, R.mipmap.pizza7, "35 min",
                "- 1 pizza crust\n- 1/3 cup Alfredo sauce\n- 1 cup sautéed mushrooms\n- 1/2 cup shredded mozzarella\n- 1 teaspoon truffle oil",
                "A gourmet pizza with rich truffle aroma and earthy mushrooms.",
                "STEP 1:\nPreheat oven to 400°F. Spread Alfredo sauce over crust.\n\nSTEP 2:\nTop with sautéed mushrooms and mozzarella.\n\nSTEP 3:\nBake for 15-18 minutes until golden.\n\nSTEP 4:\nDrizzle truffle oil before serving."));

        ps.create(new Produit("TACO PIZZA", 3, R.mipmap.pizza8, "30 min",
                "- 1 pizza dough\n- 1/2 cup salsa\n- 1 cup cooked ground beef\n- 1/2 cup shredded cheddar cheese\n- 1/2 cup shredded lettuce\n- 1/2 cup diced tomatoes",
                "A fun fusion of pizza and tacos with all your favorite toppings.",
                "STEP 1:\nPreheat oven to 425°F. Spread salsa over crust.\n\nSTEP 2:\nTop with ground beef and cheddar cheese.\n\nSTEP 3:\nBake for 12-15 minutes until cheese melts.\n\nSTEP 4:\nAdd lettuce and tomatoes before serving."));

        ps.create(new Produit("BUFFALO CHICKEN PIZZA", 4, R.mipmap.pizza9, "30 min",
                "- 1 pizza crust\n- 1/2 cup buffalo sauce\n- 1 cup cooked shredded chicken\n- 1/2 cup blue cheese crumbles\n- 1/2 teaspoon black pepper",
                "Spicy and tangy, this pizza is perfect for buffalo chicken fans.",
                "STEP 1:\nPreheat oven to 425°F. Spread buffalo sauce over crust.\n\nSTEP 2:\nTop with shredded chicken and blue cheese.\n\nSTEP 3:\nBake for 15 minutes until cheese melts.\n\nSTEP 4:\nSprinkle black pepper before serving."));

        ps.create(new Produit("MEAT LOVER'S PIZZA", 5, R.mipmap.pizza10, "40 min",
                "- 1 pizza dough\n- 1/2 cup pizza sauce\n- 1/2 cup cooked sausage\n- 1/2 cup cooked bacon crumbles\n- 1/2 cup sliced pepperoni\n- 1 cup shredded mozzarella",
                "Packed with delicious meats, this pizza is a carnivore’s delight.",
                "STEP 1:\nPreheat oven to 450°F. Spread pizza sauce over crust.\n\nSTEP 2:\nLayer sausage, bacon, pepperoni, and mozzarella.\n\nSTEP 3:\nBake for 15-18 minutes until crispy.\n\nSTEP 4:\nServe hot and enjoy."));

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
            sharePizzaRecipe();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sharePizzaRecipe() {
        String message = "Check out these amazing pizza recipes! 🍕🔥";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, "Share via"));
    }
}