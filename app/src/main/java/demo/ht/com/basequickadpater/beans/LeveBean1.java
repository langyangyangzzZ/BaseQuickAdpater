package demo.ht.com.basequickadpater.beans;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

import static demo.ht.com.basequickadpater.adapters.ExpandableItemAdapter.GRADE;

/**
 * @ClassName LeveBean1
 * 作者: szj
 * 时间: 2021/1/18 15:31
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 */
public class LeveBean1 extends AbstractExpandableItem<LeveBean2> implements MultiItemEntity {
    String grade;

    public LeveBean1(String grade) {
        this.grade = grade;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public int getItemType() {
        return GRADE;
    }
}

