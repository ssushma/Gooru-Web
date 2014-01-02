Gooru Web 0.5.11.0
=============
Introducing Gooru Web 1.0 - a one stop solution to find, share, measure and contribute the Gooru OER content

Introduction
==============
Gooru Web is the front end of the Gooru Application. Gooru makes it easy for the developers to provide millions of topic-relevant and standards-aligned resources, collections, and question items to the teachers and students. This Git repository helps the developers to start building Gooru application, which is open-sourced under the very permissive MIT license.

Features:
==============
Following are the best features of Gooru Learning

Discover
==============
Discover services provide the solution to search millions of resources, collections, and question items in the Gooru Learning Catalog. The Search APIs with the indexing support provide the filters to filter content or the Suggest APIs to personalize the experience by taking user activity and preferences into account.

Organize
==============
Organize provides the solution for the registered users to create collections (multimedia lessons) which include resources such as videos, textbooks like pdf sources, digital text and question items. The Organize services allow you to access content and perform CRUD operations for collections, resources and question items.

Teach
==============
Teach services provide the solution to manage classes, create assignments, and track collection sessions. Create multiple Classpages, which are unique pages for different student groups accessible through URL or “Classcode”. Each Classpage can have a set of assignments, with instructions and a date.

Library
==============
Gooru Library is a brand new way to discover the best collections that the Gooru community has curated across core subject areas.

Authentication
==============
Create new accounts on Gooru using the authenticaion system or Gmail connect.

Social
==============
Share, flag and tag content, access a flexible rating system and protect your users with abuse reporting using Gooru Social services.

Resource Player
==============
This module is responsible for rendering Gooru Resources. Gooru Resources comprise of 9 categories(Video, Website, Interactive, Question, Slide, Textbook, Handout, Lesson, Exam). The Resource Player is capable of rendering all of them. Provides share functionality for sharing a Resource via Facebook, Twitter or Email.

Collection Player
==============
Gooru Collection Player is capable of rendering all types of Gooru Collections including Quizzes and Collections with Questions. Player module contains collection navigation, narration, summary, sharing and printing and adding the resource/collection to the user shelf.

Environment setup and build process
==============
Eclipse IDE is used for the development of Gooru Web. Each developer machine should have the below configuration at minimum level.
JDK: 1.6 or above 
Memory: 4 GB RAM
Disk Space: 20 GB
Operating System: Windows 7 and above or Ubuntu
GWT SDK: 2.4 (stable)
Application container: Apache tomcat7
Apache Maven: Maven 3.0.4
GWT Maven plugin setup instructions: http://mojo.codehaus.org/gwt-maven-plugin/
GWT environment setup in Windows: http://www.youtube.com/watch?v=MKuLDRo8fpM or https://developers.google.com/eclipse/docs/install-eclipse-4.2
GWT environment setup in Ubuntu: http://www.youtube.com/watch?v=bkKxqynHrrQ
 
Build Process
==============
Process 1
1.	Navigate to the development project folder
	For example, cd Home\Projects\ROOT
2.	Clean install the build
	mvn clean install
3.	Run the project
	mvn gwt:run
Process 2
Right-click on the development project in Eclipse IDE and Run as “Web Application (GWT)”

