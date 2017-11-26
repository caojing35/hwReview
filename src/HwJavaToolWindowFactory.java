import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class HwJavaToolWindowFactory implements ToolWindowFactory {

    private JPanel myToolWindowContent;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        createPanel();
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(myToolWindowContent, "", false);
        toolWindow.getContentManager().addContent(content);
    }

    private void createPanel() {
        myToolWindowContent = new JPanel();
        myToolWindowContent.setLayout(new BoxLayout(myToolWindowContent, BoxLayout.Y_AXIS));
        JPanel headPanel = new JPanel();
        headPanel.setLayout(new BoxLayout(headPanel, BoxLayout.X_AXIS));
        headPanel.add(new JButton("export"));
        headPanel.add(new JButton("import"));
    }
}
