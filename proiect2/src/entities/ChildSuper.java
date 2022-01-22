package entities;

import enums.Category;
import enums.Cities;

import java.util.List;

public abstract class ChildSuper {
    protected int id;
    protected String lastName;
    protected String firstName;
    protected int age;
    protected Cities city;
    protected List<Category> giftsPreferences;

    public ChildSuper() { }
}
