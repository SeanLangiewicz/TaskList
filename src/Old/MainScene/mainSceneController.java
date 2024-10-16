package Old.MainScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class mainSceneController
{
    Parent scene;
    Stage stage;
    @FXML
    private Button pendingTasksBtn;

    @FXML
    void onActionPendingTasks(ActionEvent event) throws Exception
    {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/PendingTasks/viewPendingTasks.fxml"));
        stage.setTitle("Pending Tasks");
        stage.setScene(new Scene(scene));
        stage.show();

    }

}
