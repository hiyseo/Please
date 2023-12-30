package com.example.week1.ui.images

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


//        val photoList = ArrayList<Photo>()
//        val recyclerViewPhotoAdapter = Photo(photoList)
//
//        binding.

        val photoList = mutableListOf<Photo>()
        photoList.add(Photo("dinner", R.drawable.todaydinner))
        photoList.add(Photo("dinner", R.drawable.todaydinner))
        photoList.add(Photo("dinner", R.drawable.todaydinner))
        photoList.add(Photo("dinner", R.drawable.todaydinner))
        photoList.add(Photo("dinner", R.drawable.todaydinner))
        photoList.add(Photo("dinner", R.drawable.todaydinner))
        photoList.add(Photo("dinner", R.drawable.todaydinner))

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        val adapter = RecyclerViewPhotoAdapter(photoList)
        recyclerView.adapter = adapter

        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}