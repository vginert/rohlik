package com.vginert.rohlik.shared.core.coroutines

import com.vginert.rohlik.shared.core.result.runSuspendCatching
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

suspend inline fun <R> CoroutineScope.executeUseCase(block: () -> R): Result<R> {
    val currentExecContext = coroutineScope { coroutineContext }
    val exceptionHandler = currentExecContext[CoroutineExceptionHandler]
    return runSuspendCatching(block)
        .onFailure {
            exceptionHandler?.handleException(currentExecContext, it)
        }
}
