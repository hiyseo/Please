package com.example.week1.ui.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root




        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.image_profile, "이양파1", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile, "김당근2", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile, "박감자3", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile, "송마늘4", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile, "한통깨5", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile, "이사과6", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile, "이양파7", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile, "김당근8", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile, "이양파9", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile, "김당근10", "010-2222-3333", false))

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = MyAdapter(dataList)
        recyclerView.adapter = adapter
        val decoration = MyAdapter.AddressAdapterDecoration()
        recyclerView.addItemDecoration(decoration)

//        adapter.numberClick = object : MyAdapter.NumberClick {
//            override fun onNumberClick(view: View, position: Int) {
//                val item = dataList[position]
//                val number: String = dataList[position].number
//                val intnet = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
//                startActivity(intnet)
//            }
//        }

        adapter.favoriteClick = object : MyAdapter.FavoriteClick {
            override fun onFavoriteClick(view: View, position: Int) {
                val item = dataList[position]
                item.toggleFavorite()
                adapter.notifyItemChanged(position)
//                dataList.removeAt(position)
//                val newPosition = if (item.isFavorite){
//                    0
//                }
//                else {
//                    dataList.size
//                }
//                adapter.notifyItemMoved(position, newPosition)
//                dataList.add(newPosition, item)
            }
        }


//        binding.contactBtn.setOnClickListener {
//        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}