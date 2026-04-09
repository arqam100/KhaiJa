package com.example.khaija;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.StorageReference;

public class signin extends AppCompatActivity {

    EditText emailLogin, passwordLogin;
    Button btnLogin;
    TextView textView;
    ProgressBar progressBar2;
    FirebaseAuth fAuth;

    private StorageReference s;
    private Object ProgressBar2;

    /* DBHelper myDB;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        emailLogin = (EditText) findViewById(R.id.emailLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        textView = (TextView)findViewById(R.id.txtSignIn);
        progressBar2 = findViewById(R.id.progressBar2);
        fAuth = FirebaseAuth.getInstance();




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = emailLogin.getText().toString().trim();
                String pass = passwordLogin.getText().toString().trim();

                if (mail.isEmpty())
                {
                    emailLogin.setError("Email Is Required");
                    return;
                }

                if (pass.isEmpty())
                {
                    passwordLogin.setError("Password Is Required");
                    return;
                }

                if(pass.length() < 8)
                {
                    passwordLogin.setError("password must be equal or greater then 8 characters");
                    return;
                }

                progressBar2.setVisibility(View.VISIBLE);
                //Authenticate the user

                fAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(signin.this, "Login In Successfully", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),home.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(signin.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar2.setVisibility(View.GONE);
                        }

                    }
                });

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signin.this,accounts.class);
                startActivity(intent);
            }
        });
    }
}

     /*   myDB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usernameLogin.getText().toString();
                String pass = passwordLogin.getText().toString();

                if (user.equals("") || pass.equals(""))
                {
                    Toast.makeText(signin.this, "Fill All Fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean result = myDB.checkusernamePassword(user,pass);
                    if (result == true)
                    {
                        Intent intent = new Intent(signin.this,home.class);
                        startActivity(intent);
                        Toast.makeText(signin.this, "Welcome To Khai Ja", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(signin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}*/