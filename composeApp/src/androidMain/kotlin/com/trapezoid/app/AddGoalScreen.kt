import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.trapezoid.app.LeaderboardList
import com.trapezoid.app.PodiumView

@Composable
fun AddGoalScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(vertical = 50.dp, horizontal = 40.dp)) {
        IconButton(
            onClick = { navController.popBackStack() }
        ) {
            Icon(Icons.AutoMirrored.Default.KeyboardArrowLeft, "Back")
        }
        Text(
            text = "Add Goal",
            fontSize = 40.sp,
            fontWeight = FontWeight.Black
        )
        PodiumView()
        LeaderboardList()
    }
}