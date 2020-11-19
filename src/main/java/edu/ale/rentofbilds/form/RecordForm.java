package edu.ale.rentofbilds.form;

import edu.ale.rentofbilds.model.Build;
import edu.ale.rentofbilds.model.Client;

import java.time.LocalDateTime;

public class RecordForm {
    private String id = "";
    private String name = "";
    private String description = "";
    private String start = "";
    private String finish = "";
    private String client = "";
    private String build = "";
    private String created_at = "";
    private String modified_at = "";

    public RecordForm() {
    }

    public RecordForm(String name, String description, String start, String finish, String client, String build) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.client = client;
        this.build = build;
    }

    public RecordForm(String id, String name, String description, String start, String finish, String client, String build, String created_at, String modified_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.client = client;
        this.build = build;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

}
