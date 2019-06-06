package com.test.kotlin.ui.fragment.state.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.kotlin.R
import com.test.kotlin.databinding.FragmentDetailBinding
import com.test.kotlin.mvvm.model.entity.State
import com.test.kotlin.mvvm.view.detail.DetailViewModel
import com.test.kotlin.ui.fragment.BaseFragment
import com.test.kotlin.util.binding
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailStateFragment : BaseFragment() {


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

    private lateinit var binding: FragmentDetailBinding
    private val vm: DetailViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        val item = arguments.getParcelable(STATE) as State
        (activity as AppCompatActivity).supportActionBar?.title  = "${item.name}, ${item.country}, ${item.abbr}"
        vm.state.value = item
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = container!!.binding(R.layout.fragment_detail)
        binding.lifecycleOwner = this
        binding.vm = vm
        return binding.root
    }
}