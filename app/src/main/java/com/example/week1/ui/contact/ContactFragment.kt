package com.example.week1.ui.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week1.R
import com.example.week1.databinding.FragmentHomeBinding


class ContactFragment : Fragment() {
    companion object {
        var itemList = mutableListOf<MyItem>()
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val ADD_Contact_REQUEST = 1
    private lateinit var recyclerCountText : TextView



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        // JSON에서 식당 데이터 로드
//        if (loadedContacts.isEmpty()) {
//            loadedContacts.addAll(loadedContactsFromAssets(requireContext()))
//        }

        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.image_profile1, "이양파1", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile2, "김당근2", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile3, "박감자3", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile4, "송마늘4", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile5, "한통깨5", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile6, "박사과6", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile7, "이수박7", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile8, "박참외8", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile9, "오렌지9", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.image_profile10, "김체리10", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile11, "오감귤11", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile12, "홍당무12", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile13, "한포도13", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.image_profile14, "김망고14", "010-2222-3333", false))
//        val dataList: List<MyItem> = loadedContactsFromAssets()

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = MyAdapter(dataList)
        recyclerView.adapter = adapter
        val decoration = MyAdapter.AddressAdapterDecoration()
        recyclerView.addItemDecoration(decoration)

        //개수 반환
        recyclerCountText = binding.recyclerCount
        recyclerCountText.text = "${adapter.itemCount} ${getString(R.string.recycler_count)}"


        adapter.favoriteClick = object : MyAdapter.FavoriteClick {
            override fun onFavoriteClick(view: View, position: Int) {
                val item = dataList[position]
                item.toggleFavorite()
                adapter.notifyItemChanged(position)
                if (item.isFavorite){
                    Toast.makeText(context, "⭐즐겨찾기 등록⭐️", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context, "⭐즐겨찾기 해제⭐️", Toast.LENGTH_SHORT).show()
                }
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

        binding.contactBtn.setOnClickListener {
            val intent = Intent(requireContext(), ContactNew::class.java)
            startActivity(intent)
        }

        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onItemClick(view: View, position: Int){
                val item = dataList[position]
                val intent = Intent(context, ContactDetail::class.java)
                intent.putExtra("name", item.name)
                intent.putExtra("phone", item.number)
                intent.putExtra("profile", item.profile)
                startActivity(intent)
            }
        }
        return root
    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == ADD_Contact_REQUEST && resultCode == Activity.RESULT_OK) {
//            data?.let {
//                val name = it.getStringExtra("name") ?: ""
//                val phoneNumber = it.getStringExtra("phoneNumber") ?: ""
//                val profileImage = it.getIntExtra("profileImage", R.drawable.default_image_profile) ?: R.drawable.default_image_profile
//                val isFavorite = it.getBooleanExtra("isFavorite", false) ?: false
//                val newItem = MyItem(profileImage,name, phoneNumber, isFavorite)  // 기본 설명 추가
//
//                // 확장 함수를 사용하여 식당 추가 및 정렬
//                loadedContacts.addAndSort(newItem)
//
//                // 어댑터에 알림을 보내 리스트를 갱신
//                val adapter = binding.recyclerView.adapter as? MyAdapter
////                adapter?.submitList(loadedContacts.sortedBy { it.isFavorite })
//                adapter?.addItem(newItem)
//            }
//        }
//    }
    fun MutableList<MyItem>.addAndSort(newItem: MyItem) {
        add(newItem)
        sortByDescending { it.isFavorite }
    }
//    fun parseJsonToBoardItems(json: String): ArrayList<MyItem> {
//        val gson = Gson()
//        val itemType = object : TypeToken<ArrayList<MyItem>>() {}.type
//        return gson.fromJson(json, itemType)
//    }
//
//    val dataList: ArrayList<MyItem> = parseJsonToBoardItems(jsonString)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    private fun loadedContactsFromAssets(context: Context): List<MyItem> {
//        val jsonString = context.assets.open("contacts.json").bufferedReader().use { it.readText() }
//        return Gson().fromJson(jsonString, object : TypeToken<List<MyItem>>() {}.type)
//    }

}