[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

# An animated carousel built with Jetpack Compose.

![Alt](AhWRD.jpg)


## Implementation


1. Add it in your root build.gradle at the end of repositories:

````java
allprojects {
   repositories {
    ...
    maven { url 'https://jitpack.io' }
   }
}
````



2.  Add the dependency
````java
dependencies {
    implementation 'com.github.TheBukharian:ComposeCarousel:library_version'
}
````
---
#### Now use it

````java
VerticalCarousel(
     itemsCount = list.size,
     contentWidth = maxWidth,
     contentHeight = 200.dp,
     content = { modifier, index ->

        MyContent(
           item = list[index],
           modifier = modifier
        )
     }
)
````


#### You can build horizontal oriented carousel by using ***HorizontalCarousel***  composable function:

````java
HorizontalCarousel(
  itemsCount = 5,
  width = 250.dp,
  content = { modifier, index ->

      MyContent(modifier, index)
  }
)
````
#### Features
- Smooth scrolling animation
- Dynamic carousel content
- horisontal and vertical orientation





License
-------

    Copyright 2023 Asilbek Tilavov

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
