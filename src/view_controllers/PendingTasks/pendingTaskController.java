package view_controllers.PendingTasks;

import DAO.statusImpl;
import DAO.taskImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Task;
import javafx.scene.control.TableColumn.CellEditEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class pendingTaskController implements Initializable
{
    private static ObservableList<Task> taskList = FXCollections.observableArrayList();
    private ObservableList<String> statusList = FXCollections.observableArrayList();

    Parent scene;
    Stage stage;


    @FXML
    private Label DescriptionLbl;

    @FXML
    private Button backBtn;

    @FXML
    private ComboBox<String> statusComboBox;



    @FXML
    private TableView<Task> taskTblView;

    @FXML
    private TableColumn<?, ?> tblCompleted;

    @FXML
    private TableColumn<?, ?> tblDescription;

    @FXML
    private TableColumn<?, ?> tblID;

    @FXML
    private TableColumn<?, ?> tblName;

    @FXML
    private Button saveBtn;



    @FXML
    private TextArea taskDescription;


    @FXML
    void onActionDeleteTask(ActionEvent event) {

    }
    @FXML
    void onActionSave(ActionEvent event) throws SQLException
    {

        int id = taskTblView.getSelectionModel().getSelectedItem().getId();
        String description = taskDescription.getText();
        String status = statusComboBox.getValue();

        System.out.println("des " + description + " " + "status " + status);

        taskImpl.updateTask(description,status,id);


        refreshTbl();


    }

    @FXML
    void onActionNewTask(ActionEvent event) throws IOException
    {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/AddTask/addTask.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onMouseClickTblView(MouseEvent event)
    {
        String selectedStatus = null;
        try
        {


        String des = taskTblView.getSelectionModel().getSelectedItem().getDescription();
        selectedStatus= taskTblView.getSelectionModel().getSelectedItem().getStatus();


        System.out.println(des);
        System.out.println(selectedStatus);



        statusComboBox.setValue(selectedStatus);

            taskDescription.setText(des);

        }
        catch (Exception e)
        {
            e.toString();
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        try
        {
            refreshTbl();

            System.out.println("In Initialize");
           statusList.addAll(statusImpl.SelectAllStatus());
           statusComboBox.setItems(statusList);







            tblDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
            tblCompleted.setCellValueFactory(new PropertyValueFactory<>("Status"));



        }
        catch (Exception e)
        {
            e.toString();
        }

    }
    private void refreshTbl() throws SQLException
    {
        try
        {

            taskList.clear();
            taskTblView.getItems().clear();
            taskList.addAll(taskImpl.selectAllTasks());
            taskTblView.setItems(taskList);

            System.out.println("Refresh Complete.");
        }
        catch (Exception e)
        {
            e.toString();
        }


    }
}
