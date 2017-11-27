package com.huawei.codereview.ui

import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JPanel

class ToolWindowPanelFactory{
    companion object{
        fun create(): JPanel {
            val holePanel = CodeReviewToolWindow()
            return holePanel
        }
    }
}
