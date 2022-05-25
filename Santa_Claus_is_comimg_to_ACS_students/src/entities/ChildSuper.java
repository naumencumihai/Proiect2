package entities;

import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.List;

public class ChildSuper {
    protected int id;
    protected String lastName;
    protected String firstName;
    protected Cities city;
    protected int age;
    protected List<Category> giftsPreferences = new ArrayList<>();

    public ChildSuper() { }

    public void addToGiftPreferences(Category category) {
        if (this.giftsPreferences.contains(category)) {
            giftsPreferences.remove(category);
        }
        this.giftsPreferences.add(0, category);
    }

    public void increaseAge() {
        this.age += 1;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public Cities getCity() {
        return city;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }
}
