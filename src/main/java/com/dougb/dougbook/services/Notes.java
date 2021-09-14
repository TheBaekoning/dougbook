package com.dougb.dougbook.services;

import com.dougb.dougbook.models.NoteModel;

import java.util.List;

public interface Notes {
    NoteModel createNote(NoteModel note);
    List<String> listNotebooks();
}
