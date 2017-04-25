/*
    Nick's stab at refactoring Recipe class.
 */

package com.example.android.wearable.recipeassistant;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Recipe {
    private static final String TAG = "RecipeAssistant";

    public String titleText;
    public String summaryText;
    public String ingredientsText;

    public Recipe() {
        recipeSteps = new ArrayList<RecipeStep>();
    }

    public static Recipe fromJson(Context context, JSONObject json) {
        Recipe recipe = new Recipe();
        try {
            recipe.titleText = json.getString(Constants.RECIPE_FIELD_TITLE);
            recipe.summaryText = json.getString(Constants.RECIPE_FIELD_SUMMARY);

            JSONArray ingredients = json.getJSONArray(Constants.RECIPE_FIELD_INGREDIENTS);
            recipe.ingredientsText = "";
            for (int i = 0; i < ingredients.length(); i++) {
                recipe.ingredientsText += " - "
                        + ingredients.getJSONObject(i).getString(Constants.RECIPE_FIELD_TEXT) + "\n";
            }

            }
        } catch (JSONException e) {
            Log.e(TAG, "Error loading recipe: " + e);
            return null;
        }
        return recipe;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.RECIPE_FIELD_TITLE, titleText);
        bundle.putString(Constants.RECIPE_FIELD_SUMMARY, summaryText);
        bundle.putString(Constants.RECIPE_FIELD_INGREDIENTS, ingredientsText);
        return bundle;
    }

    public static Recipe fromBundle(Bundle bundle) {
        Recipe recipe = new Recipe();
        recipe.titleText = bundle.getString(Constants.RECIPE_FIELD_TITLE);
        recipe.summaryText = bundle.getString(Constants.RECIPE_FIELD_SUMMARY);
        recipe.ingredientsText = bundle.getString(Constants.RECIPE_FIELD_INGREDIENTS);
        return recipe;
    }
}
