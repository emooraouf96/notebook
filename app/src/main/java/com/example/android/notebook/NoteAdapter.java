package com.example.android.notebook;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List <Note> notes = new ArrayList<>();

    @NonNull
    @Override
     public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.note_item,viewGroup,false);
                 return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, int position) {
     Note currentNote = notes.get(position);
        noteHolder.textviewTitle.setText(currentNote.getTitle());
        noteHolder.textviewDesc.setText(currentNote.getDesc());
        noteHolder.textViewPriority.setText(currentNote.getPriority()+"");
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes){
        this.notes = notes;
        notifyDataSetChanged();
    }

      public Note getNoteAt(int position) {
        return notes.get(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder {

        private TextView textviewTitle;
        private TextView textviewDesc;
        private TextView textViewPriority;

        public NoteHolder(View itemView) {
            super(itemView);
            textviewTitle = itemView.findViewById(R.id.text_view_title);
            textviewDesc = itemView.findViewById(R.id.text_view_Description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);

        }
    }
}
