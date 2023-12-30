package com.example.week1.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.R
import com.example.week1.databinding.FragmentHomeBinding



class ContactFragment : Fragment() {
//    private lateinit var recyclerView: RecyclerView //RecyclerView 클래스 인스턴스
//    private lateinit var adapter: MyAdapter //MyAdapter 클래스 인스턴스

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    //null binding이 아닐 때 binding 가져옴
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val homeViewModel =
//            ViewModelProvider(this).get(ContactViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }


        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.image_profile, "이양파", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile, "김당근", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile, "이양파", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile, "김당근", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile, "이양파", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile, "김당근", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile, "이양파", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile, "김당근", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile, "이양파", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile, "김당근", "010-2222-3333", false))

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = MyAdapter(dataList)
        recyclerView.adapter = adapter
        val decoration = MyAdapter.AddressAdapterDecoration()
        recyclerView.addItemDecoration(decoration)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}