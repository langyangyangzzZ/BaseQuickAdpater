package demo.ht.com.basequickadpater.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.adapters.DragAdapter;
import demo.ht.com.basequickadpater.beans.DragBean;

import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;

import java.util.ArrayList;

/**
 * @ClassName ItemBean
 * 作者: szj
 * 时间: 2021/1/18 10:57
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 * <p>
 *  拖拽 删除 布局
 */
public class RemoveActivity extends AppCompatActivity {
    DragAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        RecyclerView recycler = findViewById(R.id.recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<DragBean> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new DragBean("石家庄加油~ "+i));
        }
        recycler.setAdapter(adapter = new DragAdapter(R.layout.item_layout,list));




        //拖动
        initDrag(recycler);

        //删除
        initRemove();


    }

    /**
     * 删除
     */
    private void initRemove() {
        //删除 监听
        OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
            @Override //删除元素 不管是否删除都会走这个方法
            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.i("删除:onItemSwipeStart",pos+"");
            }
            @Override//不知道是干嘛的
            public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.i("删除:clearView",pos+"");
            }
            @Override//删除元素,只有删除成功才会走这个方法
            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.i("删除:onItemSwiped",pos+"");
            }

            @Override       //v  X轴滑动距离
                            // 1 Y轴滑动距离
                            // b是否按压 true按压 false 未按压
            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float v, float v1, boolean b) {
                Log.i("删除:onItemSwipeMoving",v+"\t"+v1+"\t"+b);
            }
        };
        // 开启滑动删除
        adapter.enableSwipeItem();
        //删除监听
        adapter.setOnItemSwipeListener(onItemSwipeListener);
    }

    /**
     * 拖动
     */
    private void initDrag(RecyclerView recycler) {
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(adapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);

        itemTouchHelper.attachToRecyclerView(recycler);
        //拖拽监听
        OnItemDragListener onItemDragListener = new OnItemDragListener() {
            @Override   //开始拖拽下标
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos){
                Log.i("拖拽:onItemDragStart",pos+"");
            }
            @Override//拖拽过程中 form 当前 to 拖拽到
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
                Log.i("拖拽:onItemDragStart",from+"\t"+to);
            }
            @Override   //结束拖拽下标
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.i("拖拽:onItemDragEnd",pos+"");
            }
        };
        // 开启拖拽
        adapter.enableDragItem(itemTouchHelper, R.id.tv, true);

        adapter.setOnItemDragListener(onItemDragListener);
    }
}