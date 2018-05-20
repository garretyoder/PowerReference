# PowerReference
PowerReference makes using WeakReferences cleaner and easier.

# Building
PowerReference is hosted on Jitpack. To build it, add jitpack to your sources.
```gradle
maven { url 'https://jitpack.io' }
```
Include PowerReference.
```gradle
dependencies {
  implementation 'com.github.garretyoder:PowerReference:1.0'
}
```


# Usage
Make a reference.
```kotlin
val ref = myObject.asReference()
```
Get object from your reference.
```kotlin
ref()
```
The object will be nullable (?) because your `WeakReference` may have been garbage collected since it's creation. To use it you will have to null check it.
```kotlin
ref()?.let {
  //TODO: do something with the object
}
```
PowerReference provides a simple extension function to make the above pattern easier, `safe`. The `safe` method will work on any object, not just PowerReferences.
```kotlin
ref().safe {
  //TODO: do something with the object
}
```
