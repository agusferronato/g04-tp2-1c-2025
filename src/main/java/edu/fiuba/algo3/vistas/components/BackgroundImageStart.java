package edu.fiuba.algo3.vistas.components;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BackgroundImageStart {
    private final ImageView imageView;

    public BackgroundImageStart(Stage stage) {
        Image background = new Image(getClass().getResourceAsStream("/imagenes/tryfondo2.png"));
        imageView = new ImageView(background);
        imageView.fitWidthProperty().bind(stage.widthProperty());
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.setPreserveRatio(false);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
