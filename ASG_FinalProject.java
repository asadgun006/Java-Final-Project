package FinalProject;
/**
//***********************************************************************
'Project: Capstone Project
'Programmer: Asad Sohail Gundra
'Company Info: asadgundra60@gmail.com
'Description:  Problem Number 1
'    
	This program creates a javafx application that is based on the 
	SubstitutionCipher and ShuffleCipher classes. It asks the user for 
	a text and an integer value and then displays the manipulated string.
'
'	--------------------------------------------------------------------------
'   							HONOR CODE: 
'	I pledge that this program represents my own program code, I have received 
'	help from no one and I have given help to no one.
'	
'								Asad Sohail Gundra
'-----------------------------------------------------------------------------
'
'  LINE LENGTH - AVOID LINES LONGER THAN 80 CHARACTERS
'  SCALE BELOW IS TO CALIBRATE SCREENSHOTS
'  DO NOT HAVE YOUR CODE OR SCREENSHOT EXTEND BEYOND THE SCALE
0........1.........2.........3.........4.........5.........6.........7.........8
12345678901234567890123456789012345678901234567890123456789012345678901234567890
*/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.geometry.Insets;


public class ASG_FinalProject extends Application{

	/**
	 * Main method for launching the program
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		//creates a main layout for the scene graph
		BorderPane newMain = new BorderPane();
		//creates a layout for getting and displaying the information for the user.
		GridPane mainLayout = new GridPane();
		//these control ask the user to select the type of cipher they want to perform
		Label selectionLabel = new Label("Choose the type of Cipher:");
		RadioButton encodeOption = new RadioButton("Substitution Cipher");
		RadioButton encodeOption2 = new RadioButton("Shuffle Cipher");
		//confirmation button for the ciphers
		Button confirmButton = new Button("Confirm!");
		//these statements ask the user for the type of operation to perform on the string
		Label msgOption = new Label("Select if you want to encode or decode:");
		RadioButton selectEncode = new RadioButton("Encode");
		RadioButton selectDecode = new RadioButton("Decode");
		//creates a toggle group for the cipher buttons so that only one of them may
		//be selected at one time
		ToggleGroup buttonToggle = new ToggleGroup();
		//adds the buttons to the toggle group
		encodeOption.setToggleGroup(buttonToggle);
		encodeOption2.setToggleGroup(buttonToggle);
		//creates a toggle group for the encode and decode buttons
		ToggleGroup optionToggle = new ToggleGroup();
		//adds the buttons to the toggle group
		selectEncode.setToggleGroup(optionToggle);
		selectDecode.setToggleGroup(optionToggle);
		//this HBox is displayed for getting user choice when SubstitutionCipher is selected
		HBox secondView = new HBox(5);
		//this HBox is displayed for getting user choice when ShuffleCipher is selected
		HBox secondView2 = new HBox(5);  
		
		//a text field for displaying the ciphered text
		TextField displayText = new TextField();
		displayText.setEditable(false);
		

		//the main event handler after the type of cipher is selected
		confirmButton.setOnAction(new EventHandler<ActionEvent>() {
			//stores the number of messages encoded
			int encodeCount = 0;
			//stores the number of messages decoded
			int decodeCount = 0;
			
			/**
			 * This main handle method displays the information based on the cipher selected
			 */
			public void handle(ActionEvent evt) {
				//displays and adds the secondView HBox when first option is selected
				//It is also responsible for creating other handlers if the first option
				//is selected
				if (encodeOption.isSelected()) {
					secondView.getChildren().addAll(msgOption, selectEncode, selectDecode);
					mainLayout.add(secondView, 0, 3);
					//creates a confirmation button for encoding and adds it to the mainlayout
					Button enterButton1 = new Button("Enter");
					mainLayout.add(enterButton1, 0, 4);
					
					/**
					 * This lambda expression is a handler for the enterButton1. It asks the
					 * user to enter the information and adds the controls to the mainLayout.
					 */
					enterButton1.setOnAction(event -> {
						//displays information if the user wished to encode the message and 
						//adds it to the layout
						if (selectEncode.isSelected()) {
							Label messageLabel1 = new Label("Enter the message:");
							TextField messageField2 = new TextField();
							Label numLabel1 = new Label("Enter the number for shift:");
							TextField numField2 = new TextField(); 
							mainLayout.add(messageLabel1, 0, 5);
							mainLayout.add(messageField2, 1, 5);
							mainLayout.add(numLabel1, 0, 6);
							mainLayout.add(numField2, 1, 6);
							//button for generating the message for the user
							Button enterButton = new Button("Generate Message");
							//adds the button to the layout
							mainLayout.add(enterButton, 0, 7);
							//creates a handler for the enterButton
							enterButton.setOnAction(new EventHandler<ActionEvent>() {
								/**
								 * This method gets the value from each of the text fields and
								 * passes it to an instance created from the SubstitutionCipher
								 * class. The class also displays the message and the total number
								 * of messages encoded or decoded.
								 * @param arg0
								 */
								@Override
								public void handle(ActionEvent arg0) {
									String shiftValue = numField2.getText();
									int shiftNum = Integer.parseInt(shiftValue);
									SubstitutionCipher myCipher = new SubstitutionCipher(shiftNum);
									String message = myCipher.encode(messageField2.getText());
									encodeCount++;
									displayText.setText(message);
									mainLayout.add(displayText, 0, 9);
									Label numEncoded = new Label("Messsages Encoded: " + encodeCount);
									Label numDecoded = new Label("Messages Decoded: " + decodeCount);
									mainLayout.add(numEncoded, 0, 10);
									mainLayout.add(numDecoded, 0, 11);
									//creates a button that asks the user if they want to cipher again
									//and adds it to the layout
									Button reButton = new Button("Click to Cipher again");
									mainLayout.add(reButton, 0, 12);
									//handler for the reButton where it erases the mainLayout and displays just
									//the choice for cipher
									reButton.setOnAction(e -> {
										mainLayout.getChildren().clear();
										secondView.getChildren().clear();
									});

								}

							});

						}
						//this conditional displays the information if the user wishes to decode the message
						if (selectDecode.isSelected()) {
							//labels and text fields for the user to enter information
							Label messageLabel1 = new Label("Enter the message:");
							TextField messageField2 = new TextField();
							Label numLabel1 = new Label("Enter the number for shift:");
							TextField numField2 = new TextField();
							//adds the controls to the mainLayout
							mainLayout.add(messageLabel1, 0, 5);
							mainLayout.add(messageField2, 1, 5);
							mainLayout.add(numLabel1, 0, 6);
							mainLayout.add(numField2, 1, 6);
							//button for the generating the message
							Button enterButton = new Button("Generate Message");
							//adds the button to the mainLayout
							mainLayout.add(enterButton, 0, 7);
							/**
							 * Handler method for the enterButton that gets the value from each
							 * of the text fields and passes it to the instance created from
							 * the SubstitutionCipher class. It also displays the message in 
							 * a text field, along with the number of messages encoded and decoded.
							 */
							enterButton.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent arg0) {
									String shiftValue = numField2.getText();
									int shuffleNum = Integer.parseInt(shiftValue);
									SubstitutionCipher myCipher = new SubstitutionCipher(shuffleNum);
									String message = myCipher.decode(messageField2.getText());
									decodeCount++;
									displayText.setText(message);
									mainLayout.add(displayText, 0, 9);
									Label numEncoded = new Label("Messsages Encoded: " + encodeCount);
									Label numDecoded = new Label("Messages Decoded: " + decodeCount);
									mainLayout.add(numEncoded, 0, 10);
									mainLayout.add(numDecoded, 0, 11);
									//creates a button that asks the user if they want to cipher again
									//and adds it to the layout
									Button reButton = new Button("Click to Cipher again");
									mainLayout.add(reButton, 0, 12);
									//handles the action for the button and erases the layouts for getting
									//another cipher
									reButton.setOnAction(e -> {
										mainLayout.getChildren().clear();
										secondView2.getChildren().clear();
									});

								}

							});
						}
					});
				}

				//this conditional statement executes various operations if the user chooses
				//to select ShuffleCipher.
				if (encodeOption2.isSelected()) {

					//adds the HBox to the mainLayout
					secondView2.getChildren().addAll(msgOption, selectEncode, selectDecode);
					mainLayout.add(secondView2, 0, 3);
					//creates a button for entering user choice and adds it to the layout
					Button enterButton1 = new Button("Enter");
					mainLayout.add(enterButton1, 0, 4);
					//creates a new EventHandler for responding to the user choice
					enterButton1.setOnAction(new EventHandler<ActionEvent>() {

						/**
						 * Handler method that displays information based on the choice
						 * of the user
						 * @param evt
						 */
						@Override
						public void handle(ActionEvent evt) {
							//this conditional statement executes various operations if the user 
							//decides to encode the text
							if (selectEncode.isSelected()) {
								//creates controls for user to enter information
								Label messageLabel1 = new Label("Enter the message:");
								TextField messageField2 = new TextField();
								Label numLabel1 = new Label("Enter the number for shuffle:");
								TextField numField2 = new TextField();
								//adds the controls to the layout
								mainLayout.add(messageLabel1, 0, 5);
								mainLayout.add(messageField2, 1, 5);
								mainLayout.add(numLabel1, 0, 6);
								mainLayout.add(numField2, 1, 6);
								//button for generating the message
								Button enterButton = new Button("Generate Message");
								//adds the button to the layout
								mainLayout.add(enterButton, 0, 7);
								/**
								 * This handler method responds to the enterButton. It gets the
								 * value from the text fields and passes it into an instance created
								 * from the ShuffleCipher class. It then displays the message along 
								 * with the number of messages encoded or decoded by the user.
								 */
								enterButton.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent arg0) {
										String shuffleValue = numField2.getText();
										int shuffleNum = Integer.parseInt(shuffleValue);
										ShuffleCipher myCipher = new ShuffleCipher(shuffleNum);
										String message = myCipher.encode(messageField2.getText());
										encodeCount++;
										displayText.setText(message);
										mainLayout.add(displayText, 0, 9);
										Label numEncoded = new Label("Messsages Encoded: " + encodeCount);
										Label numDecoded = new Label("Messages Decoded: " + decodeCount);
										mainLayout.add(numEncoded, 0, 10);
										mainLayout.add(numDecoded, 0, 11);
										//button that asks the user if they want to perform another cipher
										Button reButton = new Button("Click to Cipher again");
										//adds the button to the layout
										mainLayout.add(reButton, 0, 12);
										//handler that responds to the reButton. It erases the mainLayout and
										//displays the cipher options for the user.
										reButton.setOnAction(e -> {
											mainLayout.getChildren().clear();
											secondView2.getChildren().clear();
										});

									}

								});

							}
							//this conditional statement executes various operations if the user 
							//decides to decode the text
							if (selectDecode.isSelected()) {
								//creates controls for the user to enter information
								Label messageLabel1 = new Label("Enter the message:");
								TextField messageField2 = new TextField();
								Label numLabel1 = new Label("Enter the number for shuffle:");
								TextField numField2 = new TextField();
								//adds the controls to the mainLayout
								mainLayout.add(messageLabel1, 0, 5);
								mainLayout.add(messageField2, 1, 5);
								mainLayout.add(numLabel1, 0, 6);
								mainLayout.add(numField2, 1, 6);
								//button for generating the message
								Button enterButton = new Button("Generate Message");
								//adds the button to the layout
								mainLayout.add(enterButton, 0, 7);
								/**
								 * This EventHandler responds to the enterButton. It gets the
								 * value from the text fields and passes it into an instance created
								 * from the ShuffleCipher class. It then displays the message along 
								 * with the number of messages encoded or decoded by the user.
								 */
								enterButton.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent arg0) {
										String shuffleValue = numField2.getText();
										int shuffleNum = Integer.parseInt(shuffleValue);
										ShuffleCipher myCipher = new ShuffleCipher(shuffleNum);
										String message = myCipher.decode(messageField2.getText());
										decodeCount++;
										displayText.setText(message);
										mainLayout.add(displayText, 0, 9);
										Label numEncoded = new Label("Messsages Encoded: " + encodeCount);
										Label numDecoded = new Label("Messages Decoded: " + decodeCount);
										mainLayout.add(numEncoded, 0, 10);
										mainLayout.add(numDecoded, 0, 11);
										//button that asks the user if they want to perform another cipher
										Button reButton = new Button("Click to Cipher again");
										//adds the button to the layout
										mainLayout.add(reButton, 0, 12);
										//a lambda expression that responds to the reButton. It erases the 
										//mainLayout and displays the cipher options for the user
										reButton.setOnAction(e -> {
											mainLayout.getChildren().clear();
											secondView2.getChildren().clear();
										});

									}

								});
							}
						}
					});
				}
			}
		});
		
		//creates a new Hbox and adds the selectionLabel and encode options to it
		HBox myBox = new HBox(5);
		myBox.setPadding(new Insets(5));
		myBox.getChildren().addAll(selectionLabel, encodeOption, encodeOption2);
		//adds the confirm button to the left of the BorderPane layout
		newMain.setLeft(confirmButton);
		//adds myBox HBox to the Top of the BorderPane layout
		newMain.setTop(myBox);
		//adds the mainLayout to the center of the BorderPane layout
		newMain.setCenter(mainLayout);
		//sets the padding and gaps for the mainLayout
		mainLayout.setVgap(5);
		mainLayout.setHgap(5);
		mainLayout.setPadding(new Insets(5));
		//adds padding to the BorderPane layout
		newMain.setPadding(new Insets(5));
		//adds the newMain BorderPane layout to the scene and specifies the dimensions
		Scene scene = new Scene(newMain, 600, 500);
		//sets the scene for the window
		stage.setScene(scene);
		//creates the title for the window
		stage.setTitle("String Cipher");
		//shows the stage window in the screen
		stage.show();
	}
}
