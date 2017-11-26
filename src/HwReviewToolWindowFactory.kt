import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.Content
import com.intellij.ui.content.ContentFactory
import java.time.Year
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JPanel





class HwReviewToolWindowFactory : ToolWindowFactory {

    private val hideToolWindowButton: JButton? = null

    private var myToolWindow: ToolWindow? = null

    private val myToolWindowContent = ToolWindowPanelFactory.create()

    init {
//        hideToolWindowButton!!.addActionListener {
//            myToolWindow!!.hide(null)
//        }
    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        myToolWindow = toolWindow
        val contentFactory: ContentFactory = ContentFactory.SERVICE.getInstance()
        val content: Content = contentFactory.createContent(myToolWindowContent, "", false)
        toolWindow.contentManager.addContent(content)
    }

}
