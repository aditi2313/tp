---
layout: page
title: Aditi Gupta's Project Portfolio Page
---

### Project: LibTask

LibTask is a desktop application used by librarians to keep track of books, overdue books, and contact details of patrons who have borrowed them and those who requested them. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC. This project is based on AddressBook - Level 3.

Given below are my contributions to the project.

* **New Feature**:
  * Added the ability to view patron and book details through LibTask GUI [\#49](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/49)
    * What it does:
      * Allows users to view patron and book details quickly via the GUI.
    * Justification:
      * The feature will improve the users' efficiency as they are able to get the details
    * Highlights:
      * This enhancement was challenging as it requires modifying the FlowPane and setting the FXML labels to render the patron and book cards in the main window.
      * In addition, it requires some measurements to ensure that the patron and book cards are rendered in-place.
    * Credits:
      * Using Scene builder to modify FXML files.
      * Understanding GridPane to evenly divide the GUI space for the respective patron and book lists via the [doc oracle guide](https://docs.oracle.com/javafx/2/get_started/fxml_example.fxml.html).
  * Added the ability to find all books related to a particular patron [\#97](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/97), [\#101](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/101)
    * What it does:
      * Allows users to get a list of books related to a particular patron.
    * Justification:
      * The feature will improve the product significantly as it will help users to filter the books that are related to a particular patron of concern.
    * Highlights:
      * This enhancement was rather similar to the `patron find` command. However, the command takes in a patron index instead of keywords.
      * Furthermore, it is challenging as it requires the creation of a predicate to obtain the books that belong to the particular patron of concern.
    * Credits:
      * Worked with [Yu Qi](https://github.com/yuqitanyq) to implement this enhancement.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=aditi2313&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-18&tabOpen=true&tabType=authorship&tabAuthor=aditi2313&tabRepo=AY2122S2-CS2103T-W14-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false)

* **Project management**:
  * Reviewed and approved PRs for merging
  * proposed design suggestions
  * Created `v1.3`, `v1.4` milestones

* **Enhancements to existing features**:
  * Updated the GUI to show book requests [\#111](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/111)
  * Updated the GUI to show book status [\#84](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/84)
  * Updated the GUI to show previous command [\#72](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/72)
  * Updated the GUI to show patron card details [\#63](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/63)
  * Added test cases for Book and Patron commands [\#88](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/88)

* **Documentation**:
  * User Guide:
    * Added documentation for the feature `book related` [\#112](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/112)
    * Added documentation for `quick start` and `introduction` [\#16](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/16)

  * Developer Guide:
    * Added MSS for related book command [\#112](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/112)
    * Update hyperlinks and terms [\#75](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/75)

* **Community**:
  * PR reviewed (with non-trivial review comments): [\#20](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/20), [\#60](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/60), [\#63](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/63), [\#69](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/69), [\#72](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/72), [\#73](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/73), [\#75](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/75), [\#101](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/101), [\#108](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/108), [\#112](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/112), [\#113](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/113), [\#127](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/127), [\#129](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/129), [\#134](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/134), [\#136](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/136), [\#138](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/138), [\#139](https://github.com/AY2122S2-CS2103T-W14-1/tp/pull/139)

* **Tools**:
  * Assertions
  * Gradle
  * Intellij

