import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.editor.VisualPosition;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.apache.http.util.TextUtils;

import java.io.File;

public class Location {

    private String projName;

    private String projPath;

    private String absoluteFilePath;

    private String relativeFilePath;

    private int startLine;

    private int endLine;

    private String selectCode;

    private String sectionCode;

    static Location create(AnActionEvent e) {
        return new Location(e);
    }

    private Location(AnActionEvent e) {
        getProjName(e);
        getFilePath(e);
        getSelectInfo(e);
    }

    private void getProjName(AnActionEvent e) {
        Project proj = e.getData(PlatformDataKeys.PROJECT);
        if (proj != null) {
            this.projName = proj.getName();
            this.projPath = proj.getBasePath();
        }
    }

    private void getFilePath(AnActionEvent e) {
        VirtualFile virtualFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (virtualFile != null) {
            this.absoluteFilePath = virtualFile.getPath();
            this.relativeFilePath = this.absoluteFilePath.replaceAll((this.projPath), "").substring(1);
        }
    }

    private void getSelectInfo(AnActionEvent e) {
        final Editor mEditor = e.getData(PlatformDataKeys.EDITOR);
        if (null == mEditor) {
            return;
        }
        SelectionModel selectionModel = mEditor.getSelectionModel();

        if (!selectionModel.hasSelection()){
            int startPos = mEditor.getCaretModel().getVisualLineStart();
            int endPos = mEditor.getCaretModel().getVisualLineEnd();
            selectionModel.setSelection(startPos, endPos);
        }

        this.startLine = selectionModel.getSelectionStartPosition() == null ? 0 : selectionModel.getSelectionStartPosition().getLine();

        this.endLine = selectionModel.getSelectionEndPosition() == null ? 0 : selectionModel.getSelectionEndPosition().getLine();

        this.selectCode = selectionModel.getSelectedText();
    }

    @Override
    public String toString() {
        return "Location{" +
                "projName='" + projName + '\'' +
                ", projPath='" + projPath + '\'' +
                ", absoluteFilePath='" + absoluteFilePath + '\'' +
                ", relativeFilePath='" + relativeFilePath + '\'' +
                ", startLine=" + startLine +
                ", endLine=" + endLine +
                ", selectCode='" + selectCode + '\'' +
                ", sectionCode='" + sectionCode + '\'' +
                '}';
    }
}
