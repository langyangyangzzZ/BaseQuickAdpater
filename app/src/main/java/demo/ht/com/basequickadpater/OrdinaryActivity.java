package demo.ht.com.basequickadpater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import demo.ht.com.basequickadpater.adapters.RecyclerViewAdapter;
import demo.ht.com.basequickadpater.beans.ItemBean;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

/**
 * @ClassName ItemBean
 * 作者: szj
 * 时间: 2021/1/18 10:57
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 * <p>
 * 普通布局
 */
public class OrdinaryActivity extends AppCompatActivity {

    RecyclerViewAdapter adapter;
    private ArrayList<ItemBean> itemBeans = new ArrayList<>();
    private RecyclerView recycler;
    private View button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordinary);

        //初始化控件Id
        initFindViewById();


        recycler.setLayoutManager(new LinearLayoutManager(this));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adapter.notifyDataSetChanged();
            }
        });
        //初始化数据
        initItem();

        recycler.setAdapter(adapter = new RecyclerViewAdapter(R.layout.item_layout, itemBeans));

        //空布局 没有数据时显示
        View view = LayoutInflater.from(this).inflate(R.layout.no_layout, null);
        adapter.setEmptyView(view);

        //条目动画 (默认动画与自定义动画)
//        initAnimation();

        //点击事件
//        initOnClick();

//        头尾布局
//        initHeadAndFootLayout();

        //上拉加载更多
//        initUpLoadMore();

        //下拉加载更多
//        initDownLoadMore();


        //预加载
//        adapter.setPreLoadNumber(20);
    }

    /**
     * 下拉加载更多
     */
    private void initDownLoadMore() {
        //允许下拉
        adapter.setUpFetchEnable(true);

        //下拉监听
        adapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
            @Override
            public void onUpFetch() {
                Toast.makeText(OrdinaryActivity.this, "下拉", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 上拉加载更多
     */
    private void initUpLoadMore() {
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                //recycler请求1s
                recycler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OrdinaryActivity.this, "请求 1s 结束", Toast.LENGTH_SHORT).show();

                        //加载完成 没有更多数据
//                        adapter.loadMoreEnd();

                        //重新请求
//                        adapter.loadMoreComplete();

                        //加载失败
                        adapter.loadMoreFail();

                        //下拉加载完成不显示文字
//                        adapter.setEnableLoadMore(false);

                    }

                }, 1000);
            }
        }, recycler);


    }

    /**
     * 头尾布局
     */
    private void initHeadAndFootLayout() {
        View headView = LayoutInflater.from(this).inflate(R.layout.item_head_layout, null);
        View foodView = LayoutInflater.from(this).inflate(R.layout.item_foot_layout, null);
        adapter.addHeaderView(headView);
        adapter.addFooterView(foodView);

        adapter.setHeaderAndEmpty(true);
    }

    /**
     * item动画
     */
    private void initAnimation() {
        //渐变动画
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        //从右到左动画
//        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        //从下到上动画
//        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        //从左到右动画
//        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        //从右到左动画
//        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);

        //自定义动画
       /*
       adapter.openLoadAnimation(new BaseAnimation() {
            @Override
            public Animator[] getAnimators(View view) {
                return new Animator[]{
                        *//**
         * scaleX / scaleY 缩放动画
         *  alpha   透明度动画   取值 1-0
         *  rotationX /rotationY 旋转动画   取值 0-360
         *  translationX / translationY 移动动画
         *      translationX正数向右移动,负数向左移动
         *      translationY正数向下移动,负数向上移动
         *//*

                        //scaleX / scaleY 缩放动画
//                        ObjectAnimator.ofFloat(view, "scaleX", 1, 2.5f, 1),
//                        ObjectAnimator.ofFloat(view, "scaleY", 1, 2.5f, 1),

//                        alpha   透明度动画   取值 1-0
//                        ObjectAnimator.ofFloat(view, "alpha", 1, 0.2f, 1),

//                        rotationX /rotationY 旋转动画   取值 0-360
//                        ObjectAnimator.ofFloat(view, "rotationX", 0,180,0),
//                        ObjectAnimator.ofFloat(view, "rotationY", 0,180,0),

//                        translationX / translationY 移动动画
//                            -  translationY正数向下移动,负数向上移动
//                            -  translationY正数向下移动,负数向上移动
                        ObjectAnimator.ofFloat(view, "translationX", 0,180,0),
                        ObjectAnimator.ofFloat(view, "translationY", 0,180,0),
                };
            }
        });
        */

        //动画是否重复播放 false重复播放 默认为true不重复模仿
        adapter.isFirstOnly(false);
    }

    /**
     * item点击事件
     */
    private void initOnClick() {
        //单击事件
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(OrdinaryActivity.this, "单击了 :" + position, Toast.LENGTH_SHORT).show();
            }
        });

        //长按事件
        adapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(OrdinaryActivity.this, "长按了 :" + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    /**
     * findViewById
     */
    private void initFindViewById() {
        recycler = findViewById(R.id.recycler);
        button = findViewById(R.id.button);
    }

    /**
     * 初始化数据
     */
    private void initItem() {
        for (int i = 0; i < 50; i++) {
            itemBeans.add(new ItemBean("学员 " + i));
        }
    }
}