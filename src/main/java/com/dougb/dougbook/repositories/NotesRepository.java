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

    @Query(nativeQuery = true, value = "SELECT DISTINCT * FROM NOTE_MODEL JOIN NOTE_MODEL_TAG WHERE NOTE_MODEL_TAG.NOTE_MODEL_ID = id AND TAG = :#{#tagName} AND NOTEBOOK = :#{#notebookName}")
    List<String> getNotesByTag(@Param("notebookName") String notebookName, @Param("tagName") String tagName);
}