package com.springboot.mysql.demo.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="PersonID")
        private long id;

        private String NAME;
        private int AGE;
        private String SEX;
        private long CONTACT_NUMBER;

}
