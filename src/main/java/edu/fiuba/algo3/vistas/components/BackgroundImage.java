package edu.fiuba.algo3.vistas.components;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BackgroundImage {
    private final ImageView imageView;

    public BackgroundImage(Stage stage, String rutaImagen) {
        Image background = new Image(getClass().getResourceAsStream(rutaImagen));
        imageView = new ImageView(background);
        imageView.fitWidthProperty().bind(stage.widthProperty());
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.setPreserveRatio(false);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
