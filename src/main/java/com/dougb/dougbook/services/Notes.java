package com.dougb.dougbook.services;

import com.dougb.dougbook.models.NoteModel;
import com.dougb.dougbook.models.NotebookModel;

public class Notes {
    public NotebookModel createNote(NoteModel note, NotebookModel currentNotebook) {
        currentNotebook.notes.add(note);
        return currentNotebook;
    }
}
