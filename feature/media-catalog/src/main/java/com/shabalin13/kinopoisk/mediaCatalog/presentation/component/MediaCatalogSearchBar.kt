package com.shabalin13.kinopoisk.mediaCatalog.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaCatalog.R
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings

@Composable
internal fun MediaCatalogSearchBar(
    searchQuery: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val focusRequester = remember { FocusRequester() }

    OutlinedTextField(
        value = searchQuery,
        onValueChange = onQueryChange,
        modifier = modifier
            .focusRequester(focusRequester),
        textStyle = MaterialTheme.typography.titleLarge,
        placeholder = {
            Text(
                text = stringResource(R.string.search_query_placeholder),
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        shape = MaterialTheme.shapes.large,
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = stringResource(
                    R.string.search_icon_content_description
                )
            )
        },
        trailingIcon = if (searchQuery.isNotEmpty()) {
            {
                IconButton(onClick = {
                    onQueryChange("")
                    focusRequester.requestFocus()
                }) {
                    Icon(
                        Icons.Filled.Close,
                        contentDescription = stringResource(R.string.clear_search_icon_content_description)
                    )
                }
            }
        } else {
            null
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch()
            }
        ),
        singleLine = true
    )
}

@Preview(showSystemUi = true)
@Composable
internal fun MediaCatalogSearchBarPreview() {
    KinopoiskTheme {
        var searchQuery by remember { mutableStateOf("") }
        MediaCatalogSearchBar(
            searchQuery = searchQuery,
            onQueryChange = { searchQuery = it },
            onSearch = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(Paddings.small)
        )
    }
}
