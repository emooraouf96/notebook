package com.example.android.notebook;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


@Database(entities = {Note.class} , version = 1)
public abstract class NoteDB extends RoomDatabase {

    private static NoteDB instance;
    public abstract NoteDAO noteDAO();
    public static synchronized NoteDB getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                       NoteDB.class, "note_DB")
                       .fallbackToDestructiveMigration()
                       .addCallback(roomcallback)
                       .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomcallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populatedbAsyncTask(instance).execute();
        }
    };
    private static class populatedbAsyncTask extends AsyncTask<Void, Void, Void>{
       private NoteDAO noteDAO;
       private populatedbAsyncTask (NoteDB db){
           noteDAO = db.noteDAO();
       }


        @Override
        protected Void doInBackground(Void... voids) {
            noteDAO.insert(new Note(1, "Title1", "Decreption1"));
            noteDAO.insert(new Note(2, "Title2", "Decreption2"));
            noteDAO.insert(new Note(3, "Title3", "Decreption3"));
            return null;
        }
    }
}
