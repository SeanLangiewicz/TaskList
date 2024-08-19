package view_controllers.MainTask;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.mainTasks;
import DAO.mainTaskListImpl;



public class maintaskController implements Initializable
{
    Parent scene;
    Stage stage;

    private static ObservableList<mainTasks> mainTaskList = FXCollections.observableArrayList();


    @FXML
    private TableView<mainTasks> taskTblView;

    @FXML
    private TableColumn<?, ?> tblID;

    @FXML
    private TableColumn<?, ?> tblName;

    @FXML
    private TableColumn<?, ?> tblDescription;

    @FXML
    private TableColumn<?, ?> tblNote;

    @FXML
    private TableColumn<mainTasks, String> tblCompleted;

    @FXML
    private Button createsubTaskBtn;

    @FXML
    private Button newTaskBtn;

    @FXML
    private Button deleteTaskBtn;

    @FXML
    void onActionCreateBtn(ActionEvent event) {

    }

    @FXML
    void onActionCreateSubTask(ActionEvent event) {

    }

    @FXML
    void onActionDeleteTask(ActionEvent event) throws IOException
    {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Test/test.fxml"));
        stage.setTitle("Screen Selection Screen");
        stage.setScene(new Scene(scene));
        stage.show();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        try
        {


           mainTaskList.addAll(mainTaskListImpl.selectAllTasks());
            taskTblView.getItems().clear();
            mainTaskList.clear();

            mainTaskList.addAll(mainTaskListImpl.selectAllTasks());




            tblID.setCellValueFactory(new PropertyValueFactory<>("id"));
            tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
            tblDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            tblNote.setCellValueFactory(new PropertyValueFactory<>("note"));

            tblCompleted.setCellValueFactory(cellData ->
            {
                boolean isComplete = cellData.getValue().isComplete();
                return new javafx.beans.property.SimpleStringProperty(isComplete ? "Yes" : "No");
            });



            taskTblView.setItems(mainTaskList);









        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
