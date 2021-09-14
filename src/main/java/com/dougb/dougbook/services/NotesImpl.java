package com.dougb.dougbook.services;

import com.dougb.dougbook.models.NoteModel;
import com.dougb.dougbook.repositories.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component(value="notes")
public class NotesImpl implements Notes {
    @Autowired
    private NotesRepository notesRepository;


    public NoteModel createNote(NoteModel note) {
        return notesRepository.save(note);
    }
}