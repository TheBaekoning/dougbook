package com.dougb.dougbook.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Data
public class NoteModel {
    public NoteModel () {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        dateFormat.setTimeZone(timeZone);
        created = dateFormat.format(new Date());
    }


    @Getter @Setter private int id;
    @Getter @Setter private String title;
    @Getter @Setter private String tag;
    @Getter @Setter private String body;
    @Getter private String created;
    @Getter @Setter private String lastModified;


}
