package demo.ht.com.basequickadpater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import demo.ht.com.basequickadpater.adapters.SectionAdapter;
import demo.ht.com.basequickadpater.beans.SectionBean;

import android.os.Bundle;
import android.provider.MediaStore;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        RecyclerView recycler = findViewById(R.id.recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<SectionBean> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if (i %2 == 0) {
                list.add(new SectionBean(true,"张三  "+i));
            }else{
                list.add(new SectionBean(false,"老刘  "+i));
            }
        }


        SectionAdapter adapter = new SectionAdapter(
                R.layout.section_item1_layout,
                R.layout.section_item2_layout,
                list
        );

        recycler.setAdapter(adapter);

    }
}