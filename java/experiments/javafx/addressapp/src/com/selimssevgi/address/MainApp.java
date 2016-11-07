package com.selimssevgi.address;/**
 * Created by ssselim on 9/27/16.
 */

import com.selimssevgi.address.model.Person;
import com.selimssevgi.address.view.PersonEditDialogController;
import com.selimssevgi.address.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
  private Stage primaryStage;
  private BorderPane rootLayout;

  private ObservableList<Person> personData = FXCollections.observableArrayList();

  /**
   * Constructor
   */
  public MainApp() {
    // Add some sample data
    personData.add(new Person("Hans", "Muster"));
    personData.add(new Person("Ruth", "Mueller"));
    personData.add(new Person("Heinz", "Kurz"));
    personData.add(new Person("Cornelia", "Meier"));
    personData.add(new Person("Werner", "Meyer"));
    personData.add(new Person("Lydia", "Kunz"));
    personData.add(new Person("Anna", "Best"));
    personData.add(new Person("Stefan", "Meier"));
    personData.add(new Person("Martin", "Mueller"));
  }

  /**
   * Returns the data as an observable list of Persons.
   * @return
   */
  public ObservableList<Person> getPersonData() {
    return personData;
  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("AddressApp");

    initRootLayout();

    showPersonOverview();

  }

  private void showPersonOverview() {
    try {
      // load person overview
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
      AnchorPane personOverview = loader.load();

      // set person overview into the center of root layout
      rootLayout.setCenter(personOverview);

      // give the controller access to the main app
      PersonOverviewController controller = loader.getController();
      controller.setMainApp(this);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * * Opens a dialog to edit details for the specified person. If the user
   * clicks OK, the changes are saved into the provided person object and true
   * is returned.
   *
   * @param person the person object to be edited
   * @return true if the user clicked OK, false otherwise.
   */
  public boolean showPersonEditDialog(Person person) {
    try {
      // Load the fxml file and create a new stage for the popup dialog.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
      AnchorPane page = (AnchorPane) loader.load();

      // Create the dialog Stage.
      Stage dialogStage = new Stage();
      dialogStage.setTitle("Edit Person");
      dialogStage.initModality(Modality.WINDOW_MODAL);
      dialogStage.initOwner(primaryStage);
      Scene scene = new Scene(page);
      dialogStage.setScene(scene);

      // Set the person into the controller.
      PersonEditDialogController controller = loader.getController();
      controller.setDialogStage(dialogStage);
      controller.setPerson(person);

      // Show the dialog and wait until the user closes it
      dialogStage.showAndWait();

      return controller.isOkClicked();
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  private void initRootLayout() {
    try {
      // load root layout from fxml file
      FXMLLoader loader = new FXMLLoader();
      System.out.println(MainApp.class.getResource("view"));
      loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
      rootLayout = loader.load();

      // show the scene containing the root layout
      Scene scene = new Scene(rootLayout);
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Stage getPrimaryStage() {
    return primaryStage;
  }
}
