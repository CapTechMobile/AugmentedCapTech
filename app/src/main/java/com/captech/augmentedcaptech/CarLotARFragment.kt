package com.captech.augmentedcaptech

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.ar.core.AugmentedImageDatabase
import com.google.ar.core.Config
import com.google.ar.core.Session
import com.google.ar.sceneform.ux.ArFragment
import java.io.IOException

class CarLotARFragment : ArFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentView = super.onCreateView(inflater, container, savedInstanceState)
        //hide some of the plane finders and discovery since its not needed for augmented images.
        planeDiscoveryController.hide()
        planeDiscoveryController.setInstructionView(null)
        arSceneView.planeRenderer.isEnabled = false
        return fragmentView!!

    }


    override fun getSessionConfiguration(session: Session?): Config {
        val arConfig = super.getSessionConfiguration(session)
        arConfig.focusMode = Config.FocusMode.AUTO
        if (session == null || !setupAugmentedImageDatabase(arConfig, session))
            activity?.finish()
        return arConfig
    }


    private fun setupAugmentedImageDatabase(config: Config, session: Session): Boolean {
        var augmentedImageDatabase: AugmentedImageDatabase? = null
        try {
            context!!.assets.open("car_database.imgdb")
                .use { loadedDB -> augmentedImageDatabase = AugmentedImageDatabase.deserialize(session, loadedDB) }
        } catch (e: IOException) {
            return false
        }

        config.augmentedImageDatabase = augmentedImageDatabase
        return true
    }


}