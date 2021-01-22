package demo.ht.com.basequickadpater.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.adapters.ExpandableItemAdapter;
import demo.ht.com.basequickadpater.beans.LeveBean1;
import demo.ht.com.basequickadpater.beans.LeveBean2;
import demo.ht.com.basequickadpater.beans.LeveBean3;

import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

public class ExpandActivity extends AppCompatActivity {
    List<MultiItemEntity> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand);

        RecyclerView recycler = findViewById(R.id.recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        //初始化数据
        initData(3,4,5);

        //设置列表默认动画效果
        recycler.setItemAnimator(new DefaultItemAnimator());

        ExpandableItemAdapter adapter = new ExpandableItemAdapter(list);

        recycler.setAdapter(adapter);

        //默认展开一级标题
        adapter.expandAll(0,true);

        //动画
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);

    }

    /**
     *
     * @param a  一级标题数量
     * @param b   二级标题数量
     * @param c   三级标题数量
     */
    private void initData(int a, int b, int c) {
        for (int i = 0; i < a; i++) {
            LeveBean1 item0 = new LeveBean1("一级列表标题" + i);
            for (int j = 0; j < b; j++) {
                LeveBean2 item1 = new LeveBean2("二级列表标题" + j);
                for (int k = 0; k < c; k++) {
                    item1.addSubItem(new LeveBean3("三级列表标题" + k));
                }
                item0.addSubItem(item1);
            }
            list.add(item0);
        }
    }
}