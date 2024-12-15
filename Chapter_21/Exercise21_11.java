/*
Author: Charles Carter
Date: 12/15/2024

Description:  This program uses JavaFX and lets the user enter a girl's or boy's name to see if it is
in the top ten rankings for baby names from the years 2001 to 2010
 */



import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
    private Map<String, Integer>[] mapForBoy = new HashMap[10];
    private Map<String, Integer>[] mapForGirl = new HashMap[10];

    private Button btFindRanking = new Button("Find Ranking");
    private ComboBox<Integer> cboYear = new ComboBox<>();
    private ComboBox<String> cboGender = new ComboBox<>();
    private TextField tfName = new TextField();
    private Label lblResult = new Label();

    @Override
    public void start(Stage primaryStage) {
        initializeData(); // Ensure data is initialized

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Select a year:"), 0, 0);
        gridPane.add(new Label("Boy or girl?"), 0, 1);
        gridPane.add(new Label("Enter a name:"), 0, 2);
        gridPane.add(cboYear, 1, 0);
        gridPane.add(cboGender, 1, 1);
        gridPane.add(tfName, 1, 2);
        gridPane.add(btFindRanking, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(lblResult);
        BorderPane.setAlignment(lblResult, Pos.CENTER);

        Scene scene = new Scene(borderPane, 370, 160);
        primaryStage.setTitle("Baby Name Popularity Ranking");
        primaryStage.setScene(scene);
        primaryStage.show();

        for (int year = 2001; year <= 2010; year++) {
            cboYear.getItems().add(year);
        }
        cboYear.setValue(2001);

        cboGender.getItems().addAll("Male", "Female");
        cboGender.setValue("Male");


        //Calls findRanking when button is pressed
        btFindRanking.setOnAction(e -> findRanking());
    }


    private void initializeData() {
        // Boy and girl name data arrays
        String[][] boyNames = {
                {"Jacob", "Michael", "Matthew", "Joshua", "Christopher", "Nicholas", "Andrew", "Joseph", "Daniel", "William"},
                {"Jacob", "Michael", "Joshua", "Matthew", "Ethan", "Andrew", "Joseph", "Christopher", "Nicholas", "Daniel"},
                {"Jacob", "Michael", "Joshua", "Matthew", "Andrew", "Ethan", "Joseph", "Daniel", "Christopher", "Anthony"},
                {"Jacob", "Michael", "Joshua", "Matthew", "Ethan", "Andrew", "Daniel", "William", "Joseph", "Christopher"},
                {"Jacob", "Michael", "Joshua", "Matthew", "Ethan", "Andrew", "Daniel", "Anthony", "Joseph", "Christopher"},
                {"Jacob", "Michael", "Joshua", "Ethan", "Matthew", "Daniel", "Andrew", "Christopher", "Anthony", "William"},
                {"Jacob", "Michael", "Ethan", "Joshua", "Daniel", "Christopher", "Anthony", "William", "Matthew", "Andrew"},
                {"Jacob", "Michael", "Ethan", "Joshua", "Daniel", "Alexander", "Anthony", "William", "Noah", "Christopher"},
                {"Jacob", "Ethan", "Michael", "Alexander", "William", "Joshua", "Daniel", "Jayden", "Noah", "Christopher"},
                {"Jacob", "Ethan", "Michael", "Jayden", "William", "Alexander", "Noah", "Daniel", "Aiden", "Anthony"}
        };

        String[][] girlNames = {
                {"Emily", "Madison", "Hannah", "Ashley", "Alexis", "Sarah", "Samantha", "Abigail", "Elizabeth", "Olivia"},
                {"Emily", "Madison", "Hannah", "Emma", "Alexis", "Ashley", "Abigail", "Sarah", "Samantha", "Olivia"},
                {"Emily", "Emma", "Madison", "Hannah", "Olivia", "Abigail", "Alexis", "Ashley", "Elizabeth", "Samantha"},
                {"Emily", "Emma", "Madison", "Olivia", "Hannah", "Abigail", "Isabella", "Ashley", "Samantha", "Elizabeth"},
                {"Emily", "Emma", "Madison", "Abigail", "Olivia", "Isabella", "Hannah", "Ava", "Samantha", "Ashley"},
                {"Emily", "Emma", "Madison", "Isabella", "Ava", "Abigail", "Olivia", "Hannah", "Sophia", "Samantha"},
                {"Emily", "Isabella", "Emma", "Ava", "Madison", "Sophia", "Olivia", "Abigail", "Hannah", "Elizabeth"},
                {"Emma", "Isabella", "Emily", "Olivia", "Ava", "Madison", "Sophia", "Abigail", "Chloe", "Mia"},
                {"Isabella", "Emma", "Olivia", "Sophia", "Ava", "Emily", "Madison", "Abigail", "Chloe", "Mia"},
                {"Isabella", "Sophia", "Emma", "Olivia", "Ava", "Emily", "Abigail", "Madison", "Chloe", "Mia"}
        };

        // Initialize the maps
        for (int i = 0; i < 10; i++) {
            mapForBoy[i] = new HashMap<>();
            mapForGirl[i] = new HashMap<>();
        }

        // Populate the maps using loops
        for (int year = 0; year < 10; year++) {
            for (int rank = 0; rank < 10; rank++) {
                String boyName = boyNames[year][rank];
                String girlName = girlNames[year][rank];
                mapForBoy[year].put(boyName, rank + 1); // Name as key, rank as value
                mapForGirl[year].put(girlName, rank + 1); // Name as key, rank as value
            }
        }
    }

    private void findRanking() {
        int year = cboYear.getValue();
        String gender = cboGender.getValue();
        String name = tfName.getText().trim();

        int index = year - 2001;  //adjusted for map values
        Map<String, Integer> map = gender.equals("Male") ? mapForBoy[index] : mapForGirl[index];

        Integer rank = map.get(name);
        if (rank != null) {
            String genderText = gender.equals("Male") ? "Boy" : "Girl";
            lblResult.setText(genderText + " name " + name + " in the year " + year + " is ranked #" + rank + ".");
        } else {
            String genderText = gender.equals("Male") ? "Boy" : "Girl";
            lblResult.setText(genderText + " name " + name + " is not ranked in the year " + year + ".");
        }
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
