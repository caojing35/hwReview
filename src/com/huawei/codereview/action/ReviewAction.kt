package com.huawei.codereview.action

import com.huawei.codereview.data.Location
import com.huawei.codereview.data.ReviewItem
import com.huawei.codereview.data.ReviewManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages

class ReviewAction  : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val location = Location.create(e)

        ReviewManager.instance.add(ReviewItem(1, "aa", "1_a", "C:\\Users\\caojing\\IdeaProjects\\TestPlugin\\src\\com\\company\\Main.java"))
        ReviewManager.instance.add(ReviewItem(2, "cc", "2_c", "C:\\Users\\caojing\\IdeaProjects\\TestPlugin\\src\\com\\company\\Main2.java"))
        ReviewManager.instance.add(ReviewItem(3, "bb", "3_b", "C:\\Users\\caojing\\IdeaProjects\\TestPlugin\\src\\com\\company\\Main3.java"))

    }
}