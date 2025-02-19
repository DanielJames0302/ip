# Buddy - User Guide

## Introduction

Buddy chatbot is for those who are *interested in using a desktop app for keeping track of upcoming tasks*. More
importantly, Buddy is
*optimized for those who prefer to work with a Command Line Interface* (CLI) while still having the benefits of a
Graphical User Interface (GUI). If you can type fast, Buddy can help scheduling tasks done faster than
traditional GUI apps. Curious? Jump to the <<Quick Start>> to get started.

## Quick Start

- Ensure you have Java `11` or above installed in your Computer.
- Download the latest `.jar` file under `Releases`
- Copy the file to the folder you want to use as the home folder for your Buddy chatbot.
- Double-click the file to start the app. The GUI should appear in a few seconds.

- Some example commands you can try:

* *`list`* : lists all tasks in the list
* **`todo`**`submit assignment` : adds a Todo task called submit assignment to the task list
* **`delete`**`1` : deletes the 1st task shown in the current list
* *`bye`* : closes the app

## Features

*Command Format*

* Words in `UPPER_CASE` are the parameters to be supplied by the user e.g. in `TASK_TYPE NAME_OF_TASK`,
  `TASK_TYPE, NAME_OF_TASK` are parameters which
  can be used as `todo borrow books`.

* Parameters should follow the order specified by each command below
* Should only have one space between each words in the command format

### Adding a todo task: `todo`

- Adds a todo task to the task list
- Format: `todo TASK_NAME`

Examples:

* `todo submit assignment`
* `todo borrow books`

### Adding a deadline task: `deadline`

- Adds a deadline task to the task list
- Format: `deadline TASK_NAME /by DUE_DATE`
- `DUE_DATE` should follow this format `yyyy-MM-dd HHmm HHmm` (e.g. `2025-02-02 1600`)

Examples:

* `deadline presentation /by 2025-12-02 1000`

### Adding a event task: `event`

- Adds a deadline task to the task list
- Format: `event TASK_NAME /from START_DATE /to END_DATE`
- `START_DATE` and `END_DATE` should follow this format `yyyy-MM-dd HHmm HHmm` (e.g. `2025-02-02 1600`)

Examples:

* `event friend meeting /from 2024-02-02 1400 /to 2024-02-02 1400`

### Listing all tasks in the list: `list`

- Shows a list of all tasks in the current list.
- Format: `list`

### Editing a person : `update`

Edits an existing tasks in the current list. +
Format: `update INDEX /FIELD_TO_UPDATE NEW_INFO`

- Updates the task at the specified `INDEX`. The index refers to the index number shown in the displayed task list. The
  index *must be a positive integer* 1, 2, 3,..
- The field to update must be provided and correctly associated with the task type.
- Existing values will be updated to the input values.

Examples:

- `update 1 /description go to gym`
  Edits the task description the 1st task of type Todo to be `go to gym`.
- `update 2 /by 2025-03-15 1400`
  Edits the due date of the 2nd task of type Deadline to be `2025-03-15 1400`.

### Locating persons by name: `find`

- Finds persons whose names contain any of the given keywords.
- Format: `find KEYWORD`


- The search is not case insensitive. e.g `homework` won't match `Homework`
- Only the task description is searched.
- A list of tasks matching keyword will be returned.

Examples:

- `find homework`
  Returns `1. [T][] homework`

### Deleting a person : `delete`

- Deletes the specified task from the current list.
- Format: `delete INDEX`


- Deletes the task at the specified `INDEX`.
- The index refers to the index number shown in the displayed person list.
- The index *must be a positive integer* 1, 2, 3, ...

Examples:

- `list` +
  `delete 3` +
  Deletes the 3rd task in the current list.

### Exiting the program : `bye`

- Exits the program.
- Format: `bye`

### Saving the data

The data of Buddy chatbot are saved in the hard disk automatically after any command that changes the data.
There is no need to save manually.

## Command Summary

* *Todo* `todo TASK_NAME` +
  e.g. `todo borrow books`
* *Deadline* `deadline TASK_NAME /by DUE_DATE` +
  e.g. `deadline presentation /by 2025-12-02 1000`
* *Event* `event TASK_NAME /from START_DATE /to END_DATE` +
  e.g. `event friend meeting /from 2024-02-02 1400 /to 2024-02-02 1400`
* *Delete* : `delete INDEX` +
  e.g. `delete 3`
* *Mark* : `mark INDEX` +
  e.g. `mark 1`
* *Unmark* : `unmark INDEX` +
  e.g. `unmark 2`
* *Update* : `update INDEX /FIELD_TO_UPDATE NEW_INFO`  +
  e.g. `update /description play game`
* *Find* : `find KEYWORD` +
  e.g. `find homework`
* *List* : `list`
* *Bye* : `bye`
