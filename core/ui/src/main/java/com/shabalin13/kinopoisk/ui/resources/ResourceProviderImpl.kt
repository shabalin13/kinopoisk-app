package com.shabalin13.kinopoisk.ui.resources

import android.content.Context
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(
    private val context: Context,
) : ResourceProvider {
    override fun getString(resId: Int) =
        context.getString(resId)

    override fun getString(resId: Int, vararg formatArgs: Any) =
        context.getString(resId, *formatArgs)

    override fun getQuantityString(resId: Int, quantity: Int, vararg formatArgs: Any) =
        context.resources.getQuantityString(resId, quantity, *formatArgs)
}
