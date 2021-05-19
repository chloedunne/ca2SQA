# 1. Scrum Sprint Backlog and Task Estimation 
   
### Sprint Backlog      
| Task ID | User Story | Task | Task Owner | Task Estimate | Status of Task |
| --- | ----------- |---- | ----- | ----- | --- |
| 1 | Student Grade Rubric | Create Rubric Class | Chloe | 1 | Done |
| 2 | Student Grade Rubric | Create Student Grade Class | Chloe | 1 | Done |
| 3 | Student Grade Rubric | Create Controller Class | Chloe | 3 | Done |
| 4 | Student Grade Rubric | Create Unit Test Class | Chloe | 3 | Done |
| 5 | Student Grade Rubric | Test Driven Development | Chloe | 2 | Done |
| 6 | Student Grade Rubric | Test Coverage Metric | Chloe | 2 | Done |
| 7 | Student Grade Rubric | Team Version Control | Chloe | 2 | Done |
| 8 | Student Grade Rubric | Code Review Check List | Chloe | 2 | To Be Started |

### Task Estimation  
Task Estimation is used within a SCRUM framework to accurately plan each task in the sprint backlog.
Story points are the most popular method of task estimation within the SCRUM framework as they allow 
teams to measure tasks by the most relevant unit to their process as possible. A story point is a 
high-level estimation of the complexity of the user story. A story point can be any value that a 
SCRUM Team agrees on e.g. hours, days, weeks etc. In this project I have chosen the value of the 
story points to be in hours, therefore 1 hour = 1 point.  
  
To chose the estimates for the tasks in this project, I read through the entire project specifications
in order to determine the requirements needed to fulfil each task. Considering my technical skills and
knowledge on each task, I was able to estimate how long it would take me to code/ document the work 
completed on each task. I do not have much experience in creating a unit testing class so I estimated
this would be longer to create than creating the rubric and student grade classes as these are object
classes which I have created many of before. 

### Velocity Metric  
Velocity is a measure of the amount of work a Team can tackle during a single Sprint and is the key 
metric in Scrum. It is measured in either story points or hours, and is very useful for forecasting as 
it allows the team to estimate how much work they can do in future sprints. Velocity is calculated at the 
end of the Sprint by totalling the Points for all fully completed User Stories.

_Velocity Calculation Example_:   

Sprint 1:  
The team committed to completing 5 user stories and each user story had 4 story points.
This totals to 20 story points. The team fully completed 4/5 user stories.

Sprint 2:  
The team committed to completing 4 user stories and each user story had 4 story points.
This totals to 16 story points. The team fully completed 2/4 user stories.

Sprint 1: 4 user stories x 4 story points = 16  
Sprint 2: 2 user stories x 4 story points = 8  
Total = 24  

Average sprint velocity is equal to 24 ÷ 2 = 12.   

# 2. Unit Testing and Test-Driven Development  

Test-driven development (TDD) is a software development process that relies on software requirements
being converted to test cases before software is fully developed, and tracking all software development
by repeatedly testing the software against all test cases. This is opposed to software being developed 
first and test cases created later. This process instructs developers to write new code only if an 
automated test has failed.

A specific commit that shows test-driven development in my code is the [Method and unit test created for creating a Rubric](https://github.com/chloedunne/ca2SQA/commit/8e084584a3c78f5730b666869728131c9672abb9#diff-d432d59d95d0e0999c1394d5b663f3b5c216efa68599620968766e902f0fc9c6) 
commit. This test case tests both independent paths and boundary cases as there a certain limitations on the 
amount of criterions a rubric can have. If a rubric has more than 10 criterion it will fail to create and return null
and if it has less than 10 criterion the rubric will be created successfully. The amount of criterion a rubric has
is checked in the createRubric function in the Controller class.

# 3. Test Coverage Metric 

The test suite I have used to run my unit tests in this project is JUnit 5 and the code coverage tool I have used is EclEmma. EclEmma is a free Java code coverage tool for Eclipse that brings code coverage analysis directly into the Eclipse workbench. Code coverage is a measurement of how many lines/blocks/arcs of your code are executed while the automated tests are running and so helps you to identify the untested parts of your code. 

![Code Coverage Tool Results](https://github.com/chloedunne/ca2SQA/blob/master/SQA_CA/CodeCoverage.png)

![Example of Code Coverage in Project](https://github.com/chloedunne/ca2SQA/blob/master/SQA_CA/CodeCoverage2.png)

# 4. Team Version-Control 

Version control, also known as source control, is the practice of tracking and managing changes to software code. For this project I worked off the develop branch. I then created feature branches off the develop branch for editing parts of the README.md document. These branches are the testcoveragemetric, versioncontrol and codereview branches. Once I finished editing such parts of the document I then merged the feature branch back into develop by creating a pull request on GitHub. Once I have finished this document fully, I will merge the develop branch into the master branch. 

# 5. Code-Review Checklist