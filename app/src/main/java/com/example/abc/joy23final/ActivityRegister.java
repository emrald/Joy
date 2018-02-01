package com.example.abc.joy23final;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import fragment.MainActivity2;

/**
 * Created by TI A1 on 24-04-2017.
 */
public class ActivityRegister extends Activity {

    Button btnagree;
    boolean flag = false;
    ImageView imgBack, imgProfile;
    TextView txtRegister, txtAgree, txtCreate, txtTerms, txtEnd, txtPrivacy, txtAlready, txtSignUpAlready;
    AutoCompleteTextView atvUserName, atvEmail;
    EditText edtPassword, edtConfirmPassword;
    Button btnSignUp;
    View focusView = null;
    ImageView imgProfile1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgProfile = (ImageView) findViewById(R.id.imgavatar);
        imgProfile1 = (ImageView) findViewById(R.id.ImageViewProfile);

        txtRegister = (TextView) findViewById(R.id.tvregisterText);
        txtAgree = (TextView) findViewById(R.id.tvAgree);
        txtCreate = (TextView) findViewById(R.id.tvCreating);
        txtTerms = (TextView) findViewById(R.id.tvTerms);
        txtEnd = (TextView) findViewById(R.id.tvEnd);
        txtPrivacy = (TextView) findViewById(R.id.tvPrivacy);
        txtAlready = (TextView) findViewById(R.id.tvAlready);
        txtSignUpAlready = (TextView) findViewById(R.id.tvSighUp);

        atvUserName = (AutoCompleteTextView) findViewById(R.id.edtusernameregister);
        atvEmail = (AutoCompleteTextView) findViewById(R.id.edtemailregister);
        edtPassword = (EditText) findViewById(R.id.edtpasswordregister);
        edtConfirmPassword = (EditText) findViewById(R.id.edtCpasswordregister);

        btnSignUp = (Button) findViewById(R.id.btn_sign_up_button);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = atvUserName.getText().toString();
                String email = atvEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String confirmpassword = edtConfirmPassword.getText().toString();

             /*   Intent i = new Intent(ActivityRegister.this, MainActivity2.class);
                startActivity(i);
                finish();*/

               if (username.trim().equals("")) {
                    atvUserName.setError(getString(R.string.error_field_required));
                    focusView = atvUserName;

                } else if (TextUtils.isEmpty(email)) {
                    atvEmail.setError(getString(R.string.error_field_required));
                    focusView = atvEmail;

                } else if (!isEmailValid(email)) {
                    atvEmail.setError(getString(R.string.error_invalid_email));
                    focusView = atvEmail;

                } else if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
                    edtPassword.setError(getString(R.string.error_invalid_password));
                    focusView = edtPassword;

                } else if (!TextUtils.isEmpty(confirmpassword) && !confirmpassword.equals(password)) {
                    edtConfirmPassword.setError(getString(R.string.error_invalid_password));
                    focusView = edtConfirmPassword;

                } else if (flag == false) {
                    Toast.makeText(ActivityRegister.this, "Agree With Terms & Conditions?", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(ActivityRegister.this, MainActivity2.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        txtSignUpAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityRegister.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
        btnagree = (Button) findViewById(R.id.btnagree);
        btnagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == true) {
                    flag = false;
                    btnagree.setBackgroundResource(R.drawable.uncheckgreen);
                } else {
                    flag = true;
                    btnagree.setBackgroundResource(R.drawable.check);
                }
            }
        });
    }


    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(ActivityRegister.this,LoginActivity.class);
        startActivity(i);
        finish();
        super.onBackPressed();
    }
}
