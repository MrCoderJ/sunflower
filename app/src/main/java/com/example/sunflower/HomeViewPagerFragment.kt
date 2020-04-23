package com.example.sunflower

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.sunflower.adapters.MY_GARDEN_PAGE_INDEX
import com.example.sunflower.adapters.PLANT_LIST_PAGE_INDEX
import com.example.sunflower.adapters.SunflowerPagerAdapter
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

        viewPager.adapter = SunflowerPagerAdapter(this)





        // Set the icons and the text for each tab
        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        return binding.root
    }

    private fun getTabIcon(postion: Int): Int{
        return when(postion){
            MY_GARDEN_PAGE_INDEX -> R.drawable.garden_tab_selector
            PLANT_LIST_PAGE_INDEX -> R.drawable.plant_list_tab_selector
            else ->throw IndexOutOfBoundsException()
        }
    }

    private  fun getTabTitle(postion: Int): String?{
        return when(postion){
            MY_GARDEN_PAGE_INDEX -> getString(R.string.my_garden_title)
            PLANT_LIST_PAGE_INDEX -> getString(R.string.plant_list_title)
            else -> null
        }
    }

}
