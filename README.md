This project is a Java application designed to manage children's tasks and wishes. The system includes features for tracking tasks, earning points, and managing wishes.

## Features

### Task Management
- Two different task types:
  - TASK1: Tasks with a specific deadline
  - TASK2: Tasks with a specific time range
- Task completion status tracking
- Task approval and rating
- Daily and weekly task list viewing

### Wish Management
- Two different wish types:
  - Product wishes
  - Activity wishes (with date and time information)
- Wish approval or rejection
- Level requirements for wish control

### Child Profile
- Point system
- Level system (1-4)
- Average rating score
- Bonus point addition feature

### File Operations
- Reading and saving tasks from/to file
- Reading and saving wishes from/to file
- Command file processing

## Class Structure

### Main
Main application class. Manages system startup, command processing, and file operations.

### Child
Manages child profiles. Tracks points, levels, and ratings.

### Task
Manages tasks. Supports two different task types (TASK1 and TASK2).

### Wish
Manages wishes. Supports product and activity wishes.

## Usage

The system runs through a command file. Commands are as follows:

- ADD_TASK1: Add a deadline task
- ADD_TASK2: Add a time-range task
- ADD_WISH1: Add a product wish
- ADD_WISH2: Add an activity wish
- TASK_DONE: Mark a task as completed
- TASK_CHECKED: Check and rate a task
- WISH_CHECKED: Check and approve/reject a wish
- ADD_BUDGET_COIN: Add bonus points
- LIST_ALL_TASKS: List all tasks
- LIST_ALL_WISHES: List all wishes
- PRINT_BUDGET: View budget status
- PRINT_STATUS: View status information
- DAILY_TASKS: List daily tasks
- WEEKLY_TASKS: List weekly tasks

### Command Examples

txt
# Task Addition Examples
ADD_TASK1 T 101 "Math Homework" "Solve pages 10-20" 2025-04-15 15:00 10 
ADD_TASK1 P 102 "Clean Room" "Organize toys" 2025-04-17 18:00 15 
ADD_TASK2 T 201 "Science Project" "Prepare experiment" 2025-04-25 10:00 2025-04-28 12:00 30 

# Task Completion and Check
TASK_DONE 101
TASK_CHECKED 101 4
TASK_DONE 102
TASK_CHECKED 102 5
TASK_DONE 201
TASK_CHECKED 201 3

# Wish Addition Examples
ADD_WISH1 W101 "Bicycle" "Blue mountain bike"
ADD_WISH2 W102 "Cinema" "Watch new movie" 2025-04-19 19:00
ADD_WISH1 W103 "Lego Set" "Star Wars edition"

# Wish Check
WISH_CHECKED W101 APPROVED 2
WISH_CHECKED W102 REJECTED
WISH_CHECKED W103 APPROVED 3

# Bonus Point Addition
ADD_BUDGET_COIN 50

# Listing Commands
LIST_ALL_TASKS
LIST_ALL_TASKS D  
LIST_ALL_TASKS W 
LIST_ALL_WISHES
PRINT_BUDGET
PRINT_STATUS
DAILY_TASKS
WEEKLY_TASKS


### Command Formats

1. Task Addition:
   - TASK1: ADD_TASK1 [T/P] [ID] [Title] [Description] [Date] [Time] [Points]
   - TASK2: ADD_TASK2 [T/P] [ID] [Title] [Description] [Start Date] [Start Time] [End Date] [End Time] [Points]

2. Wish Addition:
   - WISH1: ADD_WISH1 [ID] [Title] [Description]
   - WISH2: ADD_WISH2 [ID] [Title] [Description] [Date] [Time]

3. Task Operations:
   - Completion: TASK_DONE [Task ID]
   - Check: TASK_CHECKED [Task ID] [Rating (1-5)]

4. Wish Operations:
   - Check: WISH_CHECKED [Wish ID] [APPROVED/REJECTED] [Level]

5. Bonus Points:
   - ADD_BUDGET_COIN [Points]

### Output Examples

#### Wish List Output

Wish ID: W101, Title: 'Bicycle', Description: 'Blue mountain bike', Status: Approved, Required Level: 2
Wish ID: W103, Title: 'Lego Set', Description: 'Star Wars edition', Status: Approved, Required Level: 3


#### Task List Output

| Task ID | Title           | Child | Points | Type   | Deadline/Start    | End Time         | Status   | Rating |
|---------|-----------------|-------|--------|--------|-------------------|------------------|----------|--------|
| 101     | Math Homework   | C1    | 10     | TASK1  | 2025-04-15 15:00  | -                | Approved | 4.0    |
| 102     | Clean Room      | C1    | 15     | TASK1  | 2025-04-17 18:00  | -                | Approved | 5.0    |
| 201     | Science Project | C1    | 30     | TASK2  | 2025-04-25 10:00  | 2025-04-28 12:00 | Approved | 3.0    |


#### Budget Status Output

| Child ID | Name         | Points |
|----------|--------------|--------|
| C1       | DefaultChild | 65     |


#### Status Information Output

| Child ID | Name         | Level | Avg Rating |
|----------|--------------|-------|------------|
| C1       | DefaultChild | 2     | 4.00       |


## File Structure

The system uses the following files:

1. Commands.txt: File for writing commands
2. Tasks.txt: File for saving tasks
3. Wishes.txt: File for saving wishes

### Tasks.txt Format

Task ID: 101, Title: 'Math Homework', Description: 'Solve pages 10-20', Deadline: 2025-04-15 15:00, Points: 10, Child ID: C1, Status: completed, Rating: 4.0
Task ID: 102, Title: 'Clean Room', Description: 'Organize toys', Deadline: 2025-04-17 18:00, Points: 15, Child ID: C1, Status: completed, Rating: 5.0
Task ID: 201, Title: 'Science Project', Description: 'Prepare experiment', Start: 2025-04-25 10:00, End: 2025-04-28 12:00, Points: 30, Child ID: C1, Status: completed, Rating: 3.0


### Wishes.txt Format

Wish ID: W101, Title: 'Bicycle', Description: 'Blue mountain bike', Status: Approved, Required Level: 2
Wish ID: W103, Title: 'Lego Set', Description: 'Star Wars edition', Status: Approved, Required Level: 3


### Commands.txt Format

ADD_TASK1 T 101 "Math Homework" "Solve pages 10-20" 2025-04-15 15:00 10
ADD_TASK1 P 102 "Clean Room" "Organize toys" 2025-04-17 18:00 15
ADD_TASK2 T 201 "Science Project" "Prepare experiment" 2025-04-25 10:00 2025-04-28 12:00 30


## Requirements

- Java 8 or higher
- File read/write permissions

## Installation

1. Clone the project
2. Compile the project using Java compiler
3. Prepare the command file
4. Run the application

## License

This project is licensed under the [MIT License](LICENSE).
