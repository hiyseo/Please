package com.example.week1.ui.contact

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week1.R
import com.example.week1.databinding.FragmentHomeBinding
import com.example.week1.ui.images.Photo
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset


class ContactFragment : Fragment() {
    companion object {
        var itemList = mutableListOf<MyItem>()
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val ADD_Contact_REQUEST = 1
    private lateinit var recyclerCountText : TextView
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var dataList = mutableListOf<MyItem>()
    private lateinit var adapter: MyAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        dataList = mutableListOf<MyItem>()
//        val dataList = mutableListOf<MyItem>()
        val jsonString = readJsonFromAssets(requireContext(), "contacts.json")
        val jsonObject = JSONObject(jsonString)
        val dataObject = jsonObject.getJSONObject("data")
        val photoArray = dataObject.getJSONArray("itemList")

        for (i in 0 until photoArray.length()) {
            val photoObject = photoArray.getJSONObject(i)
            val name = photoObject.getString("name")
            val number = photoObject.getString("number")
            val isFavorite = photoObject.getBoolean("isFavorite")
            val resourceFile = photoObject.getString("profile")
            val drawableId = resources.getIdentifier(resourceFile.substringAfterLast("/").substringBeforeLast("."), "drawable", requireActivity().packageName)
            val item = MyItem(drawableId, name, number, isFavorite)
            dataList.add(item)
            Log.d("name", "${dataList.get(i).name}")
            Log.d("number", "${dataList.get(i).number}")
            Log.d("profile", "${dataList.get(i).profile}")
            Log.d("favorite", "${dataList.get(i).isFavorite}")
        }

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = MyAdapter(dataList)
        recyclerView.adapter = adapter
        val decoration = MyAdapter.AddressAdapterDecoration()
        recyclerView.addItemDecoration(decoration)

        adapter.favoriteClick = object : MyAdapter.FavoriteClick {
            override fun onFavoriteClick(view: View, position: Int) {
                val item = dataList[position]
                item.toggleFavorite()
                adapter.notifyItemChanged(position)
                if (item.isFavorite){
                    dataList.removeAt(position)
                    dataList.add(0,item)
                    Toast.makeText(context, "⭐즐겨찾기 등록⭐️", Toast.LENGTH_SHORT).show()
                    adapter.notifyItemMoved(position,0)
                    adapter.notifyDataSetChanged()
                }
                else{
                    dataList.removeAt(position)
                    dataList.add(dataList.size,item)
                    Toast.makeText(context, "⭐즐겨찾기 해제⭐️", Toast.LENGTH_SHORT).show()
                    adapter.notifyItemMoved(position,0)
                    adapter.notifyDataSetChanged()
                }
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
                intent.putExtra("position",position)
                startForResult.launch(intent)
            }
        }
        //개수 반환
        recyclerCountText = binding.recyclerCount
        recyclerCountText.text = "${adapter.itemCount} ${getString(R.string.recycler_count)}"

        return root
    }

    val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val pos = data?.getIntExtra("positionToRemove", 0)
            Log.d("POS123", pos.toString())
            Log.d("123241", "${dataList.size}")
            val delitem = dataList[pos!!].name
            dataList.removeAt(pos!!)
//            adapter.notifyDataSetChanged()
            Toast.makeText(context, "${delitem}이 삭제되었습니다 !", Toast.LENGTH_SHORT).show()
            adapter.notifyDataSetChanged()
            recyclerCountText.text = "${adapter.itemCount} ${getString(R.string.recycler_count)}"
//            adapter.notifyItemRemoved(pos!!)
        }
    }
    fun MutableList<MyItem>.addAndSort(newItem: MyItem) {
        add(newItem)
        sortByDescending { it.isFavorite }
    }

    private fun readJsonFromAssets(context: Context, fileName: String): String {
        val jsonString: String
        try {
            val inputStream: InputStream = context.assets.open(fileName)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            jsonString = String(buffer, Charset.defaultCharset())
        } catch (e: IOException) {
            e.printStackTrace()
            return ""
        }
        return jsonString
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}