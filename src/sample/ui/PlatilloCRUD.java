package sample.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.PlatillosDAO;

public class PlatilloCRUD extends Stage {

    private VBox vBox;
    private TableView<PlatillosDAO>tbvPlatillos;
    private Button btnNuevo;
    private Scene escena;

    public PlatilloCRUD(){

        CrearUI();
        this.setTitle("Administracion de platillos");
        this.setScene(escena);
        this.show();

    }

    private void CrearUI() {
        tbvPlatillos = new TableView<>();
        CrearTabla();
        btnNuevo = new Button("Nuevo platillo");
        //btnNuevo.setOnAction(event -> agregarPlatillo());
        vBox = new VBox();
        vBox.getChildren().addAll(tbvPlatillos,btnNuevo);
        escena = new Scene(vBox, 300, 250);
        
    }

    private void CrearTabla() {
        TableColumn<PlatillosDAO, Integer>tbcIdPlatillo = new TableColumn<>("ID");
        tbcIdPlatillo.setCellValueFactory(new PropertyValueFactory<>("id_platillo"));

        TableColumn<PlatillosDAO, String>tbcNombPlatillo = new TableColumn<>("Platillo");
        tbcNombPlatillo.setCellValueFactory(new PropertyValueFactory<>("nombre_platillo"));

        TableColumn<PlatillosDAO, Float>tbcPrecio = new TableColumn<>("Precio");
        tbcNombPlatillo.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tbvPlatillos.getColumns().addAll(tbcIdPlatillo,tbcNombPlatillo,tbcPrecio);
    }
}