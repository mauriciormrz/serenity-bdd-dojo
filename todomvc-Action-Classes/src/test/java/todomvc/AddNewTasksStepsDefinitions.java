package todomvc;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import todomvc.steps.TodoListUser;

import java.util.List;

public class AddNewTasksStepsDefinitions {


    @Steps
    TodoListUser todoUser;


    @Given("^that James has an empty todo list$")
    public void that_James_has_an_empty_todo_list() {

        todoUser.startsWithAnEmptyTodoList();
    }


    @When("^s?he adds '(.*)' to (?:his|her) list$")
    public void he_adds_to_his_list(String taskName) throws Exception {

        todoUser.adds_a_task(taskName);
    }

    @Then("^'(.*)' should be recorded in his list$")
    public void should_be_recorded_in_his_list(String taskName) {

        todoUser.should_see_task(taskName);
    }


    @Given("^that (?:.*) has a list containing (.*)$")
    public void has_a_list_containing(List<String> tasks) throws Exception {

        todoUser.startsWithAnEmptyTodoList();
        tasks.forEach(
                task -> todoUser.adds_a_task(task)
        );
    }

    @Then("^(?:his|her) todo list should contain (.*)$")
    public void list_should_contain(List<String> tasks) throws Exception {
        todoUser.should_see_tasks(tasks);
    }
}
