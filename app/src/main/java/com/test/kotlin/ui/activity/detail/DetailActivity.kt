package com.test.kotlin.ui.activity.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.arellomobile.mvp.presenter.InjectPresenter
import com.test.kotlin.R
import com.test.kotlin.mvp.model.entity.State
import com.test.kotlin.mvp.presentation.detail.DetailPresenter
import com.test.kotlin.mvp.view.detail.DetailView
import com.test.kotlin.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity<DetailView>(),
    DetailView {

    companion object {
        private const val STATE = "state"
        fun initIntent(context: Context, item: State): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(STATE, item)
            return intent
        }
    }

    override val mLayoutResource: Int = R.layout.activity_detail

    @InjectPresenter
    lateinit var mPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        mPresenter.setItem(intent.getParcelableExtra(STATE))
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun showInfo(item: State) {
        supportActionBar?.title  = "${item.name}, ${item.country}, ${item.abbr}"
        tvCapital.text = item.capital
        tvLargestCity.text = item.largest_city
        tvId.text = item.id.toString()
    }

}