package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.swing.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Person {
    private int Id;
    private String Name;
    private String FamilyName;
    private ImageIcon Photo;
}
