package com.sourcey.materiallogindemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MenuScreenActivity extends ListActivity
{
    private static final String APP_NAME = "CiderKitchenHelper";
    private RecipeListAdapter mAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.custom_list_activity_view);
        mAdapter = new RecipeListAdapter(this);
        setListAdapter(mAdapter);
        
        //set up the button listener for listing recipes
        Button listRecipesButton = (Button) findViewById(R.id.trigger);
        listRecipesButton.setOnClickListener(new View.OnClickListener()
                                             {
            // This allows us to launch an activity.
            // The appropriate Activity class will be called uing an
            // Intent object and then by running the startActivity method.
            public void onClick(ListView lv, int position)
            {
                String itemName = mAdapter.getItemName(position);
                Intent intent = new Intent(getApplicationContext(),
                                           ListRecipesActivity.class);
                intent.putExtra(Constrants.RECIPE_NAME_TO_LOAD, itemName);
                startActivity(intent);
                finish();
            }
        });
        
        //set up the button listener for searching recipes
        Button searchRecipesButton = (Button) findViewById(R.id.trigger);
        searchRecipesButton.setOnClickListener(new View.OnClickListener()
                                             {
            // This allows us to launch an activity.
            // The appropriate Activity class will be called uing an
            // Intent object and then by running the startActivity method.
            public void onClick(ListView lv, int position)
            {
                String itemName = mAdapter.getItemName(position);
                Intent intent = new Intent(getApplicationContext(),
                                           SearchRecipesActivity.class);
                intent.putExtra(Constrants.RECIPE_NAME_TO_LOAD, itemName);
                startActivity(intent);
                finish();
            }
        });
        
        //set up the button listener for adding a recipe
        Button addRecipeButton = (Button) findViewById(R.id.trigger);
        addRecipeButton.setOnClickListener(new View.OnClickListener()
                                             {
            // This allows us to launch an activity.
            // The appropriate Activity class will be called uing an
            // Intent object and then by running the startActivity method.
            public void onClick(ListView lv, int position)
            {
                String itemName = mAdapter.getItemName(position);
                Intent intent = new Intent(getApplicationContext(),
                                           AddRecipeActivity.class);
                intent.putExtra(Constrants.RECIPE_NAME_TO_LOAD, itemName);
                startActivity(intent);
                finish();
            }
        });
        
        //set up the button listener for listing recipes
        Button removeRecipeButton = (Button) findViewById(R.id.trigger);
        removeRecipeButton.setOnClickListener(new View.OnClickListener()
                                             {
            // This allows us to launch an activity.
            // The appropriate Activity class will be called uing an
            // Intent object and then by running the startActivity method.
            public void onClick(ListView lv, int position)
            {
                String itemName = mAdapter.getItemName(position);
                Intent intent = new Intent(getApplicationContext(),
                                           RemoveRecipeActivity.class);
                intent.putExtra(Constrants.RECIPE_NAME_TO_LOAD, itemName);
                startActivity(intent);
                finish();
            }
        });
    }
}
