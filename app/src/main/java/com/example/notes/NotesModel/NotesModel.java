package com.example.notes.NotesModel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notesTable")
public class NotesModel {
    public int getNotesId() {
        return notesId;
    }

    public void setNotesId(int notesId) {
        this.notesId = notesId;
    }

    public String getNotesName() {
        return notesName;
    }

    public void setNotesName(String notesName) {
        this.notesName = notesName;
    }

    public String getNotesText() {
        return notesText;
    }

    public void setNotesText(String notesText) {
        this.notesText = notesText;
    }

    @PrimaryKey(autoGenerate = true)
    int notesId;
    @ColumnInfo(name = "notesName")
    String notesName;
    @ColumnInfo(name = "notesText")
    String notesText;


}
