package com.example.week1.ui.images

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week1.R
import com.example.week1.databinding.FragmentDashboardBinding

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
        photoList.add(Photo("frog", R.drawable.frog))
        photoList.add(Photo("judy", R.drawable.judy))
        photoList.add(Photo("minniemouse", R.drawable.minniemouse))
        photoList.add(Photo("pooh", R.drawable.pooh))
        photoList.add(Photo("santacandle", R.drawable.santacandle))
        photoList.add(Photo("santasnoopy", R.drawable.santasnoopy))
        photoList.add(Photo("vanellope", R.drawable.vanellope))

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        val adapter = RecyclerViewPhotoAdapter(photoList)
        recyclerView.adapter = adapter

        adapter.onItemClick ={
            val intent = Intent(requireContext(), PhotoIn::class.java)
            intent.putExtra("photo", it)
            startActivity(intent)
        }

        return root
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}