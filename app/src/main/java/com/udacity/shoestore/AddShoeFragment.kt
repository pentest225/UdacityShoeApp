package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.adapters.AddShoesImageAdapter
import com.udacity.shoestore.adapters.BrandItemAdapter
import com.udacity.shoestore.adapters.ShoesSizeAdapter
import com.udacity.shoestore.databinding.FragmentAddSheeBinding
import com.udacity.shoestore.dialogues.SaveShoeLinkDialogue
import com.udacity.shoestore.models.BrandData
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.utils.DefaultDataList
import timber.log.Timber


class AddShoeFragment : Fragment() {

    lateinit var binding: FragmentAddSheeBinding
    lateinit var addShoesDialog:SaveShoeLinkDialogue
    private val viewModel : ShoeViewModel by viewModels()
    lateinit var shoesSizeAdapter : ShoesSizeAdapter
    lateinit var shoesImageAdapter: AddShoesImageAdapter
    var selectedBrand : BrandData? = null
    var createdShoe:Shoe = Shoe(
        name = "Patrick Shoe",
        description = "",
        smallDescription = "",
        price = "",
        isNewCollection = false,
        company = "",
        images = mutableListOf(),
        size = 0.0
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddSheeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initShoeImageRecyclerView()
        binding.viewModel = viewModel
        binding.createdShoe = createdShoe
        binding.lifecycleOwner = this

        addShoesDialog = SaveShoeLinkDialogue(requireContext(), onSave = {
            viewModel.addShoeImage(it)
        })

        binding.addButton.setOnClickListener {
            addShoesDialog.show()
        }
        binding.spinnerBrand.adapter = BrandItemAdapter(requireContext(),DefaultDataList.brandList)

        binding.spinnerBrand.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                selectedBrand = DefaultDataList.brandList[position]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Timber.i("On Nothing selected")
            }
        }
        binding.buttonSubmit.setOnClickListener {
            saveShoes()
        }

    }

    private fun saveShoes(){
        Timber.i(createdShoe.toString())
        if(selectedBrand == null){
            Toast.makeText(requireContext(),"Select Shoe brand please",Toast.LENGTH_LONG).show()
        }else if(createdShoe.name.isBlank()){
            Toast.makeText(requireContext(),"Add Shoes title please",Toast.LENGTH_LONG).show()
        }else if(createdShoe.description.isBlank()){
            Toast.makeText(requireContext(),"Add Shoes description please",Toast.LENGTH_LONG).show()
        }else if (createdShoe.price.isBlank()){
            Toast.makeText(requireContext(),"Add Shoes PRICE please",Toast.LENGTH_LONG).show()
        }else if(viewModel.addedShoeLink.value == null || viewModel.addedShoeLink.value!!.isEmpty()){
            Toast.makeText(requireContext(),"Select One or more image the shoes please",Toast.LENGTH_LONG).show()
        }
        else{
           val links = viewModel.addedShoeLink.value!!
            createdShoe = createdShoe.copy(
                smallDescription = binding.edDescription.text.toString(),
                company = selectedBrand!!.brandName,
                images = links,
                size = 40.0 //I DON'T HAVE TIME TO IMPLEMENT THE SIZE CLICKER
            )
            viewModel.addNewShow(createdShoe)
            findNavController().navigateUp()
        }

    }

    private fun initShoeImageRecyclerView() {
        //LISTEN ADD SHOE IMAGE
        viewModel.addedShoeLink.observe(viewLifecycleOwner, Observer {

            it?.let {
                if(it.isNotEmpty()){
                    binding.rvShoeImage.isVisible = true
                    shoesImageAdapter = AddShoesImageAdapter(it, onDelete = {
                        viewModel.deleteShoeList(it)
                    })
                    binding.rvShoeImage.adapter = shoesImageAdapter
                }else{
                    binding.rvShoeImage.isVisible = true
                }

            }
        })
        //LISTEN SELECT SIZE
        viewModel.shoeSizeList.observe(viewLifecycleOwner, Observer {

            it?.let {

                shoesSizeAdapter = ShoesSizeAdapter(it, onSelect = {

                })

                binding.rvShoesSize.adapter = shoesSizeAdapter
            }
        })


    }
}