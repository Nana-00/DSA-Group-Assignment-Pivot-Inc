import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PharmacyManagementSystemUI extends Application {

    /*
    Pivot Inc.
    
    10862595-Daniel Nana Ampomah
    10896752-Kenneth Ankrah
    10892036-Berima Akoto
    10916516-Doreen Oduro
    10915824-Emmanuella Afia Frimpomaah Acheampong
    */

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set up the main window
        primaryStage.setTitle("Pharmacy Management System");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);

        // Create the menu bar
        MenuBar menuBar = new MenuBar();
        Menu adminMenu = new Menu("Admin Profile");
        MenuItem logoutMenuItem = new MenuItem("Logout");
        MenuItem settingsMenuItem = new MenuItem("Settings");
        adminMenu.getItems().addAll(logoutMenuItem, settingsMenuItem);
        menuBar.getMenus().addAll(adminMenu);

        // Create the profile picture frame
        ImageView profilePicture = new ImageView(new Image("profile-picture.png"));
        profilePicture.setFitWidth(50);
        profilePicture.setFitHeight(50);
        Rectangle profilePictureFrame = new Rectangle(50, 50);
        profilePictureFrame.setFill(Color.WHITE);
        profilePictureFrame.setStroke(Color.GRAY);
        profilePictureFrame.setStrokeWidth(2);
        StackPane profilePicturePane = new StackPane(profilePictureFrame, profilePicture);

        // Create the welcome message
        Text welcomeText = new Text("Welcome");
        welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        welcomeText.setFill(Color.BLACK);
        HBox welcomeBox = new HBox(welcomeText);
        welcomeBox.setAlignment(Pos.CENTER);
        BorderPane welcomePane = new BorderPane();
        welcomePane.setLeft(profilePicturePane);
        welcomePane.setCenter(welcomeBox);

        // Create the main content
        Button addDrugButton = new Button("Add Drug");
        Button searchDrugButton = new Button("Search for Drug");
        Button viewDrugsButton = new Button("View Drugs and Suppliers");
        Button viewPurchaseHistoryButton = new Button("View Purchase History");
        Rectangle addDrugRect = createRectangleWithText("Add Drug", Color.GRAY, Color.WHITE);
        Rectangle searchDrugRect = createRectangleWithText("Search for Drug", Color.GRAY, Color.WHITE);
        Rectangle viewDrugsRect = createRectangleWithText("View Drugs and Suppliers", Color.GRAY, Color.WHITE);
        Rectangle viewPurchaseHistoryRect = createRectangleWithText("View Purchase History", Color.GRAY, Color.WHITE);
        VBox mainContent = new VBox();
        mainContent.setAlignment(Pos.CENTER);
        mainContent.setPadding(new Insets(20));
        mainContent.setSpacing(20);
        mainContent.getChildren().addAll(
                new HBox(addDrugButton, addDrugRect),
                new HBox(searchDrugButton, searchDrugRect),
                new HBox(viewDrugsButton, viewDrugsRect),
                new HBox(viewPurchaseHistoryButton, viewPurchaseHistoryRect)
        );

        // Create the root pane
        BorderPane rootPane = new BorderPane();
        rootPane.setTop(menuBar);
        rootPane.setCenter(mainContent);
        rootPane.setLeft(welcomePane);

        // Create the scene and show the stage
        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Rectangle createRectangleWithText(String text, Color fillColor, Color textColor) {
        Rectangle rect = new Rectangle(150, 50);
        rect.setFill(fillColor);
        rect.setStroke(Color.GRAY);
        rect.setStrokeWidth(2);
        Text label = new Text(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        label.setFill(textColor);
        StackPane pane = new StackPane(rect, label);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5));
        return rect;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
