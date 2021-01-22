package demo.ht.com.basequickadpater.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.adapters.MyAdapter;
import demo.ht.com.basequickadpater.beans.ImageBean;
import demo.ht.com.basequickadpater.beans.UserBean;
import demo.ht.com.basequickadpater.databinding.ActivityBinBinding;
import demo.ht.com.basequickadpater.fragments.BindingFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class BinActivity extends AppCompatActivity {

    private ActivityBinBinding binding;
    private ArrayList<UserBean> userBeans = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_bin
        );

        ArrayList<UserBean> userList = new ArrayList<UserBean>() {
            {
                add(new UserBean("张三", 23));
                add(new UserBean("王五", 23));
                add(new UserBean("赵六", 23));
                add(new UserBean("武大", 23));
            }
        };

        HashMap<String, String> hashMap = new HashMap<String, String>() {
            {
                put("name", "HashMap");
            }
        };

        String[] s = new String[1];
        s[0] = new String("User数组");
        //设置数组
        binding.setUsers(s);

        //设置int
        binding.setListi(1);


        //设置对象
        binding.setUser(new UserBean("szj", 1));

        //设置List
        binding.setUserList(userList);

        //设置Map
        binding.setHashMap(hashMap);

        //设置Text监听
        binding.setOnClickListener(this);

        //设置Button按钮监听
        binding.setOnButtonClick(this);


//        //RecyclerView
        initRecyclerView();

        //设置图片
        ImageBean imageBean = new ImageBean("https://dss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top-e3b63a0b1b.png");
        binding.setImageUrl(imageBean);

        binding.setDate(new Date());
    }

    private void initRecyclerView() {
        RecyclerView rel = findViewById(R.id.rel);

        rel.setLayoutManager(new LinearLayoutManager(this));

        //初始化数据
        initItem();

        rel.setAdapter(new MyAdapter(userBeans,this));
    }


    /**
     * 初始化数据
     */
    private void initItem() {
        for (int i = 0; i < 50; i++) {
            userBeans.add(new UserBean("数据: " + i));
        }
    }

    public void onClick(View view){
        if (view.getId() ==R.id.tv1) {
            Toast.makeText(this, "点击了tv1", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "点击了tv2", Toast.LENGTH_SHORT).show();
        }
    }

//    //Button 切换到Fragment
    public void onButtonClick(View view){

//        Toast.makeText(this, "Button按钮", Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new BindingFragment()).commit();

    }
}