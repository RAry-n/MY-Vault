package com.aryan.vault.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aryan.vault.R
import com.aryan.vault.databinding.FragmentImagesBinding
import com.google.firebase.ktx.Firebase
import java.io.IOException


class Images : Fragment() {

    private var _binding: FragmentImagesBinding? = null
    private val binding get() = _binding!!
    private var imgRef = Firebase.storage.refrence
    private var currentFile: Uri?= null

        //val list=ArrayList<DataClass>()
   // list.add(DataClass(snapshot.child("Filename").getValue(),------,--------))

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            _binding = FragmentImagesBinding.inflate(inflater,container,false)
      binding.floatingActionButton.setOnClickListener{
         Intent(Intent.ACTION_GET_CONTENT).also {
             it.true ="image/*"
         }


}
        return binding.root
    }
    private fun uploadImageToStorage(filename : String)
    {
        try{
            currentFile?
        }catch (e:IOException){

        }
    }


}