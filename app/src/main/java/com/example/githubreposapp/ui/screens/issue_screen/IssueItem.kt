package com.example.githubreposapp.ui.screens.issue_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.githubreposapp.R
import com.example.githubreposapp.ui.screens.issue_screen.model.ReposIssuesUiModel

@Composable
fun IssueItem(
    modifier: Modifier = Modifier,
    issueData: ReposIssuesUiModel
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(10.dp)
            ),

        ) {
        Image(
            painter = painterResource(R.drawable.ic_issues),
            contentDescription = "Warning",
            modifier = Modifier.padding(start = 5.dp, top = 5.dp).size(40.dp),

            )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = issueData.title,
                    modifier = Modifier
                    .padding(bottom = 6.dp)
                    .weight(4f),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = issueData.state,
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp)
                )
            }
            Spacer(Modifier.padding(top = 5.dp))
            Text(
                text = issueData.author,
                fontSize = 20.sp
            )
            Spacer(Modifier.padding(top = 20.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Created At : ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = issueData.date,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}


//@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_6)
//@Composable
//fun GreetingPreview() {
//    IssueItem(issueData = IssueData("item1","15/12/2019 : 9pm"))
//}