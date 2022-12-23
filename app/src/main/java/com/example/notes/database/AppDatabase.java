package com.example.notes.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;


import com.example.notes.NotesModel.NotesDao;
import com.example.notes.NotesModel.NotesModel;

@Database(entities = {NotesModel.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NotesDao notesDao();
}
