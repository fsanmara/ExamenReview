package edu.dam.pgl.examenreview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class MediaPlayerActivity extends AppCompatActivity {


    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    Fragment mpf = new MediaPlayerFragment();
    int numero;

    //TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        //tv = findViewById(R.id.tv);

        numero = getIntent().getExtras().getInt("NUMERO");

        Bundle bundle = new Bundle();
        bundle.putInt("NUMERO", numero);

        mpf.setArguments(bundle);

        ft.replace(R.id.contenedor, mpf);
        ft.commit();

        //tv.setText(String.valueOf(numero));

        //prueba



    }
}
