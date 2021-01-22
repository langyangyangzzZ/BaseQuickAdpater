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

        recycler.setLayoutManager(new LinearLayoutManager(this));

//        //初始化数据
        ArrayList<MultipleBean> list = new ArrayList<>();
        for (int i = 0; i <50; i++) {
            if (i % 3 == 0) {
                //布局一
                list.add( new MultipleBean(MultipleItemQuickAdapter.TEXT));
            }else if(i % 3 ==1){
                //布局二
                list.add( new MultipleBean(MultipleItemQuickAdapter.IMG));
            }else{
                //布局三
                list.add( new MultipleBean(MultipleItemQuickAdapter.TEXT_IMG));
            }
        }

        MultipleItemQuickAdapter adapter = new MultipleItemQuickAdapter(list);

        recycler.setAdapter(adapter);

    }
}