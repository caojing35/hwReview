package com.huawei.codereview.toolwindow;

import com.huawei.codereview.action.ReviewAction;
import com.huawei.codereview.data.ReviewItem;
import com.huawei.codereview.data.ReviewManager;
import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.DataConstants;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.table.JBTable;

import javax.swing.*;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolWindow {
    private JPanel contentPanel;
    private JTable issueTab;
    private JButton addBtn;
    private JButton deleteBtn;
    private JButton clearBtn;
    private ReviewTableModel tableModel;

    public ToolWindow() {
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReviewItem item = getSelectedModel();
                ReviewManager.instance.delete(item);
            }
        });
    }

    private void createUIComponents() {

        tableModel = new ReviewTableModel();
        tableModel.addTableModelListener(new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e) {

            }
        });
        issueTab = new JBTable(tableModel);
        issueTab.setAutoCreateRowSorter(true);
        issueTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2)
                {
                    JTable table = ((JTable)e.getSource());

                    int row = table.rowAtPoint(e.getPoint());
                    int modelIdx = issueTab.convertRowIndexToModel(row);

                    //get Item in Model
                    ReviewItem item = getSelectedModel();

                    //get VietualFile
                    VirtualFile virtualFile = VfsUtil.findFileByIoFile(new File(item.getFile()), true);

                    //get Project
                    Project project = ProjectManager.getInstance().getOpenProjects()[0];

                    //open file
                    OpenFileDescriptor openFileDescriptor = new OpenFileDescriptor(
                            project, virtualFile);
                    openFileDescriptor.navigate(true);
                    Editor editor = FileEditorManager.getInstance(project)
                            .getSelectedTextEditor();

                    //set select
                    editor.getSelectionModel().setSelection(0, 15);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ToolWindow");
        frame.setContentPane(new ToolWindow().contentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    class ReviewTableModel extends AbstractTableModel implements ReviewManager.DataListener{

        List<ReviewItem> data;

        ReviewTableModel(){
            data = ReviewManager.instance.itemContainer.data;
            ReviewManager.instance.addListener(this);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0)
                return data.get(rowIndex).getId();
            if (columnIndex == 1)
                return data.get(rowIndex).getDesc();
            return null;
        }

        @Override
        public void onDataChanged() {
            this.fireTableDataChanged();
        }
    }

    private int getSelectedIdx()
    {
        return issueTab.getSelectedRow();
    }

    private int getSelectedModelIdx()
    {
        int row =  issueTab.getSelectedRow();
        return issueTab.convertRowIndexToModel(row);
    }

    private ReviewItem getSelectedModel()
    {
        int row =  issueTab.getSelectedRow();
        int modexIdx =  issueTab.convertRowIndexToModel(row);
        return ReviewManager.instance.itemContainer.data.get(modexIdx);

    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}
