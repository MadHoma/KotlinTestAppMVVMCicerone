package com.test.kotlin.ui.fragment.state.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.test.kotlin.R
import com.test.kotlin.mvp.model.entity.State
import com.test.kotlin.mvp.presentation.detail.DetailPresenter
import com.test.kotlin.mvp.view.detail.DetailView
import com.test.kotlin.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailStateFragment : BaseFragment(), DetailView {


    companion object {
        private const val STATE = "state"
        fun newInstance(item: State): DetailStateFragment {
            val bundle = Bundle()
            bundle.putParcelable(STATE, item)
            val fragment = DetailStateFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override val mLayoutResource: Int = R.layout.fragment_detail

    @InjectPresenter
    lateinit var mPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        mPresenter.setItem(arguments.getParcelable(STATE))
    }

    override fun showInfo(item: State) {
        (activity as AppCompatActivity).supportActionBar?.title  = "${item.name}, ${item.country}, ${item.abbr}"
        tvCapital.text = item.capital
        tvLargestCity.text = item.largest_city
        tvId.text = item.id.toString()
    }
}