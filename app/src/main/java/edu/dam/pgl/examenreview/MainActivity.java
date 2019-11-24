package edu.dam.pgl.examenreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnEnjoy;
    EditText etNumero;
    private int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnjoy = findViewById(R.id.btnEnjoy);
        etNumero = findViewById(R.id.etNumero);

        btnEnjoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numero = Integer.parseInt(etNumero.getText().toString().trim());

                if(numero >= 1 && numero < 5) {

                    Intent intent = new Intent(MainActivity.this, MediaPlayerActivity.class);

                    intent.putExtra("NUMERO", numero);

                    startActivity(intent);

                } else {

                    Toast.makeText(getApplicationContext(), "El número introducido debe estar entre 1 y 4", Toast.LENGTH_LONG).show();
                }
            }
        });




    }
}
