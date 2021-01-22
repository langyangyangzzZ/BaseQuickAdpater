package demo.ht.com.basequickadpater.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import demo.ht.com.basequickadpater.BR;
import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.beans.UserBean;
import demo.ht.com.basequickadpater.databinding.ItemLayoutBinding;

/**
 * @author 正在蜕变的CV工程师
 * @ClassName MyAdapter
 * 时间: 2021/1/22 13:10
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public List<UserBean> list;
    public Context context;


    public MyAdapter(List<UserBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate.getRoot());
        viewHolder.setInflate(inflate);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.getInflate().setVariable(BR.userBean,list.get(position));
        //当数据改变时，binding会在下一帧去改变数据，如果我们需要立即改变，就去调用executePendingBindings方法。
        holder.getInflate().executePendingBindings();
    }

    @Override
    public int getItemCount() {

        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemLayoutBinding inflate;

        public ItemLayoutBinding getInflate() {
            return inflate;
        }

        public void setInflate(ItemLayoutBinding inflate) {
            this.inflate = inflate;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
