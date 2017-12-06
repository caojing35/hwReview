package com.huawei.codereview.toolwindow

import com.huawei.codereview.ui.ToolWindowPanelFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.Content
import com.intellij.ui.content.ContentFactory
import javax.swing.JButton


class CodeReviewToolWindowFactory : ToolWindowFactory {

    private var myToolWindow: ToolWindow? = null

    private val myToolWindowForm = ToolWindow()

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        myToolWindow = toolWindow
        val contentFactory: ContentFactory = ContentFactory.SERVICE.getInstance()
        val content: Content = contentFactory.createContent(myToolWindowForm.contentPanel, "", false)
        toolWindow.contentManager.addContent(content)
    }

}
