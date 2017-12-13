package com.huawei.codereview;

import com.huawei.codereview.data.ReviewItem;
import com.huawei.codereview.data.ReviewManager;
import com.intellij.openapi.components.*;
import org.jetbrains.annotations.Nullable;

@State(
        name = "hwReviewLogs",
        storages = {
                @Storage(
                        id = "reviewLog",
                        file = "hwReviewLog.xml"
                )}
)
public class MyService implements PersistentStateComponent<ReviewManager.ItemContainer>, ProjectComponent {
    @Nullable
    @Override
    public ReviewManager.ItemContainer getState() {
        ReviewManager.ItemContainer container = new ReviewManager.ItemContainer();
        container.data.addAll(ReviewManager.instance.itemContainer.data);
        return container;
    }

    @Override
    public void loadState(ReviewManager.ItemContainer itemContainer) {
        for (ReviewItem item : itemContainer.data){
            ReviewManager.instance.add(item);
        }
    }
}
