package view_controllers.AddTask;


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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class addTaskController implements Initializable
{
    private ObservableList<String> statusList = FXCollections.observableArrayList();

    Parent scene;
    Stage stage;

    @FXML
    private Button backBtn;

    @FXML
    private Button saveBtn;
    @FXML
    private TextField descriptionTxtFld;

    @FXML
    private TextField statusTxtFld;

    @FXML
    private ComboBox<String> statusCmboBox;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException
    {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/PendingTasks/viewPendingTasks.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionSaveBtn(ActionEvent event) throws IOException
    {

        String description = descriptionTxtFld.getText();
        String status = statusCmboBox.getValue().toString();

        System.out.println("des " + description + " " + "status " + status);

        taskImpl.addTask(description,status);

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/PendingTasks/viewPendingTasks.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {
            statusList.addAll(statusImpl.SelectAllStatus());
            statusCmboBox.setItems(statusList);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
}
