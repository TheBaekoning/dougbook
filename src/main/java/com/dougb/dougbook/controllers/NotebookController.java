package com.dougb.dougbook.controllers;

import com.dougb.dougbook.models.NoteModel;
import com.dougb.dougbook.services.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/notebook")
public class NotebookController {

    @Autowired
    private Notes notes;

    @RequestMapping(value = "/createNote",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    public NoteModel createNewNote(@RequestBody NoteModel note) {
        return notes.createNote(note);
    }

    @RequestMapping(value = "/updateNote",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    public Object updateNote(@RequestBody NoteModel note) {
        if (notes.updateNote(note) == null)
            return new ResponseEntity<>("ERROR: Invalid Note ID", HttpStatus.BAD_REQUEST);
        return notes.updateNote(note);
    }

    @RequestMapping(value = "/getNotebooks",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<String> getNotebooks() {
        return notes.listNotebooks();
    }

    @RequestMapping(value = "/getNotebook/{notebook}",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<NoteModel> getNotebooks(@PathVariable String notebook) {
        return notes.listNotes(notebook);
    }

    @RequestMapping(value = "/getNotebook/{notebook}/{tag}",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<NoteModel> getNotesByTag(@PathVariable String notebook, @PathVariable String tag){
        return notes.filterNotes(notebook, tag);
    }

    @RequestMapping(value = "/getNote/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public NoteModel getNoteById(@PathVariable String id){
        return notes.retrieveNoteById(id);
    }

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteNote(@PathVariable long id) {
        notes.deleteNote(id);
        return ResponseEntity.noContent().build();
    }



}
