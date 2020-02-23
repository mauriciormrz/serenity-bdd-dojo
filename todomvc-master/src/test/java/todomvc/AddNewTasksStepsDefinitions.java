package todomvc;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import todomvc.actions.addTasks.AddTaskActions;
import todomvc.actions.addTasks.AddTasksActions;
import todomvc.actions.navigate.NavigationActions;
import todomvc.actions.todolist.TodoListQuestions;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AddNewTasksStepsDefinitions {

    @Steps
    NavigationActions navigate;

    @Steps
    AddTasksActions addTasks;

    @Steps
    AddTaskActions addTask;

    @Steps
    TodoListQuestions theTodoList;

    @Given("^that James has an empty todo list$")
    public void that_James_has_an_empty_todo_list() {

        navigate.toTheApplicationHomePage();
    }


    @When("^s?he adds '(.*)' to (?:his|her) list$")
    public void he_adds_to_his_list(String taskName) throws Exception {

        addTask.withName(taskName);
    }

    @Then("^'(.*)' should be recorded in (?:his|her) list$")
    public void should_be_recorded_in_his_list(String taskName) {

        assertThat(theTodoList.contents()).contains(taskName);
    }


    @Given("^that (?:.*) has a list containing (.*)$")
    public void has_a_list_containing(List<String> tasks) throws Exception {

        navigate.toTheApplicationHomePage();
        addTasks.withNames(tasks);
    }

    @Then("^(?:his|her) todo list should contain (.*)$")
    public void list_should_contain(List<String> tasks) throws Exception {

        assertThat(theTodoList.contents()).hasSameElementsAs(tasks);
    }
}
