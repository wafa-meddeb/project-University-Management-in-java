package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.swing.*;


@Getter
@Setter
@NoArgsConstructor


public class Person {

    private String name;
    private String familyName;
    private String photo;



    public Person(String name, String familyName, String photo) {
        this.name = name;
        this.familyName = familyName;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "\nName : "+getName()+"\nFamily Name : "+getFamilyName()+"\nPhoto : "+getPhoto() ;
    }
}

