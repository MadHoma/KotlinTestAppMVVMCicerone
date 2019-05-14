package com.test.kotlin.ui.activity.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.test.kotlin.R
import com.test.kotlin.mvp.model.entity.State
import com.test.kotlin.mvp.presentation.main.MainPresenter
import com.test.kotlin.mvp.view.main.MainView
import com.test.kotlin.ui.activity.BaseActivity
import com.test.kotlin.ui.activity.detail.DetailActivity
import com.test.kotlin.ui.adapter.StateAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView>(), MainView {

    override val mLayoutResource: Int = R.layout.activity_main

    @InjectPresenter
    lateinit var mPresenter: MainPresenter

    private lateinit var adapter: StateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = StateAdapter {
          mPresenter.openDetail(it)
        }
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = adapter
        mPresenter.load()
    }

    override fun loading(isShowLoading: Boolean) {
        progressBar.visibility = if (isShowLoading) View.VISIBLE else View.GONE
    }

    override fun show(list: List<State>) {
        adapter.list = list
        adapter.notifyDataSetChanged()
    }

    override fun showMessage(res: Int) {
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show()
    }
}