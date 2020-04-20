package com.example.sunflower

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import com.example.sunflower.databinding.FragmentHomeViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator


/**
 * A simple [Fragment] subclass.
 */
class HomeViewPagerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHomeViewPagerBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        // Set the icons and the text for each tab
        TabLayoutMediator(tabLayout, viewPager){tab, position ->
//            tab.setIcon()
        }.attach()
        return binding.root
    }

    private fun getTabIcon(postion: Int): Int{
        return when(postion){

        }
    }

}
