package com.dougb.dougbook.repositories;

import com.dougb.dougbook.models.NoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<NoteModel, Long> {
}