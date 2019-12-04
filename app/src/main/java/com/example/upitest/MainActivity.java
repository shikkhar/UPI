package com.example.upitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.editText)
    EditText referenceNumberEditText;
    @BindView(R.id.buttonCreateMandate)
    Button createMandateButton;
    @BindView(R.id.editTextCreateMandate)
    EditText createMandateEditText;
    @BindView(R.id.buttonCheckMandate)
    Button checkMandateButton;
    @BindView(R.id.editTextCheckMandate)
    EditText checkMandateEditText;
    @BindView(R.id.buttonExecutePayment)
    Button executePayment;
    @BindView(R.id.editTextExecutePayment)
    EditText executePaymentEditText;

    @OnClick(R.id.buttonCreateMandate)
    void onCreateClick(){
        HashMap<String, String> params = new HashMap<>();
        Repository.createMandateRequest(new CreateMandateResponseCallback(), null);
    }

    @OnClick(R.id.buttonCheckMandate)
    void onCheckClick(){
        HashMap<String, String> params = new HashMap<>();
        //params.put("ordPspRefNo", "HDFCMOBYCY1574162581806");
        Repository.checkMandateRequest(new CheckMandateResponseCallback(), referenceNumberEditText.getText().toString());
    }

    @OnClick(R.id.buttonExecutePayment)
    void onExecuteClick(){
        Repository.executePaymentRequest(new ExecutePaymentResponseCallback(), referenceNumberEditText.getText().toString());
    }

    @OnClick(R.id.buttonCheckPayment)
    void onCheckPaymentClick(){
        HashMap<String, String> params = new HashMap<>();
        //Repository.checkPaymentRequest(new CheckPaymentResponseCallback(), params);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private class CreateMandateResponseCallback implements VolleySeverRequest.VolleyResponseCallback{
        @Override
        public void onSuccess(String response) {
            createMandateEditText.setText("");
            createMandateEditText.setText(response);
        }

        @Override
        public void onFail(VolleyError error) {
            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private class CheckMandateResponseCallback implements VolleySeverRequest.VolleyResponseCallback{
        @Override
        public void onSuccess(String response) {
            createMandateEditText.setText("");
            checkMandateEditText.setText(response);
        }

        @Override
        public void onFail(VolleyError error) {
            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private class ExecutePaymentResponseCallback implements VolleySeverRequest.VolleyResponseCallback{
        @Override
        public void onSuccess(String response) {
            createMandateEditText.setText("");
            executePaymentEditText.setText(response);
        }

        @Override
        public void onFail(VolleyError error) {
            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private class CheckPaymentResponseCallback implements VolleySeverRequest.VolleyResponseCallback{
        @Override
        public void onSuccess(String response) {

        }

        @Override
        public void onFail(VolleyError error) {
            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
