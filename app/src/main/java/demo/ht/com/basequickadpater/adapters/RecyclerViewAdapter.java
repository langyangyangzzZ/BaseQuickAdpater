package demo.ht.com.basequickadpater.adapters;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.Nullable;
import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.beans.ItemBean;

/**
 * @ClassName RecyclerViewAdapter
 * 作者: szj
 * 时间: 2021/1/18 10:56
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 */
public class RecyclerViewAdapter extends BaseQuickAdapter<ItemBean, BaseViewHolder> {


    public RecyclerViewAdapter(int layoutResId, @Nullable List<ItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ItemBean item) {
        helper.setText(R.id.tv, item.getIndex());
    }
}
