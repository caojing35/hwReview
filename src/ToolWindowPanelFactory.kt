import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JPanel

class ToolWindowPanelFactory{
    companion object{
        fun create(): JPanel {
            val holePanel = JPanel()
            holePanel.layout = BoxLayout(holePanel, BoxLayout.Y_AXIS)
            val headPanel = JPanel()
            headPanel.layout = BoxLayout(headPanel, BoxLayout.X_AXIS)
            headPanel.add(JButton("export"))
            headPanel.add(JButton("import"))
            holePanel.add(headPanel)
            return holePanel
        }
    }
}
