import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.trapezoid.app.NavBar
import kotlinx.coroutines.launch
@ExperimentalMaterial3Api
@Composable
fun SearchScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }
    val searchBarState = remember { mutableStateOf(false) }
    val suggestions = listOf("Anne", "Bob", "Bill", "Joey", "Jill", "Jack", "Hugh", "Jass")
    val filteredSuggestions = suggestions.filter {
        it.contains(searchQuery, ignoreCase = true) // Use `searchQuery` directly
    }

    Scaffold (
        topBar = {
//            Text(
//                "Trapezoid",
//                modifier = Modifier
//                    .padding(vertical = 25.dp, horizontal = 10.dp),
//
//                style = TextStyle(fontSize = 25.sp)
//            )
        },
        bottomBar = { NavBar(navController) },
        content = { paddingValues ->
            Column (
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 15.dp)
            ) {
                SearchBar(
                    inputField = {
                        TextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            placeholder = { Text("Search...") },
                            modifier = Modifier.fillMaxWidth(),
                            leadingIcon = {
                                IconButton(onClick = {
                                    searchBarState.value = !searchBarState.value
                                }) {
                                    Icon(Icons.Default.Search, contentDescription = null)
                                }
                                          },
                            trailingIcon = {
                                if (searchQuery.isNotEmpty()) {
                                    IconButton(onClick = {
                                        searchQuery = ""
                                    }) {
                                        Icon(Icons.Default.Clear, contentDescription = null)
                                    }
                                } else if(searchBarState.value){
                                    IconButton(onClick = {
                                        searchBarState.value = !searchBarState.value
                                    }) {
                                        Icon(Icons.Default.Clear, contentDescription = null)
                                    }
                                }
                            },
                                )
                    },
                    expanded = isExpanded,
                    onExpandedChange = { isExpanded = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    colors = SearchBarDefaults.colors(),

                    content = {
                        if (filteredSuggestions.isNotEmpty()) {
                            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                                items(filteredSuggestions) { suggestion ->
                                    Text(
                                        text = suggestion,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(8.dp)
                                            .clickable {
                                                // Set the search query to the clicked suggestion
                                                searchQuery = suggestion
                                            }
                                    )
                                }
                            }
                            }
                    }
                )
//                SearchBar(
//                    query = searchQuery.value,
//                    onQueryChange = { searchQuery.value = it },
//                    onSearch = { /* Handle search logic here */ },
//                    active = searchBarState.value,
//                    onActiveChange = { isActive ->
//                        // Toggle the search bar state
//                        searchBarState.value = isActive
//                    },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small),
//                    placeholder = { Text("Search...") },
//                    leadingIcon = {
//                        IconButton(onClick = {
//                            searchBarState.value = !searchBarState.value
//                        }) {
//                            Icon(Icons.Default.Search, contentDescription = null)
//                        }
//
//                                  },
//                    trailingIcon = {
//                        if (searchQuery.value.isNotEmpty()) {
//                            IconButton(onClick = {
//                                searchQuery.value = ""
//                            }) {
//                                Icon(Icons.Default.Clear, contentDescription = null)
//                            }
//                        } else if(searchBarState.value){
//                            IconButton(onClick = {
//                                searchBarState.value = !searchBarState.value
//                            }) {
//                                Icon(Icons.Default.Clear, contentDescription = null)
//                            }
//                        }
//                    },
//                    colors = SearchBarDefaults.colors(
//                        containerColor = Color.Transparent, // Set the container color to transparent
//                    ),
//                    content = {
//                        if (filteredSuggestions.isNotEmpty()) {
//                            LazyColumn(modifier = Modifier.fillMaxWidth()) {
//                                items(filteredSuggestions) { suggestion ->
//                                    Text(
//                                        text = suggestion,
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(8.dp)
//                                            .clickable {
//                                                // Set the search query to the clicked suggestion
//                                                searchQuery.value = suggestion
//                                            }
//                                    )
//                                }
//                            }
//                        }
//                    }

        }


    }
    )
}