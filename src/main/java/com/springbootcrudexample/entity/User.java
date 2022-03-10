package com.springbootcrudexample.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;
    String username;
    @JsonIgnore
    String password;


    public User(String abc, String $2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6, ArrayList<Object> objects) {
    }
}
