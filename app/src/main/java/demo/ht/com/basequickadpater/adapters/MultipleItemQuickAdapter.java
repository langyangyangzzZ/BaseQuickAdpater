package demo.ht.com.basequickadpater.adapters;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.beans.MultipleBean;

public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleBean, BaseViewHolder> {

    public MultipleItemQuickAdapter(List data) {
        super(data);
        addItemType(MultipleBean.TEXT, R.layout.mult_item1_layout);
        addItemType(MultipleBean.IMG, R.layout.mult_item2_layout);
        addItemType(MultipleBean.TEXT_IMG, R.layout.mult_item3_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleBean item) {
        switch (helper.getItemViewType()) {
            case MultipleBean.TEXT:
                helper.setText(R.id.tv, "我是布局一 ");
                break;
            case MultipleBean.IMG:
                helper.setImageResource(R.id.image, R.drawable.ic_launcher_background);
                break;
            case MultipleBean.TEXT_IMG:
                helper.setImageResource(R.id.image, R.drawable.ic_launcher_foreground);
                helper.setText(R.id.tv, "我是布局三");
                break;

        }
    }

}