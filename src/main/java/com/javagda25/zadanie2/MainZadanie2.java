package com.javagda25.zadanie2;

import com.javagda25.zadanie1.Person;

import java.util.*;
import java.util.stream.Collectors;

public class MainZadanie2 {
    public static void main(String[] args) {
        Person person1 = new Person("Jacek", "Kowalski", 18, true);
        Person person2 = new Person("Jacek", "Górski", 15, true);
        Person person3 = new Person("Andżelika", "Dżoli", 25, false);
        Person person4 = new Person("Wanda", "Ibanda", 12, false);
        Person person5 = new Person("Marek", "Marecki", 17, true);
        Person person6 = new Person("Johny", "Brawo", 25, true);
        Person person7 = new Person("Stary", "Pan", 80, true);
        Person person8 = new Person("Newbie", "Noob", 12, true);
        Person person9 = new Person("Newbies", "Sister", 19, false);

        List<String> languages1 = Arrays.asList("Java;Cobol;Cpp;Lisp".split(";"));
        List<String> languages2 = Arrays.asList("Java;Lisp".split(";"));
        List<String> languages3 = Arrays.asList("Java;Cobol;Cpp;Lisp;C#".split(";"));
        List<String> languages4 = Arrays.asList("C#;C;Cpp".split(";"));
        List<String> languages5 = Arrays.asList("Java;Assembler;Scala;Cobol".split(";"));
        List<String> languages6 = Arrays.asList("Java;Scala".split(";"));
        List<String> languages7 = Arrays.asList("C#;C".split(";"));
        List<String> languages8 = Collections.emptyList();
        List<String> languages9 = Arrays.asList("Java");

        Programmer programmer1 = new Programmer(person1, languages1);
        Programmer programmer2 = new Programmer(person2, languages2);
        Programmer programmer3 = new Programmer(person3, languages3);
        Programmer programmer4 = new Programmer(person4, languages4);
        Programmer programmer5 = new Programmer(person5, languages5);
        Programmer programmer6 = new Programmer(person6, languages6);
        Programmer programmer7 = new Programmer(person7, languages7);
        Programmer programmer8 = new Programmer(person8, languages8);
        Programmer programmer9 = new Programmer(person9, languages9);

        List<Programmer> programmers = Arrays.asList(programmer1, programmer2, programmer3, programmer4, programmer5,
                programmer6, programmer7, programmer8, programmer9);
        System.out.println(programmers);

        // uzyskaj listę programistów, którzy są mężczyznami
        List<Programmer> listOfMan = programmers.stream()
                .filter(p -> p.getPerson().isMale())
                .collect(Collectors.toList());
        listOfMan.forEach(p -> System.out.println(p));

        System.out.println("********************");

        // uzyskaj listę niepełnoletnich programistów (obydwóch płci), którzy piszą w Cobolu
        List<Programmer> listOfYoungCobol = programmers.stream()
                .filter(p -> p.getPerson().getAge() < 18 && p.getLanguages().contains("Cobol"))
                .collect(Collectors.toList());
        listOfYoungCobol.forEach(p -> System.out.println(p));

        System.out.println("********************");

        // uzyskaj listę programistów, którzy znają więcej, niż jeden język programowania
        List<Programmer> listOfProgrammerMore = programmers.stream()
                .filter(p -> p.getLanguages().size() > 1)
                .collect(Collectors.toList());
        listOfProgrammerMore.forEach(p -> System.out.println(p));

        System.out.println("********************");

        // uzyskaj listę programistek, które piszą w Javie i Cpp
        List<Programmer> listOfWomanJavaCpp = programmers.stream()
                .filter(p -> !p.getPerson().isMale() && p.getLanguages().contains("Java") && p.getLanguages().contains("Cpp"))
                .collect(Collectors.toList());
        listOfWomanJavaCpp.forEach(p -> System.out.println(p));

        System.out.println("********************");

        // uzyskaj listę męskich imion
        List<Programmer> listOfManName = programmers.stream()
                .filter(p -> p.getPerson().isMale())
                .collect(Collectors.toList());
        List<String> listOfManName2 = listOfManName.stream()
                .map(p -> p.getPerson().getFirstName())
                .collect(Collectors.toList());

        listOfManName2.forEach(p -> System.out.println(p));

        System.out.println("********************");

        // uzyskaj set wszystkich języków opanowanych przez programistów
        Set<String> setLanguages = programmers.stream()
                .map(p -> p.getLanguages())
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        System.out.println(setLanguages);

        System.out.println("********************");

        // uzyskaj listę nazwisk programistów, którzy znają więcej, niż dwa języki
        List<Programmer> listOfNamesMore = programmers.stream()
                .filter(p -> p.getLanguages().size() > 2)
                .collect(Collectors.toList());
        List<String> listOfNamesMore2 = listOfNamesMore.stream()
                .map(p -> p.getPerson().getLastName())
                .collect(Collectors.toList());
        listOfNamesMore2.forEach(p -> System.out.println(p));

        System.out.println("********************");

        // sprawdź, czy istnieje chociaż jedna osoba, która nie zna żadnego języka
        Optional<Programmer> listOfEmptyLang = programmers.stream()
                .filter(p -> p.getLanguages().size() == 0)
                .findAny();
        if (listOfEmptyLang.isPresent()) {
            System.out.println("Jest chociaż jedna");
        }


        Boolean czyIstnieje = programmers.stream()
                .anyMatch(p -> p.getLanguages().size() == 0);
        System.out.println(czyIstnieje);

        System.out.println("********************");

        // uzyskaj ilość wszystkich języków opanowanych przez programistki
        List<Programmer> setWoman = programmers.stream()
                .filter(p -> !p.getPerson().isMale())
                .collect(Collectors.toList());

        Set<String> setLanguagesWoman = setWoman.stream()
                .map(p -> p.getLanguages())
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        System.out.println(setLanguagesWoman);

    }
}
