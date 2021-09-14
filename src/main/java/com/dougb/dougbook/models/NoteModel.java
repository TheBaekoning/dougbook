package com.dougb.dougbook.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

@Getter
@Setter
@ToString
@Entity()
public class NoteModel {
    public NoteModel () {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        dateFormat.setTimeZone(timeZone);
        created = dateFormat.format(new Date());
    }


    @Getter @Setter @Id @GeneratedValue private int id;
    @Getter @Setter private String title;
    @Getter @Setter private String tag;
    @Getter @Setter private String body;
    @Getter private String created;
    @Getter @Setter private String lastModified;

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
