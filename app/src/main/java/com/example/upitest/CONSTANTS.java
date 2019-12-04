package com.example.upitest;

public class CONSTANTS {

    //local Server
    // public static String BASE_URL = "https://b9a22759.ngrok.io/mobycy";

    //Staging Server
    public static String BASE_URL = "http://13.126.228.36/mobycy";

    public static class NetworkRequestUrls {
        public static final String CREATE_MANDATE = BASE_URL + "/api/testupi";
        public static final String CHECK_MANDATE = BASE_URL + "/api/upi/verify";
        public static final String EXECUTE_PAYMENT = BASE_URL + "/api/execute/payment";

        public static final String CHECK_PAYMENT = "";


    }

    public static class NetworkRequestTags {
        public static final String CREATE_MANDATE = "0";
        public static final String CHECK_MANDATE = "1";
        public static final String EXECUTE_PAYMENT = "2";

        public static final String CHECK_PAYMENT = "3";

    }
}
