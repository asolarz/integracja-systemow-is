import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LaptopController implements Initializable {
    @FXML
    private TableView<LaptopSpecification> tableView;
    @FXML
    private TableColumn<LaptopSpecification, String> name;
    @FXML
    private TableColumn<LaptopSpecification, String> displaySize;
    @FXML
    private TableColumn<LaptopSpecification, String> resolution;
    @FXML
    private TableColumn<LaptopSpecification, String> screenType;
    @FXML
    private TableColumn<LaptopSpecification, String> touchpad;
    @FXML
    private TableColumn<LaptopSpecification, String> cpu;
    @FXML
    private TableColumn<LaptopSpecification, String> cores;
    @FXML
    private TableColumn<LaptopSpecification, String> freq;
    @FXML
    private TableColumn<LaptopSpecification, String> ram;
    @FXML
    private TableColumn<LaptopSpecification, String> space;
    @FXML
    private TableColumn<LaptopSpecification, String> discType;
    @FXML
    private TableColumn<LaptopSpecification, String> gpu;
    @FXML
    private TableColumn<LaptopSpecification, String> gpuRam;
    @FXML
    private TableColumn<LaptopSpecification, String> os;
    @FXML
    private TableColumn<LaptopSpecification, String> dvd;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("name"));
        displaySize.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("displaySize"));
        resolution.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("resolution"));
        screenType.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("screenType"));
        touchpad.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("touchpad"));
        cpu.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("cpu"));
        cores.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("cores"));
        freq.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("freq"));
        ram.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("ram"));
        space.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("space"));
        discType.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("discType"));
        gpu.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("gpu"));
        gpuRam.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("gpuRam"));
        os.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("os"));
        dvd.setCellValueFactory(new PropertyValueFactory<LaptopSpecification, String>("dvd"));

        name.setCellFactory(TextFieldTableCell.forTableColumn());
        displaySize.setCellFactory(TextFieldTableCell.forTableColumn());
        resolution.setCellFactory(TextFieldTableCell.forTableColumn());
        screenType.setCellFactory(TextFieldTableCell.forTableColumn());
        touchpad.setCellFactory(TextFieldTableCell.forTableColumn());
        cpu.setCellFactory(TextFieldTableCell.forTableColumn());
        cores.setCellFactory(TextFieldTableCell.forTableColumn());
        freq.setCellFactory(TextFieldTableCell.forTableColumn());
        ram.setCellFactory(TextFieldTableCell.forTableColumn());
        space.setCellFactory(TextFieldTableCell.forTableColumn());
        discType.setCellFactory(TextFieldTableCell.forTableColumn());
        gpu.setCellFactory(TextFieldTableCell.forTableColumn());
        gpuRam.setCellFactory(TextFieldTableCell.forTableColumn());
        os.setCellFactory(TextFieldTableCell.forTableColumn());
        dvd.setCellFactory(TextFieldTableCell.forTableColumn());

        try {
            tableView.setItems(readSpec());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ObservableList<LaptopSpecification> readSpec() throws IOException {
        ObservableList<LaptopSpecification> specifications = FXCollections.observableArrayList();
        LaptopSpecificationCollection laptopSpecificationCollection = new LaptopSpecificationCollection();
        laptopSpecificationCollection.readFromFile("katalog.txt");
        return laptopSpecificationCollection.getLaptopSpecificationList();
    }

    public void exportToFile(ActionEvent actionEvent) {
        ObservableList<LaptopSpecification> specifications = tableView.getItems();
        String s = specifications
                .stream()
                .map(LaptopSpecification::toSemiColonSeparatedSpec).reduce("", String::concat);
        FileWriter.exportToFile(s);
    }


    public void editCommitName(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {
        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setName(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitDisplaySize(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {
        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setDisplaySize(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitResolution(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {
        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setResolution(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitScreenType(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {

        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setScreenType(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitTouchpad(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {
        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setTouchpad(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitCpu(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {
        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setCpu(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitCores(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {

        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setCores(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitFreq(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {

        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setFreq(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitRam(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {
        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setRam(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitDiscType(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {

        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setDiscType(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitSpace(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {
        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setSpace(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitGpu(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {
        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setGpu(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitGpuRam(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {
        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setGpuRam(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitOs(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {
        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setOs(laptopSpecificationStringCellEditEvent.getNewValue());
    }

    public void editCommitDvd(TableColumn.CellEditEvent<LaptopSpecification, String> laptopSpecificationStringCellEditEvent) {
        LaptopSpecification selectedItem = tableView.getSelectionModel().getSelectedItem();
        selectedItem.setDvd(laptopSpecificationStringCellEditEvent.getNewValue());
    }
}
