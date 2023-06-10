package com.example.networkme

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.networkme.databinding.FragmentProfileBinding




class profile : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contactIntent()
        showDialogVersion()
    }



    private fun contactIntent() {
        binding?.apply {


            ivWhatsapp.setOnClickListener {
                val intentWhatsapp = Intent()
                intentWhatsapp.action = Intent.ACTION_VIEW
                intentWhatsapp.addCategory(Intent.CATEGORY_BROWSABLE)
                intentWhatsapp.data = Uri.parse("https://wa.me/6287805766936")
                startActivity(intentWhatsapp)
            }


            ivInstagram.setOnClickListener {
                val intentInstagram = Intent()
                intentInstagram.action = Intent.ACTION_VIEW
                intentInstagram.addCategory(Intent.CATEGORY_BROWSABLE)
                intentInstagram.data = Uri.parse("https://www.instagram.com/dendi_rf06/")
                startActivity(intentInstagram)
            }

            ivLocation.setOnClickListener {
                val intentLocation = Intent()
                intentLocation.action = Intent.ACTION_VIEW
                intentLocation.addCategory(Intent.CATEGORY_BROWSABLE)
                intentLocation.data = Uri.parse("https://goo.gl/maps/oycSYmF3a2w12E387")
                startActivity(intentLocation)
            }
        }
    }

    private fun showDialogVersion() {
        binding?.apply {
            ivAbout.setOnClickListener {
                val builder = AlertDialog.Builder(requireActivity(), R.style.CustomAlertDialog)
                    .create()
                val view = layoutInflater.inflate(R.layout.alert, null)
                val button = view.findViewById<Button>(R.id.buttonClose)
                builder.setView(view)
                button.setOnClickListener {
                    builder.dismiss()
                }
                builder.setCanceledOnTouchOutside(false)
                builder.show()
            }
        }
    }
}