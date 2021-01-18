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

    public static final int TEXT = 1;//布局一
    public static final int IMG = 2;//布局二
    public static final int TEXT_IMG = 3;//布局三

    public MultipleItemQuickAdapter(List data) {
        super(data);
        addItemType(TEXT, R.layout.mult_item1_layout);
        addItemType(IMG, R.layout.mult_item2_layout);
        addItemType(TEXT_IMG, R.layout.mult_item3_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleBean item) {
        switch (helper.getItemViewType()) {
            case TEXT:
                helper.setText(R.id.tv, "我是布局一 ");
                break;
            case IMG:
                helper.setImageResource(R.id.image, R.drawable.ic_launcher_background);
                break;
            case TEXT_IMG:
                helper.setImageResource(R.id.image, R.drawable.ic_launcher_foreground);
                helper.setText(R.id.tv, "我是布局三");
                break;

        }
    }
}