# User Guide
This guide covers the features and usage of the Aeugh, Ranice's Duke Project... application.

### Overview
1. [Purpose]()
2. [Features]()
3. [Usage]()
4. [Glossary]()

## Purpose
Aeugh, Ranice's Duke Project... is a simple task managing application. It features a simple Graphical User Interface (GUI) and Command Line Interface (CLI) for user commands.

![](/docs/Ui.png/)

This application was developed for the CS2103T individual project assignment.


## Features 

+ ### Task Types: To-Dos, Deadlines, and Events

There are 3 different types of tasks that can recorded by the task list: To-Dos, Deadlines, and Events. To-Dos are tasks that are not bounded by a date and time. Deadlines and Events are bounded by a date and time. 

+ ### Task List 

This application has an in bult task list that keeps track of all tasks. Each task is assigned an index number dependant on the time at which the task was added into the list, in ascending order. The task list also keeps track of the status of each task, if the task has been completed or not. Tasks can be mark as done, as well as removed from the list. The task list can be printed out into the GUI for user viewing, and the task list features a simple search function to search for tasks in the list.

+ ### Data Saving

Task list data is saved into a `.txt` data file to be loaded into the application in every session. At the end of the session, all changes to the task list will be written back to the data file for use in the next session.

## Usage

### Adding Tasks

+ #### `todo` - Adds 'To-Do' task into task list.

  Describe action and its outcome.

  |Syntax|Example|Outcome|
  |------|-------|--------|
  |`todo (task name)`| `todo homework`||

+ #### `deadline` - Adds 'Deadline' task into task list.

  Describe action and its outcome.

    |Syntax|Example|Outcome|
    |------|-------|--------|
  |`deadline (task name) /by [YYYY-MM-DD] [HHMM]`|`deadline assignment /by 2020-02-01 2359`||

+ #### `event` - Adds 'Event' task into task list.

  Describe action and its outcome.

  |Syntax|Example|Outcome|
  |------|-------|--------|
  |`event (task name) /by [YYYY-MM-DD] [HHMM]`|`event formal dinner /at 2020-02-01 2359`||

### Task List Manipulation

+ #### `delete` - Deletes a task from the task list.

  `delete` helps to delete tasks from the task list, given the index of the task to be deleted.

  |Syntax|Example|Outcome|
  |------|-------|--------|
  |`delete [task index]`| `delete 3`||


+ #### `done` - Marks a task as 'done' in the task list.

  `done` helps to mark a task as 'done' in the task list, given the index of the task to be marked as 'done'.

  |Syntax|Example|Outcome|
  |------|-------|--------|
  |`delete [task index]`| `done 3`||


+ #### `list` - Prints out entire task list.

  `list` helps to display entire task list for user viewing in the GUI.

  |Syntax|Example|Outcome|
  |------|-------|--------|
  |`list`| `list`||

+ #### `find` - Helps to search for a task in the task list given keywords.

  `find` helps to search for a task in the task list given a singular keyword. The tasks are searched by their task names, and any task with a task name containing the specified keyword, will be listed out in the GUI for user viewing.

  |Syntax|Example|Outcome|
  |------|-------|--------|
  |`find [keyword]`| `find book`||

## Glossary


