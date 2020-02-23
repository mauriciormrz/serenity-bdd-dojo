package todomvc.ui;


import net.serenitybdd.screenplay.targets.Target;

public class TodoList {

    public final static Target NEW_TODO = Target.the("New Todo Field")
            .locatedBy(".new-todo");

    public final static Target ITEMS = Target.the("Todo items")
            .locatedBy(".todo-list li");

}
