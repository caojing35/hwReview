package com.huawei.codereview.data

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.SelectionModel
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class Location private constructor(e: AnActionEvent) {

    private var projName: String? = null

    private var projPath: String? = null

    private var absoluteFilePath: String? = null

    private var relativeFilePath: String? = null

    private var startLine: Int = 0

    private var endLine: Int = 0

    private var selectCode: String? = null

    private val sectionCode: String? = null

    init {
        getProjName(e)
        getFilePath(e)
        getSelectInfo(e)
    }

    private fun getProjName(e: AnActionEvent) {
        val proj = e.getData(PlatformDataKeys.PROJECT)
        if (proj != null) {
            this.projName = proj.name
            this.projPath = proj.basePath
        }
    }

    private fun getFilePath(e: AnActionEvent) {
        val virtualFile = e.getData(PlatformDataKeys.VIRTUAL_FILE)
        if (virtualFile != null) {
            this.absoluteFilePath = virtualFile.path
            this.relativeFilePath = this.absoluteFilePath!!.replace(this.projPath!!.toRegex(), "").substring(1)
        }
    }

    private fun getSelectInfo(e: AnActionEvent) {
        val mEditor = e.getData(PlatformDataKeys.EDITOR) ?: return
        val selectionModel = mEditor.selectionModel

        if (!selectionModel.hasSelection()) {
            val startPos = mEditor.caretModel.visualLineStart
            val endPos = mEditor.caretModel.visualLineEnd
            selectionModel.setSelection(startPos, endPos)
        }

        this.startLine = if (selectionModel.selectionStartPosition == null) 0 else selectionModel.selectionStartPosition!!.getLine()

        this.endLine = if (selectionModel.selectionEndPosition == null) 0 else selectionModel.selectionEndPosition!!.getLine()

        this.selectCode = selectionModel.selectedText
    }

    override fun toString(): String {
        return "com.huawei.codereview.data.Location{" +
                "projName='" + projName + '\'' +
                ", projPath='" + projPath + '\'' +
                ", absoluteFilePath='" + absoluteFilePath + '\'' +
                ", relativeFilePath='" + relativeFilePath + '\'' +
                ", startLine=" + startLine +
                ", endLine=" + endLine +
                ", selectCode='" + selectCode + '\'' +
                ", sectionCode='" + sectionCode + '\'' +
                '}'
    }

    companion object {

        internal fun create(e: AnActionEvent): Location {
            return Location(e)
        }
    }
}
