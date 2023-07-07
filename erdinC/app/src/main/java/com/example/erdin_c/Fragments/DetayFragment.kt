package com.example.erdin_c.Fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.erdin_c.databinding.FragmentDetayBinding
private const val ARG_MEMBER = "selectedListMember"
private const val ARG_ROW_ID = "selectedRowId"
class DetayFragment : Fragment() {
    private var listMember: String? = null
    private var rowId: Int? = null
    private var fbinding : FragmentDetayBinding?=null
    private val binding get() = fbinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            listMember = it.getString(ARG_MEMBER)
            rowId = it.getInt(ARG_ROW_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentDetayBinding.inflate(inflater, container, false)
        Toast.makeText(requireActivity().baseContext, listMember, Toast.LENGTH_LONG).show()
        binding.apply {
            detayRowIndexTextView.text=rowId.toString()
            detayMemberTextView.text=listMember
        }
        countDowToChange.start()

        return binding.root
    }

    val countDowToChange = object: CountDownTimer(5000, 1000) {
        override fun onTick(millisUntilFinished: Long) {}

        override fun onFinish() {
            binding.apply {
                detayRowIndexTextView.text=(rowId?.plus(5)).toString()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(selectedListMember: String, selectedRowId: Int) =
            DetayFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_MEMBER, selectedListMember)
                    putInt(ARG_ROW_ID, selectedRowId)
                }
            }
    }

    override fun onDestroy() {
        fbinding = null
        countDowToChange.cancel()
        super.onDestroy()
    }


}