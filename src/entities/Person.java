package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.swing.*;


@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor

public class Person {
    private int id;
    private String name;
    private String familyName;
    private byte[] photo;
    private static int lastId=0;
    public Person() {
        this.id=++lastId;
    }

    @Override
    public String toString() {
        return "Id : "+id+"\nName : "+getName()+"\nFamily Name : "+getFamilyName()+"\nPhoto : "+getPhoto() ;
    }
}

