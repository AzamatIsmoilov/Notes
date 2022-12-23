package com.example.notes.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.notes.NotesModel.NotesDao;
import com.example.notes.NotesModel.NotesModel;
import com.example.notes.R;
import com.example.notes.database.AppDatabase;
import com.example.notes.notesAdapter.NotesItemAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class NotesActivity extends AppCompatActivity {
    NotesItemAdapter notesItemAdapter;
    EditText searchNotes;
    ImageView searchNotesImage;
    RecyclerView recyclerView;
    FloatingActionButton addNotesBtn;
    List<NotesModel> notesList = new ArrayList<>();
    AppDatabase database;
    int DeleteCarId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes);
        init();

    }

    public void init() {
        searchNotes = findViewById(R.id.search_notes_txt);
        searchNotesImage = findViewById(R.id.search_notes_image);
        recyclerView = findViewById(R.id.notes_recyclerView);
        addNotesBtn = findViewById(R.id.add_Notes);
        recyclerView.setAdapter(notesItemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "notes_txt").build();
        addNotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotesActivity.this, AddNotesActivity.class);
                startActivity(intent);
            }
        });

    }



        private class MalumotKorishAsyncTask extends AsyncTask<String, String, String> {

            ProgressDialog progressDialog;


            @Override
            protected void onPreExecute() {
                progressDialog = ProgressDialog.show(NotesActivity.this, "Kuting!  ", "malumotlar yuklanmoqda!");
            }

            @Override
            protected String doInBackground(String... params) {
                NotesDao carDao = database.notesDao();

                notesList.clear();
                notesList.addAll(carDao.getAll());


                return "";
            }

            @Override
            protected void onPostExecute(String result) {
                progressDialog.dismiss();
            }


        }
    }
