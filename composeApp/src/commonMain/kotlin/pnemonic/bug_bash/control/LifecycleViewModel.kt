package pnemonic.bug_bash.control

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

abstract class LifecycleViewModel : ViewModel() {

    private val observer = LifecycleEventObserver { _, event ->
        when (event) {
            Lifecycle.Event.ON_CREATE -> onCreate()
            Lifecycle.Event.ON_DESTROY -> onDestroy()
            Lifecycle.Event.ON_PAUSE -> onPause()
            Lifecycle.Event.ON_RESUME -> onResume()
            Lifecycle.Event.ON_START -> onStart()
            Lifecycle.Event.ON_STOP -> onStop()
            else -> Unit
        }
    }

    fun observe(lifecycleOwner: LifecycleOwner) {
        // Add the observer to the lifecycle
        lifecycleOwner.lifecycle.addObserver(observer)
    }

    fun onDispose(lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycle.removeObserver(observer)
    }

    open fun onCreate() = Unit
    open fun onStart() = Unit
    open fun onPause() = Unit
    open fun onResume() = Unit
    open fun onStop() = Unit
    open fun onDestroy() = Unit
}