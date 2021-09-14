package com.dougb.dougbook.services;

import com.dougb.dougbook.models.NoteModel;
import com.dougb.dougbook.repositories.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component(value = "notes")
public class NotesImpl implements Notes {
    @Autowired
    private NotesRepository notesRepository;


    public NoteModel createNote(NoteModel note) {
        return notesRepository.save(note);
    }

    public List<String> listNotebooks() {
        return notesRepository.retrieveAllNotebooks();
    }

    public List<NoteModel> listNotes(String notebook) {
        return notesRepository.getNotesByNotebook(notebook);
    }

    public List<String> filterNotes(String notebook, String tag) {
        List<String> filter = notesRepository.getNotesByTag(notebook, tag);
        return filter;
    }

    public void deleteNote(long id) {
        notesRepository.deleteById(id);
    }
}