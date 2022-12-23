package com.example.notes.notesAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.notes.NotesModel.NotesModel;
import com.example.notes.R;

import java.util.List;

public class NotesItemAdapter extends RecyclerView.Adapter<NotesItemAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<NotesModel> notesModels;
    private final NotesInterface notesInterface;

    public NotesItemAdapter(Context context, List<NotesModel> notesModels, NotesInterface notesInterface) {
        this.notesModels = notesModels;
        this.inflater = LayoutInflater.from(context);
        this.notesInterface = notesInterface;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.notes_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NotesModel notesModel = notesModels.get(position);
        holder.notesName.setText(notesModel.getNotesName());
        holder.notesText.setText(notesModel.getNotesText());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                notesInterface.deleteNote(notesModel.getNotesId());
            }
        });


    }

    @Override
    public int getItemCount() {
        return NotesModel.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView notesName, notesText;
        final ImageView delete;

        ViewHolder(View view) {
            super(view);
            notesName = view.findViewById(R.id.show_notes_name);
            delete = view.findViewById(R.id.delete_notes);
            notesText = view.findViewById(R.id.show_notes_text);


        }
    }

    interface NotesInterface {
        void deleteNote(int carId);

    }
}