package com.example.erdin_c.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.erdin_c.Fragments.DetayFragment
import com.example.erdin_c.R


open class CustomListAdapter(private val context : Context, private val list : ArrayList<String>, private val fragmentActivity: FragmentActivity) : BaseAdapter() {

    fun onCreateViewHolder(itemView : View, parent : ViewGroup) : View {
        var itemView = itemView


        return itemView
    }
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
       return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = inflateTheLayout(convertView, parent)
        val (rowIndexTextView: TextView, listMemberTextView: TextView) = setTextViews(convertView)
        setDataToViews(rowIndexTextView, position, listMemberTextView, convertView)
        return convertView
    }

    private fun setDataToViews(rowIndexTextView: TextView, position: Int, listMemberTextView: TextView, convertView: View?) {
        rowIndexTextView.text = position.toString()
        listMemberTextView.text = list[position]
        convertView?.setOnClickListener() {
            val selectedDetayFragment = DetayFragment.newInstance(list[position], position)
            startFragment(selectedDetayFragment)
        }
    }

    private fun setTextViews(convertView: View?): Pair<TextView, TextView> {
        val rowIndexTextView: TextView = convertView!!.findViewById(R.id.rowIndex)
        val listMemberTextView: TextView = convertView.findViewById(R.id.listMemberTextView)
        return Pair(rowIndexTextView, listMemberTextView)
    }

    private fun inflateTheLayout(convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        convertView = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_row, parent, false)
        return convertView
    }

    private fun startFragment(fragment: Fragment) {
        val supportFragmentManager1 = fragmentActivity.supportFragmentManager
        val transaction = supportFragmentManager1.beginTransaction()
        transaction.replace(R.id.mainActivityFragmentContainer, fragment, "tagg")
        transaction.addToBackStack("tagg")
        transaction.commitAllowingStateLoss()
    }
}