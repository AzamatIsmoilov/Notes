package com.example.notes.NotesModel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface NotesDao {
    @Query("SELECT * FROM notesTable")
    List<NotesModel> getAll();


    @Query("SELECT * FROM notesTable WHERE notesName LIKE :notesName")
    NotesModel findByName(String notesName);


    @Insert
    void insertAll(NotesModel... notesModels);

    @Delete
    void delete(NotesModel notesModel);

    @Query("DELETE FROM notesTable WHERE notesId=:notesId")
    void deleteById(int notesId);

    @Insert
    void insertAll(NotesModel notesModel);

//    @Query("UPDATE notesTable SET notesName=:notesNewName, notesText=:notesNewText  WHERE notesId = :id")
//    void updateNote(int id, String notesNewName, String notesNewText);

}

