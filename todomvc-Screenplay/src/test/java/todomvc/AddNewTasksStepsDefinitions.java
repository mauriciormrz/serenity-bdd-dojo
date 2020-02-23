package todomvc;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import todomvc.questions.TheItems;
import todomvc.tasks.AddTodoItem;
import todomvc.tasks.Start;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static org.hamcrest.Matchers.hasItem;

public class AddNewTasksStepsDefinitions {

    @Before
    public void set_the_stage() {

        OnStage.setTheStage(new OnlineCast());
    }


    @Given("^that (.*) has an empty todo list$")
    public void that_the_actor_has_an_empty_todo_list(String actorName) {

        OnStage.theActorCalled(actorName).attemptsTo(Start.withAnEmptyList());
    }


    @When("^s?he adds '(.*)' to (?:his|her) list$")
    public void he_adds_to_his_list(String taskName) throws Exception {

       OnStage.theActorInTheSpotlight().attemptsTo(AddTodoItem.called(taskName));
    }


    @Then("^'(.*)' should be recorded in his list$")
    public void should_be_recorded_in_his_list(String taskName) {

       OnStage.theActorInTheSpotlight().should(seeThat(
               "the items displayed", TheItems.displayed(), hasItem(taskName)
       ));
    }


    @Given("^that (?:.*) has a list containing (.*)$")
    public void has_a_list_containing(List<String> tasks) throws Exception {

    }

    @Then("^(?:his|her) todo list should contain (.*)$")
    public void list_should_contain(List<String> tasks) throws Exception {

    }
}
