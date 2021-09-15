package com.dougb.dougbook.services;

import com.dougb.dougbook.models.NoteModel;
import com.dougb.dougbook.repositories.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
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

    public List<NoteModel> filterNotes(String notebook, String tag) {
        return notesRepository.getNotesByTag(notebook, tag);
    }

    public NoteModel retrieveNoteById(String id){
        return notesRepository.getNoteById(id);
    }

    public NoteModel updateNote(NoteModel note){
        Optional<NoteModel> lookupNote = notesRepository.findById(note.getId());
        if(lookupNote.isEmpty())
        return null;

        String created = lookupNote.get().getCreated();
        NoteModel result = notesRepository.save(note);
        result.setCreated(created);
        return result;
    }

    public void deleteNote(long id) {
        notesRepository.deleteById(id);
    }
}