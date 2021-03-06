package sample.ui;

import components.ButtonCustome;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.models.PlatillosDAO;

public class PlatilloCRUD extends Stage {

    private VBox vBox;
    private TableView<PlatillosDAO>tbvPlatillos;
    private Button btnNuevo;
    private Scene escena;
    private PlatillosDAO objPDAO;

    public PlatilloCRUD(){

        objPDAO = new PlatillosDAO();
        CrearUI();
        this.setTitle("Administracion de platillos");
        this.setScene(escena);
        this.show();

    }

    private void CrearUI() {

        tbvPlatillos = new TableView<>();
        CrearTabla();
        btnNuevo = new Button("Nuevo Platillo");
        btnNuevo.setOnAction(event -> { new FrmPlatillos(tbvPlatillos,null); });
        vBox = new VBox();
        vBox.getChildren().addAll(tbvPlatillos,btnNuevo);
        escena = new Scene(vBox,500,250);

    }

    private void CrearTabla() {
        TableColumn<PlatillosDAO, Integer>tbcIdPlatillo = new TableColumn<>("ID");
        tbcIdPlatillo.setCellValueFactory(new PropertyValueFactory<>("id_platillo"));

        TableColumn<PlatillosDAO, String>tbcNombPlatillo = new TableColumn<>("Platillo");
        tbcNombPlatillo.setCellValueFactory(new PropertyValueFactory<>("nombre_platillo"));

        TableColumn<PlatillosDAO, Float>tbcPrecio = new TableColumn<>("Precio");
        tbcPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<PlatillosDAO, String>tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(
                new Callback<TableColumn<PlatillosDAO, String>, TableCell<PlatillosDAO, String>>() {
                    @Override
                    public TableCell<PlatillosDAO, String> call(TableColumn<PlatillosDAO, String> param) {
                        return new ButtonCustome(1);
                    }
                }
        );

        TableColumn<PlatillosDAO, String>tbcBorrar = new TableColumn<>("Borrar");
        tbcBorrar.setCellFactory(
                new Callback<TableColumn<PlatillosDAO, String>, TableCell<PlatillosDAO, String>>() {
                    @Override
                    public TableCell<PlatillosDAO, String> call(TableColumn<PlatillosDAO, String> param) {
                        return new ButtonCustome(2);
                    }
                }
        );

        tbvPlatillos.getColumns().addAll(tbcIdPlatillo,tbcNombPlatillo,tbcPrecio,tbcEditar,tbcBorrar);
        tbvPlatillos.setItems(objPDAO.getAllPlatillo());
    }
}
