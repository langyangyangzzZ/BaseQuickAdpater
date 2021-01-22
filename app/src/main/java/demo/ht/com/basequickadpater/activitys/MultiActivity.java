package demo.ht.com.basequickadpater.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.adapters.MultipleItemQuickAdapter;
import demo.ht.com.basequickadpater.beans.MultipleBean;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

/**
 * @ClassName ItemBean
 * 作者: szj
 * 时间: 2021/1/18 10:57
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 *
 * 多布局
 */
public class MultiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        RecyclerView recycler = findViewById(R.id.recycler);


        recycler.setLayoutManager(new GridLayoutManager(this, 3));

//        //初始化数据
        ArrayList<MultipleBean> list = new ArrayList<>();
        for (int i = 0; i <50; i++) {
            if (i % 3 == 0) {
                list.add( new MultipleBean(1));
            }else if(i % 3 ==1){
                list.add( new MultipleBean(2));
            }else{
                list.add( new MultipleBean(3));
            }
        }

        MultipleItemQuickAdapter adapter = new MultipleItemQuickAdapter(list);

        recycler.setAdapter(adapter);

        //position 当前可见条目
        adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                Log.i("多布局适配器",position+"");
                return list.get(position).getItemType();
            }
        });


    }
}