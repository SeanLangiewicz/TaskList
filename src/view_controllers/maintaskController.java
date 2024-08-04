package view_controllers;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;
import model.mainTasks;
import DAO.mainTaskListImpl;


public class maintaskController implements Initializable
{

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
    private TableColumn<mainTasks, Boolean> tblCompleted;

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
    void onActionDeleteTask(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {
            taskTblView.getItems().clear();
            mainTaskList.clear();

            mainTaskList.addAll(mainTaskListImpl.selectAllTasks());


            tblID.setCellValueFactory(new PropertyValueFactory<>("id"));
            tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
            tblDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            tblNote.setCellValueFactory(new PropertyValueFactory<>("note"));


          // tblCompleted.setCellValueFactory(new PropertyValueFactory<mainTasks,Boolean>("isComplete"));

            TableColumn<mainTasks,Boolean> genColumn = new TableColumn<>("isComplete");





            taskTblView.setItems(mainTaskList);







        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
