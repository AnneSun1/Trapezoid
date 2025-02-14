package com.trapezoid.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

//import coil.compose.rememberAsyncImagePainter

data class FriendRequest(
    val id: String,
    val name: String,
    val profilePicUrl: String
)

data class Friend(
    val id: String,
    val name: String,
    val profilePicUrl: String,
    val updatesCount: Int
)

@Composable
fun FriendsScreen(navController: NavController) {
    val friends: List<Friend> = listOf(
        Friend("1", "Alice", "", 0),
        Friend("2", "Bob", "", 1),
        Friend("3", "Charlie", "", 0),
        Friend("4", "David", "", 0),
        Friend("5", "Eve", "", 0),
    )
    val friendRequests: List<FriendRequest>  = listOf(
        FriendRequest("6", "Frank", ""),
        FriendRequest("7", "Grace", ""),
        FriendRequest("8", "Heidi", "")
    )
    val onAcceptRequest: (FriendRequest) -> Unit = {}
    val onRejectRequest: (FriendRequest) -> Unit = {}

    var showFriendRequests by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        IconButton(
            onClick = { navController.popBackStack() }
        ) {
            Icon(Icons.AutoMirrored.Default.KeyboardArrowLeft, "Back")
        }
        Text(
            text = "Your Friends",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Friend Requests Dropdown
        if (friendRequests.isNotEmpty()) {
            FriendRequestsSection(
                friendRequests = friendRequests,
                expanded = showFriendRequests,
                onExpandedChange = { showFriendRequests = it },
                onAcceptRequest = onAcceptRequest,
                onRejectRequest = onRejectRequest
            )
        }

        // Friends List
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(friends) { friend ->
                FriendRow(friend = friend)
            }
        }
    }
}


@Composable
private fun FriendRequestsSection(
    friendRequests: List<FriendRequest>,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onAcceptRequest: (FriendRequest) -> Unit,
    onRejectRequest: (FriendRequest) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        // Dropdown Header
        Surface(
            onClick = { onExpandedChange(!expanded) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Friend Requests (${friendRequests.size})",
                    style = MaterialTheme.typography.titleMedium
                )
                Icon(
                    imageVector =  Icons.Default.ArrowDropDown, // TODO: Change based on "expand"
                    contentDescription = if (expanded) "Collapse" else "Expand"
                )
            }
        }

        // Dropdown Content
        AnimatedVisibility(visible = expanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                friendRequests.forEach { request ->
                    FriendRequestRow(
                        request = request,
                        onAccept = { onAcceptRequest(request) },
                        onReject = { onRejectRequest(request) }
                    )
                }
            }
        }
    }
}


@Composable
private fun FriendRequestRow(
    request: FriendRequest,
    onAccept: () -> Unit,
    onReject: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Picture and Name
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
//            Image(
//                painter = rememberAsyncImagePainter(request.profilePicUrl),
//                contentDescription = "Profile picture of ${request.name}",
//                modifier = Modifier
//                    .size(40.dp)
//                    .clip(CircleShape),
//                contentScale = ContentScale.Crop
//            ) // TODO: Uncomment after adding image loading
            Text(text = request.name)
        }

        // Action Buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onAccept,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text("Accept")
            }
            IconButton(onClick = onReject) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Reject friend request"
                )
            }
        }
    }
}


@Composable
private fun FriendRow(friend: Friend) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Picture and Name
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
//            Image(
//                painter = rememberAsyncImagePainter(friend.profilePicUrl),
//                contentDescription = "Profile picture of ${friend.name}",
//                modifier = Modifier
//                    .size(40.dp)
//                    .clip(CircleShape),
//                contentScale = ContentScale.Crop
//            ) // TODO: Uncomment after adding image loading
            Text(text = friend.name)
        }

        // Updates Count
        if (friend.updatesCount > 0) {
            Badge(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = friend.updatesCount.toString())
            }
        }
    }
}