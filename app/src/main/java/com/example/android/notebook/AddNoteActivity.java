package com.example.android.notebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    public static final String Extra_Title = "com.example.android.roomlibrary.Extea_Title";
    public static final String Extra_Desc = "com.example.android.roomlibrary.Extea_Desc";
    public static final String Extra_priority = "com.example.android.roomlibrary.Extea_Priority";

    private EditText editTextTitle;
   private EditText editTextDesc;
   private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);


        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDesc = findViewById(R.id.edit_text_Desc);
        numberPickerPriority = findViewById(R.id.number_picker_priority);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }

      private  void saveNote() {

        String title = editTextTitle.getText().toString();
        String desc = editTextDesc.getText().toString();
        int priority = numberPickerPriority.getValue();

        if (title.trim().isEmpty() || desc.trim().isEmpty()){
            Toast.makeText(this, "plz inser title & desc", Toast.LENGTH_SHORT).show();
            return;
        }

          Intent data = new Intent();
          data.putExtra(Extra_Title,title);
          data.putExtra(Extra_Desc, desc);
          data.putExtra(Extra_priority, priority);
          setResult(RESULT_OK, data);
          finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menue,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     switch (item.getItemId()){
         case R.id.save_note:
             saveNote();
             return true;
             default:
                 return super.onOptionsItemSelected(item);

         }
     }
}
