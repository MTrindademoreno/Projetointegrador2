package dominando.android.goodfood.view.acticity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.security.FileIntegrityManager
import android.widget.ImageView
import com.squareup.picasso.Picasso
import dominando.android.goodfood.R
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val img =findViewById<ImageView>(R.id.img_splash)
        Picasso.get().load("https://i.pinimg.com/originals/64/19/4c/64194cdfcded215e58a815083a0e88a6.jpg").into(img)
        Timer("SplashScreen", false).schedule(2000) {
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
        }




    }
}