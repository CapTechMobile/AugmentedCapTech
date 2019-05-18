
## ARCore - Augmented Images

This is a demo application of Augmented Images within Sceneform. The purpose of this demo is to demonstrate 3 unique images that are on top of cars and then Sceneform augments the camera to add labels to each of the cars. Furthermore, this app demonstrates that Augmented Images are now able to continue tracking after they leave the camera frame and allow the images found to move while still having the Augmented Content attached to it. 

![a gif of the cars being shown](content/car_show.gif)

The above video demonstrates that after the tracked images leave the frame they are still being tracked by ARCore. This means when their anchored position in the physical world comes back into the camera the label for the car will already be there and we will no longer have to scan the image again. 

![a gif of the cars being shown](content/truck_roll.gif)

The above video demonstrates that after we begin tracking an image, that image can begin to move and the anchored augmented content will move with the image it is attached to. 


# License
Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.