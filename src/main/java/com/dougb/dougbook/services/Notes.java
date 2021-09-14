package com.dougb.dougbook.services;

import com.dougb.dougbook.models.NoteModel;
import com.dougb.dougbook.models.NotebookModel;
import org.springframework.stereotype.Service;

public interface Notes {
    NoteModel createNote(NoteModel note);
}
