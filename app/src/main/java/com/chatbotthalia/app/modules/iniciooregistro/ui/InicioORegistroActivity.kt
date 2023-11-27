package com.chatbotthalia.app.modules.iniciooregistro.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.chatbotthalia.app.R
import com.chatbotthalia.app.appcomponents.base.BaseActivity
import com.chatbotthalia.app.databinding.ActivityInicioORegistroBinding
import com.chatbotthalia.app.modules.iniciarsesion.ui.IniciarSesionActivity
import com.chatbotthalia.app.modules.iniciooregistro.`data`.viewmodel.InicioORegistroVM
import com.chatbotthalia.app.modules.registro.ui.RegistroActivity
import kotlin.String
import kotlin.Unit

class InicioORegistroActivity :
    BaseActivity<ActivityInicioORegistroBinding>(R.layout.activity_inicio_o_registro) {
  private val viewModel: InicioORegistroVM by viewModels<InicioORegistroVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.inicioORegistroVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = IniciarSesionActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
      }, 3000)
    }

    override fun setUpClicks(): Unit {
      binding.btnRegistrate.setOnClickListener {
        val destIntent = RegistroActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      binding.txtIniciaSesin.setOnClickListener {
        val destIntent = IniciarSesionActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    companion object {
      const val TAG: String = "INICIO_O_REGISTRO_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, InicioORegistroActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
