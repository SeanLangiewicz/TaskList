package view_controllers.oldControllers.SelectedTask;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import model.Tasks;

public class selectedTaskController
{
    @FXML
    private CheckBox completeCheckBox;

    @FXML
    private TextField taskDescriptionTxtFld;

    @FXML
    private TextField taskNameTxtFld;

    @FXML
    private TextField taskNoteTxtFld;

    public void sendRecord(Tasks selectedTask)
    {
        int selectedID = selectedTask.getId();
        String name = selectedTask.getName();

        try
        {
            taskNameTxtFld.setText(String.valueOf(selectedTask.getId()));
            taskDescriptionTxtFld.setText(String.valueOf(selectedTask.getDescription()));
            taskNoteTxtFld.setText(String.valueOf(selectedTask.getNote()));

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }


}

