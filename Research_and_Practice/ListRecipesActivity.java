package com.example.android.wearable.ciderkitchenhelper;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONObject;

public class ListRecipesActivity extends activity
{
  private static final String TAG = "CiderKitchenHelper";
  private String mRecipeName;
  private Recipe mRecipe;
  private TextView mTitleView;
  private TextView mSummaryTextView;
  private TextView mIngredientsTextView;

  @Override
  protected void onStart()
  {
    super.onStart();
    Intent intent = getIntent();
    mRecipeName = intent.getStringExtra(Constants.RECIPE_NAME_TO_LOAD);
    loadRecipe();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.recipe);
    mTitleView = (TextView) findViewById(R.id.recipeTextTitle);
    mSummaryTextView = (TextView) findViewById(R.id.recipeTextSummary);
    mIngredientsTextView = (TextView) findViewById(R.id.textIngredients);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    // Inflate the menu; this adds items to the action bar if it's present.
    getMenuInflator().inflate(R.menu.main, menu);
    return true;
  }

  private void loadRecipe()
  {
    JSONObject jsonObject = AssetUtils.loadJSONAsset(this, mRecipeName);
    if (jsonObject != null) {
      mRecipe = Recipe.fromJson(this, jsonObject);
      if (mRecipe != null) {
        displayRecipe(mRecipe);
      }
    }
  }

  private void displayRecipe(Recipe recipe)
  {
    // set fade-in animation for a recipe name
    Animation fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

    // set an animation to the title TextView
    mTitleTextView.setAnimation(fadeIn);

    // populate title, summary, and ingredients textviews with text
    mTitleText.setText(recipe.titleText);
    mSummaryTextView.setText(recipe.summaryText);
    mIngredientsTextView.setText(recipe.ingredientsText);

    //
    findViewByID(R.id.ingredientsHeader).setAnimation(fadeIn);
    findViewByID(R.id.ingredientsHeader).setVisibility(View.VISIBLE);
  }
}
