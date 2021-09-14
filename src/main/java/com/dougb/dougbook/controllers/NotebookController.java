package com.dougb.dougbook.controllers;

import com.dougb.dougbook.models.NoteModel;
import com.dougb.dougbook.services.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/notebook")
public class NotebookController {

    @Autowired
    private Notes notes;

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    public NoteModel createNewNote(@RequestBody NoteModel note) {
        return notes.createNote(note);
    }
}
