package com.example.week1.ui.images

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week1.databinding.FragmentDashboardBinding
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class ImageFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val photoList = mutableListOf<Photo>()

        val jsonString = readJsonFromAssets(requireContext(), "photos.json")

        val jsonObject = JSONObject(jsonString)
        val dataObject = jsonObject.getJSONObject("data")
        val photoArray = dataObject.getJSONArray("photo_list")

        for (i in 0 until photoArray.length()) {
            val photoObject = photoArray.getJSONObject(i)
            val name = photoObject.getString("name")
            val resourceFile = photoObject.getString("resourceFile")

            val drawableId = resources.getIdentifier(resourceFile.substringAfterLast("/").substringBeforeLast("."), "drawable", requireActivity().packageName)

            val photo = Photo(name, drawableId)
            photoList.add(photo)
        }

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        val adapter = RecyclerViewPhotoAdapter(photoList)
        recyclerView.adapter = adapter

        adapter.onItemClick = { photo ->
            val intent = Intent(requireContext(), PhotoIn::class.java)
            intent.putExtra("photo", photo)
            startActivity(intent)
        }

//
//
//
//        val photoList = mutableListOf<Photo>()
//        photoList.add(Photo("frog", R.drawable.frog))
//        photoList.add(Photo("judy", R.drawable.judy))
//        photoList.add(Photo("minniemouse", R.drawable.minniemouse))
//        photoList.add(Photo("pooh", R.drawable.pooh))
//        photoList.add(Photo("santacandle", R.drawable.santacandle))
//        photoList.add(Photo("santasnoopy", R.drawable.santasnoopy))
//        photoList.add(Photo("vanellope", R.drawable.vanellope))
//
//        val recyclerView = binding.recyclerView
//        recyclerView.layoutManager = GridLayoutManager(context, 2)
//        val adapter = RecyclerViewPhotoAdapter(photoList)
//        recyclerView.adapter = adapter
//
//        adapter.onItemClick ={
//            val intent = Intent(requireContext(), PhotoIn::class.java)
//            intent.putExtra("photo", it)
//            startActivity(intent)
//
//        }
//
//
//
//


        return root
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
}