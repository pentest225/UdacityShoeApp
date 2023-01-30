package com.udacity.shoestore.dialogues

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import com.udacity.shoestore.databinding.DialogueAddShoesImageBinding
import timber.log.Timber


class SaveShoeLinkDialogue(context: Context,val onSave:(link:String)->Unit) :Dialog(context) {
    lateinit var binding: DialogueAddShoesImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding = DialogueAddShoesImageBinding.inflate(LayoutInflater.from(context)) // ?? I wonder how well it can work
        setContentView(binding.root)
        this.setCancelable(false)
        binding.btnSaveLink.setOnClickListener {
            if(binding.editText.text.trim().isNotBlank()){
                onSave(binding.editText.text.toString())
                Timber.e("ON SAVE IMAGE")
                this.dismiss()
            }
        }
        super.onCreate(savedInstanceState)
    }

}