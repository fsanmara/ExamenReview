package edu.dam.pgl.examenreview;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MediaPlayerFragment extends Fragment {

    String name = "db";
    String titulo, recurso;
    TextView tvTexto;
    MediaPlayer mediaPlayer;


    public MediaPlayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


         View view = inflater.inflate(R.layout.fragment_media_player, container, false);

         tvTexto = view.findViewById(R.id.tvTexto);

         Bundle bundle = getArguments();

         int numero = bundle.getInt("NUMERO");

        SQLiteOpenHelper  dbHelper = new MultimediaSQLiteOpenHelper(getContext(), name, null, 1 );

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from audios" +
                " where _id = ?", new String[] {Integer.toString(bundle.getInt("NUMERO"))});


        if (cursor.moveToFirst()) {
            do {
                titulo   = cursor.getString(1);
                recurso = cursor.getString(3);
            } while (cursor.moveToNext());
        }

        if(numero == 1 || numero == 3) {

                mediaPlayer = MediaPlayer.create(getContext(), R.raw.marcha_turca);
                mediaPlayer.start();

                tvTexto.setText(titulo);

        }

        if(numero == 2 || numero == 4){

            mediaPlayer = MediaPlayer.create(getContext(), R.raw.serenata_13);

            tvTexto.setText(titulo);
            mediaPlayer.start();
        }


         return view;
    }

}
