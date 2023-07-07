package com.example.erdin_c.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.erdin_c.Adapters.CustomListAdapter
import com.example.erdin_c.databinding.FragmentListBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class ListFragment : Fragment() {
    private var fbinding : FragmentListBinding? = null
    private val binding get() = fbinding!!
    private var customListAdapter : CustomListAdapter?=null
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        createCustomListAdapter(takeDataAsList())
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fbinding = FragmentListBinding.inflate(inflater, container, false)
        binding.apply {
            listFragmentListView.adapter = customListAdapter
        }


        return binding.root
    }

    private fun takeDataAsList(): ArrayList<String> {
        return arrayListOf("Patates", "Domates", "Menemen", "Biber", "Skyline GTR R34", "Duck")
    }

    private fun createCustomListAdapter(someItems: ArrayList<String>) {
        customListAdapter =
            CustomListAdapter(requireActivity().baseContext, someItems, requireActivity())
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}