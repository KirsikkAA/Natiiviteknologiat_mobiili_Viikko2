package com.example.viikko2.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import com.example.viikko2.domain.Task
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikko2.TaskViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun HomeScreen(taskViewModel: TaskViewModel = viewModel()) {

    var taskTitle by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        Spacer(modifier = Modifier.height(height = 24.dp))

        Text(
            text= "Task List",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(height = 8.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(taskViewModel.tasks) { task ->
                TaskRow (
                    task = task,
                    onToggle = {taskViewModel.toggleDone(task.id)},
                    onDelete = {taskViewModel.removeTask(task.id)}
                )
            }
        }

        Spacer(modifier = Modifier.height(height = 16.dp))

        OutlinedTextField(
            value = taskTitle,
            onValueChange = {taskTitle = it},
            label = {Text("New task")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(height = 8.dp))

        Button(onClick = {
            if (taskTitle.isNotEmpty()){

                val newId = (taskViewModel.tasks.maxOfOrNull {it.id} ?: 0)+1
                val currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())

                taskViewModel.addTask(
                    Task(
                        id = newId,
                        title = taskTitle,
                        description = "",
                        priority = 1,
                        dueDate = currentDate,
                        done = false
                    )
                )
                taskTitle = ""
            }
        },
            modifier = Modifier.fillMaxWidth()

        ){
            Text(text="Add Task")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(onClick = {
                taskViewModel.sortDueDate()
            }) {
                Text("Sort by date")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                taskViewModel.filterByDone(true)
            }) {
                Text("Show done")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                taskViewModel.reset()
            }) {
                Text("Reset")
            }
        }
    }
}

@Composable
fun TaskRow(
    task: Task,
    onToggle: () -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row (verticalAlignment =  Alignment.CenterVertically){
            Checkbox(
                checked = task.done,
                onCheckedChange = {onToggle()}
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = task.title)
                Text ("Due: ${task.dueDate}")
            }
        }
        Button(onClick = onDelete) {
            Text("Delete")
        }
    }
}
