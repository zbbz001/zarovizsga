package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kennel {

    private final List<Dog> dogList = new ArrayList<>();

    public void addDog(Dog dog) {
        dogList.add(dog);
    }

    public List<Dog> getDogs() {
        return new ArrayList<>(dogList);
    }

    public void feedAll() {
        dogList.forEach(Dog::feed);
    }

    public Dog findByName(String dogName) {
        for (Dog dog : dogList) {
            if (dogName.equals(dog.getName())) {
                return dog;
            }
        }

        throw new IllegalArgumentException("The dog is not found: " + dogName);
    }

    public void playWith(String dogName, int multiplier) {
        dogList.stream()
                .filter(dog -> dog.getName().equals(dogName))
                .forEach(dog -> dog.play(multiplier));
    }

    public List<String> getHappyDogNames(int minHappiness) {
        return dogList.stream()
                .filter(dog -> dog.getHappiness() > minHappiness)
                .map(Dog::getName)
                .collect(Collectors.toList());
    }
}
