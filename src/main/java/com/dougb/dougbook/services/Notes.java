package com.dougb.dougbook.services;

import com.dougb.dougbook.models.NoteModel;

import java.util.List;

public interface Notes {
    NoteModel createNote(NoteModel note);
    List<String> listNotebooks();
    List<NoteModel> listNotes(String notebook);
    List<NoteModel> filterNotes(String notebook, String tag);
    NoteModel retrieveNoteById(String id);
    NoteModel updateNote(NoteModel note);
    void deleteNote(long id);
}
