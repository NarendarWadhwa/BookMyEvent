package com.example.bookmyevent.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bookmyevent.utils.LoadingDialog

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    protected lateinit var mBinding: VB
    protected lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this@BaseActivity, getLayoutId())
        mViewModel = ViewModelProvider(this@BaseActivity).get(getViewModel())
        createDialog()
        onBinding()
    }

    private fun createDialog() {
        val progressDialog = LoadingDialog(this@BaseActivity)
        progressDialog.setCancelable(false)
        mViewModel.getVisibility().observe(this@BaseActivity, Observer {
            progressDialog.run {
                if (it) show() else dismiss()
            }
        })
        mViewModel.getMessage().observe(this@BaseActivity, Observer {
            progressDialog.setMessage(it)
        })
    }

    abstract fun getLayoutId(): Int
    abstract fun getViewModel(): Class<VM>
    abstract fun onBinding()

}