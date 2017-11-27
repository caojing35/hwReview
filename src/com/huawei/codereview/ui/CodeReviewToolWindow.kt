package com.huawei.codereview.ui

import java.net.URL
import javax.swing.*

class CodeReviewToolWindow : JPanel() {

    val exportBtn: JButton = JButton()

    val importBtn: JButton = JButton()

    val addBtn: JButton = JButton()

    val deleteBtn: JButton = JButton()

    val clearBtn: JButton = JButton()

    val gotoBtn: JButton = JButton()

    init {
        this.layout = BoxLayout(this, BoxLayout.Y_AXIS)
        initHeader()
    }

    private fun initHeader(){
        val headPanel = JPanel()
        headPanel.layout = BoxLayout(headPanel, BoxLayout.X_AXIS)
        exportBtn.icon = ImageIcon(getPngUrl("hwreview/export.png"), "export")
        importBtn.icon = ImageIcon(getPngUrl("hwreview/import.png"), "import")
        addBtn.icon = ImageIcon(getPngUrl("hwreview/add.png"), "add")
        headPanel.add(exportBtn)
        headPanel.add(importBtn)
        headPanel.add(addBtn)

        //import,export,clear,add,delete,goto
        this.add(headPanel)
    }

    companion private object {
        fun getPngUrl(location: String): URL{
            return this.javaClass.classLoader.getResource(location)
        }
    }
}