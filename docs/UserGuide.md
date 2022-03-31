---
layout: page
title: User Guide
---

LibTask is a **desktop application for librarians to manage book loans and requests by patrons, optimized for use via a [Command Line Interface (CLI)](#6-glossary)** while still having the benefits of a Graphical User Interface (GUI). If you can type fast, LibTask can get your book tracking tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

# **1. Introduction**

## 1.1. Welcome to LibTask
As a school librarian of a large library, you may already have your own desktop library software. However, existing library software are GUI-based and slow to work with. If you prefer to work with CLI commands efficiently while still having the benefits of aesthetic displays, then LibTask is designed just for you! LibTask provides you with a well packaged system of commands for managing book loans and book requests by your patrons. With LibTask, you can quickly process borrowing and returning of books by typing a few commands. The system also maintains two independent lists of books and patrons, allowing you to perform queries more efficiently.

## 1.2. About the User Guide
The purpose of this guide is to explain to you how to use **LibTask** and to allow you to have an enjoyable experience. It explains the features and commands compatible with LibTask.  It is also structured in a way that lets you easily navigate to relevant sections.

Take note of following symbols that are used in this document:

* :information_source:: This symbol is used to highlight extra knowledge.

* :exclamation:: This symbol is used to warn users of potential actions that might corrupt the LibTask's data file.

## 1.3. Navigating the User Guide

For help with the setup of LibTask, you can refer to head to our [Quick start](#2-quick-start) section.

For the full documentation of each feature, you can refer to our [Features](#3-features) section.

For frequently asked questions about LibTask, you can refer to our [FAQ](#4-faq) section.

For a quick overview of all the commands in LibTask, you can refer to our [Command summary](#5-command-summary) section.

For the list of definitions of vocabulary words used in this document can be found in our [Glossary](#6-glossary) section.

--------------------------------------------------------------------------------------------------------------------

# **2. Quick start**

1. Ensure you have Java `11` or above installed in your Computer. You can follow this [guide](https://docs.oracle.com/en/java/javase/11/install) to download and install java.

1. Download the latest `libtask.jar` from [here](https://github.com/AY2122S2-CS2103T-W14-1/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your LibTask.

1. Double-click the file to start the app. The GUI is similar to the one shown below and should appear in a few seconds.<br>
   ![Ui](images/Ui.png)

1. Type a command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open a help window.<br>
   Here are some sample commands you can try:

   * **`patron list`** : Lists all patrons in LibTask's patron list.

   * **`patron add n/Alice s/S01823283S p/90123212 e/profA@u.nus.edu `** : Adds a patron named `Alice` into LibTask's patron list.

   * **`patron delete 3`** : Deletes the 3rd patron shown in the displayed patron list.

   * **`book add n/Harry Potter i/12398-12398-239 a/J.K.Rowling t/Thriller t/Magic`**: Adds a book titled `Harry Potter`into LibTask's book list.

   * **`book list`** : Lists all books in LibTask's book list.

   * **`book delete 1`** : Deletes the 1st book shown in the displayed book list.

   * **`exit`** : Exits LibTask.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

# **3. Features**

This section describes the features supported by LibTask and how to use them.

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `patron delete INDEX`, `INDEX` is a parameter which the user can enter and can be used as `patron delete 1`.

* Items in square brackets are optional.<br>
  e.g. `patron add n/NAME s/ID p/PHONE e/EMAIL [t/TAG]…​ ` can be used as `patron add n/John s/A0123456A p/93231222 e/e03482@u.nus.edu t/student` or as `patron add n/John s/A0123456A p/93231222 e/e03482@u.nus.edu`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend` or `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `patron list`, `book list`, `exit` and `clear`) will be ignored.<br>
  e.g. `help 123` will be interpreted as `help`.

</div>

## 3.1. General Features

--------------------------------------------------------------------------------------------------------------------

### 3.1.1. Viewing help : `help`

Opens a help window explaining how to access LibTask's user guide.

![help message](images/helpMessage.png)

Format: `help`

### 3.1.2. Clearing all entries : `clear`

Clears all patrons and books from LibTask's patron and book lists.

Format: `clear`

### 3.1.3. Exiting LibTask : `exit`

Exits the program.

Format: `exit`

### 3.1.4. Retrieving previous command: `u`

Retrieves the previous command entered by the user back to the command box.

Format: `u`

* Loads your previous successfully entered commands back to the command box so you can view and rerun it.
* Only allows each command to be viewed once.

### Saving LibTask's data

LibTask's data is saved in the hard disk automatically after any command that changes it. There is no need to save manually.

## 3.2. Patron Features

--------------------------------------------------------------------------------------------------------------------
### 3.2.1. Adding a patron: `patron add`
Adds a patron to LibTask's patron list.

Format: `patron add n/NAME s/ID p/PHONE e/EMAIL [t/TAG]…​`

Examples:
* `patron add n/John s/A02128282A p/93231222 e/e03482@u.nus.edu t/student`
* `patron add n/Alice s/S01823283S p/90123212 e/profA@u.nus.edu`

### 3.2.2. Listing all patrons : `patron list`

Shows a list of all patrons in LibTask's patron list.

Format: `patron list`

* If all patrons are already listed, the command will still show a success message as having listed all patrons, but the patrons listed will have no visual change.

### 3.2.3. Editing a patron : `patron edit`

Edits the details of a patron at a specified index of the displayed patron list.

Format: `patron edit INDEX [n/NAME] [s/ID] [p/PHONE] [e/EMAIL] [t/TAG]…​`

* Edits the patron at the specified `INDEX`. The index refers to the index number shown in the displayed patron list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the patron will be removed i.e. adding of tags is not cumulative.
* You can remove all the patron’s tags by typing `t/` without
    specifying any tags after it.

Examples:
* `patron edit 1 n/John Cena p/91959491 e/johncena@u.nus.edu` Edits the name, phone number and email address of the 1st patron in the displayed patron list to be `John Cena`, `91959491` and `johncena@u.nus.edu` respectively.
* `patron edit 2 n/Alice t/Professor t/Horror ` Edits the name of the 2nd patron in the displayed patron list to be `Alice` and changes tags to `Professor` and `Horror`.

### 3.2.4. Finding a patron by name: `patron find`

Finds all patrons with names matching the given keywords in LibTask's patron list.

Format: `patron find KEYWORD [KEYWORD]…​`

* The search is case-insensitive. e.g. `hans` will match `Hans`
* The order of the keywords does not matter. e.g. results from the keyword `Hans Bo` will match results of the keyword `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. results from the keyword `Han` will not match results from the keyword `Hans`
* Patrons matching at least one part of the keyword will be returned (i.e. `OR` search).
  e.g. keyword `Hans Bo` will return patrons with names `Hans Gruber`, `Bo Yang`

Example:

`patron find alex david` returns `Alex Yeoh`, `David Li`<br>

  ![result for 'find alex david'](images/findAlexDavidResult.png)

### 3.2.5. Deleting a patron : `patron delete`

Deletes the patron at a specified index in the displayed patron list.

Format: `patron delete INDEX`

* Deletes the patron at the specified `INDEX`.
* The index refers to the index number shown in the displayed patron list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `patron list` followed by `patron delete 2` deletes the 2nd patron shown in the displayed patron list.
* `patron find n/Betsy` followed by `patron delete 1` deletes the 1st person in the results of the `find` command.

### 3.2.6. Listing all patrons with overdue books : `patron overdue`

Lists all patrons in LibTask's patron list with overdue books.

Format: `patron overdue`

## 3.3. Book Features

--------------------------------------------------------------------------------------------------------------------

### 3.3.1. Adding a book: `book add`
Adds a book to LibTask's book list.

Format: `book add n/NAME i/ISBN [a/AUTHOR …] [t/CATEGORY_TAG …] `

<div markdown="span" class="alert alert-primary">

**Tip:**
* ISBN must be 10 or 13 digits in length
</div>

Examples:
* `book add n/Harry Potter i/978-7-783828-15-1 a/J.K.Rowling t/Thriller t/Magic`
* `book add n/Heads You Lose i/979-381-26-8943-3 a/Lisa Lutz a/David Hayward`

### 3.3.2. Listing all books : `book list`

Shows a list of all books in LibTask's book list.

Format: `book list`

* If all books are already listed, the command will still show a success message as having listed all books, but the books listed will have no visual change.

### 3.3.3. Finding books : `book find`

Lists all books in LibTask's book list that satisfy the predicates given.

Format: `book find [n/NAME] [t/CATEGORY_TAG] [a/AUTHOR]`

* Finds the books that match the predicate supplied.
* Only one of the optional fields can be provided.
* The tag, name and author must be provided will also return partial results. 

Examples:
* `book find n/Harry` Returns all books in LibTask's book list whose titles contain the word `Harry`.
* `book find t/Adventure` Returns all books in LibTask's book list which have a tag `Adventure`.

### 3.3.4. Editing a book : `book edit`

Edits the details of a book at a specified index of the displayed book list.

Format: `book edit INDEX [n/NAME] [i/ISBN] [a/AUTHOR …] [t/CATEGORY_TAG …]`

* Edits the book at the specified `INDEX`. The index refers to the index number shown in the displayed book list. The index **must be a positive integer** 1, 2, 3, … and smaller than or equal to the number of books in the displayed list.
* At least one of the optional fields (ISBN, AUTHOR, CATEGORY_TAG) must be provided.
* Existing values will be updated to the input values.
* When editing tags or authors, the existing tags or authors of the book will be removed i.e. adding of tags and authors is not cumulative. However, if all tags are added in a single input, the multiple tags will be added.
* You can remove all the book’s authors and tags by typing `a/` or `t/` respectively without
    specifying any tags after it.

Examples:
* `book edit 1 n/Harry Potter: Sorcerer's Stone t/Adventure t/Magic` edits the name of the 1st book to be `Harry Potter: Sorceror's Stone` and edit its category tag to be `Adventure` and `Magic`.
* `book edit 2 i/978-79317-3-542-3 a/Another Rowling t/` edits the ISBN of the 2nd book to be `978-79317-3-542-3`, changes the author to `Another Rowling` and clears all existing tags.

### 3.3.5. Deleting a book : `book delete`

Deletes the book at the specified index in the displayed book list.

Format: `book delete INDEX`

* Deletes the book at the specified `INDEX`.
* The index refers to the index number shown in the displayed book list.
* The index **must be a positive integer** 1, 2, 3, … and smaller than or equal to the number of books in the displayed list.

Examples:
* `book list` followed by `book delete 2` deletes the 2nd book from LibTask's book list.

### 3.3.6. Borrowing a book : `borrow`

Allows the patron at `INDEX1` of the displayed patron list to borrow a book at `INDEX2` of the displayed book list.

Format: `borrow INDEX1 INDEX2`

* `INDEX1` refers to the index number of a patron shown in the displayed patron list.
* `INDEX2` refers to the index number of a book shown in the displayed book list.
* `INDEX1` **must be a positive integer** 1, 2, 3, … and smaller than or equal to the number of patrons in the displayed list.
* `INDEX2` **must be a positive integer** 1, 2, 3, … and smaller than or equal to the number of books in the displayed list.
* The book at `INDEX2` must not be already borrowed.

Examples:
* `patron list` and `book list` followed by `borrow 2 3` establishes a relationship that the 2nd patron borrows the 3rd book.

### 3.3.7. Returning a book : `return`

Depending on the exact command, returns all books borrowed by a patron at a specified index of the displayed patron list, or returns a book at a specified index in the displayed book list.

Format: `return PREFIX/INDEX`

* `PREFIX` must be either `p` for patrons or `b` for books.
* If `PREFIX` is `p`, `INDEX` refers to the index number shown in the displayed patron list.
* If `PREFIX` is `b`, `INDEX` refers to the index number shown in the displayed book list.
* `INDEX` **must be a positive integer** 1, 2, 3, … and smaller than or equal to the number of patrons or books in the displayed list.
* If the book at index `INDEX` is not borrowed, or if the patron at index `INDEX` does not borrow any books, nothing happens.

Examples:
* `patron list` followed by `return p/3` will return all books borrowed by the 3rd patron, if any.
* `book list` followed by `return b/2` will return the 2nd book, if it is borrowed.

### 3.3.8. Requesting a book : `book request`

Establishes a relationship that patron at index `INDEX1` of the displayed patron list is requesting to be notified when the book at index `INDEX2` of the displayed book list is available.

Format: `book request INDEX1 INDEX2`

* `INDEX1` **must be a positive integer** 1, 2, 3, … and smaller than or equal to the number of patrons in the displayed list.
* `INDEX2` **must be a positive integer** 1, 2, 3, … and smaller than or equal to the number of books in the displayed list.
* If the book at index `INDEX2` is currently available, a message will be displayed.

Examples:
* `patron list` and `book list` followed by `book request 1 2` keeps a record that the 1st patron in the displayed patron list would like to be notified when the 2nd book in the displayed book list is available.

### 3.3.9. Listing all books related to a patron : `book related`

Displays all books related to the patron at the specified index of the displayed patron list.

Format: `book related INDEX`

* `INDEX` **must be a positive integer** 1, 2, 3, … and smaller than or equal to the number of patrons in the displayed list.

Examples:
* `book related 1` will display all the books borrowed and requested by the 1st patron in the displayed patron list.


### Editing the data file

LibTask's data is saved as a JSON file `[JAR file location]/data/libtask.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation:
**Caution:**
If your changes to the data file makes its format invalid, LibTask will discard all data and start with an empty data file at the next run.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

# **4. FAQ**

**Q1**: What happens if there is no response after attempting to enter a command?<br>
**A**: Please double-check if the format of the command is written correctly. If the issue persists, please close the application and restart it again.

**Q2**: I tried to edit a book's details, but there seems to be an error message being shown. Why is that so?<br>
**A**: Please do ensure that if the book name is not provided, at least one of the optional fields Isbn, Author and Category tag is provided.

**Q3**: Is there any other way to exit the application without typing?<br>
**A**: Yes, there is another way to exit the program, and that is by clicking the File button on the top left-hand corner of the app. There is an exit button in the dropdown list which appear after clicking the File button.

**Q4**: Will the data of the books be saved if the program was not closed via the `exit` command or via the method shown in Q3?<br>
**A**: Yes the data will still be saved. However, to ensure a better user experience, we recommend using the exit command as described in the user guide.

**Q5**: Is there a shortcut on using the various commands?<br>
**A**: Unfortunately, no there is no shortcut. In order to execute the various commands, please enter the commands in the correct format and with valid inputs.

**Q6**: I entered the `book list` command but nothing has changed. Is this expected?<br>
**A**: Yes, it is expected, as all the books have probably been already listed.

**Q7**: Is there a summary of the commands?<br>
**A**: Yes, there is a summary of commands available, and they can be found in the section below.

**Q8**: Why are there two separate lists for books and patrons instead of one combined list?<br>
**A**: This is done so that the user can see the two lists side by side and have a clearer picture of the various patrons and books in the database.
--------------------------------------------------------------------------------------------------------------------

# **5. Command summary**

## 5.1. General Commands

| Function                                   | Format Of Command                                                          |
|--------------------------------------------|----------------------------------------------------------------------------|
| **Show message to help page**              | `help`                                                                     |
| **Clear all entries**                      | `clear`                                                                    |
| **Exit the program**                       | `exit`                                                                     |
| **Show previous commands**                 | `u`                                                                        |
| **Navigating the different patrons/books** | **Pressing the :arrow_up: and :arrow_down: arrows on keyboard :keyboard:** |

## 5.2. Patron Commands

| Function                            | Format Of Command                                                 |
|-------------------------------------|-------------------------------------------------------------------|
| **Add a new patron**                | `patron add n/NAME s/ID p/PHONE e/EMAIL [t/TAG]…​`                |
| **List all patrons**                | `patron list`                                                     |
| **Edit a patron**                   | `patron edit INDEX [n/NAME] [s/ID] [p/PHONE] [e/EMAIL] [t/TAG]…​` |
| **Find a patron**                   | `patron find n/KEYWORD [n/KEYWORD]…​`                             |
| **Delete a patron**                 | `patron delete INDEX`                                             |
| **List patrons with overdue books** | `patron overdue`                                                  |

## 5.3. Book Commands

| Function                               | Format Of Command                                                   |
|----------------------------------------|---------------------------------------------------------------------|
| **Add a book**                         | `book add n/NAME i/ISBN [a/AUTHOR]…​ [t/CATEGORY_TAG]…​`            |
| **List all books**                     | `book list`                                                         |
| **Find a book**                        | `book find [n/NAME] [t/TAG] [a/AUTHOR]`                             |
| **Edit a book**                        | `book edit INDEX [n/NAME] [i/ISBN] [a/AUTHOR]…​ [t/CATEGORY_TAG]…​` |
| **Delete a book**                      | `book delete INDEX`                                                 |
| **Borrow a book**                      | `borrow INDEX1 INDEX2`                                              |
| **Return a book**                      | `return PREFIX/INDEX`                                               |
| **Request a book**                     | `request INDEX1 INDEX2`                                             |
| **List all books related to a patron** | `book related INDEX`                                                |

# **6. Glossary**

| Term                   | Explanation                                                         |
|------------------------|---------------------------------------------------------------------|
| Command-line interface | a console which users can type text as commands into it to execute. |
