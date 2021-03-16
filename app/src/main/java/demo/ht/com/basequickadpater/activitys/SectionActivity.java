package demo.ht.com.basequickadpater.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.adapters.SectionAdapter;
import demo.ht.com.basequickadpater.beans.SectionBean;
import demo.ht.com.basequickadpater.utils.DensityUtil;
import demo.ht.com.basequickadpater.utils.GroupListener;
import demo.ht.com.basequickadpater.utils.OnGroupClickListener;
import demo.ht.com.basequickadpater.utils.StickyDecoration;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ItemBean
 * 作者: szj
 * 时间: 2021/1/18 10:57
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 *
 * 双布局
 */
public class SectionActivity extends AppCompatActivity {

    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        RecyclerView recycler = findViewById(R.id.recycler);

        manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);

        ArrayList<SectionBean> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if (i  == 0) {
                list.add(new SectionBean(true,"   头布局   "+i));
            }else if(i % 5 == 0 ){
                list.add(new SectionBean(false,"分组"));
            }else{
                list.add(new SectionBean(false,"张三"));
            }
        }

        StickyDecoration.Builder builder = StickyDecoration.Builder
                .init(position -> {
                    Log.i("getGroupName",position+"");
                    //组名回调
                    if (list.size() > position && position > -1) {
                        //获取组名，用于判断是否是同一组
                        return list.get(position).getName();
                    }
                    return null;
                })
                //背景色
                .setGroupBackground(Color.parseColor("#48BDFF"))
                //高度
                .setGroupHeight(DensityUtil.dip2px(this, 35))
                //分割线颜色
                .setDivideColor(Color.parseColor("#EE96BC"))
                //分割线高度 (默认没有分割线)
                .setDivideHeight(DensityUtil.dip2px(this, 2))
                //字体颜色 （默认）
                .setGroupTextColor(Color.BLACK)
                //字体大小
                .setGroupTextSize(DensityUtil.sp2px(this, 15))
                // 边距   靠左时为左边距  靠右时为右边距
                .setTextSideMargin(DensityUtil.dip2px(this, 10))
                // header数量（默认0）
                //.setHeaderCount(1)
                //Group点击事件
                .setOnClickListener(new OnGroupClickListener() {
                    @Override
                    public void onClick(int position, int id) {
                        //点击事件，返回当前分组下的第一个item的position
//                        String content = "onGroupClick --> " + position + " " +  dataList.get(position).getProvince();
                        Toast.makeText(SectionActivity.this, list.get(position).getName(), Toast.LENGTH_SHORT).show();
                    }
                });

        StickyDecoration decoration = builder.build();

        recycler.setLayoutManager(manager);
        recycler.addItemDecoration(decoration);

        SectionAdapter adapter = new SectionAdapter(
                R.layout.section_item1_layout,
                R.layout.section_item2_layout,
                list
        );

        recycler.setAdapter(adapter);



    }
}