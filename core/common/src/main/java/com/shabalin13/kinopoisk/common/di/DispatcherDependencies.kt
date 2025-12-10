package com.shabalin13.kinopoisk.common.di

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherDependencies {
    @IoDispatcher
    fun ioDispatcher(): CoroutineDispatcher

    @DefaultDispatcher
    fun defaultDispatcher(): CoroutineDispatcher
}
