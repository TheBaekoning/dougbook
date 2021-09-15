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

    /**
     * Creates a new note with proper JSON body of type NoteModel
     * @param note - Request body of type NoteModel to be created
     * @return - created note
     */
    @RequestMapping(value = "/createNote",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    public NoteModel createNewNote(@RequestBody NoteModel note) {
        return notes.createNote(note);
    }

    /**
     * Updates an existing note. The null check is if the note does not exist(DNE), if it DNE then returns BAD REQUEST
     * @param note - Request body of type NoteModel to be updated
     * @return - returns newly updated note if successful
     */
    @RequestMapping(value = "/updateNote",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    public Object updateNote(@RequestBody NoteModel note) {
        if (notes.updateNote(note) == null)
            return new ResponseEntity<>("ERROR: Invalid Note ID", HttpStatus.BAD_REQUEST);
        return notes.updateNote(note);
    }

    /**
     * Gets a list of notebooks that currently exists
     * @return - list of notebooks
     */
    @RequestMapping(value = "/getNotebooks",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<String> getNotebooks() {
        return notes.listNotebooks();
    }

    /**
     * Gets all notes within a notebook
     * @param notebook - string name of notebook to look up
     * @return - list of notes within a notebook
     */
    @RequestMapping(value = "/getNotebook/{notebook}",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<NoteModel> getNotebooks(@PathVariable String notebook) {
        return notes.listNotes(notebook);
    }

    /**
     * Filters notes by tag of a given notebook
     * @param notebook - notebook of which the notes are associated with
     * @param tag - filters notes by tag within the notebook
     * @return - returns list of notes filtered by tag within the given notebook
     */
    @RequestMapping(value = "/getNotebook/{notebook}/{tag}",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<NoteModel> getNotesByTag(@PathVariable String notebook, @PathVariable String tag) {
        return notes.filterNotes(notebook, tag);
    }

    /**
     * Retrieves a note
     * @param id - the ID of the note to be retrieved
     * @return - returns a note
     */
    @RequestMapping(value = "/getNote/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public NoteModel getNoteById(@PathVariable String id) {
        return notes.retrieveNoteById(id);
    }

    /**
     * Deletes a note
     * @param id - ID of note to be deleted
     * @return - returns No Content if successful
     */
    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteNote(@PathVariable long id) {
        notes.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}
