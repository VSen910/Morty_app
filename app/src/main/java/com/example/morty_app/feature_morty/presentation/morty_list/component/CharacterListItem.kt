package com.example.morty_app.feature_morty.presentation.morty_list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.morty_app.feature_morty.domain.model.Character
import com.example.morty_app.ui.theme.fontFamily

@Composable
fun CharacterListItem(
    character: Character,
    onItemClick: (Character) -> Unit
) {
    Card(
        modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp)
    ) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(character) }
            .padding(20.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(data = character.image),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Text(text = "${character.name}", style = TextStyle(fontSize = 18.sp), fontFamily = fontFamily,fontWeight = FontWeight.Bold)
                Text(
                    text = "${character.species} - ${character.status}",
                    style = TextStyle(fontSize = 15.sp),
                    fontFamily = fontFamily,fontWeight = FontWeight.Normal
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun preview_function() {
    val c = Character(
        gender = "Male",
        id = 1,
        image = "https://avatars.githubusercontent.com/u/92343715?v=4",
        name = "gautam",
        species = "Human",
        status = "unmarried",
        type = "developer"
    )
    CharacterListItem(character = c, onItemClick = {})
}