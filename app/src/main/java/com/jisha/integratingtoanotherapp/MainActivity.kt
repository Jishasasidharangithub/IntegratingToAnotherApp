package com.jisha.integratingtoanotherapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jisha.integratingtoanotherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        handleEvents()
    }
    private fun handleEvents(){
        binding?.faceBook?.setOnClickListener {
            startActivity(getOpenFacebookIntent())
        }
        binding?.YouTube?.setOnClickListener {
            startActivity(getOpenYouTube())
        }
        binding?.whatsApp?.setOnClickListener {
            startActivity(getOpenWhatApp())
        }
    }
    private fun getOpenFacebookIntent(): Intent {
        return try {
            packageManager.getPackageInfo("com.facebook.katana", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/426253597411506"))
        } catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/appetizerandroid"))
        }
    }
    private fun getOpenYouTube(): Intent? {
        return try {
            packageManager.getPackageInfo("com.google.android.youtube", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCRmoG8dTnv0B7y9uoocikLw"))
        } catch (e: Exception) {
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/channel/UCRmoG8dTnv0B7y9uoocikLw")
            )
        }
    }
    private fun getOpenWhatApp(): Intent? {
        return try{
            packageManager.getPackageInfo("com.whatsapp", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=+918086439333"))
            intent.putExtra(Intent.EXTRA_TEXT, "Hello, this is a message for WhatsApp!")
        }
            catch (e: Exception){
            Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=+918086439333"))
        }
    }
}