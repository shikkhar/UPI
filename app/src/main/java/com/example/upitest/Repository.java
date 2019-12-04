package com.example.upitest;

import java.util.HashMap;

import static com.example.upitest.CONSTANTS.BASE_URL;

public class Repository {

    public static void createMandateRequest(VolleySeverRequest.VolleyResponseCallback callback,
                                            HashMap<String, String> params){
        VolleySeverRequest serverRequest = new VolleySeverRequest(callback);
        serverRequest.makeGetRequest(CONSTANTS.NetworkRequestUrls.CREATE_MANDATE,
                params,
                CONSTANTS.NetworkRequestTags.CREATE_MANDATE);
    }

    public static void checkMandateRequest(VolleySeverRequest.VolleyResponseCallback callback,
                                            String orgPsprefNo){
        VolleySeverRequest serverRequest = new VolleySeverRequest(callback);
        String uri = String.format(CONSTANTS.NetworkRequestUrls.CHECK_MANDATE + "?ordPspRefNo=%1$s",
                orgPsprefNo);
        serverRequest.makeGetRequest(uri,
                null,
                CONSTANTS.NetworkRequestTags.CHECK_MANDATE);
    }

    public static void executePaymentRequest(VolleySeverRequest.VolleyResponseCallback callback,
                                           String umn){
        VolleySeverRequest serverRequest = new VolleySeverRequest(callback);
        String uri = String.format(CONSTANTS.NetworkRequestUrls.EXECUTE_PAYMENT + "?umn=%1$s",
                umn);
        serverRequest.makeGetRequest(uri,
                null,
                CONSTANTS.NetworkRequestTags.EXECUTE_PAYMENT);
    }

    public static void checkPaymentRequest(VolleySeverRequest.VolleyResponseCallback callback,
                                            HashMap<String, String> params){
        /*VolleySeverRequest serverRequest = new VolleySeverRequest(callback);
        serverRequest.makeGetRequest(CONSTANTS.NetworkRequestUrls.CHECK_PAYMENT,
                params,
                CONSTANTS.NetworkRequestTags.CHECK_PAYMENT);*/
    }
}
