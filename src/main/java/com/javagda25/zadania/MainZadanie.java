package com.javagda25.zadania;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainZadanie {
    public static void main(String[] args) {
        Person person1 = new Person("Jacek", "Kowalski", 18, true);
        Person person2 = new Person("Jacek", "Górski", 15, true);
        Person person3 = new Person("Andżelika", "Dżoli", 25, false);
        Person person4 = new Person("Wanda", "Ibanda", 12, false);
        Person person5 = new Person("Marek", "Marecki", 17, true);
        Person person6 = new Person("Johny", "Brawo", 25, true);
        Person person7 = new Person("Stary", "Pan", 80, true);
        Person person8 = new Person("Newbie", "Noob", 12, true);
        Person person9 = new Person("Bewbies", "Sister", 19, false);
        List<Person> list = new ArrayList<Person>(Arrays.asList(
                person1,
                person2,
                person3,
                person4,
                person5,
                person6,
                person7,
                person8,
                person9
        ));

        // wypisz liste mezczyzn
        list.stream()
                .filter(element -> element.isMale())
                .forEach(wyswietl -> System.out.println(wyswietl));

        System.out.println("*******");

        // uzyskaj listę dorosłych kobiet
        list.stream()
                .filter(p -> !p.isMale())
                .filter(p -> (p.getAge() >= 18))
                .forEach(wyswietl -> System.out.println(wyswietl));

        System.out.println("*******");

        // uzyskaj listę mężczyzn (collect)
        List<Person> listOfMan = list.stream()
                .filter(element -> element.isMale())
                .collect(Collectors.toList());
        listOfMan.forEach(person -> System.out.println(person));

        System.out.println("*******");

        // uzyskaj listę dorosłych kobiet których imie zaczyna się od "B" (filter)
        List<Person> listOfAdultWoman = list.stream()
                .filter(p -> ((!p.isMale()) && (p.getAge() >= 18) && p.getFirstName().startsWith("B")))
                .collect(Collectors.toList());
        listOfAdultWoman.forEach(person -> System.out.println(person));

        System.out.println("*******");

        // uzyskaj Optional<Person> z dorosłym Jackiem findAny/findfirst
        Optional<Person> adultJacek = list.stream()
                .filter(p -> (p.getAge() >= 18) && p.getFirstName().equalsIgnoreCase("Jacek"))
                .findFirst();
        if (adultJacek.isPresent()) {
            System.out.println(adultJacek.get());
        }

        System.out.println("*******");

        // mapowanie
        // lista imion
        List<String> namesCollections = list.stream()
                .map(person -> person.getFirstName())
                .collect(Collectors.toList());

        System.out.println("*******");

        // to samo dla SET
        Set<String> lastNameCollections = list.stream()
                .map(person -> person.getLastName())
                .collect(Collectors.toSet());

        System.out.println("*******");

        // lista wartości Integer
        List<Integer> wiekOsob = list.stream()
                .map(person -> person.getAge()).collect(Collectors.toList());
//        wiekOsob.forEach(person -> System.out.println(person));

        System.out.println("*******");

        OptionalDouble ageStream = list.stream()
                .mapToInt(people -> people.getAge()).average();
        if(ageStream.isPresent()){
            System.out.println("Średnia wieku: " + ageStream.getAsDouble());
        }

        // lista unikalnych imion
    }


}
