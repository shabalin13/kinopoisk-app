package com.shabalin13.kinopoisk.data.mediaCatalog.remote.dataSources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shabalin13.kinopoisk.data.mediaCatalog.mapper.MediaCatalogMapper
import com.shabalin13.kinopoisk.domain.mediaCatalog.models.MediaCatalogItem
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

internal class MediaCatalogPagingSource @AssistedInject constructor(
    private val mediaCatalogRemoteDataSource: MediaCatalogRemoteDataSource,
    private val mediaCatalogMapper: MediaCatalogMapper,
    @Assisted(QUERY_TAG) private val query: String,
) : PagingSource<Int, MediaCatalogItem>() {

    override fun getRefreshKey(state: PagingState<Int, MediaCatalogItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MediaCatalogItem> {
        val page = params.key ?: INITIAL_PAGE_NUMBER
        val pageSize = params.loadSize

        val result = mediaCatalogRemoteDataSource.getMediaCatalog(query, page, pageSize)

        return result.fold(
            onFailure = { error ->
                LoadResult.Error(error)
            },
            onSuccess = { mediaCatalogDto ->
                val currentPage = mediaCatalogDto.page
                val maxPage = mediaCatalogDto.pages

                val mediaCatalogItems = mediaCatalogMapper.mapToDomain(mediaCatalogDto)

                LoadResult.Page(
                    data = mediaCatalogItems,
                    prevKey = if (currentPage == INITIAL_PAGE_NUMBER) null else currentPage - 1,
                    nextKey = if (currentPage < maxPage) currentPage + 1 else null
                )
            }
        )
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted(QUERY_TAG) query: String,
        ): MediaCatalogPagingSource
    }

    private companion object {
        const val QUERY_TAG = "QUERY_TAG"
        const val INITIAL_PAGE_NUMBER = 1
    }
}
