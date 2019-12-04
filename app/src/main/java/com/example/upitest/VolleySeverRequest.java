package com.example.upitest;

import android.text.TextUtils;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Class to make Volley Requests
 */
public class VolleySeverRequest {
    final static String APPLICATION_JSON_VALUE = "application/json";
    //callback for volley responses
    private VolleyResponseCallback responseCallback;


    public VolleySeverRequest() {

    }

    public VolleySeverRequest(VolleyResponseCallback responseCallback) {
        this.responseCallback = responseCallback;
    }

    //make a json get request using url
    public void makeGetRequest(String url, final HashMap<String, String> params, String requestTag) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseCallback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseCallback.onFail(error);
            }
        }) /*{
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                *//*Map<String, String> params = new HashMap<>();
                params.put("ordPspRefNo", "HDFCMOBYCY1574162581806");
                *//*
                if (params != null) {
                    return params;
                }
                return super.getParams();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return setHeaders();
            }
        }*/;

        stringRequest.setTag(requestTag);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                (int) TimeUnit.SECONDS.toMillis(15), //After the set time elapses the request will timeout
                0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().getVolleyRequestQueue().add(stringRequest);
    }

    //function to cancel all volley requests with the given tag

    public static void cancelRequests(Object... tags) {
        for (Object tag : tags) {
            AppController.getInstance().getVolleyRequestQueue().cancelAll(tag);
        }
    }

    private Map<String, String> setHeaders() {
        //String cookie = EightfoldsUtils.getInstance().getFromSharedPreference(context, COOKIE);
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiI3OTgyODY3MDE0IiwiZXhwIjoxNTc2MzE4NjM2LCJqdGkiOiJ6YmFMUU1WYnZHRHZnRFh4U2FYSUNRIiwiaWF0IjoxNTczNzI2NjM2LCJ1c2VyTmFtZSI6Ijc5ODI4NjcwMTQiLCJ1c2VySWQiOjE5NzE0OH0.yHLKdUofqcvWor7TbGgJgxsQbYC1N2OAWO85zC6xyaA";
        //EightfoldsUtils.getInstance().getFromSharedPreference(context, ACCESS_TOKEN);
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", APPLICATION_JSON_VALUE);
        headers.put("Accept", APPLICATION_JSON_VALUE);
        if (!TextUtils.isEmpty(accessToken)) {
            headers.put("Authorization", "Bearer " + accessToken);
        }
        /*if (mUsername != null && mPassword != null) {
            headers.put("Authorization", ("Basic " + Base64.encodeToString((mUsername + ":" + mPassword).getBytes(), Base64.NO_WRAP)));
        }
        if (!TextUtils.isEmpty(cookie)) {
            headers.put("Cookie", cookie);
        }*/
        return headers;
    }

    /*
    Volley response Callback Class
     */
    public interface VolleyResponseCallback {

        void onSuccess(String response);

        void onFail(VolleyError error);
    }


}
