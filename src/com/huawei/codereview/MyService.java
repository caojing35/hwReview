package com.huawei.codereview;

import com.huawei.codereview.data.ReviewManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import org.jetbrains.annotations.Nullable;

@State(
        name = "reviewLogs",
        storages = {@Storage(
                id = "other",
                file = StoragePathMacros.MODULE_FILE + "/reviewLog.xml"
        )}
)
public class MyService implements PersistentStateComponent<ReviewManager.ItemContainer> {
    @Nullable
    @Override
    public ReviewManager.ItemContainer getState() {
        return ReviewManager.instance.itemContainer;
    }

    @Override
    public void loadState(ReviewManager.ItemContainer itemContainer) {
        ReviewManager.instance.itemContainer = itemContainer;
    }
}
