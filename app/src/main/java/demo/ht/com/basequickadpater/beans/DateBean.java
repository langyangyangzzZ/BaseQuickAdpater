package demo.ht.com.basequickadpater.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.databinding.BindingConversion;

/**
 * @author 正在蜕变的CV工程师
 * @ClassName DateBean
 * 时间: 2021/1/22 16:18
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 */
public class DateBean {
    //获取当前日期
    @BindingConversion
    public static String convertDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(date);
    }
}
