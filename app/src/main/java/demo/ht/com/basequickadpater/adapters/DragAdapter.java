package demo.ht.com.basequickadpater.adapters;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.beans.DragBean;

/**
 * @ClassName DragAdapter
 * 作者: szj
 * 时间: 2021/1/18 15:05
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 */
public class DragAdapter extends BaseItemDraggableAdapter<DragBean, BaseViewHolder> {
    /**
     *
     * @param layoutResId item布局
     * @param data  数据
     */
    public DragAdapter(int layoutResId, List<DragBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DragBean item) {
        helper.setText(R.id.tv,item.getName());
    }
}
