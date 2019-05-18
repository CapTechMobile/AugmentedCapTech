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

/*
 * Copyright 2018 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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