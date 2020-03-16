package project3;

import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arthr
 */
public class GUI extends Application {

    private Stage window;
    private Scene mainMenu, gameView;
    private GridPane centerPane = new GridPane();
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Bang! The Dice Game");
        this.buildMainMenu();
        window.show();
    }

    private void buildMainMenu() {
        StackPane root = new StackPane();
        mainMenu = new Scene(root, 1280, 960);
        Button play = new Button();
        play.setTranslateX(-150);
        play.setMaxWidth(200);
        play.setMaxHeight(50);
        play.setText("Play Game");

        Button quit = new Button();
        quit.setTranslateX(150);
        quit.setMaxWidth(200);
        quit.setMaxHeight(50);
        quit.setText("Quit");

        Text aiText = new Text("Number of AI players:");
        aiText.setTranslateY(75);
        aiText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        ComboBox amountOfPlayersBox = new ComboBox();
        amountOfPlayersBox.getItems().addAll("2", "3", "4", "5", "6", "7");
        amountOfPlayersBox.setTranslateY(110);
        amountOfPlayersBox.getSelectionModel().selectFirst();

        this.printBangName(root);
        root.getChildren().add(play);
        root.getChildren().add(quit);
        root.getChildren().add(amountOfPlayersBox);
        root.getChildren().add(aiText);
        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startGame();
            }
        });
        quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
            }
        });

        window.setScene(mainMenu);
    }

    private void printBangName(StackPane root) {
        //Creating a Text object 
        Text primaryText = new Text();
        Text secondaryText = new Text();
        //Setting font to the text 
        primaryText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));

        secondaryText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        //setting the position of the text  
        primaryText.setTranslateX(0);
        primaryText.setTranslateY(-150);

        secondaryText.setTranslateX(0);
        secondaryText.setTranslateY(-100);
        //Setting the color 
        primaryText.setFill(Color.RED);

        secondaryText.setFill(Color.WHITE);
        //Setting the Stroke  
        primaryText.setStrokeWidth(2);

        secondaryText.setStrokeWidth(2);
        // Setting the stroke color
        primaryText.setStroke(Color.BLACK);

        secondaryText.setStroke(Color.BLACK);

        //Setting the text to be added. 
        primaryText.setText("BANG!");
        secondaryText.setText("THE DICE GAME");
        root.getChildren().add(primaryText);
        root.getChildren().add(secondaryText);
    }

    private void startGame() {
        StackPane temp = new StackPane();
        BorderPane border = new BorderPane();
        border.setLeft(Dices("/assets/1.jpg", "/assets/2.jpg", "/assets/3.jpg", "/assets/4.jpg", "/assets/5.jpg", border));
        StackPane card = addCard("/assets/bartCassidy.png");
        GridPane.setConstraints(card, 5,4);
        centerPane.getChildren().addAll(card);
        border.setCenter(centerPane);
        border.setTop(temp);
        gameView = new Scene(border, 1280, 960);

        window.setScene(gameView);
    }

    private VBox Dices(String dice1, String dice2, String dice3, String dice4, String dice5, BorderPane border) {
        VBox vbox = new VBox();
        Button reroll = new Button();

        reroll.setText("Re-roll Selected");
        reroll.setMaxWidth(200);
        reroll.setMaxHeight(50);
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(10));

        CheckBox checkBox1 = new CheckBox();
        CheckBox checkBox2 = new CheckBox();
        CheckBox checkBox3 = new CheckBox();
        CheckBox checkBox4 = new CheckBox();
        CheckBox checkBox5 = new CheckBox();

        checkBox1.setPadding(new Insets(5));
        checkBox2.setPadding(new Insets(5));
        checkBox3.setPadding(new Insets(5));
        checkBox4.setPadding(new Insets(5));
        checkBox5.setPadding(new Insets(5));

        HBox hbox1 = new HBox();
        hbox1.setAlignment(Pos.CENTER_LEFT);
        hbox1.getChildren().add(addDice(dice1));
        hbox1.getChildren().add(checkBox1);

        HBox hbox2 = new HBox();
        hbox2.setAlignment(Pos.CENTER_LEFT);
        hbox2.getChildren().add(addDice(dice2));
        hbox2.getChildren().add(checkBox2);

        HBox hbox3 = new HBox();
        hbox3.setAlignment(Pos.CENTER_LEFT);
        hbox3.getChildren().add(addDice(dice3));
        hbox3.getChildren().add(checkBox3);

        HBox hbox4 = new HBox();
        hbox4.setAlignment(Pos.CENTER_LEFT);
        hbox4.getChildren().add(addDice(dice4));
        hbox4.getChildren().add(checkBox4);

        HBox hbox5 = new HBox();
        hbox5.setAlignment(Pos.CENTER_LEFT);
        hbox5.getChildren().add(addDice(dice5));
        hbox5.getChildren().add(checkBox5);

        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.getChildren().add(hbox3);
        vbox.getChildren().add(hbox4);
        vbox.getChildren().add(hbox5);
        vbox.getChildren().add(reroll);
        reroll.setOnAction((ActionEvent event) -> {
            //We will need a function from the dice class that takes in 5 booleans and will reroll the numbers 
            //It will take the asset and replace it in the left side.

            //Maybe do a Game.RerollDie(Bool,bool,bool,bool,bool)
            //Call the corrosponding die.
            System.out.println(checkBox1.isSelected());
            border.setLeft(Dices("/assets/2.jpg", "/assets/3.jpg", "/assets/1.jpg", "/assets/5.jpg", "/assets/4.jpg", border));
        });
        return vbox;
    }

    private StackPane addDice(String url) {
        StackPane dice = new StackPane();
        Rectangle diceIcon = new Rectangle(52.0, 52.0);
        Image img = new Image("File:." + url + "");
        ImageView iv = new ImageView();
        iv.setImage(img);

        dice.getChildren().add(diceIcon);
        dice.getChildren().add(iv);
        return dice;
    }

    private StackPane addCard(String url) {
        StackPane card = new StackPane();
        GridPane grid = new GridPane();
        Rectangle cardIcon = new Rectangle(200, 300);
        Text characterName = new Text("BART CASSIDY");
        Text description = new Text("When a player makes you lose one or more life\n" + "points, he must take an arrow.\n" + "Life points lost to Indians or Dynamite are not affected.");
        cardIcon.setFill(Color.TRANSPARENT);
        cardIcon.setStroke(Color.BLACK);
        card.getChildren().add(cardIcon);
        
        Image img = new Image("File:." + url + "");
        ImageView iv = new ImageView();
        iv.setImage(img);
        iv.setFitHeight(50);
        iv.setFitWidth(50);
        
        GridPane.setConstraints(iv, 0,0);
        GridPane.setConstraints(characterName, 1,0);
        GridPane.setConstraints(description, 0,1);
        grid.getChildren().addAll(iv, characterName, description);
        card.getChildren().add(grid);
        return card;
    }
}
