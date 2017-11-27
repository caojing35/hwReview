package com.huawei.codereview.action

import com.huawei.codereview.data.Location
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class ReviewAction  : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val location = Location.create(e)
        Messages.showMessageDialog(location.toString(), "debuginfo", Messages.getInformationIcon())
    }
}