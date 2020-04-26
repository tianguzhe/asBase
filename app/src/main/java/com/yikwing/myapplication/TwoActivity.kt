package com.yikwing.myapplication

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.yikwing.livedatapermission.LivePermissions
import com.yikwing.livedatapermission.PermissionResult


@Route(path = "/app/two")
class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

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

    }
}