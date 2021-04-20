
/*TABLE OF CONTENTS
1. SETUP TEXT FIELD
2. SETUP BUTTONS
3. SETUP LABELS
4. SETUP VBOX
5. SETUP KEY ENTER EVENT
6. SETUP ADD BUTTON LAMBDA EVENT
7. SETUP LARGEST BUTTON LAMBDA EVENT
8. SETUP SMALLEST BUTTON LAMBDA EVENT
9. SETUP CLEAR BUTTON LAMBDA EVENT
*/


package generic_array_list2;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Generic_array_list2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MyList myList=new MyList<>();
        String empty_array_list="--Empty Array List--";
        
//                                1. SETUP TEXT FIELD
        TextField array_input=new TextField();
        array_input.setAlignment(Pos.CENTER);
        array_input.setMaxWidth(250);
        array_input.setPromptText("--Click Here to Type--");
        array_input.setFocusTraversable(false);
        
//                                2. SETUP BUTTONS
        Button add_string_btn=new Button("ADD");
        Button largest_btn = new Button("GET LARGEST");
        Button smallest_btn = new Button("GET SMALLEST");
        Button clear_btn=new Button("CLEAR");
        
//                                3. SETUP LABELS
        Label array_input_print=new Label(empty_array_list);
        array_input_print.setMaxWidth(400);
        array_input_print.setAlignment(Pos.CENTER);
        
        Label largest_label=new Label();
        largest_label.setAlignment(Pos.CENTER);
        largest_label.setPadding(new Insets(8));
        
        Label smallest_label=new Label();
        smallest_label.setAlignment(Pos.CENTER);
        smallest_label.setPadding(new Insets(8));
        
        
//                                4. SETUP VBOX
        VBox vbox=new VBox(array_input, add_string_btn, array_input_print, 
                            largest_btn, largest_label, smallest_btn, smallest_label, clear_btn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(15);
        Scene scene = new Scene(vbox, 600, 600);
        scene.getStylesheets().add("styles.css");
        
//                                5. SETUP KEY ENTER EVENT
        scene.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if (array_input.getText().equals("")){                                  //if text field is empty, error
                array_input_print.setText("Enter Something");                           //set label to error message
                array_input_print.setStyle("-fx-background-color: red;"                 //change styling of label to show error
                                            + "-fx-padding: 10px;");
                array_input_print.setMaxWidth(200);
                }
                
                else {
                    try {
                        Double.parseDouble(array_input.getText());                      //see if text field converts to a double
                    }
                    catch (NumberFormatException e){                                    //if not, then display error
                        array_input_print.setText(array_input.getText()+" not a Double\n\tTry Again");     //set label to error message
                        array_input_print.setStyle("-fx-background-color: red;"                 //change styling of label to show error
                                                    + "-fx-padding: 10px;");
                        array_input_print.setMaxWidth(200);
                        array_input.clear();                                            //clear text field
                    }
                    myList.add(Double.parseDouble(array_input.getText()));              //add value of text field to array in myList class as Double
                    array_input.clear();                                                //clear text field
                    String string_array_list=myList.printArrayList();                   //use printArrayList method to convert array list to a string
                    array_input_print.setText(string_array_list);                       //set label to array list
                    array_input_print.setStyle("");                                     //reset styling from style sheet
                    array_input_print.setMaxWidth(400);                                 //reset max width to 400
            }
                
            }
        });
        
//                                    6. SETUP ADD BUTTON LAMBDA EVENT
        add_string_btn.setOnAction(event ->{
            
            if (array_input.getText().equals("")){                                      //if array list is empty, error
                array_input_print.setText("Eneter Something");                          //set text field prompt
                array_input.requestFocus();                                             //reset focuse to type again in text field
                array_input_print.setStyle("-fx-background-color: red;"                 //set label to error
                                            + "-fx-padding: 10px;");
                array_input_print.setMaxWidth(200);
            }
            else {
                try {
                        Double.parseDouble(array_input.getText());                      //see if text field converts to a double
                    }
                catch (NumberFormatException e){                                        //if not, then display error
                    array_input_print.setText(array_input.getText()+" not a Double\n\tTry Again");     //set label to error message
                    array_input_print.setStyle("-fx-background-color: red;"                 //change styling of label to show error
                                                + "-fx-padding: 10px;");
                    array_input_print.setMaxWidth(200);
                    array_input.clear();                                                //clear text field
                    array_input.requestFocus();
                }
                myList.add(Double.parseDouble(array_input.getText()));                    //add value of text field to array in myList class as Double
                array_input.clear();                                                    //clear text field
                String string_array_list=myList.printArrayList();                       //use printArrayList method to convert array list to a string
                array_input_print.setText(string_array_list);                           //set label to array list
                array_input_print.setStyle("");                                         //reset styling from style sheet
                array_input.requestFocus();                                             //request focus to keep cursor blinking and active for text field
                array_input_print.setMaxWidth(400);                                     //reset max width to 400
            }
        });
        
//                                    7. SETUP LARGEST BUTTON LAMBDA EVENT
        largest_btn.setOnAction(event ->{
            Number largest_result=(Number) myList.largest();                            //cast result from largest method in MyList class
            largest_label.setText("Largest: "+largest_result);                          //display results
            largest_label.setStyle("-fx-background-color: rgb(0,0,0)");                 //set background color to black
        });
        
//                                    8. SETUP SMALLEST BUTTON LAMBDA EVENT
        smallest_btn.setOnAction(event ->{
            Number smallest_result=(Number) myList.smallest();                          //cast result from largest method in MyList class
            smallest_label.setText("Smallest: "+smallest_result);                       //display results
            smallest_label.setStyle("-fx-background-color: rgb(0,0,0)");                //set background color to black
        });
        
//                                    9. SETUP CLEAR BUTTON LAMBDA EVENT
        clear_btn.setOnAction(event ->{
            array_input.clear();                                                    //clear text field
            largest_label.setText("");                                              //clear label
            largest_label.setStyle("");                                             //set label to default style sheet
            smallest_label.setText("");                                             //clear label
            smallest_label.setStyle("");                                            //set label to default style sheet
            array_input_print.setText(empty_array_list);                            //reset prompt value for text field
            
            myList.clearArrayList();
        });
    
        primaryStage.setTitle("Generic Array List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
