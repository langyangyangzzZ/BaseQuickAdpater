package demo.ht.com.basequickadpater.beans;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MultipleBean implements MultiItemEntity {
    private int itemType;

    public MultipleBean(int itemType) {
        this.itemType = itemType;
    }

    @Override//返回当前显示布局
    public int getItemType() {
        return itemType;
    }
}