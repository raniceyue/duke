# User Guide
This guide covers the features and usage of the Aeugh, Ranice's Duke Project... application.

### Contents
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

  Example of usage: 

  `todo (task name)`

  Expected outcome:

  `outcome`

+ #### `deadline` - Adds 'Deadline' task into task list.

  Describe action and its outcome.

  Example of usage: 

  `deadline (task name) /by [YYYY-MM-DD] [HHMM]`

  Expected outcome:

  `outcome`

+ #### `event` - Adds 'Event' task into task list.

  Describe action and its outcome.

  Example of usage: 

  `event (task name) /by [YYYY-MM-DD] [HHMM]`

  Expected outcome:

  `outcome`

### Task List Manipulation

+ #### `delete` - Deletes a task from the task list.

  `delete` helps to delete tasks from the task list, given the index of the task to be deleted.

  Example of usage: 

  `delete [task index]`

  Expected outcome:

  `outcome`

+ #### `done` - Marks a task as 'done' in the task list.

  `done` helps to mark a task as 'done' in the task list, given the index of the task to be marked as 'done'.

  Example of usage: 

  `done [task index]`

  Expected outcome:

  `outcome`

+ #### `list` - Prints out entire task list.

  `list` helps to display entire task list for user viewing in the GUI.

  Example of usage: 

  `list`

  Expected outcome:

  `outcome`

+ #### `find` - Helps to search for a task in the task list given a singular keyword.

  `find` helps to search for a task in the task list given a singular keyword. The tasks are searched by their task names, and any task with a task name containing the specified keyword, will be listed out in the GUI for user viewing.

  Example of usage: 

  `find [keyword]`

  Expected outcome:

  `outcome`

## Glossary


