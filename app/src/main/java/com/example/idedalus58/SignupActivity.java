package com.example.idedalus58;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    //************************************************************//
    @BindView(R.id.input_id_utilisateur) EditText _nameText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.input_reEnterPassword) EditText _reEnterPasswordText;
    @BindView(R.id.btn_signup) Button _signupButton;
    @BindView(R.id.link_login) TextView _loginLink;

    //************************************************************//
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        //************************************************************//

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        //************************************************************//

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Terminer avec l'écran d'enregistrement et revenir à l'activité Connexion
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    //************************************************************//
    public void signup() {
        Log.d(TAG, "S'inscrire");

        if (!validate()) {
            onSignupFailed();
            return;
        }
    //************************************************************//

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("création du compte...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String password = _passwordText.getText().toString();
        String reEnterPassword = _reEnterPasswordText.getText().toString();

        // TODO: Implémentez votre propre logique d'inscription ici.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // Sur appel complet soit onSignupSuccess ou onSignupFailed
                        // en fonction du succès
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

    //************************************************************//

    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }
    //**************************** Affichage des message d'erreur (Toast) ********************************//

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Echec d'identification", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    //************************************************************//

    //************* Affichage des different message d'erreur (Toast) **********//

    public boolean validate() {
        boolean valid = true;

        //************************************************************//

        String name = _nameText.getText().toString();
        String password = _passwordText.getText().toString();
        String reEnterPassword = _reEnterPasswordText.getText().toString();

        //************************************************************//

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("au moins 3 caractères");
            valid = false;
        } else {
            _nameText.setError(null);
        }
        //************************************************************//

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("Entre 4 à 10 caractères alphanumériques");
            valid = false;
        } else {
            _passwordText.setError(null);
        }
        //************************************************************//

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 ||
            reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            _reEnterPasswordText.setError("Mot de passe Ne correspond pas");
            valid = false;
        } else {
            _reEnterPasswordText.setError(null);
        }

        return valid;

        //************************************************************//
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
}