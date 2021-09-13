package com.dougb.dougbook;

import com.dougb.dougbook.models.NoteModel;
import com.dougb.dougbook.models.NotebookModel;
import com.dougb.dougbook.services.Notes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class NotesTests {
    @Test
    public void CreateNote() {
        // arrange
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        dateFormat.setTimeZone(timeZone);
        String currentTime = dateFormat.format(new Date());

        NoteModel expectedNote = new NoteModel();
        NotebookModel testNoteBook = new NotebookModel();

        expectedNote.setId(1);
        expectedNote.setTitle("test");
        expectedNote.setTag("tag");
        expectedNote.setBody("this is a test body");

        Notes notes = new Notes();

        // act

        NotebookModel actual = notes.createNote(expectedNote, testNoteBook);

        // assert

        assertEquals(expectedNote, actual.notes.get(0));
    }

    @Test
    public void DeleteNote() {

    }
}
