package com.example.notes.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.room.Room;


import com.example.notes.NotesModel.NotesDao;
import com.example.notes.NotesModel.NotesModel;
import com.example.notes.R;
import com.example.notes.database.AppDatabase;

public class AddNotesActivity extends AppCompatActivity {
    EditText notesText, notesName;
    ImageView backNotes, saveNotes;
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_notes);
        init();
    }

    public void init() {
        notesName = findViewById(R.id.name_notes);
        notesText = findViewById(R.id.notes_text);
        backNotes = findViewById(R.id.notesback);
        saveNotes = findViewById(R.id.save_notes);

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "notes_txt").build();
        saveNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MalumotSaqlashAsyncTask().execute();
            }
        });
        backNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNotesActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        });
    }

    private class MalumotSaqlashAsyncTask extends AsyncTask<String, String, String> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(AddNotesActivity.this, "Malumotlar yuklanmoqda ", "Iltimos hhamma malumotlar yuklanishini kuting !");
        }

        @Override
        protected String doInBackground(String... params) {
            NotesDao carDao = database.notesDao();
            NotesModel notesModel = new NotesModel();
            notesModel.setNotesName(notesName.getText().toString());
            notesModel.setNotesText(notesText.getText().toString());
            carDao.insertAll(notesModel);
            return "";
        }

        @Override
        protected void onPostExecute(String result) {

            progressDialog.dismiss();
            notesName.setText("");
            notesText.setText("");


        }


    }

}
