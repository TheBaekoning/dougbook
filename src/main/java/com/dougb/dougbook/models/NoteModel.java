package com.dougb.dougbook.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Getter
@Setter
@ToString
@Entity()
public class NoteModel {
    public NoteModel () {
       /** TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        dateFormat.setTimeZone(timeZone);
        created = dateFormat.format(new Date());**/
    }

    public NoteModel(long id, String title, String body, String created, String lastModified, String notebook) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.created = created;
        this.lastModified = lastModified;
        this.notebook = notebook;
    }


    @Column(updatable = false) @Id @GeneratedValue private long id;
    @Getter @Setter @Column(nullable = false)  private String title;
    @ElementCollection @Column(nullable = false) private List<String> tag = new ArrayList<>();
    @Getter @Setter @Column(nullable = false) private String body;
    private @Column(nullable = false, updatable = false) String created;
    @Getter @Setter private String lastModified;
    @Column(nullable = false) private String notebook;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NoteModel noteModel = (NoteModel) o;
        return Objects.equals(id, noteModel.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
