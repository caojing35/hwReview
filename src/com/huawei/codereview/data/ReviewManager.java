package com.huawei.codereview.data;

import java.util.ArrayList;
import java.util.List;

public class ReviewManager {
    public class ItemContainer {
        public List<ReviewItem> data = new ArrayList<>();
    }

    public static final ReviewManager instance = new ReviewManager();

    public ItemContainer itemContainer = new ItemContainer();

    public void add(ReviewItem item){
        itemContainer.data.add(item);
    }
}
