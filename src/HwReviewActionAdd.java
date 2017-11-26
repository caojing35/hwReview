import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;


public class HwReviewActionAdd extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Location location = Location.create(e);
        Messages.showMessageDialog(location.toString(), "debuginfo", Messages.getInformationIcon());
    }
}
