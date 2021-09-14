package com.dougb.dougbook.controllers;

import com.dougb.dougbook.models.NoteModel;
import com.dougb.dougbook.models.NotebookModel;
import com.dougb.dougbook.services.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/getNotebooks",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<String> getNotebooks() {
        return notes.listNotebooks();
    }


}
