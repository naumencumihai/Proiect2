package strategy;

import entities.Child;
import main.App;
import storage.Children;

import java.util.List;

public interface Strategy {
    Children getChildrenThisYear(App app, int year);
}
