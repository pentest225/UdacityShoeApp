package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.adapters.ShoesItemAdapter
import com.udacity.shoestore.databinding.FragmentHomeBinding
import timber.log.Timber


class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    private val viewModel : ShoeViewModel by activityViewModels()
    private lateinit var shoeAdapter : ShoesItemAdapter
    private lateinit var mostPopularShoeAdapter : ShoesItemAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addShoeFragment)
        }

        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView(){
        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            it.let { shoelist ->
                shoeAdapter = ShoesItemAdapter(shoelist,R.layout.shoes_vertical_item, onSelectItem = {
                    Timber.i("On Select Shoe")
                })

                mostPopularShoeAdapter = ShoesItemAdapter(shoelist.filter { it ->
                    it.isNewCollection
                },R.layout.shoes_item, onSelectItem = {
                    Timber.i("on Select Shoe")
                })

                binding.rvMostPopular.adapter = shoeAdapter
                binding.rvNewCollection.adapter = mostPopularShoeAdapter
            }
        })
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.logout_menu,menu)
//
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout_menu -> {
                print("Logout")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}