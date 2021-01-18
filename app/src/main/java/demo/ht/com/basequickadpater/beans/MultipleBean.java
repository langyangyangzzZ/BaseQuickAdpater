package demo.ht.com.basequickadpater.beans;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MultipleBean implements MultiItemEntity {
    public static final int TEXT = 1;
    public static final int IMG = 2;
    public static final int TEXT_IMG = 3;
    private int itemType;

    public MultipleBean(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}