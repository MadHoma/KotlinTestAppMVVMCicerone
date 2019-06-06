package com.test.kotlin.ui.fragment.state.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.test.kotlin.R
import com.test.kotlin.databinding.FragmentListStateBinding
import com.test.kotlin.mvvm.view.main.ListStateViewModel
import com.test.kotlin.ui.adapter.StateAdapter
import com.test.kotlin.ui.fragment.BaseFragment
import com.test.kotlin.util.binding
import kotlinx.android.synthetic.main.fragment_list_state.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListStateFragment : BaseFragment() {

    companion object {
        fun newInstance() = ListStateFragment()
    }

    private lateinit var binding: FragmentListStateBinding
    private val vm: ListStateViewModel by viewModel()

    private val adapter = StateAdapter {
        vm.openDetail(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.load()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = container!!.binding(R.layout.fragment_list_state)
        binding.lifecycleOwner = this
        binding.vm = vm
        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvList.layoutManager = LinearLayoutManager(context)
        rvList.adapter = adapter
        vm.list.observe(this, Observer { list ->
            list?.let {
                adapter.list = it
                adapter.notifyDataSetChanged()
            }
        })

        vm.message.observe(this, Observer { message ->
            message?.let {
                showMessage(it)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
    }

    private fun showMessage(res: Int) {
        Toast.makeText(context, res, Toast.LENGTH_SHORT).show()
    }
}