package demo.ht.com.basequickadpater.beans;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

/**
 * @author 正在蜕变的CV工程师
 * @ClassName UserBean
 * 时间: 2021/1/21 15:47
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 */
public class UserBean  extends BaseObservable {
    public String name;
   private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable  //private 设置数据调用
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        //private 请求设置数据
        notifyPropertyChanged(BR.age);
    }

    public UserBean(String name) {
        this.name = name;
    }

    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
