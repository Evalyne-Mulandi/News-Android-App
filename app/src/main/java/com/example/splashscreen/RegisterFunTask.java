package com.example.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterFunTask extends AsyncTask<String, Void, String> {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private Context context;

    // Constructor to receive the context
    public  RegisterFunTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        OkHttpClient client = new OkHttpClient();
        String json = params[0]; // JSON data for user creation

        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url("https://vast-adequately-elk.ngrok-free.app/php_rest_newstb/create_users.php") // Replace with your API endpoint
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                return "Error: " + response.code();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d("UserFuncTask", "Response: " + result);

        try {
            JSONObject jsonResponse = new JSONObject(result);

            // Check if the "success" field in the JSON response is true
            boolean success = jsonResponse.optBoolean("success", false);

            if (success) {
                Log.d("UserFunTask", "User created successfully");
                Intent intent = new Intent(context,  nuntium.class);
                context.startActivity(intent);
            } else {
                // Handle the case where user creation was not successful
                Log.d("UserFunTask", "User creation failed");
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("UserFunTask", "Error parsing JSON response");
        }
    }
    }

