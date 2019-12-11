This application can work both on GUI mode and Commandline mode.
At the beginning of the program the user can chose his/her preferred mode to interact with it.

I wanted to make the database as readable and clutter-free as possible.
So, I split the database into three files.

1. The "student_database.txt" file contains basic information about each and every student.

The format of the data table is as follows:

Department | ID | Name | CGPA | Credits

2. The "course_database.txt" file contains the information about every courses including
their sections. The section creation system is automated and new section is generated
when the number of students in the ongoing section exceeds 40. This database also contains
the id of the students who are currently assigned to each course.

The format of the data table is:

CourseName | Section | 1st Student's ID | 2nd Student's ID | ..... | nth Student's ID |

3. The "student_progress_database.txt" file contains information about the progress of each
student as the name suggests. It tracks the record of completed courses and CGPA of each of those
courses.

The format of the data table is:

StudentID | CourseName | CGPA


