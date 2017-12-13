package com.huawei.codereview.data;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReviewManager {

    public static final ReviewManager instance = new ReviewManager();

    public ItemContainer itemContainer = new ItemContainer();

    private List<DataListener> listeners = new ArrayList<>();

    public void addListener(DataListener listener){
        if (!listeners.contains(listener)){
            listeners.add(listener);
        }
    }

    private void fireDataChanged()
    {
        for (DataListener listener : listeners){
            listener.onDataChanged();
        }
    }

    public void add(ReviewItem item){
        itemContainer.data.add(item);
        fireDataChanged();
    }

    public void clear(){
        itemContainer.data.clear();
        fireDataChanged();
    }

    public void delete(ReviewItem item){
        itemContainer.data.remove(item);
        fireDataChanged();
    }

    static public class ItemContainer implements Serializable {
        public List<ReviewItem> data = new ArrayList<>();
    }

    public interface DataListener{
        public void onDataChanged();
    }
}
