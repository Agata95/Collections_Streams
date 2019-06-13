package com.javagda25.zadanie2;

import com.javagda25.zadanie1.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor

public class Programmer {
    private Person person;
    private List<String> languages;
}
