# User Guide
This guide covers the features and usage of the Aeugh, Ranice's Duke Project... application.

## Overview
1. [Purpose](#purpose)
2. [Features](#features)
3. [Usage](#usage)
   1. [Adding Tasks](#adding-tasks)
      1. [`todo`](#todo---adds-to-do-task-into-task-list)
      2. [`deadline`](#deadline---adds-deadline-task-into-task-list)
      3. [`event`](#event---adds-event-task-into-task-list)
   2. [Task List Manipulation](#task-list-manipulation)
      1. [`list`](#list---prints-out-entire-task-list)
      2. [`find`](#find---helps-to-search-for-a-task-in-the-task-list-given-keywords)
      3. [`done`](#done---marks-a-task-as-done-in-the-task-list)
      4. [`delete`](#delete---deletes-a-task-from-the-task-list)

## Purpose
Aeugh, Ranice's Duke Project... is a simple task managing application. It features a simple Graphical User Interface (GUI) and Command Line Interface (CLI) for user commands.

![](/docs/Ui.png/)

This application was developed for the CS2103T individual project assignment.


## Features 

+ ### Task Types: To Dos, Deadlines, and Events

There are 3 different types of tasks that can recorded by the task list: To Dos, Deadlines, and Events. To Dos are tasks that are not bounded by a date and time. Deadlines and Events are bounded by a date and time. 

+ ### Task List 

This application has an in bult task list that keeps track of all tasks. Each task is assigned an index number dependant on the time at which the task was added into the list, in ascending order. The task list also keeps track of the status of each task, if the task has been completed or not. Tasks can be mark as done, as well as removed from the list. The task list can be printed out into the GUI for user viewing, and the task list features a simple search function to search for tasks in the list.

+ ### Data Saving

Task list data is saved into a `.txt` data file to be loaded into the application in every session. At the end of the session, all changes to the task list will be written back to the data file for use in the next session.

## Usage

This application is used through a command line interface. You are required to enter commands into a text box to add tasks and manipulate the task list. Entered commands will be echoed into the chat box, afterwhich, the application will output the outcome of your command. 

### Adding Tasks

+ #### `todo` - Adds 'To Do' task into task list.

  This command adds a To Do type task into the task list. \
  It has 1 parameter, `task name`, for the name of the task.

  ##### Example of Usage: 
  
  |Syntax|Example|
  |------|-------|
  |`todo (task name)`| `todo homework`|
  
  ##### Example of Outcome:

  The program will confirm the addition of the task and echo the details of the added task in the chat box. \
  It will also output the resultant number of tasks in your task list.
  ![](/docs/images/todoDemo.png/)
  
+ #### `deadline` - Adds 'Deadline' task into task list.

  This command adds a Deadline type task into the task list. \
  It has 3 parameters, `task name`, for the name of the task, `date` and `time` for the deadline.

  ##### Example of Usage: 
  
  |Syntax|Example|
  |------|-------|
  |`deadline (task name) /by [date] [time]`|`deadline assignment /by 2020-02-01 2359`||

  > :information_source: **Important to Note** \
  > Please enter the date and time in the `YYYY-MM-DD HHMMM` format.
  
  ##### Example of Outcome:
  
  The program will confirm the addition of the task and echo the details of the added task in the chat box. \
  It will also output the resultant number of tasks in your task list.

  ![](/docs/images/deadlineDemo.png/)
  

+ #### `event` - Adds 'Event' task into task list.

  This command adds an Event type task into the task list. \
  It has 3 parameters, `task name`, for the name of the task, `date` and `time` of the event.
  
  ##### Example of Usage: 

  |Syntax|Example|
  |------|-------|
  |`event (task name) /by [date] [time]`|`event formal dinner /at 2020-02-01 2359`||
    
  > :information_source: **Important to Note** \
  > Please enter the date and time in the `YYYY-MM-DD HHMMM` format.

  ##### Example of Outcome:

  The program will confirm the addition of the task and echo the details of the added task in the chat box. \
  It will also output the resultant number of tasks in your task list.
    
  ![](/docs/images/eventDemo.png/)


### Task List Manipulation

+ #### `list` - Prints out entire task list.

  `list` helps to display entire task list for user viewing in the GUI.

  ##### Example of Usage:

  |Syntax|Example|
  |------|-------|
  |`list`| `list`|
  
  ##### Example of Outcome:

  The program will print out the entire task list into the chat box, including the index and status of the task.
  ![](/docs/images/listDemo.png/)

+ #### `find` - Helps to search for a task in the task list given keywords.

  `find` helps to search for a task in the task list given a singular keyword. \ 
  The tasks are searched by their task names, and any task with a task name containing the specified keyword, will be listed out in the GUI for user viewing.

  ##### Example of Usage:

  |Syntax|Example|
  |------|-------|
  |`find [keyword]`| `find dinner`|
  
  ##### Example of Outcome:
  
  The program will print out a list of results containing tasks with tasknames containing the `keyword` substring.
  ![](/docs/images/findDemo.png/)
  
+ #### `done` - Marks a task as 'done' in the task list.

  `done` helps to mark a task as 'done' in the task list, given the index of the task to be marked as 'done'.

  ##### Example of Usage:

  |Syntax|Example|
  |------|-------|
  |`delete [task index]`| `done 1`|
  
  > :information_source: **Important to Note** \
  > Please enter an index that is within the number of items in the task list.
  
  ##### Example of Outcome:

  The program will confirm the completion of the task and echo the details of the task.
  ![](/docs/images/doneDemo.png/)

+ #### `delete` - Deletes a task from the task list.

  `delete` helps to delete tasks from the task list, given the index of the task to be deleted.

  ##### Example of Usage:

  |Syntax|Example|
  |------|-------|
  |`delete [task index]`| `delete 1`|
  
  > :information_source: **Important to Note** \
  > Please enter an index that is within the number of items in the task list.

  ##### Example of Outcome:

  The program will confirm the deletion of the task and echo the details of the deleted task.
  ![](/docs/images/deleteDemo.png/)
  








