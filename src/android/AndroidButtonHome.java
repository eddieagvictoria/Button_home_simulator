package com.example.androidbuttonhome;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        try {
            Activity activity = this.cordova.getActivity();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            activity.startActivity(intent);

            // Crear un objeto JSON con el resultado
            JSONObject result = new JSONObject();
            result.put("success", true); // Éxito
            result.put("message", "Home button simulated successfully");

            // Enviar el resultado a JavaScript
            callbackContext.success(result);
        } catch (Exception e) {
            // En caso de error, enviar un mensaje de error
            JSONObject result = new JSONObject();
            result.put("success", false); // Error
            result.put("message", "Failed to simulate home button: " + e.getMessage());

            // Enviar el resultado a JavaScript
            callbackContext.error(result);
        }
    }
}