package com.hammadmukhtar.inlogic;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Initializing Default loading indicator */
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
    }

    public void showWaitDialog(){
        progressDialog.show();
    }

    public void hideWaitDialog(){
        progressDialog.dismiss();
    }

    public boolean isShowing(){
        return progressDialog.isShowing();
    }
}
