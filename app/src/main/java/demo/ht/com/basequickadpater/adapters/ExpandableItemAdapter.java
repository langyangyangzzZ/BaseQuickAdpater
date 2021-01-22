package demo.ht.com.basequickadpater.adapters;

import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.beans.LeveBean1;
import demo.ht.com.basequickadpater.beans.LeveBean2;
import demo.ht.com.basequickadpater.beans.LeveBean3;


public class ExpandableItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    //年级
    public final static int GRADE = 0;
    //组员
    public final static int GROUP = 1;
    //姓名
    public final static int NAME = 2;
    public ExpandableItemAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(GRADE, R.layout.item_layout);
        addItemType(GROUP, R.layout.mult_item1_layout);
        addItemType(NAME, R.layout.item_head_layout);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {

        switch (holder.getItemViewType()) {
            case GRADE:
                LeveBean1 leveBean1 = (LeveBean1) item;
                holder.setText(R.id.tv, leveBean1.getGrade());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        Toast.makeText(mContext, "点击了" + pos, Toast.LENGTH_SHORT).show();

                        if (leveBean1.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });
                break;
            case GROUP:
                LeveBean2 leveBean2 = (LeveBean2) item;
                holder.setText(R.id.tv, leveBean2.getGroup());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        Toast.makeText(mContext, "点击了" + pos, Toast.LENGTH_SHORT).show();

                        if (leveBean2.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });
                break;
            case NAME:
                LeveBean3 leveBean3 = (LeveBean3) item;
                holder.setText(R.id.tv, leveBean3.getName());

                //删除某一个元素
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        remove(pos);
                    }
                });

                break;
            default:
                break;
        }
    }
}