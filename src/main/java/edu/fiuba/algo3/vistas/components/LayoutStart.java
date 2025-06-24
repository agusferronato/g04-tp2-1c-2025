package edu.fiuba.algo3.vistas.components;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class LayoutStart {
    private final StackPane root;

    public LayoutStart(Stage stage, PlayButton playButton) {
        BackgroundImage background = new BackgroundImage(stage, "/imagenes/tryfondo2.png");
        TitleBox titleBox = new TitleBox();
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.setPadding(new Insets(20, 20, 50, 20));
        buttonBox.getChildren().add(playButton.getButton());

        root = new StackPane();
        root.getChildren().addAll(
                background.getImageView(),
                titleBox.getTitleContainer(),
                buttonBox
        );

        StackPane.setAlignment(titleBox.getTitleContainer(), Pos.TOP_CENTER);
        StackPane.setMargin(titleBox.getTitleContainer(), new Insets(50, 0, 0, 0));
    }

    public StackPane getRoot() {
        return root;
    }
}
