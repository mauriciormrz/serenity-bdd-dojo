package todomvc.actions.addTasks;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class AddTasksActions {

    @Steps
    AddTaskActions addTaskActions;

    @Step("Add tasks: {0}")
    public void withNames(List<String> tasks) {

        tasks.forEach(
                task -> addTaskActions.withName(task)
        );
    }
}
