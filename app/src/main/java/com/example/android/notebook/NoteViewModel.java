package com.example.android.notebook;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepo repo;
    private LiveData<List<Note>> allNotes;
    public NoteViewModel(@NonNull Application application) {
        super(application);
        repo = new NoteRepo(application);
        allNotes = repo.getAllNotes();
    }

    public void insert(Note note){
        repo.insert(note);
    }
    public void update(Note note){
        repo.update(note);
    }
    public void delete(Note note){
        repo.delete(note);
    }
    public void deleteAllNotes(Note note){
        repo.deleteAllNotes(note);
    }
    LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }

    public void deleteAllNotes() {
    }
}
