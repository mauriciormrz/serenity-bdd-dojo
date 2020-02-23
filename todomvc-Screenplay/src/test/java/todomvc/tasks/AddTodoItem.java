package todomvc.tasks;

import net.bytebuddy.asm.Advice;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import todomvc.ui.TodoList;



public class AddTodoItem implements Task {

    private final String thingToDo;

    public AddTodoItem(String thingToDo) {
        this.thingToDo = thingToDo;
    }

    public static Performable called(String taskName) {
        return Instrumented.instanceOf(AddTodoItem.class)
                .withProperties(taskName);
    }

    @Override
    @Step("{0} adds a todo item called #thingToDo ")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(thingToDo).into(TodoList.NEW_TODO)
                .thenHit(Keys.RETURN)
        );
    }
}
