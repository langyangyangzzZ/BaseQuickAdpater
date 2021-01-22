package demo.ht.com.basequickadpater.beans;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

import static demo.ht.com.basequickadpater.adapters.ExpandableItemAdapter.GROUP;

/**
 * @ClassName LeveBean2
 * 作者: szj
 * 时间: 2021/1/18 15:31
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 */
public class LeveBean2 extends AbstractExpandableItem<LeveBean3> implements MultiItemEntity {
    String  group;

    public LeveBean2(String group) {
        this.group = group;
    }


    public String getGroup() {
        return group;
    }

    @Override
    public int getItemType() {
        return GROUP;
    }

    @Override
    public int getLevel() {
        return 2;
    }
}
