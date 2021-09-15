package com.dougb.dougbook;

import com.dougb.dougbook.controllers.NotebookController;
import com.dougb.dougbook.models.NoteModel;
import com.dougb.dougbook.services.Notes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(NotebookController.class)
public class NotebookControllerTests {
    @MockBean
    private Notes mockNotes;

    @Autowired
    private NotebookController controller;

    @Test
    public void CreateNoteSuccess() {
        // arrange
        NoteModel expected = new NoteModel();
        expected.setId(1);
        expected.setTitle("testTitle");
        expected.setBody("testBody");
        expected.setNotebook("testNotebook");

        NoteModel actual = new NoteModel();
        actual.setId(1);
        actual.setTitle("testTitle");
        actual.setBody("testBody");
        actual.setNotebook("testNotebook");

        when(mockNotes.createNote(expected)).thenReturn(actual);

        // act

        NoteModel result = controller.createNewNote(expected);

        // assert

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void GetNoteByIdSuccess() {
        // arrange
        NoteModel expected = new NoteModel();
        expected.setId(1);
        expected.setTitle("testTitle");
        expected.setBody("testBody");
        expected.setNotebook("testNotebook");

        NoteModel actual = new NoteModel();
        actual.setId(1);
        actual.setTitle("testTitle");
        actual.setBody("testBody");
        actual.setNotebook("testNotebook");

        String id = String.valueOf(expected.getId());

        when(mockNotes.retrieveNoteById(String.valueOf(expected.getId()))).thenReturn(actual);

        // act

        NoteModel result = controller.getNoteById((String.valueOf(expected.getId())));

        // assert

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void GetNotebookSuccess() {
        // arrange
        List<NoteModel> actualList = new ArrayList<>();
        List<NoteModel> expectedList = new ArrayList<>();

        NoteModel actual;
        NoteModel expected;
        String expectedNotebook = "testNotebook";

        for (int i=0; i < 3; i++) {
            actual = new NoteModel();
            actual.setId(i);
            actual.setTitle("testTitle");
            actual.setBody("testBody");
            actual.setNotebook(expectedNotebook);

            expected = new NoteModel();
            expected.setId(i);
            expected.setTitle("testTitle");
            expected.setBody("testBody");
            expected.setNotebook(expectedNotebook);

            actualList.add(actual);
            expectedList.add(expected);
        }


        when(mockNotes.listNotes(expectedNotebook)).thenReturn(actualList);

        // act

        List<NoteModel> result = controller.getNotebook(expectedNotebook);

        // assert

        for (int i=0; i < 3; i++){
            Assertions.assertEquals(expectedList.get(i), result.get(i));
        }
    }

    @Test
    public void GetListOfNotebookSuccess() {
        // arrange
        List<String> actualList = new ArrayList<>();
        List<String> expectedList = new ArrayList<>();


        String expectedNotebook = "testNotebook";

        for (int i=0; i < 3; i++) {
            actualList.add("testTitle"+i);
            expectedList.add("testTitle"+i);
        }


        when(mockNotes.listNotebooks()).thenReturn(actualList);

        // act

        List<String> result = controller.getNotebooks();

        // assert

        for (int i=0; i < 3; i++){
            Assertions.assertEquals(expectedList.get(i), result.get(i));
        }
    }

    @Test
    public void GetNotebookWithTagSuccess() {
        // arrange
        List<NoteModel> actualList = new ArrayList<>();
        List<NoteModel> expectedList = new ArrayList<>();
        List<String> tags = new ArrayList<>();

        tags.add("test");

        NoteModel actual;
        NoteModel expected;
        String expectedNotebook = "testNotebook";
        String expectedTag = "test";

        for (int i=0; i < 3; i++) {
            actual = new NoteModel();
            actual.setId(i);
            actual.setTitle("testTitle");
            actual.setBody("testBody");
            actual.setNotebook(expectedNotebook);
            actual.setTag(tags);

            expected = new NoteModel();
            expected.setId(i);
            expected.setTitle("testTitle");
            expected.setBody("testBody");
            expected.setNotebook(expectedNotebook);
            expected.setTag(tags);

            actualList.add(actual);
            expectedList.add(expected);
        }


        when(mockNotes.filterNotes(expectedNotebook, expectedTag)).thenReturn(actualList);

        // act

        List<NoteModel> result = controller.getNotesByTag(expectedNotebook, expectedTag);

        // assert

        for (int i=0; i < 3; i++){
            Assertions.assertEquals(expectedList.get(i), result.get(i));
        }
    }
}
