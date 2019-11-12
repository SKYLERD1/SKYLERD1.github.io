/*
Author Name: Skyler Swiderski
Date: 10/17/2019
Program Name: Swiderski_TextAnalzyer
Purpose: In this particular file, it gives a GUI to the Word Count application using the service files.
*/

package week07_textanalyzerGUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Swiderski_GUI_ApplicationClass extends Application {
	public ListView<String> listView1 = new ListView<String>(); // The listView object in the GUI; made public so other methods can access it
	
	public static void main(String[] args) {
		Application.launch(args); // Runs/Calls the GUI
	}
	
	@Override
	public void start(Stage primaryStage) {
		// Create a border pane
		BorderPane mainPane = new BorderPane();
		mainPane.setPadding(new Insets(12.5, 12.5, 12.5, 12.5));
		
		// Create another border pane
		BorderPane borderPane1 = new BorderPane();
		
		// Create a flow pane
		FlowPane flowPane1 = new FlowPane();
		flowPane1.setAlignment(Pos.CENTER);
		flowPane1.setPadding(new Insets(12.5, 12.5, 12.5, 12.5));
		
		// Create another flow pane
		FlowPane flowPane2 = new FlowPane();
		flowPane2.setAlignment(Pos.CENTER);
		
		// Create elements for the panes
		Label label1 = new Label("Word Occurrences GUI:");
		Label label2 = new Label("Results:");
		// ListView listView1 = new ListView();
		Button btnExecute = new Button("Execute"); // create button
		
		// Place nodes in the pane
		borderPane1.setTop(label1);
		borderPane1.setCenter(label2);
		mainPane.setTop(borderPane1);
		flowPane1.getChildren().add(listView1);
		mainPane.setCenter(flowPane1);
		flowPane2.getChildren().add(btnExecute);
		mainPane.setBottom(flowPane2);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(mainPane); // set the scene dimensions
		primaryStage.setTitle("GUI Word Occurrences"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		// Set the action for the button
		btnExecute.setOnAction((e) -> btnExecute());
	}
	
	/**
	 * Displays the word count into the listview object in the GUI
	 */
	public void btnExecute() {
		try {
			int wordCount = 0; // creates and initializes the total word count
			
			Swiderski_CountUtility_ServiceClass counter = new Swiderski_CountUtility_ServiceClass(); // creates a new object from the appropriate service class

			String filename = "E:\\Program Files\\Eclipse\\Workspace\\CEN3024\\src\\week07_textanalyzerGUI\\Mod3_text_analzyer.txt"; // file location
			File file = new File(filename); // creates a file object using the file location said in the parameter
			FileReader file_read = new FileReader(file); // creates a file reader that will use the above file
			BufferedReader reader = new BufferedReader(file_read); // creates a buffer reader that will use the above file reader
			@SuppressWarnings("unused")
			String line; // line representing the line(s) in the file

			List<Swiderski_WordCountResult_ServiceClass> list = null; // creates and initializes the list

			while ((line = reader.readLine()) != null) { // continues looking at each line till there is a line that contains nothing
				list = counter.countWordOccurrences(reader); // sends the word to be counted and added to the list
			}

			for (Swiderski_WordCountResult_ServiceClass result : list) { // Goes through the list and does the following
				wordCount += result.getCount(); // updates the total word count (adding to itself) from each individual word's word count
				listView1.getItems().add(result.toString()); // adds each word and its count on its own line to the listview object
			}
			
			listView1.getItems().add(String.format("Total word count: %d", wordCount)); // displays the total word count
		} catch (Exception ex) { // If there is an error or exception
			listView1.getItems().add("Text Analyzer failed."); // displays error message if the application fails
		}
	}
}
