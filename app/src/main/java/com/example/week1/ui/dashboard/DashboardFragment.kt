package com.example.week1.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.week1.R
import com.example.week1.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

//    private var recyclerView: RecyclerView? = null
//    private var recyclerViewPhotoAdapter : RecyclerViewPhotoAdapter? = null
//    private var photoList = mutableListOf<Photo>()
//
//    private fun preparePhotoListData() {
//        var photo = Photo("dinner", R.drawable.todaydinner)
//        photoList.add(photo)
//        photo = Photo("dinner", R.drawable.todaydinner)
//        photoList.add(photo)
//        photo = Photo("dinner", R.drawable.todaydinner)
//        photoList.add(photo)
//        photo = Photo("dinner", R.drawable.todaydinner)
//        photoList.add(photo)
//        photo = Photo("dinner", R.drawable.todaydinner)
//        photoList.add(photo)
//        photo = Photo("dinner", R.drawable.todaydinner)
//        photoList.add(photo)
//        photo = Photo("dinner", R.drawable.todaydinner)
//        photoList.add(photo)
//        photo = Photo("dinner", R.drawable.todaydinner)
//        photoList.add(photo)
//        photo = Photo("dinner", R.drawable.todaydinner)
//        photoList.add(photo)
//
//        recyclerViewPhotoAdapter!!.notifyDataSetChanged()
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        photoList = ArrayList()
//
//        recyclerView = findViewById<View>(R.id.ivPhotoImage) as RecyclerView
//        recyclerViewPhotoAdapter = recyclerViewPhotoAdapter(this @DashboardFragment, photoList)
//        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, 2)
//        recyclerView!!.layoutManager = layoutManager
//        recyclerView!!.adapter = recyclerViewPhotoAdapter
//
//        preparePhotoListData()

//        val dashboardViewModel =
//            ViewModelProvider(this).get(DashboardViewModel::class.java)

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