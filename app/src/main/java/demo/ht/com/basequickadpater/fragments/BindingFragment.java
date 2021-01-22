package demo.ht.com.basequickadpater.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.beans.UserBean;
import demo.ht.com.basequickadpater.databinding.FragmentBindingBinding;

public class BindingFragment extends Fragment {


    private FragmentBindingBinding inflate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Fragment
        inflate = DataBindingUtil.inflate(inflater, R.layout.fragment_binding, container, false);

        inflate.setUserBean(new UserBean("Fragment页面 "));

        inflate.setClick(this);

        return inflate.getRoot();
    }
    public void onTextClick(View view){
        Toast.makeText(getActivity(), "Fragment页面", Toast.LENGTH_SHORT).show();
    }
}