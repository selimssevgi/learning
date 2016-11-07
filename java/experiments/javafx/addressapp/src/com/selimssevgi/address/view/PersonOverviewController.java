package com.selimssevgi.address.view;

import com.selimssevgi.address.MainApp;
import com.selimssevgi.address.model.Person;
import com.selimssevgi.address.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by ssselim on 9/27/16.
 */
public class PersonOverviewController {

  @FXML
  private TableView<Person> personTable;
  @FXML
  private TableColumn<Person, String> firstNameColumn;
  @FXML
  private TableColumn<Person, String> lastNameColumn;

  @FXML
  private Label firstNameLabel;
  @FXML
  private Label lastNameLabel;
  @FXML
  private Label streetLabel;
  @FXML
  private Label postalCodeLabel;
  @FXML
  private Label cityLabel;
  @FXML
  private Label birthdayLabel;

  // reference to the main application
  private MainApp mainApp;

  /**
   * The constructor
   * The constructor is called before the initialize method
   */
  public PersonOverviewController() {

  }

  /**
   * Initializes the controller class.
   * This method is automatically called
   * after the fxml file has been loaded.
   */
  @FXML
  private void initialize() {
    // initialize the person table with the two columns.
    firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

    // clear the person details
    showPersonDetails(null);

    // listen for selection changes and show the person details when changed
    personTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showPersonDetails(newValue));
  }

  /**
   * Is called by the main application to give a reference back to itself
   */
  public void setMainApp(MainApp mainApp) {
    this.mainApp = mainApp;

    // add observable list data to the table
    personTable.setItems(mainApp.getPersonData());
  }

  /**
   * Fills all text fields to show details about the person
   * If the specified person is null, all text fields are cleared.
   */
  private void showPersonDetails(Person person) {
    if (person != null) {
      // fill the labels with info from the person object
      firstNameLabel.setText(person.getFirstName());
      lastNameLabel.setText(person.getLastName());
      streetLabel.setText(person.getStreet());
      postalCodeLabel.setText(String.valueOf(person.getPostalCode()));
      cityLabel.setText(person.getCity());
      birthdayLabel.setText(DateUtil.format(person.getBirthday()));
    } else {
      // person is null, remove all the text
      firstNameLabel.setText("");
      lastNameLabel.setText("");
      streetLabel.setText("");
      postalCodeLabel.setText("");
      cityLabel.setText("");
      birthdayLabel.setText("");
    }
  }

  /**
   * Called when the user clicks on the delete button
   */
  @FXML
  private void handleDeletePerson() {
    int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
      personTable.getItems().remove(selectedIndex);
    } else {
      // nothing selected
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.initOwner(mainApp.getPrimaryStage());
      alert.setTitle("No Selection");
      alert.setHeaderText("No Person Selected");
      alert.setContentText("Please select a person in the table.");

      alert.showAndWait();
    }
  }

  /**
   * Called when the user clicks the new button. Opens a dialog to edit
   * details for a new person.
   */
  @FXML
  private void handleNewPerson() {
    Person tempPerson = new Person();
    boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
    if (okClicked) {
      mainApp.getPersonData().add(tempPerson);
    }
  }

  /**
   * Called when the user clicks the edit button. Opens a dialog to edit
   * details for the selected person.
   */
  @FXML
  private void handleEditPerson() {
    Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
    if (selectedPerson != null) {
      boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
      if (okClicked) {
        showPersonDetails(selectedPerson);
      }

    } else {
      // Nothing selected.
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.initOwner(mainApp.getPrimaryStage());
      alert.setTitle("No Selection");
      alert.setHeaderText("No Person Selected");
      alert.setContentText("Please select a person in the table.");

      alert.showAndWait();
    }
  }
}
