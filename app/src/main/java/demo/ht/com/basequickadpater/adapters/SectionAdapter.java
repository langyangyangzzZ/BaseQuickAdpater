package demo.ht.com.basequickadpater.adapters;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.beans.SectionBean;
/**
 * @ClassName ItemBean
 * 作者: szj
 * 时间: 2021/1/18 10:57
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 */
public class SectionAdapter extends BaseSectionQuickAdapter<SectionBean,BaseViewHolder> {
     public SectionAdapter(int layoutResId, int sectionHeadResId, List data) {
        super(layoutResId, sectionHeadResId, data);
    }

    /**
     * 布局一
     */
    @Override
    protected void convert(BaseViewHolder helper, SectionBean item) {
         helper.setText(R.id.tv, item.getName());
    }

    /**
     * 布局二
     */
    @Override
    protected void convertHead(BaseViewHolder helper,final SectionBean item) {
        helper.setText(R.id.tv, item.getName());
    }
}