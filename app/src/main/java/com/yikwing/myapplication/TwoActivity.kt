package com.yikwing.myapplication

import android.Manifest
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.yikwing.aidlservice.IYiPay
import com.yikwing.livedatapermission.LivePermissions
import com.yikwing.livedatapermission.PermissionResult
import kotlinx.android.synthetic.main.activity_two.*


@Route(path = "/app/two")
class TwoActivity : AppCompatActivity() {

    var iYiPay: IYiPay? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        registerService()

        LivePermissions(this).request(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        ).observe(this, Observer {
            when (it) {
                is PermissionResult.Grant -> {
                    Toast.makeText(this, "Grant", Toast.LENGTH_SHORT).show()
                }

                is PermissionResult.Rationale -> {
                    it.permissions.forEach { s ->
                        Toast.makeText(this, "deny: $s", Toast.LENGTH_SHORT).show()
                    }
                }

                is PermissionResult.Deny -> {
                    it.permissions.forEach { s ->
                        Toast.makeText(this, "Rationale $s", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        })

        btnPay.setOnClickListener {
//
//            if (iYiPay == null) {
//                registerService()
//            }

            val money =
                iYiPay?.getMoney(username.text.toString().trim(), password.text.toString().trim())
                    ?: "请先安装易支付"

            Toast.makeText(this, money, Toast.LENGTH_SHORT).show()

        }

    }


    private fun registerService() {
        val intent = Intent("con.giao.ge.ipay")
        intent.setPackage("com.yikwing.aidlservice")

        bindService(intent, object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName?) {
                iYiPay = null
            }

            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                iYiPay = IYiPay.Stub.asInterface(service)
            }

        }, Context.BIND_AUTO_CREATE)
    }
}