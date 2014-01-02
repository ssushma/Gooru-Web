/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.shared.util;
/**
 * @fileName : MessageProperties.java
 *
 * @description : This interface is used to set the static text.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public interface MessageProperties {
	//Special Characters
	String GL_SPL_SEMICOLON = ":";
	String GL_SPL_STAR = "*";
	String GL_SPL_PLUS = "+";
	String GL_SPL_QUESTION = "?";
	String GL_SPL_EXCLAMATION = "!";
	String GL_GRR_ARE = "are";
	String GL_GRR_IS = "is";
	
	String GL0001="Invalid Request specified";
	String GL0002="Specified Request no longer exists";
	String GL0003="This action can't be performed on the request";
	String GL0004="Invalid Reason specified";
	String GL0005="Comments must be {0} characters or shorter";
	String GL0006="{0} is mandatory";
	String GL0007="Invalid {0} specified";
	String GL0008="{0} must be {1} characters or shorter";
	String GL0009="{0} should not be in future";
	String GL0010="Specified {0} no longer exists";
	String GL0011="Specified file format is not supported";
	String GL0012="Essay file size exceeds the allowed size of 512 KB";
	String GL0013="Specified content has request associated with it";
	String GL0014="Unable to generate PDF document. Please contact system administrator";
	String GL0015="Unable to deliver the document to FTP location. Please contact system administrator with the details";
	String GL0016="Specified Essay is not ready for delivery";
	String GL0017="Feedback sheet is not available for specified request";
	String GL0018="The rubric you have chosen is wrong";
	String GL0019="The rubric rating you have chosen is wrong";
	String GL0021="Document is not available for specified request";
	String GL0022="Specified Request(s) {1} are not allowed for this action";
	String GL0023="No request(s) specified for batch update";
	String GL0024="No language rule code";
	String GL0025="Unable to apply Mark-up Assistant";
	String GL0026="Unable to process bulk upload";
	String GL0027="Error(s) while reading record {0}";
	String GL0028="Configuration file not found";
	String GL0029="Invalid Configuration file";
	String GL0030="No record to upload";
	String GL0031="New Password should be different from Old Password";
	String GL0032="Confirm Password and New Password should be same";
	String GL0033="Enter the correct password";
	String GL0034="Password should be minimum {0} and maximum {1} characters";
	String GL0035="Specified user no longer exists";
	String GL0036="Invalid cell format";
	String GL0037="Code Value {0} is not available";
	String GL0038="Unable to Redflag request";
	String GL0039="Invalid file uploaded";
	String GL0040="Specified username is already associated with another user.";
	String GL0041="Another {0} exists with the same name";
	String GL0042="At least 2 hierarchy must be specified";
	String GL0043="Specified Course has content associated with it";
	String GL0044="You do not have access to delete this course";
	String GL0045="Hierarchy must be unique";
	String GL0046="Free courses does not require any sign-up";
	String GL0047="This course is not allowed for sign-up";
	String GL0048="This course is not allowed for stop sign-up action";
	String GL0049="This course status is not allowed for this action";
	String GL0050="Old Password does not match with existing password";
	String GL0051="Old Password and new password should not be same";
	String GL0052="Max Session time allowed is 4 hours";
	String GL0053="Session Start time and End time is Equal";
	String GL0054="It appears that this record has changed since the time you started editing it. This is likely due to someone else editing the record. You need to perform your edits again.";
	String GL0055="Invalid search type specified";
	String GL0056="{0} not found";
	String GL0057="Redflag reason Code Value is not available";
	String GL0058="Start time greater than End time";
	String GL0059="Only JPG,PNG and GIF files are supported";
	String GL0060="Sorry";
	String GL0061="Oops!";
	String GL0062="Reset password";
	String GL0063="Forgot Password";
	String GL0064="Wait!";
	String GL0065="Aww..";
	
	
	//Register Validation Message
	String GL0066="{0} cannot be empty.";
	String GL0067="Please enter a valid {0}";
	String GL0068="Please select {0}";
	String GL0069="{0} don't match";
	String GL0070="{0} is required";
	String GL0071="{0} should be atleast {1} characters.";
	String GL0072="{0} should be {1} characters.";
	String GL0073="{0} must contain at least one number.";
	String GL0074="PARENT";
	String GL0075="Please select gender";
	String GL0076="Password mustn't be password";
	String GL0077="NONPARENT";
	String GL0078="Password should not be same with the Username";
	String GL0079="Parent/Guardian age mustn't be less than 13";
	String GL0080="Image url mustn't be empty";
	String GL0081="Paste a valid url";
	String GL0082="Please enter your {0}.";
	
	//Validation Msgs
	
	String GL0091="Drag it to one of your collections";
	String GL0092="The email address specified already exists within Gooru, but your account is not activated yet. Re-Activation link is sent to your mail account, Please Check your email...";
	String GL0093="Drag it into a collection to save it.";
	
	String GL0094 = "See Classic Gooru";
	
	String GL0100 = "It looks like your password reset link has expired."; //Token is expired.Please
	
	
	// Labels for Assign Tab in Collection Edit 
	String GL0101 = "Assign this collection to your Classpage";
	String GL0102 = "Classpage";
	String GL0103 = "Assignment";
	String GL0104 = "Assign";
	
	String GL0105 = "Please choose one of the following...";
	
	String GL0106 = "You have no classpages to assign this collection to!";
	String GL0107 = "Click on the&nbsp;";
	String GL0108 = "Teach";
	String GL0109 = "&nbsp;tab above to create one.";
	String GL0110 = "Loading...";
	String GL0111 = "You have no assignments in this classpage.";
	
	String GL0112 = "Your collection is private. If you choose to assign it, we will make it shareable.";
	
	String GL0113 = "This assignment has already reached its 10 collection limit.";
	String GL0114 = "This collection has already been added to this assignment.";
	
	String GL0115 = "New Classpage";
	String GL0116 = "Classpage List";
	String GL0117 = "You have no Classpages yet!";
	String GL0118 = "Click on the + New Classpage button above to get started.";
	String GL0119 = "Gooru Guide";
	String GL0120 = " to learn how to create and use Classpages, or click on + New Classpages to start exploring yourself!";
	
	String GL0121 = "Untitled Assignment";
	String GL0122 = "Creating...";
	//Gooru Guide
	String GL0123 = "Gooru Guide";
	String GL0124 = "Go to the next page to learn how you can customize your collection.";
	String GL0125 = "Go to the next page to learn how to create and manage Classpages.";
	String GL0126 = "Go to the Next Page to learn how a student can use your Classpage.";
	String GL0127 = "Go to the next page to learn how students will use the Classpage.";
	String GL0128 = "Go to the next page to learn tips on how to study a collection.";
	String GL0129 = "Go to the next page to learn how to navigate through a resource.";
	String GL0130 = "You've finished the tour!";
	String GL0131 = "Go back to learn about the four different areas of Gooru.";
	String GL0132 = "Need a refresher on how to search? Go back to Discover to read the tips.";
	String GL0133 = "Need a refresher on how to create a collection? Go back to Organize to read the tips.";
	String GL0134 = "Need a refresher on how to create a Classpage? Go back to "+" \" Teach\" "+" to read the tips.";
	String GL0135 = "Need a refresher on how to enter a Class Code? Go back to learn how.";
	String GL0136 = "Need a refresher on how students will study on Gooru? Go back to Study to read the tips.";
	String GL0137 = "Need a refresher on how to use the Collection Cover? Go back to read the tips.";
	
	//Classpage
	String GL0138 = "Edit Image";
	String GL0139 = "Student View";
	String GL0140 = "Edit";		//used in Assignment Tab view
	String GL0141 = "Save";
	String GL0142 = "Cancel";	//used in Email Share also 
	String GL0143 = "Character limit reached.";	// Assignment Tab also
	String GL0144 = "New Assignment";
	String GL0145 = "Delete this Classpage";
	String GL0146 = "You have no assignments!";
	String GL0147 = "Why don't you create one using the +Assignment button above?";
	
	//Landing page Gooru in collection
	String GL0148 = "The Blended Learning Model";
	String GL0149 = "In the blended learning model, teachers utilize learning stations to easily differentiate a lesson.  Students work in small groups and travel to learning stations to complete various tasks set up by the teacher.";
	String GL0150 = "Create a Gooru collection to engage your students and tier instruction either with different levels or learning styles. Collection narration allows you to provide teacher instruction so that students are well supported while away from the teacher.";

	String GL0151 = "The Flipped Classroom Model";
	String GL0152 = "In the flipped classroom model, teachers prepare content for students to view at home. Students then come to class ready to participate in more in-depth learning activities, such as problem-solving tasks or labs.";
	String GL0153 = "Build a Gooru collection and start with a video - either a video you find on Gooru or a screencast that you make. Add in additional resources - simulations, articles, or games. Share the collection with your students and let them explore the content at their own pace. Learn how to create a collection for the Flipped Classroom model.";

	String GL0154 = "The Assessments Model";
	String GL0155 = "Assessments document a student's knowledge and/or skills of a particular concept.";
	String GL0156 = "Compile questions from Gooru to create concept-aligned quizzes. In addition, blend in Gooru resources to create a new test experience--dynamic assessments that include videos, simulations, and more.";

	String GL0157 = "The Project-Based Learning Model";
	String GL0158 = "Project-based learning revolves around complex, real-world problems. In this model, the students become the creators of content. Through the inquiry of project creation and analysis, students collaborate, iterate, and reflect on their learning and findings.";
	String GL0159 = "By building collections in Gooru, students can take an active role in their own learning!  Students will hone their research skills and tailor their resource selection to optimize peer learning. Student work can then be easily stored within Gooru, creating a digital portfolio of their work as an exemplar for future classes. Learn how to create a collection for the Project-Based Learning model.";

	String GL0160 = "The Enriched Instruction Model";
	String GL0161 = "Enriched instruction brings a technological edge to traditional direct instruction. Teachers leverage interactive media, such as videos and simulations, to hook and then guide students through new concepts.";
	String GL0162 = "If you’re interested in enriching your lessons with multi-media resources, discovering on Gooru is the best place to start.  You can show the resources directly from your Gooru search query or you can string resources together into a collection. Creating a collection of your resources will allow you to show a short video clip followed immediately with an online quiz or an interactive game. Learn how to create a collection for the Enriched Instruction model.";

	//Gooru Guide
	String GL0163 = "Need a refresher on how to navigate through a collection? Go back to read tips about the collection.";
	String GL0164 = "Start your Gooru experience by searching for a keyword.";

	//Landing Page ...
	String GL0165 = "Grade Level";
	String GL0166 = "Elementary School";
	String GL0167 = "Middle School";
	String GL0168 = "High School";
	String GL0169 = "Higher Education";
	String GL0170 = "What will you discover today?";
	String GL0171 = "You may filter by (optional)";
	String GL0172 = "Standard (e.g. CCSS.M.8.F.A.3)";
	String GL0172_1 = "Standard (e.g. TEKS.M.HS.G.7)";
	
	//EditClasspage
	String GL0173 = "Please enter a title.";
	
	//Search Root View
	String GL0174 = "Resources";
	String GL0175 = "Collections";
	String GL0176 = "Search";				//Used in Header also.
	String GL0177 = "Discover your favorite topic...";
	String GL0178 = "beta";
	
	//Header
	String GL0179 = "Discover";
	String GL0180 = "Organize";
	String GL0181 = "Teach";
	String GL0182 = "Study";
	String GL0183 = "Hi Guest!";
	String GL0184 = "Class Code";
	String GL0185 = "Study Now";
	String GL0186 = "Sign Up";		// Regiseter Page also.
	String GL0186_1 = GL_SPL_EXCLAMATION;
	String GL0187 = "Log in";		// Used in Login Popup also.
	
	//Logout Popup
	String GL0188 = "Did you hear the bell?";
	String GL0189 = "Class is dismissed!";
	String GL0190 = "Ok";
//	String GL0191 = GL0142; Duplicate.

	//Logout Panel
	String GL0192 = "Settings";
	String GL0193 = "Classic Gooru";
	String GL0194 = "Support";
	String GL0195 = "Feedback";
	String GL0196 = "Gooru Guide";
	String GL0197 = "Logout";
	
	/// Landing Page
	String GL0198 = "Teachers' Picks";		// Used in TeachersPickUc also.
	String GL0199 = "How to Use Gooru";
	String GL0200 = "Gooru in the Classroom";
	String GL0201 = "Take a Tour";
	
	
	//Login Page
	String GL0202 = "Username or Email";
	String GL0203 = "Log in with Google";
	String GL0204 = "Password";
	String GL0205 = "Forgot your password?";
	String GL0206 = "Stay Logged in";
	String GL0207 = "Sign Up here!";
	String GL0208 = "Don't have an account?";
	String GL0209 = "Or";	//	Register, Edit Classpage also
	
	//Register Page
	String GL0210 = "We are excited to have you register as a beta-user and join us in creating our next version of Gooru!";
	String GL0211 = "Birthday";
	String GL0212 = "Email";
	String GL0213 = "Go";
	String GL0214 = "The email address specified already exists with in Gooru. Please use sign-in to log in to your existing account.";
	

	//Email Share
	String GL0215 = "Please enter your Email.";
	String GL0216 = "Please specify at least one recipient.";
	String GL0217 = "Enter recipient's email";
	String GL0218 = "Gooru - {0}";
	String GL0219 = "{0} <div><br/></div><div> {1} </div><div><br/></div><div>Sent using Gooru. Visit {2} for more great resources and collections. It's free!</div>";
	String GL0220 = "Check out {0} Gooru profile and fantastic collections";
	String GL0221 = "{0} is an active member of the Gooru community! Take a look and browse through all their great collections - {1} <div><br/></div><div>Gooru is a free search engine for learning used by thousands of teachers around the world to discover, organize and create teaching materials.</div><div><br/></div><div>Experience Gooru today at {2} </div>";
	String GL0222 = "Email to Friend";
	String GL0223 = "From";
	String GL0224 = "To";
	String GL0225 = "Send me a copy of this message";
	String GL0226 = "Subject";
	String GL0227 = "Message";
	String GL0228 = "Send";
	
	//Edit Classpage - Dont use these...
	String GL0229 ="Share this Classpage with your students via:&nbsp;&nbsp;&nbsp;&nbsp;";
	String GL0230 ="Class Code";
	String GL0231 ="a Web Link";
	String GL0232 ="Web Link";
	String GL0233 ="Class Codes are an easy way to share Classpages with your students in the classroom.<br></br>Ask your students to enter the Class Code in the Study tab to find their assignments.";
	String GL0234 ="Use Web Links if you want to share Classpages via email or other online channels.<br></br>Ask your students to click directly on the link to find their assignments.";
	String GL0235 ="Please select a due date.";
	String GL0236 ="Please enter directions.";
	String GL0237 ="Remove";
	String GL0238 ="Due Date";
	String GL0239 ="Add a collection to assign";
	String GL0240 ="Update";
	String GL0241 ="click to expand";
	
	//Login Page
	String GL0242 = "Logging in...";
		
	//Header
	String GL0243 ="Please enter Class Code";
	String GL0244 = "We don't recognize that code. Try again and double check with your teacher for the correct code.";
	
	//Landing Page..
	String GL0245 = "With thanks to our wonderful supporters and people like you!";
	
	// Search Page filters help messages
	String GL0246 = "If you are looking for resources from a specific website, use the Source filter to limit your search results to that website.";
	String GL0247 = "Content found through Gooru is aligned to the Common Core Standards for Mathematics and the California Science Curriculum Standards.";
	
	
	//Collection Share Tab... Please dont use this...
	String 	GL0248	= "Direct link";
	String	GL0249	= "";
	String	GL0250	= "";
	String	GL0251	= "";
	String	GL0252	= "";
	String	GL0253	= "";
	String	GL0254	= "";
	String	GL0255	= "";
	String	GL0256	= "";
	String	GL0257	= "";
	String	GL0258	= "";
	String	GL0259	= "";
	String	GL0260	= "";
	String	GL0261	= "";
	String	GL0262	= "";
	String	GL0263	= "";
	String	GL0264	= "";
	String	GL0265	= "";
	String	GL0266	= "";
	String	GL0267	= "";
	String	GL0268	= "";
	String	GL0269	= "";
	String	GL0270	= "";
	String	GL0271	= "";
	String	GL0272	= "";
	String	GL0273	= "";
	String	GL0274	= "";
	String	GL0275	= "";
	String	GL0276	= "";
	String	GL0277	= "";
	String	GL0278	= "";
	String	GL0279	= "";
	String	GL0280	= "";
	String	GL0281	= "";
	String	GL0282	= "";
	String	GL0283	= "";
	String	GL0284	= "";

	//Collection Share Tab... Please dont use this...
	
	//ImproveGoorupopup
	String	GL0285	= "We've Improved Gooru!.";
	String	GL0286	= "Gooru just got better!";
	String	GL0287	= "We are excited to announce that we have added more features to Gooru!";
	String	GL0288	= "What's new?";
	String	GL0289	= "A new question type: Multiple Answer";
	String	GL0290	= "Because sometimes a question can have more than one correct answer. &nbsp;";
	String	GL0291	= "Learn more about our questions types.";
	String	GL0292	= "Gooru Goes Mobile!";
	//String	GL0293	= "Did you know that you can use Gooru with your iPad? As you create collections for mobile devices, look out for this icon - it will tell you which resources are not mobile friendly so you can avoid them. Be sure to check off the box [ ] I am building this collection for my iPad when you create a New Collection. You can always turn it off later.  &nbsp; ";
	String	GL0293	= "Did you know that you can use Gooru with your iPad? As you create collections for mobile devices, look out for this icon ";
	String	GL0293_1= "- it will tell you which resources are not mobile friendly so you can avoid them. Be sure to check off the box [ ]. "; 
	String	GL0294	= "Learn more!";
	String	GL0295	= "Fill in the _____";
	String	GL0296	= "[Blank]! We've added a Fill-in-the-Blank question type! Now you'll be able to create your own fill-in-the-blank questions with one or multiple blanks. If there are any other question types that you'd like to see on Gooru, let us know! ";
	String	GL0297	= "Terms of Use.";
	String	GL0298	= "Questions? Email";
	String	GL0299	= "support@goorulearning.org";
	String	GL0342  = "Learn how to add questions.";
	String	GL0343  = "Learn more!";
	String	GL0344  = "Learn more about our Community Guidelines.";
	// New Collection hints popups messages
	String GL0300 = "What grade(s) is your collection intended for? This field isn’t required, but providing this information will help us classify your collection and help other users find your collection if you choose to make it public.";
	String GL0301 = "What course are you creating your collection for? This field isn’t required, but providing this information will help us classify your collection and help other users find your collection if you choose to make it public.";
	
	//Edit Questions.
	String GL0302 = "You've reached the limit of resources you can add to a collection!\n\nTip: Try dividing this into two collections.";
	
	//Collection Create
	String GL0303 = "Don't worry, you'll be able to edit this information later.";
	
	//Edit Question.
	String GL0304 = "Edit Question";
	String GL0305 = "Multiple Choice";
	String GL0306 = "True/False";
	String GL0307 = "Open-Ended";
	String GL0308 = "Question";
	String GL0309 = "Add Question Image";
	String GL0310 = "Please include the question";
	String GL0311 = "Please include answer choice";
	String GL0312 = "Please choose a correct answer.";
	String GL0313 = "Choices";
	String GL0314 = "Correct";
	String GL0315 = "Answer Choice";
	String GL0316 = "Explanation";
	String GL0317 = "Hints";

	//Collection Create
	String GL0318 = "Title";
	String GL0319 = "Untitled Collection";
	String GL0320 = "Please select which grade the content in this folder is for. It helps us classify it!";
	String GL0321 = "Please select which Course the content in this folder is for. It helps us classify it!";
//	String GL0322 = "Title this collection to start saving resources";
	String GL0322 = "Create a New Collection";
	String GL0323 = "Title cannot be a URL.";
	String GL0324 = "title can not be empty";
	String GL0325 = "Grade";
	String GL0326 = "Course";
	String GL0327 = "Please fill mandatory field(*)";
	String GL0328 = "Visibility";
	String GL0329 = "Public";
	String GL0330 = "Allows others to find and learn from your collection";
	String GL0331 = "Shareable";
	String GL0332 = "Allows you to share with only those who have a link";
	String GL0333 = "Private";
	String GL0334 = "No one but you can see this collection";
	
	//Add A Resource
	String GL0335 = "There are {0} recommendations for you!";	
	String GL0336 = "There are no Results..";
	
	
	
	//Flagging...
	String GL0337 = "I would like to flag \"{0}\" because";
	String GL0338 = "Please provide us with more details";
	
	//Edit Question.
	String GL0339 = "Please wait...";
	
	//Error popup
	String GL0340 = "Looks like this collection is not available!";
	String GL0341 = "You do not have permission to edit this Classpage";

	//Login
	String GL0345 = "Welcome to Gooru!";
	String GL0346 = "Log in with a Gooru account";
	String GL0347 = "Please double-check your email address and password, and then try logging in again.";
	String GL0348 = "Your browser's cookies seem to be turned off. Please turn them on to continue! Don't know how ? <a href=\"http://support.google.com/accounts/bin/answer.py?hl=en&amp;p=mail&amp;ctx=ch_ServiceLoginAuth&amp;answer=61416\" target=\"_blank\" style=\"text-decoration: none;\">This might help you!</a>";
	

	//Add Question popup
	String GL0349="Multiple Choice Question";
	String GL0350="Write your question, provide at least two answer choices and select one correct answer. You can add up to five answers, an image, explanation and up to five hints.";
	String GL0351="Multiple Answer Question";
	String GL0352="Write your question, provide up to five answer choices and select at least one correct answer (you can select up to all five to be correct). You can also add an image, explanation and up to five hints.";
	String GL0353="True/False Question";
	String GL0354="Write your statement and select whether it is true or false. You can also add an image, explanation and up to five hints.";
	String GL0355="Fill in the Blank Question";
	String GL0356="As you write the question, use brackets for your fill-in-the-blank answers. For example: \"The big bad [wolf] blew down the [house].\" You can also add an image, an explanation  and up to five hints. ";
	String GL0357="Open Ended Question";
	String GL0358="Write an Open Ended question. You can add an image, explanation, and up to five hints. This question will not be scored. Note: you will be able to collect answers from those that send it via the \"email\" or \"print\" option at the end of the collection.";
	// Adding user own resources
	String GL0359="Please describe what the resource is about.";
	String GL0360="Choose a resource category";
	String GL0361="In order to use ant uploaded resource in your collection, you mmust have all rights necesssary from the party that controls the copyright.Please refer to the Community Guidelines,Terms of Use and the Copyright Policy for additional information.";

	//Share UI Collection Edit confirmation popups
	String GL0362="Your collection is ";
	String GL0363="Are you sure this is correct?";
	String GL0364="Looks like you have some private resources!";
	String GL0365="Before you make your collection public, please make sure all of the information of each resource is correct (title, description, category and image) - you won't be able to change it later. However, you will be able to edit the narration or remove the resource at any point.";
	String GL0366="You won't be able to assign this in your Classpage or share it with others. To share with the Gooru community, make it public.";
	String GL0367="You can share your collection via link, email or social media which you can find in the share tab of Organize, or via Classpage which you can create in Teach.";

	
	//Signup Labels
	String GL0400 = "Join the Gooru Community!";
	String GL0401 = "Discover, organize, teach and study with the best free K-12 learning resources.";
	String GL0402 = "Sign up with Google";
	String GL0403 = "Why sign up with Google";
	String GL0404 = "It's fast and easy. Use your existing Google account to sign in without a password.";
	String GL0405 = "Don't have a Google account";
	String GL0406 = "Sign up with your email address";
	String GL0407 = "Already have an account";
	String GL0408 = "Click here to log in.";
	String GL0409 = "Please fill out the following information.";
	String GL0410 = "Pick wisely! This will appear publicly on Gooru and you will not be able to change it later.";
	String GL0411 = "Why enter your birthday";
	String GL0412 = "Your birthday helps ensure you get the right Gooru experience for your age. This information will never appear anywhere on the website.";
	String GL0413 = "Your name will not appear publicly anywhere on Gooru.";
	String GL0414 = "Double check your email. Make sure it's correct!";
	String GL0415 = "Passwords must be between 5 and 14 characters and must contain at least one number.";
	String GL0416 = "Teacher";
	String GL0417 = "Student";
	String GL0418 = "Parent";
	String GL0419 = "Other";
	String GL0420 = "By clicking Sign Up, I agree to the";
	String GL0421 = "Copyright Policy";
	String GL0422 = "Terms of Service";
	String GL0423 = "Username";
	String GL0424 = "First Name";
	String GL0425 = "Last Name";
	String GL0426 = "Email";
	String GL0427 = "Confirm Password";
	String GL0428 = "The email address specified already exists within Gooru";

	
	String GL0429 = "Thank you for signing up with Gooru!";
	String GL0430 = "Please check your email to confirm your account.";
	String GL0431 = "Continue using Gooru";
	String GL0432 = "What's Next?";
	String GL0433 = "Learn how to";

	String GL0434 = "Email or Username";
	String GL0435 = "You will be getting an email containing a link to reset your password.";
	String GL0436 = "Please enter your email or username below.";


	String GL0437 = "If you have any questions, please contact <a href=\"mailto:support@goorulearning.org\">support@goorulearning.org</a>";
	String GL0438 = "This email or username has not been registered.";
	String GL0439 = "Please provide your email address or username.";
	String GL0440 = "Success!";
	String GL0441 = "An email has been sent with instructions on how to reset your password.";
	String GL0442 = "Confirm Your Email";
	String GL0443 = "You need to confirm your email first!";
	//Signup Labels
	
	//HTTP and HTTPS protocols msgs
	String HTTP = "http";
	String HTTPS = "https";
	
	String GL0444 = "This Username is taken.";
	String GL0445 = "Not a valid email.";
	String GL0446 = "Passwords don't match.";
	String GL0447 = "This Email id is already registered.";
	String GL0448 = "Discover your favorite Science, Math and Social Sciences topic...";
	String GL0449 = "This collection contains {0} resource(s) that {1} not mobile friendly.";
	String GL0450 = "Creating collections for your iPad? Check this box if you are! You can always change your mind later. ";
	String GL0451 = "Learn more about what you can do on your iPad.";
	String GL0452 = "Privacy Policy.";
	String GL0453 = "This collection is mobile friendly.";
	String GL0454 = "Creating collections for your iPad? This icon tells you which resources are not mobile friendly.";
	
	String GL0455 = "We need your parent's account";
	String GL0456 = "My parent has a Gooru account:";
	
	String GL0457 = "Parent's Email";
	String GL0458 = "My parent doesn't have an account:";
	String GL0459 = "Click here to register as a parent.";
	String GL0460 = "Continue";
	String GL0461 = "For the right age appropriate experience of Gooru, a student may require a parent account to complete registration. If you are a parent and don't currently have a Gooru account, please register now.";
	String GL0462 = "Why do I need my parent";
	String GL0463 = "Parent EmailId is required";
	String GL0464 = "Not a valid email.";
	String GL0465 = "This email id is not registered with Gooru.";
	String GL0466 = "OR";
	String GL0467 = "Student Sign Up";
	String GL0468 = "Parent Account : ";
	String GL0469 = "signing up...";
	String GL0470 = "Parents, please make an account to register your student.";
	String GL0471 = "Parent Sign Up";
	String GL0472 = "Create an account for your student";
	
	String GL0473 = "User name should be > 4 and < 20 characters only.";
	String GL0474 = "Students, enter your Class Code provided by your teacher.";
	String GL0475 = "Cannot use special characters";
	String GL0476 = "We saved a copy of this collection for you to customize and make your own! If you want to keep browsing the library, you can always click \"Organize\" in the Navigation bar to find this copy later.";
	String GL0477 = "Are you sure you want to exit?";
	String GL0478 = "Your registration will not be completed.";
	String GL0479 = "Continue with Registration";
	String GL0480 = "Leave Registration";
	
	String GL0481 = "You're 13";
	String GL0482 = "Don't worry...";
	String GL0483 = "Congrats";
	String GL0484 = "Now that you are 13, you can have more Gooru privileges! To unlock these features";
	String GL0485 = ", please enter your email.";
	String GL0486 = "Submit";
	String GL0487 = "Enter it later";
	String GL0488 = "What are these features";
	String GL0489 = "- Gooru Profile Page";
	String GL0490 = "- Uploading your own Profile image";
	String GL0491 = "- Make collection public";	
	String GL0492 = "Complete your Profile";
	String GL0493 = "Help us get to know you better! You can add your own profile image, biography, and choose your own password for your Gooru account. You can always change them in you settings.";
	String GL0494 = "Change password";
	String GL0495 = "Update my profile later";
	String GL0496 = "You can always update your information in settings.";
	String GL0497 = "Go to Settings";
	String GL0498 = "Thanks";
	String GL0499 ="Your profile is updated";
	String GL0500 = "You can't select more than 5 courses.";
	String GL0501 = "Thanks!";
	String GL0502 = "Your email has been confirmed!";
	String GL0503 = "Your DOB can't be <13.";
	String GL0504 = "Click on the Teach tab above to create one.";
	String GL0505 = "Copying...";
	
}


