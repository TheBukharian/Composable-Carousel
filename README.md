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
