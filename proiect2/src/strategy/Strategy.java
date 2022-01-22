package strategy;

import entities.Child;
import main.App;

import java.util.List;

public interface Strategy {
    List<Child> getChildrenThisYear(App app);
}
