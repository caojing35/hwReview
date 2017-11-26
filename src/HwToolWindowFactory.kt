import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory

import javax.swing.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class HwToolWindowFactory internal constructor() : ToolWindowFactory {

    private val hideToolWindowButton: JButton? = null
    private val myToolWindow: ToolWindow? = null

    init {
        hideToolWindowButton!!.addActionListener { myToolWindow!!.hide(null) }
    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {

    }
}
