import java.lang.ref.WeakReference

class Ref<out T: Any> internal constructor(obj: T) {
    private val weakRef = WeakReference(obj)
    operator fun invoke(): T? = weakRef.get()
}

fun <T: Any> T.asReference() = Ref(this)
fun <T: Any?> T?.safe(body: (T) -> Unit): T? {
    this?.let(body)
    return this
}