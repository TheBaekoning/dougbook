package com.dougb.dougbook;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.springframework.format.annotation.DateTimeFormat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class NotesTests {
    @Test
    public void CreateNote(){
        // arrange
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        dateFormat.setTimeZone(timeZone);
        String currentTime = dateFormat.format(new Date());

        NoteModel expectedNote = new NoteModel () {
            id = 1,
            title = "test",
            body = "testNote",
            created = currentTime,
            modified = ""
        };
        Notes notes = new Notes();

        // act

        NoteModel actual = notes.CreateNote(expectedNote);

        // assert

        assertEquals(expectedNote, actual);
    }

    @Test
    public void DeleteNote(){

    }
}
