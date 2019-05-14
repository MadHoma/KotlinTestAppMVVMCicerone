package com.test.kotlin.ui.fragment.state.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.test.kotlin.R
import com.test.kotlin.mvp.model.entity.State
import com.test.kotlin.mvp.presentation.main.MainPresenter
import com.test.kotlin.mvp.view.main.MainView
import com.test.kotlin.ui.adapter.StateAdapter
import com.test.kotlin.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_list_state.*

class ListStateFragment : BaseFragment(), MainView {

    companion object {
        fun newInstance() = ListStateFragment()
    }

    override val mLayoutResource: Int = R.layout.fragment_list_state

    @InjectPresenter
    lateinit var mPresenter: MainPresenter

    private val adapter = StateAdapter {
        mPresenter.openDetail(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.load()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvList.layoutManager = LinearLayoutManager(context)
        rvList.adapter = adapter
    }

    override fun loading(isShowLoading: Boolean) {
        progressBar.visibility = if (isShowLoading) View.VISIBLE else View.GONE
    }

    override fun show(list: List<State>) {
        adapter.list = list
        adapter.notifyDataSetChanged()
    }

    override fun showMessage(res: Int) {
        Toast.makeText(context, res, Toast.LENGTH_SHORT).show()
    }
}