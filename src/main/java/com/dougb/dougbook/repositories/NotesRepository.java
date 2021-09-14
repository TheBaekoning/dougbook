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

    @Query(value = "SELECT id, body, title FROM NoteModel WHERE notebook = :#{#notebookName} ")
    List<String> getNotesByNotebook(@Param("notebookName") String notebookName);

}