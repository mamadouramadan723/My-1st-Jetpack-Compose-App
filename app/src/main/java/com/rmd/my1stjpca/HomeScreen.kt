package com.rmd.my1stjpca

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rmd.my1stjpca.model.BottomMenuContent
import com.rmd.my1stjpca.model.Course
import com.rmd.my1stjpca.ui.theme.*

// here we have created HomeScreen function
// and we will call all functions inside it.
// and finally just call this function from mainActivity
@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    // this is the most outer box
    // having all the views inside it
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            // this is the function for header
            GreetingSection()
            // it's for chipsSection, and pass
            // as many strings as you want
            ChipSection(
                chips = listOf(
                    "Data structures",
                    "Algorithms",
                    "competitive programming",
                    "python"
                )
            )
            // function for
            SuggestionSection()
            // this is for course section
            CourseSection(
                // function require list of courses and
                // one course contain 5 attributes
                courses = listOf(
                    Course(
                        title = "geek of the year",
                        R.drawable.ic_headphone,
                        // these are colors.......
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    // below are the copies of the objects
                    // and you can add as many as you want
                    Course(
                        title = "How does AI Works",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Course(
                        title = "Advance python Course",
                        R.drawable.ic_play,
                        skyblue1,
                        skyblue2,
                        skyblue3
                    ),
                    Course(
                        title = "Advance Java Course",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Course(
                        title = "prepare for aptitude test",
                        R.drawable.ic_play,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Course(
                        title = "How does AI Works",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                )
            )
        }
        // this is the final one that is bottomMenu
        BottomMenu(
            items = listOf(
                // having 5 instances
                BottomMenuContent("Home", R.drawable.ic_home),
                BottomMenuContent("explore", R.drawable.ic_baseline_explore_24),
                BottomMenuContent("dark mode", R.drawable.ic_moon),
                BottomMenuContent("videos", R.drawable.ic_videocam),
                BottomMenuContent("Profile", R.drawable.ic_profile),
            ), modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}


@Composable
// and this is the function
// just for creating header at top

fun GreetingSection(
    name: String = "Geeks"
) {
    // here we just arrange the views
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            // heading text view
            Text(
                text = "Good morning, $name",
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        // search icon
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

// This is how we can create chip section at the top of app

@Composable
fun ChipSection(
    // function with single argument
    chips: List<String>
) {
    var selectedChipIndex by remember {
        // it will not update the string
        // but save and it will helpful for us
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        // this is basic condition for selected chip index
                        if (selectedChipIndex == it) ButtonGreen
                        else DarkerButtonGreen
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}
// This function is for suggestion section

@Composable
fun SuggestionSection(
    color: Color = LightGreen1
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            // here are two text views or we can say only text
            Text(
                text = "Daily Coding",
                // it can be little bit confusing but
                // it is just text style alternate
                // of font family in XML
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                // same as above
                text = "do at least • 3-10 problems / day",
                style = MaterialTheme.typography.bodyLarge,
                color = TextWhite
            )
        }
        Box(
            // box containing icon
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonGreen)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
// this function tells us that
// how menu item should look like
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonGreen,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        // it is basically what we should have
        // for creating an element of BottomMenuItem
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

// it's basically how menu item should look like
@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonGreen,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        // here are some parameters
        // for how elements will align
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            // it's basic condition
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun CourseSection(courses: List<Course>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "courses",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(courses.size) {
                CourseItem(course = courses[it])
            }
        }
    }
}

@Composable
fun CourseItem(
    course: Course
) {
    BoxWithConstraints(
        // Box with some attributes
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(course.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight
        // setting 5 points for medium
        // color or we can say for another
        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())
        // joining points to make curves with the help of path class
        // path file that we have created earlier
        // having function that just help to reduce our code
        // and the function is standardQuadFromTo(m1,m2) taking
        // two peramente and connect them
        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        // it's another part of that
        // texture with light color
        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        // canvas is used when we
        // want to draw something
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                // function for drawing paths
                // just pass the path
                path = mediumColoredPath,
                color = course.mediumColor
            )
            drawPath( // it's for the lighter path
                path = lightColoredPath,
                color = course.lightColor
            )
        }
        // so , we have done with texture and
        // now just creating box and other things
        // box containing course elements
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = course.title,
                style = MaterialTheme.typography.headlineMedium,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = course.iconId),
                contentDescription = course.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // Handle the clicks
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonGreen)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}
