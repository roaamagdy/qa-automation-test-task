Project Details:

Project Description: A Test Automation Project to automate some tests for webservice using Rest assured, java-TestNG framework and maven repository

Prerequisites:

1.	Java 
2.	JDK 1.7 or higher version
3.	Maven 
4.	Eclipse IDE
 
Installation:

1.	Import the project as maven 
2.	Right click on project and click update project and select force update to download the missing jars included in the project 
3.	You may need to update “JDK” used in eclipse to be “1.7 or higher”

Project Breakdown: 

Project is divided into 3 Packages:
1.	com.billie.api.model:  Contains needed models
a.	CommentModel-> Contains all elements related to comment data (id, postId, name email,body)

2.	com.billie.api.test: Contains all implemented tests:
a.	CommentsTest: Contains test cases covered to verify the required cases 

3.	com.billie.api.util: This package contains helper classes 
a.	DataReader: Used to construct Json object with data saved in json file

To run the Tests, Use one of the following:

1.	Run testng.xml
2.	Run project as “Maven” test 
3.	Run test class directly as “TestNG Test”: com.billie.api.test.CommentsTest
