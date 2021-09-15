package com.dougb.dougbook.repositories;

import com.dougb.dougbook.models.NoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<NoteModel, Long> {
    @Query(value = "SELECT DISTINCT notebook FROM NoteModel")
    List<String> retrieveAllNotebooks();

    @Query(value = "SELECT DISTINCT a FROM NoteModel a JOIN a.tag WHERE notebook = :#{#notebookName}")
    List<NoteModel> getNotesByNotebook(@Param("notebookName") String notebookName);

    @Query(value = "SELECT DISTINCT * FROM NOTE_MODEL JOIN NOTE_MODEL_TAG WHERE NOTE_MODEL_TAG.NOTE_MODEL_ID = id AND NOTEBOOK = ?1 AND TAG = ?2", nativeQuery = true)
    List<NoteModel> getNotesByTag(String notebookName,  String tagName);

    @Query(value = "SELECT * FROM NOTE_MODEL WHERE ID = ?1", nativeQuery = true)
    NoteModel getNoteById(String id);
}