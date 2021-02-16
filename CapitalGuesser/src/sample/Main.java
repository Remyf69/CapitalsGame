package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Random;


public class Main extends Application {

    String[][] capitalList = {{"Albania","Tirana"},{"Allemagne","Berlin"},{"Andorre","Andorre"},{"Arménie","Erevan"},{"Autriche","Vienne"},{"Azerbaïdjan","Bakou"}
            ,{"Belgique","Bruxelles"},{"Biélorussie","Minsk"},{"Bosnie-Herzégovine","Sarajevo"},{"Bulgarie","Sofia"},{"Chypre","Nicosie"},{"Croatie","Zagreb"}
            , {"Danemark","Copenhague"},{"Espagne","Madrid"},{"Estonie","Tallinn"},{"Finlande","Helsinki"},{"France","Paris"},{"Géorgie","Tbilissi"},{"Grèce","Athènes"}
            ,{"Hongrie","Budapest"},{"Irlande","Dublin"},{"Islande","Reykjavik"},{"Italie","Rome"},{"Kazakhstan","Noursoultan"},{"Lettonie","Riga"}
            ,{"Liechtenstein","Vaduz"},{"Lituanie","Vilnius"},{"Luxembourg","Luxembourg"},{"Macédoine du Nord","Skopje"},{"Malte","La Valette"},{"Moldavie","Chisinau"}
            ,{"Monaco","Monaco"},{"Monténégro","Podgorica"},{"Norvège","Oslo"},{"Pays-Bas","Amsterdam"},{"Pologne","Varsovie"},{"Portugal","Lisbonne"},{"Roumanie","Bucarest"}
            ,{"Royaume-Uni","Londres"},{"Russie","Moscou"},{"Saint-Marin","Saint-Marin"},{"Serbie","Belgrade"},{"Solvaquie","Bratislava"},{"Slovénie","Ljubljana"}
            ,{"Suède","Stockholm"},{"Suisse","Berne"},{"Tchéquie","Prague"},{"Turquie","Ankara"},{"Ukraine","Kiev"},{"Vatican","Vatican"},{"Abkhazie","Sukhumi"}
            ,{"Kosovo","Pristina"}};

    int score = 0;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
    //FIRST SCENE
        //Layouts
        VBox mainLayout = new VBox();
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setSpacing(50);
        mainLayout.setBackground(new Background(new BackgroundFill(Color.LIGHTSALMON, CornerRadii.EMPTY, Insets.EMPTY)));

        //Elements
        Label title = new Label("Capitals !");
        title.setFont(new Font("Gobold", 70));
        Button play = new Button("Play");
        play.setFont(new Font("Gobold", 20));


        //Adding the elements to Layouts
        mainLayout.getChildren().addAll(title,play);

        //Creating the first scene
        Scene mainScene = new Scene(mainLayout, 500,300);

    //PLAYING SCENE
        //Layouts
        VBox playMainLayout = new VBox();
        playMainLayout.setAlignment(Pos.CENTER);
        playMainLayout.setSpacing(20);
        HBox validLayout = new HBox();
        validLayout.setAlignment(Pos.CENTER);
        validLayout.setSpacing(20);
        playMainLayout.setBackground(new Background(new BackgroundFill(Color.LIGHTSALMON, CornerRadii.EMPTY, Insets.EMPTY)));

        //Elements
        Label country = new Label("Country");
        country.setFont(new Font("Gobold", 30));
        Label capitalTitle = new Label("Capital ?");
        capitalTitle.setFont(new Font("Gobold", 20));
        TextField response = new TextField();
        response.setFont(new Font("Gobold", 15));
        Button newQuestion = new Button("New");
        newQuestion.setFont(new Font("Gobold", 12));
        Button valid = new Button("Valid");
        valid.setFont(new Font("Gobold", 12));
        Label scoring = new Label("Score : " + score);
        scoring.setFont(new Font("Gobold", 12));

        //Adding elements to the layouts
        validLayout.getChildren().addAll(newQuestion,valid);

        playMainLayout.getChildren().addAll(country,capitalTitle,response,validLayout,scoring);


        //Creating playing scene
        Scene playingScene = new Scene(playMainLayout,500,300);

        //Setting the actions on Buttons
        play.setOnAction(e -> {
            window.setScene(playingScene);
            valid.defaultButtonProperty();
        });
        newQuestion.setOnAction(e -> {
            Random random = new Random();
            int randomNumber = random.nextInt(52);
            String countrySelected = new String(capitalList[randomNumber][0]);
            country.setText(countrySelected);
            response.setText("");
            BackgroundFill bgfillneutral = new BackgroundFill(Color.WHITE,CornerRadii.EMPTY, Insets.EMPTY);
            response.setBackground(new Background(bgfillneutral));

            System.out.println(Font.getFamilies());
        });
        valid.setOnAction(e -> {
            String countrySelected = country.getText();
            String trueResponse = response.getText();
            for (int i = 0; i < capitalList.length;i++){
                if(capitalList[i][0].equals(countrySelected)){
                    if(trueResponse.equals(capitalList[i][1])){
                        System.out.println("Win !");
                        BackgroundFill bgfilltrue = new BackgroundFill(Color.LIGHTGREEN,CornerRadii.EMPTY, Insets.EMPTY);
                        response.setBackground(new Background(bgfilltrue));
                        score = score + 1;
                        scoring.setText("Score : " + score);

                    } else {
                        BackgroundFill bgfillfalse = new BackgroundFill(Color.CORAL,CornerRadii.EMPTY, Insets.EMPTY);
                        response.setBackground(new Background(bgfillfalse));
                        System.out.println("Nope...");
                    }
                }
            }
        });


        window.setScene(mainScene);
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }



}