import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by Dillon Fagan on 9/13/16.
 */
public class FoodFinder extends Application {

    private TextField ingredientField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Primary layout for the window
        VBox primaryLayout = new VBox();
        primaryLayout.setPadding(new Insets(16, 16, 16, 16));
        primaryLayout.setSpacing(20);
        primaryLayout.setAlignment(Pos.CENTER);
        primaryLayout.setBackground(new Background(new BackgroundFill(Color.rgb(220, 60, 60), CornerRadii.EMPTY, Insets.EMPTY)));

        // Title of the application, shown in large font
        Label titleLabel = new Label("FoodFinder");
        titleLabel.setFont(new Font("Verdana", 32));
        titleLabel.setTextFill(Color.WHITE);

        // Secondary layout to house input and submit button
        HBox secondaryLayout = new HBox();
        secondaryLayout.setSpacing(10);
        secondaryLayout.setAlignment(Pos.CENTER);

        // Text field for inputting the ingredients
        ingredientField = new TextField();
        ingredientField.setPromptText("Enter ingredients...");
        ingredientField.setPrefSize(250, TextField.USE_COMPUTED_SIZE);
        ingredientField.setFocusTraversable(false);

        // Button to submit the query
        Button searchButton = new Button("Search");
        searchButton.setOnAction(a -> {
            fetchIngredients();
            ingredientField.setText("");
        });

        // Button to open a "New Recipe" window
        Button newRecipeButton = new Button("New Recipe...");

        // Add all items to the secondary layout
        secondaryLayout.getChildren().addAll(ingredientField, searchButton);

        // Add all items to the primary layout
        primaryLayout.getChildren().addAll(titleLabel, secondaryLayout, newRecipeButton);

        // Setup the window and show it
        primaryStage.setTitle("FoodFinder");
        primaryStage.setScene(new Scene(primaryLayout, 600, 400));
        primaryStage.show();
    }

    /**
     * Fetches the comma-separated ingredients in the ingredient field
     * and initiates a search.
     */
    private void fetchIngredients() {
        for (String s : ingredientField.getText().split(", ")) {
            System.out.println(s); // temporarily print ingredients to the console
        }
    }
}