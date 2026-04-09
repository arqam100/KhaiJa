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

public class accounts extends AppCompatActivity {

    EditText username, password, phn, email;
    Button signUp;
    TextView signIn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    private StorageReference s;
    private Object ProgressBar;
    /* DBHelper myDB;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        progressBar=findViewById(R.id.progressBar);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        phn = (EditText) findViewById(R.id.phn);
        email = (EditText) findViewById(R.id.email);
        signUp = (Button) findViewById(R.id.signUp);
        signIn = (TextView) findViewById(R.id.signIn);

        fAuth = FirebaseAuth.getInstance();
        ProgressBar = findViewById(R.id.progressBar);





        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (mail.isEmpty())
                {
                    email.setError("Email Is Required");
                    return;
                }

                if (pass.isEmpty())
                {
                    password.setError("Password Is Required");
                    return;
                }

                if(pass.length() < 8)
                {
                    password.setError("password must be equal or greater then  8 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                //register the user in fire base

                fAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(accounts.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),home.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(accounts.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),signin.class));
            }
        });
    }
}

      /*  myDB = new DBHelper(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String cnPass = retypePassword.getText().toString();
                String mail = email.getText().toString();


                if(user.equals("") || pass.equals("") || cnPass.equals("") || mail.equals(""))
                {
                    Toast.makeText(accounts.this,"Fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (pass.equals(retypePassword))
                    {
                     Boolean userCheckResult = myDB.checkusername(user);
                     if (userCheckResult == false)
                     {
                        Boolean regResult= myDB.insertData(user,pass);
                        if (regResult == true)
                        {
                            Intent intent = new Intent(getApplicationContext(),home.class);
                            startActivity(intent);
                            Toast.makeText(accounts.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(accounts.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                     }
                     else
                     {
                         Toast.makeText(accounts.this, "User Already Exists \n Please Sign In", Toast.LENGTH_SHORT).show();
                     }
                    }
                    else
                    {
                        Toast.makeText(accounts.this, "Password Not Match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accounts.this,signin.class);
                startActivity(intent);
                Toast.makeText(accounts.this, "Sign In Your Account", Toast.LENGTH_LONG).show();
            }
        });
    }

}*/