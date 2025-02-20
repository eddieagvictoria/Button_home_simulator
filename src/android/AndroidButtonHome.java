package com.example.androidbuttonhome;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.app.Activity;

public class AndroidButtonHome extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("simulateHomeButton")) {
            this.simulateHomeButton(callbackContext);
            return true;
        }
        return false;
    }

    private void simulateHomeButton(CallbackContext callbackContext) {
        Activity activity = this.cordova.getActivity();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        activity.startActivity(intent);
        callbackContext.success("Home button simulated");
    }
}