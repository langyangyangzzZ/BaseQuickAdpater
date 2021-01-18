package demo.ht.com.basequickadpater.beans;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

import static demo.ht.com.basequickadpater.adapters.ExpandableItemAdapter.NAME;

/**
 * @ClassName LeveBean3
 * 作者: szj
 * 时间: 2021/1/18 15:31
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 */
public class LeveBean3 implements MultiItemEntity{
    String name;

    public LeveBean3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getItemType() {
        return NAME;
    }
}