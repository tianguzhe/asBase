package com.yikwing.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.Logger
import com.yikwing.myapplication.network.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {


    private lateinit var requestJob: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNetwork()

        btnIc.setOnClickListener {
            ARouter.getInstance().build("/app/two").navigation()
        }


    }

    private fun initNetwork() {
        requestJob = CoroutineScope(Dispatchers.IO).launch {
            val result = RetrofitFactory.instance.getWxList()
            withContext(Dispatchers.Main) {
                result.data.forEach {
                    Logger.d(it.name)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        requestJob.takeIf { it.isActive }?.cancel()
    }
}