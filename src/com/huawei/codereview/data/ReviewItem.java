package com.huawei.codereview.data;

import java.io.Serializable;

public class ReviewItem implements Serializable{
    public int id;
    public String desc;
    public String content;
    public String file;

    public ReviewItem()
    {

    }

    public ReviewItem(int id, String desc, String content, String file)
    {
        this.id = id;
        this.desc = desc;
        this.content = content;
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewItem item = (ReviewItem) o;

        if (id != item.id) return false;
        if (desc != null ? !desc.equals(item.desc) : item.desc != null) return false;
        if (content != null ? !content.equals(item.content) : item.content != null) return false;
        return file != null ? file.equals(item.file) : item.file == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (file != null ? file.hashCode() : 0);
        return result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
