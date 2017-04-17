//web ref: http://www.informit.com/articles/article.aspx?p=1646053&seqNum=3

package com.example.android.wearable.ciderkitchenhelper;
//package cs3398_cider_s2017.kitchenhelper;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends ListActivity
{
    private static final String APP_NAME = "CiderKitchenHelper";
    private SQLRecipeListAdapter srlAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.custom_list_activity_view);
        srlAdapter = new SQLRecipeListAdapter(this);
        setListAdapter(srlAdapter);
        
        //set up the button listener for listing recipes
        Button listRecipesButton = (Button) findViewById(R.id.trigger);
        listRecipesButton.setOnClickListener(new View.OnClickListener()
        {
            // This allows us to launch an activity.
            // The appropriate Activity class will be called uing an
            // Intent object and then by running the startActivity method.
            public void onClick(ListView lv, int position)
            {
                String itemName = srlAdapter.getItemName(position);
                Intent intent = new Intent(getApplicationContext(),
                                           RecipeActivity.class);
                intent.putExtra(Constrants.RECIPE_NAME_TO_LOAD, itemName);
                startActivity(intent);
            }
        });
        
        //set up the button listener for searching recipes
        Button searchRecipesButton = (Button) findViewById(R.id.trigger);
        searchRecipesButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(ListView lv, int position)
            {
                String itemName = srlAdapter.getItemName(position);
                Intent intent = new Intent(getApplicationContext(),
                                           SearchActivity.class);
                intent.putExtra(Constrants.RECIPE_NAME_TO_LOAD, itemName);
                startActivity(intent);
            }
        });
    
        //set up the button listener for adding a recipe
        Button addRecipeButton = (Button) findViewById(R.id.trigger);
        addRecipeButton.setOnClickListener(new View.OnClickListener()
                                               {
            public void onClick(ListView lv, int position)
            {
                String itemName = srlAdapter.getItemName(position);
                Intent intent = new Intent(getApplicationContext(),
                                           AddRecipeActivity.class);
                intent.putExtra(Constrants.RECIPE_NAME_TO_LOAD, itemName);
                startActivity(intent);
            }
        });
        
        //set up the button listener for removing recipes
        Button addRecipeButton = (Button) findViewById(R.id.trigger);
        addRecipeButton.setOnClickListener(new View.OnClickListener()
                                               {
            public void onClick(ListView lv, int position)
            {
                String itemName = srlAdapter.getItemName(position);
                Intent intent = new Intent(getApplicationContext(),
                                           RemoveRecipeActivity.class);
                intent.putExtra(Constrants.RECIPE_NAME_TO_LOAD, itemName);
                startActivity(intent);
            }
        });
        
    }
}

