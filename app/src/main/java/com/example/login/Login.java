package com.example.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private static final String TAG = "Singin";
    private Button btnSingin;
    private TextView txtEmail;
    private TextView txtPassWord;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view2);

        btnSingin.findViewById(R.id.btnSingin);
        txtEmail.findViewById(R.id.txtEmail);
        txtPassWord.findViewById(R.id.txtPassWord);
        mAuth = FirebaseAuth.getInstance();

    }

    private void singIn() {
        String email = txtEmail.getText().toString();
        String passWord = txtPassWord.getText().toString();
        mAuth.signInWithEmailAndPassword(email, passWord)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "đúng cmnr!!");

                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                });


    }
}
