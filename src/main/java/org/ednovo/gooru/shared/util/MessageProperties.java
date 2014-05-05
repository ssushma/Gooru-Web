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



public interface MessageProperties {
	//Special Characters
	String GL_SPL_SEMICOLON = ":";
	String GL_SPL_STAR = "*";
	String GL_SPL_PLUS = "+";
	String GL_SPL_QUESTION = "?";
	String GL_SPL_EXCLAMATION = "!";
	String GL_SPL_FULLSTOP = ".";
	String GL_GRR_ARE = "are";
	String GL_GRR_AND =	"and";
	String GL_GRR_YES="Yes";
	String GL_GRR_IS = "is";
	String GL_GRR_ALPHABET_A = "A";
	String GL_GRR_ALPHABET_B = "B";
	String GL_GRR_Hyphen= "-";
	String GL_GRR_COMMA= ",";
	String GL_GRR_BYMR="By Mr.";
	String GL_GRR_BYMS="By Ms.";
	String GL_GRR_OF="of";
	String GL_GRR_THE="the";
	String GL_GRR_ALPHABET_APOSTROPHE = "'s";
	String GL_GRR_NUMERIC_ONE = "1";
	String GL_GRR_NUMERIC_TWO = "2";
	String GL_GRR_NUMERIC_THREE = "3";
	String GL_GRR_NUMERIC_FOUR = "4";
	String GL_GRR_NUMERIC_FIVE = "5";
	String GL_GRR_Close ="X";
	
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
	String GL0073="{0} must contain at least one number and one letter.";
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
	String GL0101 = "Assign this collection to your Class";
	String GL0102 = "Class";
	String GL0103 = "Assignment";
	String GL0104 = "Assign";
	
	String GL0105 = "Please choose one of the following...";
	
	String GL0106 = "Don't your collections deserve a home?";
	String GL0107 = "Click on the&nbsp;";
	String GL0108 = "Click on the Teach tab above to create one and to start assigning Collections to your students.";
	String GL0109 = "Click on the Teach tab at the top of the page to create your first class! and to start assigning Collections to your students.";
	String GL0110 = "Loading";
	String GL0111 = "You have no assignments in this Class.";
	
	String GL0112 = "Your collection is private. If you choose to assign it, we will make it shareable.";
	
	String GL0113 = "This assignment has already reached its 10 collection limit.";
	String GL0114 = "This collection has already been added to this assignment.";
	
	String GL0115 = "New Class";
	String GL0116 = "Class List";
	String GL0117 = "You haven't started a Class yet!";
	String GL0118 = "Classes are the simplest way to share collections with your students.";
	String GL0119 = "Gooru Guide";
	String GL0120 = " to learn how to create and use Classes, or click on + New Classes to start exploring yourself!";
	
	String GL0121 = "Untitled Assignment";
	String GL0122 = "Creating...";
	//Gooru Guide
	String GL0123 = "Gooru Guide";
	String GL0124 = "Go to the next page to learn how you can customize your collection.";
	String GL0125 = "Go to the next page to learn how to create and manage Classes.";
	String GL0126 = "Go to the Next Page to learn how a student can use your Class.";
	String GL0127 = "Go to the next page to learn how students will use the Class.";
	String GL0128 = "Go to the next page to learn tips on how to study a collection.";
	String GL0129 = "Go to the next page to learn how to navigate through a resource.";
	String GL0130 = "You've finished the tour!";
	String GL0131 = "Go back to learn about the four different areas of Gooru.";
	String GL0132 = "Need a refresher on how to search? Go back to Discover to read the tips.";
	String GL0133 = "Need a refresher on how to create a collection? Go back to Organize to read the tips.";
	String GL0134 = "Need a refresher on how to create a Class? Go back to "+" \" Teach\" "+" to read the tips.";
	String GL0135 = "Need a refresher on how to enter a Class Code? Go back to learn how.";
	String GL0136 = "Need a refresher on how students will study on Gooru? Go back to Study to read the tips.";
	String GL0137 = "Need a refresher on how to use the Collection Cover? Go back to read the tips.";
	
	//Class
	String GL0138 = "Edit Image";
	String GL0139 = "Student View";
	String GL0140 = "Edit";		//used in Assignment Tab view
	String GL0141 = "Save";
	String GL0142 = "Cancel";	//used in Email Share also 
	String GL0143 = "Character limit reached.";	// Assignment Tab also
	String GL0144 = "Assign a collection";
	String GL0145 = "Delete this Class";
	String GL0146 = " -<n> Gooru Search</n>";
	String GL0147 = "It's so quiet in this class. Start assigning collections!"; 
	
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
	String GL0172 = "Standard (e.g. CCSS.Math.Content.8.F.A.3)";
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
	String GL0185 = "Study";
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
	String GL0207 = "Sign Up here";
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
	String GL0216_1 = "Please specify at least one student email id";
	String GL0217 = "Enter recipient's email";
	String GL0218 = "Gooru - {0}";
	String GL0218_1 = "{0} has shared their class {1} with you";
	String GL0219 = "{0} <div><br/></div><div> {1} </div><div><br/></div><div>Sent using Gooru. Visit {2} for more great resources and collections. It's free!</div>";
	String GL0219_1 = "Hello there! <div><br/></div>Your teacher, {0} has shared the class: {1} with you. Please access the class by clicking the link below or by entering in the Class Code under the Study tab." +
			" <div><br/></div><div> {2} </div><div><br/></div><div>ClassCode: {3} </div><div><br/></div><div>Sent using Gooru. Visit {4} for more great resources and collections. It's free!</div>";
	String GL0220 = "Check out {0} Gooru profile and fantastic collections";
	String GL0221 = "{0} is an active member of the Gooru community! Take a look and browse through all their great collections - {1} <div><br/></div><div>Gooru is a free search engine for learning used by thousands of teachers around the world to discover, organize and create teaching materials.</div><div><br/></div><div>Experience Gooru today at {2} </div>";
	String GL0222 = "Email to Friend";
	String GL0222_1 = "Share this class";
	String GL0223 = "From";
	String GL0224 = "To";
	String GL0225 = "Send me a copy of this message";
	String GL0226 = "Subject";
	String GL0227 = "Message";
	String GL0228 = "Send";
	
	//Edit Classpage - Dont use these...
	String GL0229 ="Share this Class with your students via:&nbsp;&nbsp;&nbsp;&nbsp;";
	String GL0230 ="Class Code";
	String GL0231 ="a Web Link";
	String GL0232 ="Web Link";
	String GL0233 ="Class Codes are an easy way to share Classes with your students in the classroom.<br></br>Ask your students to enter the Class Code in the Study tab to find their assigned collections.";
	String GL0234 ="Use Web Links if you want to share Classes via email or other online channels.<br></br>Ask your students to click directly on the link to find their assigned collections.";
	String GL0235 ="Please select a due date.";
	String GL0236 ="Please enter directions.";
	String GL0237 ="Remove";	//This is used in collaborators for Button.
	String GL0238 ="Due Date";
	String GL0239 ="Assign a collection";
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
	String	GL0285	= "We've Improved Gooru!";
	String	GL0286	= "Gooru just got better!";
	String	GL0287	= "We are excited to announce that we have added more features to Gooru!";
	String	GL0288	= "What's new?";
	String	GL0289	= "A new question type: Multiple Answer";
	String	GL0290	= "Because sometimes a question can have more than one correct answer. &nbsp;";
	String	GL0291	= "Learn more about our questions types.";
	String	GL0292	= "Invite students to your Class";
	String	GL0293	= "Now you can invite students to join your Class. This means that your students will always know what collections you've assigned, and you'll always know how your students are progressing. ";
	String	GL0293_1= "- it will tell you which resources are not mobile friendly so you can avoid them. Be sure to check off the box [ ]. "; 
	String	GL0294	= "Click here to";
	String	GL0295	= "Monitor the progress of your students";
	String	GL0296	= "Now you can track student progress in live time! Which students are answering Question 4 incorrectly? Are students watching the entire video? These and many more answers will soon be revealed! ";
	String	GL0297	= "Terms of Use";
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
	String GL0328 = "Visibility:";
	String GL0329 = "Public";
	String GL0330 = "(Allows others to find and learn from your collection)";
	String GL0331 = "Shareable";
	String GL0332 = "(Allows you to share with only those who have a link)";
	String GL0333 = "Private";
	String GL0334 = "(No one but you can see this collection)";
	
	//Add A Resource
	String GL0335 = "There are {0} recommendations for you!";	
	String GL0336 = "There are no Results..";
	
	
	
	//Flagging...
	String GL0337 = "I would like to flag \"{0}\" because";
	String GL0338 = "Please provide us with more details";
	
	//Edit Question.
	String GL0339 = "Please wait...";
	
	//Error popup
	String GL0340 = "You do not have permission to see this collection.";
	String GL0341 = "You do not have permission to edit this Class";

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
	String GL0360="Choose a resource format";
	String GL0361="In order to use ant uploaded resource in your collection, you mmust have all rights necesssary from the party that controls the copyright.Please refer to the Community Guidelines,Terms of Use and the Copyright Policy for additional information.";

	//Share UI Collection Edit confirmation popups
	String GL0362="Your collection is now ";
	String GL0363="Are you sure this is correct?";
	String GL0364="Looks like you have some private resources!";
	String GL0365="Before you make your collection public, please make sure all of the information of each resource is correct (title, description, format and image) - you won't be able to change it later. However, you will be able to edit the narration or remove the resource at any point.";
	String GL0366="You're the only one who can see it. (I promise not to peek!) You won't be able to assign or share this collection while it's private.";
	String GL0367="That means that anyone you share this link with will be able to access it. So quit holding out and let the world know!";

	
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
	String GL0454 = "Creating collections for your iPad? This icon "; 
	String GL04431 = "tells you which resources are not mobile friendly.";

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
	
	String GL0473 = "Username must be between 4 and 20 characters.";
	String GL0474 = "Students, enter the Class Code provided by your teacher.";
	String GL0475 = "Cannot use special characters";
	String GL0476 = "Please sign in to customize this collection. Once you're signed in you'll have your very own copy to customize, beautify, and awesome-ify. Okay, maybe awesome-ify isn't a word.";
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
	String GL0504 = "Click on the Teach tab above to create one and to start assigning Collections to your students.";//duplicate for GL0108 GL0109
	String GL0505 = "Copying...";
	//5.12 Messages
	String GL0506 = "Browse our Library";		//No search Results.
	String GL0507 = "No result for";
	String GL0508 = "See more";
	String GL0509 = "See less";
	String GL0510 = "View Collection Analytics";
	String GL0511 = "Or share this with your friends and colleagues by copying and pasting this link";
	String GL0512 = "Share this with your friends and colleagues by copying and pasting this link.";
	String GL0513 = "Assign this Collection to your students by copying and pasting this link";
	String GL0514 =  "Assign this to a class and collect class-specific insights";
	String GL0515 = "RUSD Library";
	String GL0516 = "Community Library";
	String GL0517 = "Assign to another Class";
	String GL0518 = "Assign this collection";
	String GL0519 = "Assign";
	String GL0520 = "Log in to Assign to a Class";
	String GL0521 = "You have successfully assigned this collection to ";

	String GL0522 = "Transform Learning. Inspire Students.";
	String GL0523 = "Create and share collections of engaging web resources with your students. Browse courses in our K-12 Community Library to get started.";
	String GL0524 = "Find";
	String GL0525 = "standards-aligned, interactive learning materials tied to Common Core";
	String GL0526 = "Share";
	String GL0527 = "custom collections, personalized to meet the unique needs of your students";
	String GL0528 = "Measure";
	String GL0529 = "your students' engagement, comprehension, and progress";
	String GL0530 = "Contribute";
	String GL0531 = "to an active community of teachers and students";
	
	String GL0532 = "RUSD Community Library";
	String GL0533 = "This library showcases collections created by teachers from the Riverside Unified School District in California.";
	String GL0534 = "Find";
	String GL0535 = "standards-aligned, interactive learning materials tied to Common Core";
	String GL0536 = "Share";
	String GL0537 = "custom collections, personalized to meet the unique needs of your students";
	String GL0538 = "Measure";
	String GL0539 = "your students' engagement, comprehension, and progress";
	String GL0540 = "Contribute";
	String GL0541 = "to an active community of teachers and students";
	String GL0542 = "Like this resource? Use this button to save the resource you are viewing to a Collection.";
	String GL0543 = "Got it!";
	String GL0544 = "Share this collection with your colleagues";
	String GL0545 = "Share this collection";
	String GL0546 = "Share this with your friends and colleagues by copying and pasting this link.";
	String GL0547 = "This Collection has been added!";
	
	
	
	String GL0548 = "Open in new tab";
	String GL0549 = "Click the button below to open this resource!";
	String GL0550 = "The resource will open in a new tab.";
	String GL0551 = "When you’re done with this resource, come back to this page to keep learning.";
	String GL0552 = "Please click the button below to view it on its original website.";
	
	String GL0553 = "Rename this collection";
	String GL0554 = "#$*@! Please find a G-rated way to express yourself!";
	String GL0555 = "This message has been deleted.";
	String GL0556 = "Flag this collection";
	String GL0557 = "You'hv flagged this collection";
	
	String GL0558 = "Delete";
	String GL0559 = "Are you sure you want to delete this?";
	String GL0560 = "deleting...";
	String GL0561 = "now";
	String GL0562 = "days ago";
	String GL0563 = "hours ago";
	String GL0564 = "minutes ago";
	String GL0565 = "Share your feedback and ideas with fellow teachers about this Collection.";
	String GL0566 = "Publisher: ";
	String GL0567 = "#$*@! Please find a G-rated way to express yourself!";	//Duplicate of GL0554
	
	String GL0568 = "This collection is missing your voice. Please ";
	String GL0569 = "to comment.";
	String GL0570 = "posting...";
	String GL0571 = "Post";
	String GL0572 = "See Other Related Concepts";
	String GL0573 = "Author";
	
	String GL0574 = "Course";
	String GL0575 = "Standards";
	
	String GL0576 = "Related Concepts";
	String GL0577 = "Course";
	String GL0578 = "in this collection";
	String GL0579 = "days";
	String GL0580 = "day";
	
	String GL0581 = "I can explain";
	String GL0582 = "I understand";
	String GL0583 = "Meh...";
	String GL0584 = "I don’t understand";
	String GL0585 = "I need help";
	
	String GL0586 = "Return to the Library to browse other Collections";
	String GL0587 = "Featured Courses";
	String GL0588 = "RUSD Featured Courses";
	
	//Add collection view messages.
	
	String GL0589 =	"View the collection in the Organize tab";
	String GL0590 =	"Add";
	String GL0591 ="Adding....";
	String GL0592 ="Hide";
	String GL0593 ="Rename (optional)";
	String GL0685 =	"Add resource instead";
	String GL0690 = "Add this collection";
	String GL0691 ="Add Again";
	String GL0692 ="This collection has been added, again! ";
	String GL0696 =	"Create a new collection";
	String GL0699_1 =	"Please choose one of the collection.";
	String GL0699_2 =	"You already reached max limit.";

	
	//Collection meta data.
	
	String GL0594 ="Study";
	String GL0595 ="Created by: ";
	String GL0694 = "Acknowledgements ";
	
	//collection end page
	String GL0596 =	"You've reached the end of this collection!";
	String GL0597 = "Replay";
	String GL0598 = "Share this Collection";
	String GL0599= "Save this summary?";
	String GL0695 = "Application is Down";
	
	//Collection Flag
	String GL0600 = "Flag";
	String GL0601 = "Flag this Collection";
	String GL0602 = "Flag a Resource";
	String GL0603 = "Resources in the collection are inappropriate";
	String GL0604 = "Collection title, objective or narration is not appropriate";
	String GL0605 = "Collection information appears to be inaccurate";
	String GL0606 = "Other reason";
	String GL0607 =  "Please provide us with more details:";
	String GL0608 =  "Reset";
	String GL0609 = "Choose a Resource:";
	String GL0610 ="Please choose the resource you want to flag";
	String GL0611 ="I would like to flag this resource because ";
	String GL0612 ="Resource is inappropriate (i.e. for students)";
	String GL0613 ="Resource is unavailable (i.e. it doesn't load)";
	String GL0614 ="Resource information appears to be inaccurate (e.g. the resource title, format, description)";
	String GL0615 ="Thank you for submitting!";
	String GL0616 ="Course: ";
	String GL0617 ="Legal:";
	String GL0618="Learning Objective:";
	String GL0619="Standards:";
	String GL0620="Collections that have this resource ";
	String GL0621="Resource Information";
	String GL0622="Created by ";
	
	String GL0623 = "Click here to learn more about our Community Library.";
	String GL0624 = "Click here to learn more about commenting.";
	String GL0625 = "Do you live in a Common Core state? What about NGSS? TEKS? Now you can tell Gooru which curriculum standards you'd like to see! ";
	String GL0626 = "Click here to learn more about collection analytics.";
	String GL0627 = "Economics, 3D Design, and more! Explore six new libraries of partner content and take your curriculum a step further. ";
	String GL0627_1 = "Say hello to three new resource types: audio, images, and text. ";
	String GL0628 = "Click here to learn more about reactions.";
	
	String GL0629 = "Choose your standards ";
	String GL0630 = "Explore our new libraries";
	String GL0630_1 = "New resource types";
	
	//priview player
	String GL0631="Customize";
	String GL0632="replay this collection";
	String GL0633="Play";
		
	// For Assign popup in collection preview.
	String GL0634="Don’t have an account? "; //Label.
	
	//For Customize popup in collection preview.
	String GL0635="Hang on just a second!"; //HTMLPanel
	String GL0636="Save to customize"; //Button.
	String GL0637="View and customize this collection";//Button
	
	//For Share popup in collection preview.
	String GL0638="Share this link via ";//HTMLPanel
	String GL0639="Switch to Bit.ly"; //Label.
	String GL0640="Switch to embed code";//Label.
	String GL0641=	"swithUrlLbl";//dynamic text
	String GL0642=	"swithToEmbedLbl";//dynamic text
	String GL0643="Switch to full URL";//dynamic text
	String GL0644=	"Share this with your friends and colleagues by copying and pasting this link."; //HTMLPanel
	
	//collection play share.
	String GL0645=	"Collection";//Label.
	String GL0646="Facebook";//Button 
	String GL0647="Twitter";//Button 
	
	//sent sucess email popup.
	String GL0648="Thank You! Your email was sent to "; //HTMLPanel
	
	//print summary page
	String GL0649="Name:";//Label
	String GL0650="Class:";//Label
	String GL0651="Collection Title: ";//Label
	String GL0652="Username: ";//Label
	String GL0653="Time spent: ";//Label
	String GL0654=	"Open Ended Questions";//Label
	
	//collection does not exists.
	String GL0655=	"This collection is no longer available."; //HTMLPanel
	String GL0656=	"It’s either been deleted or made private by the creator";//HTMLPanel
	String GL0657=	"In the meantime, why don't you browse the courses in our library.";//HTMLPanel
	String GL0697 ="NoHeader";
	
	//Add to an existing collection
	String GL0658=	"Add to an existing collection";//Label
	String GL0659=	"You've reached the limit of resources you can add to a collection! Tip: Try dividing this into two collections.";//Label
	String GL0660=	"+New Collection";//Label
	String GL0661=	"please choose one of the collection";//Label
	String GL0662=	"you already reached max limit";//Label
	String GL0663=	"This resource has been added to your collection!";//Label
	String GL0664="Add collection instead";//Label
	String GL0698 ="Add this resource to your collection.";
	String GL0699 ="This resource has been added to your collection, again!";
	
	//Fill in the blanks
	String GL0665="Answer";//HTMLPanel.
	String GL0666="Submit";//Button 
	String GL0667="Hints (0 Left)";//Button 
	
	//New text
	String GL0668="What will your students see when they study this collection?";
	
	//Resource register.
	String GL0669="Want to save and share resources and collections?";//Label
	String GL0670="Get an account today and let Gooru work for you!";//Label
	String GL0671="Sign up for Gooru";//Label
	String GL0672="Birthdate";//Label
	String GL0673="Sign me up!";//BlueButtonUc
	String GL0674=	"Maybe later";//Anchor
	String GL0675=	"I already have an account.";//Anchor

	String GL0676=	"You know your students would LOVE this collection. Click here to assign it.";//Button
	String GL0677=	"This collection could use a bit of your signature touch. Click here to make your own customizable copy.";//Button
	String GL0678=	"I think a little showing off is in order. Share this collection with your friends and colleagues.";//Button
	String GL0679 = "This Collection is private!";
	
	//Featured Contributors
	String GL0680 = "Featured Contributors"; //Link
	String GL0681 = "Psst! If you love this resource, yes, you can totally keep it! Just click this button to save it to a collection.";
	
	
	//Organize 
	String GL0682 = "Share this collection with your students to start gathering data!";
	String GL0683 = "Coming soon";
	String GL0684 = "There are no resources in this collection.";
	
	//New 
	String GL0686 ="!";
	String GL0687 ="This collection is ";
	String GL0688 ="Shhhh! ";
	String GL0689 ="High Five! ";
	String GL0693 ="Collection Title cannot be empty.";
	String GL0700 ="private! ";
	String GL0701 ="shareable! ";
	String GL0702 ="Q:";
	
	//Resource Narration
	String GL0703 =	"I Got it!";
	
	//No search results collections.
	String GL0704 =	"Didn't find what you're looking for?"; //Label
	String GL0705 =	"Try the tips below:";//Label
	String GL0706 ="Remove some filters";//Label
	String GL0707 ="Check the spelling";//Label
	String GL0708 ="Use a different keyword";//Label
	String GL0709 ="Change the toggle (resources vs. collections)";//Label
	String GL0710 =	"Try our suggested collections";//Label
	//No search results vc
	String GL0711 =	"We didn't find any results for that...";//Label
	String GL0712 =	"You may try:";//Label
	String GL0713 ="Removing some filters";//Label
	String GL0714 ="Checking the spelling";//Label
	String GL0715 ="Using a different keyword";//Label
	String GL0716 =	"Changing the toggle (resources vs. collections)";//Label
	String GL0717 =	"Try our suggested resources";//Label
	//search embed vc
	String GL0718 ="Embed this code into your website";
	//search filters
	String GL0719 ="Filters";//Label
	String GL0720 =	"|";//Label
	String GL0721 ="Resource Format";//DisclosurePanelUc
	String GL0722 ="Source";//DisclosurePanelUc
	String GL0723 =	"no match found";//Label
	String GL0724 ="Standard";//DisclosurePanelUc
	String GL0725 =	"Clear All";//Label
	
	//search more info
		String GL0726 =	"More Information";
		String GL0727 ="Vocabulary";
		String GL0728 ="Average Time";
		String GL0729 ="Likes";
		String GL0730 ="License";
		String GL0731 =	"Resource License:";
		String GL0732 =	"Question Mark";
		String GL0733 ="Gooru";
		String GL0734 =	"More Info";
		String GL0735 =	"drag to add";
		String GL0736 =	"added";
		String GL0737 ="Not iPad friendly";
		String GL0738 =	"Aww!";
		String GL0739 =	"see 10 more";
		String GL0740 =	"Hang on just a second!";
		String GL0741 =	"Login to customize this collection";
		String GL0742 =	"we save a copy of this collection....";
		String GL0743 =	"Customize this collection!";
		String GL0744 = "This is a pretty great collection, but I bet that you could make it even better! Click \"Save to Customize\" and we'll create a copy of this collection for you to tweak, personalize, or rebuild.";

		

		String GL0745 = "Done";
		String GL0749 = "Type and select standards for this collection.";
		String GL0750 = "Add a teacher tip to show other teachers how you are using this collection and what you are using the collection for.";
		//Teach
		String GL0747 =	"Give your Class a name!";
		String GL0746 =	"Please enter title.";
		String GL0748 =	"Are you sure?";
		String GL0751 = "Learn more about Gooru";
		String GL0752 = "Show only standards-aligned collections";
		String GL0753 = "Show all featured collections in this course";

		//User Settings.
		String GL0800	= 	"Edit image";
		String GL0801	= 	"Profile Page";
		String GL0802	= 	"On";
		String GL0803	=	"Off";
		String GL0804	=	"Tell Us About Yourself";
		String GL0805	=	"This will appear in your Profile Page. ";
		String GL0806	=	"View Profile";
		String GL0807	=	"Account";
		String GL0808	=	"Saving...";
		String GL0809	=	"Gender";
		String GL0810	=	"Male";
		String GL0811	=	"Female";
		String GL0812	=	"Prefer not to share";
		String GL0813	=	"(Email not confirmed yet)";
		String GL0814	=	"Security";
		String GL0815	=	"You cannot change your password because you logged in with your Google account.";
		String GL0816	=	"Click here to change your password.";
		String GL0817	=	"Educational Information";
		String GL0818	=	"ROLE:";
		String GL0819	=	"GRADE(S):";
		String GL0820	=	"Select grade(s) for this collection.";
		String GL0821	=	"COURSE(S):";
		String GL0822	=	"Oops! You can only add 5 courses.";
		String GL0823	=	"User Pic";
		
		//shelf
		String GL0824	=	"You are about to delete your&nbsp;"; //Label
		String GL0825	=	"This is permanent action and will delete all of its content."; //Label
		String GL0826	=   "Please type 'DELETE' and click Ok."; //Label
		String GL0827	= 	"Copy";//Label
		String GL0828	= 	"Info";//Label
		String GL0829	= 	"Content";//Label
		String GL0830	= 	"Collaborator";//Label
		String GL0831	= 	"Collection Analytics";//Label
		String GL0832	= 	"Collaborators";//Label
		String GL0833	=   "ADD FROM RECENT";//Label
		String GL0834	= 	"Keep Collection in Class";//BlueButtonUc
		String GL0835	= 	"Make Collection Private";//BlueButtonUc
		String GL0836	=	"This collection is in use!";//Label
		String GL0837	=	"This collection is currently being used in the ";//Label
		String GL0838	=	"If you would like to make this collection private, this collection will be removed and no longer available to the class.";//Label
		String GL0839	=   "Error Occured";
		String GL0840	=  	"Your private resource(s)";//Label
		String GL0841	= 	"Go Back";//BlueButtonUc
		//collection share tab.
		String GL0842	= 	"COLLECTION VISIBILITY";
		String GL0843	= 	"Select visibility option for this collection";
		String GL0844	= 	"Error";
		String GL0845	= 	"Cannot make collections public yet.";//Label
		//collection info tab
		String GL0846	=   "Select a course for this collection.";//Label
		String GL0847	=  	"Add a Course";//Button
		String GL0848	= 	"Remove Course";//Button
		String GL0849	= "sorry, you can only add 15 standards!";//Label
		String GL0850	= 	"Kindergarten";

		//Content tab in shelf
		String GL0851	= "New Resource";//Button
		String GL0852	= "New Question";//Button
		String GL0853	="Drag and drop resources to reorder them";//Label
		String GL0854	="This collection is empty!";//Label
		String GL0855	="Add a resource using the";//Inline Label
		String GL0856	="+ New Resource";//InlineLabel
		String GL0857	="+ New Question";//InlineLabel
		String GL0858	="link above.";//InlineLabel
		
		//Hints
		String GL0859	="Hints (hints will show up in this order)";
		//Add Question image in shelf
		String GL0860	="Question Image or Video";//Label
		String GL0861	=	"Change Image";//Label
		String GL0862	="Remove Image";//Label
		//Add Question Resource View in shelf.
		String GL0863	="Question *";//HTMLPanel
		String GL0864	="Answer Choices *";//Label
		String GL0865 ="iPad friendly";
		String GL0866 	="+ Answer Choice";//Anchor
		String GL0867 	="Explanation";//Label
		String GL0868	="+ Hints";//Anchor
		String GL0869	="I agree to Gooru's copyright policy.";//Label
		String GL0870	="I agree that I either own this copyrighted content or have permission by the copyright holder to use this content. Further, I will use this material for educational uses only. Please refer to the";//Label
		String GL0871	="Community Guidelines";//Anchor
		String GL0872	="Terms";//Anchor
		String GL0873	="Privacy";//Anchor
		String GL0874	="for additional information.";//Label
		String GL0875	="Copyright";//Anchor
		String GL0876	="Please choose atleast one correct answer.";
		String GL0877	="Hints Charecters should be <=150";
		String GL0878	="Answer Charecters should be <=150";
		String GL0879	="Explanation Charecters should be <=400";
		String GL0880	="Charecters should be <=500";
		String GL0881	="Don’t forget to add brackets around the answers.";
		String GL0882	="Only 3 blanks are allowed.";
		String GL0883	="Please check that each answer is bracketed as in the example above.";
		String GL0884	="Please check that you've added the correct answer inside each set of brackets.";
		String GL0885	="_______";
	//Add Resource View in shelf
		String GL0886	="Add a resource";
		String GL0887	="From Web";
		String GL0888	="From File";
		String GL0889	="From Search";
		String GL0890	="Fill in the Blank";
		String GL0891	="Are you sure you want to remove the question image?";
		String GL0892	="Oops! You can't add a shortened URL as a resource.";
		String GL0893	="Add a Question";
		//Add search reource view in shelf
		String GL0894	="Search from Gooru’s millions of resources";//Label
		String GL0895	="Search for a keyword, then drag the resource you want from search results page into your collection";//Label
		String GL0896	="Go to Search ";//Button
		String GL0897	="Suggested Resources";//Label
		String GL0898	="One More Step";
		String GL0899	=".png";
		String GL0900	="Small";
		//Add user own resource view in shelf.
		String GL0901	="Upload a PDF or JPG file under 5MB ";//HTMLPanel
		String GL0902	="Browse";//Button
		String GL0903	="Please add a title.";//Label.
		String GL0904	="Description";//HTMLPanel
		String GL0905	="Please add a description.";//Label
		String GL0906	="Resource Format*";//HTMLPanel
		String GL0907	="Handout";//HTMLPanel
		String GL0908	="Slide";//HTMLPanel
		String GL0909	="TextBook";//HTMLPanel
		String GL0910	="Lesson";//HTMLPanel
		String GL0911	="Thumbnail Image";//HTMLPanel
		String GL0912	="Upload Image";//Button
		String GL0913	="Oops! We only support files under 5MB.";//Label
		String GL0914	="Please add a file.";//Label
		//Add web resource view,User own resource preview and web resource preview in shelf
		String GL0915	="URL*";//HTMLPanel.
		String GL0916	="Please enter a URL.";//Label
		String GL0917	="Please choose a format.";//Label
		String GL0918	="Videos";//HTMLPanel.
		String GL0919	="Interactives";//HTMLPanel.
		String GL0920	="Websites";//HTMLPanel.
		String GL0921	="Exam";//HTMLPanel.
		String GL0922	="Click here to generate an image";//Label
		String GL0923	="Refresh";//HTMLPanel.
		String GL0924	="Oops! You can't add a Gooru URL as a resource.";//Label
		String GL0925	="Thats a Playlist/Channel. Please choose another format.";//Label
		String GL0926	="Please enter a valid URL.";//Label
		String GL0927	="Looks like this is a Playlist not a video! Please select Webpage.";//Label
		String GL0928	="You are about to make this resource public, meaning it will be discoverable in search by the  Gooru community. After doing so, you will not be able to change any of the information, which includes the file, title, description, category, and image. However, you will be able to edit the narration or remove the resource at any point.";//Label
		String GL0929	="Uploaded File";//Label.
		String GL0930	="You are about to make this resource public, meaning it will be discoverable in search by the  Gooru community. After doing so, you will not be able to change any of the information, which includes the URL, title, description, category, and image. However, you will be able to edit the narration or remove the resource at any point.";//Label.
		String GL0931	="Uploaded URL";//Label
		//Exists Resource View in shelf
		String GL0932	="Already Exists";//HTMLPanel
		String GL0933	="This resource already exists";
		String GL0934	="Views";
		String GL0935	="Stars and the Universe";//Label
		
		//Collaborator
		String GL0936 = "Collection Creator";
		String GL0937 = "Remove yourself from the collaborator list";
		String GL0938 = "You";
		String GL0939 = "Current Collaborator(s)";
		String GL0940 = "Work together, go further!";
		String GL0941 = "Add a Collaborator";
		String GL0942 = "Teaching is more fun with friends! Use this page to add up to 20 collaborators. Anyone added as a collaborator will have permission to edit this collection.";
		String GL0943 = "Invite collaborators";
		String GL0944 = "Invite";
		String GL0945 = "Separate email addresses with a comma or space";	//Not used.. Duplicate of GL1111 
		
		//Copy resource confirmation popup.
		String GL0946 ="Copy Resources to";
		String GL0947 ="Choose a collection to copy this resources to";//HTMLPanel
		
		//Edit user own resource popup.
		String GL0948 ="Upload a file ";//HTMLPanel
		String GL0949 ="Edit Resource";
		String GL0950 ="Or keep the current File.";//Anchor
		String GL0951 ="Change the File";//Button
		String GL0952 ="File Title";//HTMLPanel.
		String GL0953 ="Please fill out your role, username and password so you can access Gooru directly.";//HTMLPanel.
		String GL0954 ="Your file is uploaded.";//Label
		String GL0955 ="Oops! We only support PDF and JPG files.";
		
		//shelf collection resource child view
		String GL0956 ="No narration added";//HTML
		String GL0957 ="Edit video start/stop times";//Label
		String GL0958 ="min";//HTMLPanel
		String GL0959 ="sec";//HTMLPanel
		String GL0960 ="Edit Start page";//Label
		String GL0961 =	"Start page :";//Label
		String GL0962 =	"Edit Narration";//Label
		String GL0963 =	"Edit Info";//Label
		String GL0964 =	"Edit Video Time";//Label
		String GL0965 =	"Copy To";//Label
		String GL0966 ="Updating...";//Label
		String GL0967 ="Add narration for your viewers";
		String GL0968 ="Are you sure you want to remove this resource from your collection?";
		String GL0969 ="collectionItem";
		String GL0970 =	"Please enter valid start and stop time.";
		String GL0971 ="Please enter the Start and End times in Minutes : Seconds (mm:ss).";
		String GL0972 ="Start time";
		String GL0973="Stop time";
		String GL0974="Video time:";
		String GL0975="Make sure to click \"Update\" to save the resource before doing something else!";
		
		String GL0976 ="Original URL";
		String GL0977="None Available";
		//More collection prompt.
		String GL0978="It looks like there are a lot of resources in this collection!";//Label
		String GL0979="Tip: ";//Label
		String GL0980="Try separating your collection into two";//Label
		String GL0981="Hmmm..";
		String GL0982="Add to your collection";
		String GL0983="by dragging another resource into it";
		String GL0984="Congratulations, you're now ready";
		String GL0985="to play freely on gooru";
		String GL0986="infoMsg";
		String GL0987="onlyMsg";
		String GL0988="onlyCongrats";
		//shelf collection
		String GL0989="This folder is empty!";
		//shelf folder collection
		String GL0990="Add to this Collection";
		String GL0991="Edit this Collection";
		//shelf list view
		String GL0992="Save this Collection";//LabelGlassPanel
		String GL0993="New Collection";
		String GL0994="Folders";//Label
		String GL0995="You have no collections!";
		String GL0996="Looking for your collections...";
		String GL0997="Drag a resource here to start a new collection.";
		String GL0998="Drag a collection here to save and customize it. ";
		String GL0999="You've reached the limit of folders/collections you can add to a folder!";
		
		String GL1000="Science";
		String GL1001="Math";
		String GL1002="Social Sciences";
		String GL1003="Language Arts";
		String GL1004="Skip";
		String GL1005="See all featured contributors.";
		String GL1006="are the featured contributors for";
		String GL1007="is the featured contributor for";
		String GL1008="Popular";
		String GL1009="Featured";
		String GL1010="Sign in with Google";
		String GL1011="Looks like this email is tied with Google!";
		String GL1012="Sign in through this link";
		//Balloon popup
		String GL1013="Coming soon!";
		
		String GL1014 = "Please enter collaborators Email.";
		String GL1015 = "Collaborators Email Id should not be Empty.";
		String GL1016 = "You can only add {0} collaborators to this collection.";
		String GL1017 = "You have reached the limit of {0} collaborators.";
		String GL1018 = "You can't add yourself as a collaborator.";
		String GL1019 = "{0} is not valid email id.";
		//Organize
		String GL1020 = "You are about to delete your \"{0}\" Collection.";
		//Confirmation Popup
		String GL1021 ="removing...";
		//course list
		String GL1022 ="Please select course.";
		//Disclosure panel.
		String GL1023 ="Dropdown Arrow";
		String GL1024 ="About Gooru";
		String GL1025 ="No Classpage";
		String GL1026 ="Title Shouldn't be empty";
		//Email share uc
		String GL1027="Please enter valid email.";
		String GL1027_1="Please enter only one email.";
		//Error popup
		String GL1028="Please drag the resource into collection...";
		String GL1029="Questions?";
		String GL1030="Check the FAQ's";
		
		String GL1031="Save and customize collections";
		String GL1032="Add a resource to a new collection";
		String GL1033="Alright! Let's get started on this brand new collection. Fill out the information below to let your students know what this collection teaches.";
		//Narration Uc
		String GL1034="";//Label.
		String GL1035="UserName";//Label
		String GL1036="Narration";//HTMLPanel.
		String GL1037="Do you want to save your results?";
		String GL1038="Looks like you answered some questions! Do you want to save your answers?";
		String GL1039="If you close this collection without printing or emailing your results, you will lose your work.";
		String GL1040="Leave this page";
		String GL1041="Stay on this page";
		String GL1042="Questions";
		String GL1043="Shouldn't be empty!";
		
		//new cateroies
		String GL1044 = "Texts";
		String GL1045 = "Audio";
		String GL1046 = "Images";
		String GL1047 = "Other";
		String GL1048="lastname";
		String GL1049="code";
		String GL1050="Close";
		String GL1051="Collection End";
		String GL1052="Collection Home";
		String GL1053="Jody Silverman";
		String GL1054="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin diam elit, luctus id porttitor semper, feugiat ac elit. Aenean non sagittis arcu, sit amet commodo felis. Proin mattis tristique posuere.";
		String GL1055="mailto:support@goorulearning.org";
		
		//Shelf list on drag and drop
		String GL1056="Save your favorite resources";
		String GL1057="Found a resource that you love? Just drag it over the box above to start a new collection. Collections are a wonderful way to share your favorite web resources with your students.";
		String GL1058="Found a collection that you'd like to use? Just drag it over the box above to save a copy for yourself! It'll be all yours to remix, revamp, and remodel.";

		//Add Resource ToolTip.
		String GL1059="This collection has reached its limit!";
		String GL1060="You need to confirm your account before you can make your profile public! ";
		
		//Gooru Guide
		String GL1061="New to Gooru?";
		String GL1062="Use the Gooru Guide to learn how to discover, organize, teach and study on Gooru.";
		
		//Library topic collection tooltip
		String GL1063="Gooru Community Library";
		
		//organize tooltip
		String GL1064="resources you've discovered into quizzes or collections, which are customizable playlists.";
		
		//study now tooltip and study tooltip.
		String GL1065="Enter";
		String GL1066="collections at your own pace and get guidance from your teacher's narration.";
		String GL1067="collections in the classroom or assign them to your students as homework.";
		
		//search box tooltip
		String GL1068="Enter any Science, Math, Social Sciences, or English Language Arts keyword or topic you would like to discover.";
		String GL1069="Examples:";
		String GL1070="Solar system";
		String GL1071="exponents";
		String GL1072="oceans";
		String GL1073="cells";
		
		//Collaborators
		String GL1111 = "Separate email addresses with a comma or space";
		String GL1112 = "Last edit was made {0} by {1}";
		String GL1113 = "Current Collaborator(s)";
		String GL1114 = "Pending Invitation(s) ";
		
		//profile page view.
		String GL1074="My Subjects:";
		String GL1075="Add Courses or Grades";
		String GL1076="Grade";
		String GL1077="About Me:";
		String GL1078="Your Profile Page is not public.";
		String GL1079="Profile Page Visibility";
		String GL1080="Share this Profile Page with others";
		String GL1081="http://bit.ly/14141GK";
		String GL1082="Public Collections";
		String GL1083="does not have any collections!";
		String GL1084="";
		String GL1085="Check out  ";
		String GL1086="'s Gooru Profile Page";
		String GL1087="Add Image";
		String GL1088="What course(s) do you teach? ";
		String GL1089="Oops";
		String GL1090="Please add different courses";
		String GL1091="Rights";
		String GL1091_1="404 Message";
		
		//ppp collection more info
		String GL1092="The term Open Educational Resources (OER) refers to educational materials that are freely available and licensed in a way that gives users the legal permission to reuse, revise, remix, and redistribute.";
		String GL1093="Open Education Resources";
		String GL1094="Resources in this Collection";
		String GL1095="You Don't have Access To Perform This Action";
		String GL1096="You need to be logged in";
		String GL1097="Your";
		String GL1098="OER License";
		//ppp collection result
		String GL1099="Views";
		String GL1110="Resource";
		String GL1115="Open";
		String GL1116="Kindly add teacher tip and then click save.";
		
		String GL1117="Team";
		
		String GL1118 = "Remove Collaborator?";
		String GL1119 = "Are you sure you want to remove {0} as a collaborator? They will no longer be able to access or edit the collection.";
		String GL1120 = "Woohoo!";
		String GL1121 = "Your invitations have been sent!";
		String GL1122 = "Collaborator removed";
		String GL1123 = "{0} is no longer a collaborator on this collection.";
		
		//New class page popup.
		String GL1124 = "What do you Teach?";
				
		//Collaborators
		String GL1125 = "You will no longer be able to edit this collection.";
		String GL1126 = "You are no longer a collaborator on this collection.";
		String GL1127 = "Heads up!";
		String GL1128 = "You are about to remove yourself from the collaborator list.";
		
		//Assignments View.
		String GL1129 = "This assignment is empty.";
		
		//Student Assignment View.
		String GL1130 = "Return to Teacher View";
		String GL1131 ="Oops! Looks like your teacher hasn't added any Collections to his/her page yet. Check back later to see if there are any changes";
		
		//Class code view.
		String GL1132="Students, enter in the Class Code provided by your teacher.";
		String GL1133="Oops! We don’t recognize that code. Try again and double check with your teacher for the correct code.";

		//Assignments Tab View
		String GL1134=	"Please select a collection.";
		String GL1135=	"Drop me into a collection!";
		String GL1136=	"Drop me into a folder!";
		//Collaborator
		String GL1137="inviting...";//Label
		//signup complete profile view
		String GL1138="submitting...";
		String GL1139="If you have any questions";
		String GL1140="First name (optional)";
		String GL1141="Last name (optional)";
		String GL1142="Tell us more about yourself! (optional)";
		String GL1143="New password (optional)";
		String GL1144="Confirm New password";
		String GL1145="Please contact ";
		String GL1146="Please select role.";
		
		//Folder Message Titles
		String GL1147="Edit Folder Title";
		String GL1148="Delete Folder";
		String GL1149="Move Folder";
		String GL1150="Copy Folder";
		String GL1151="New Folder";
		String GL1152="more";
		
		//Collaborators - Delete
		String GL1153="more classes";
		String GL1154="Classes";
		String GL1155="Class!";
		String GL1156 = "This collection is currently being used in your";
		String GL1157 ="If you would like to remove yourself as collaborator, the collection will be removed and no longer be available in ";
		
		/// different section...
		String GL1158 ="This collection is public, which allows others to find and learn from your collection";
		String GL1159 ="Congratulations";
		String GL1160 ="Your Gooru account has been created. Tell us more about your favorite course(s) and grade(s). We’ll use this information to personalize your Gooru experience or skip to finish.";
		String GL1161 = "Sorry! We don't support that format yet!";
		
		//Collaborators
		String GL1162 = "Are you sure ?";
		String GL1163 = "Uh oh...";
		String GL1164 = "This collection is currently being used in {0}'s Class!";
		String GL1165 = "If you remove their collaborator privileges, this collection will no longer be available to their Class.";
		String GL1165_1 = "You've added the maximum number of collaborators!";
		//Assign
		String GL1166 = "Directions:";
		String GL1167 = "(Optional)";
		String GL1168 = "Due Date:";
		String GL1172 = "Assigning...";
		String GL1179= "what do you want to tell your student...";
		String GL1183= "Nice Work!";
		
		//Library Topic List View
		String GL1169 ="Search for more on this topic";
		String GL1170 ="No Collection available!";
		String GL1171 ="Topic";
		
		String GL1173 = "This folder has been deleted.";
		String GL1174 = "Are you 100% sure you want to delete this folder?";
		String GL1175 = "Please type \"delete\" and click Ok";
		String GL1176 = "Delete Folder";
		String GL1177="Whoops!";
		String GL1178="Sorry! We only support three levels of folders.";
		String GL1180="Courses";
		String GL1181=	"photo";
		String GL1182="Our Contributors";
		
		//Collaborator
		String GL1184 = "You've added the maximum number of collaborators!";
		String GL1185 =	"Login";
		String GL1184_1 = "Separate email addresses with a comma or semicolon";
		String GL1186 = "This collection is currently being used in your {0} Class!";
		String GL1187 = "If you delete this collection, it will be removed and no longer be available in the class. This is permanent action!";

		//Registration welcome popup.
		String GL1188 =	"Get started on Gooru";
		String GL1189 =	"Now, on your way! Happy Studying";
		String GL1190 ="You're now ready to use Gooru";
		String GL1191 ="Thanks! You’re almost there...";
		String GL1192 =	"We sent you a confirmation email with instructions on how to complete your Gooru registration. Please check your email account.";
		String GL1193 =	"Please contact us at";
		String GL1194 =	"Didn’t receive a confirmation email";
		
		//parent register vc
		String GL1195 ="Looks like you’re going to need your parent or guardian’s help to sign up. Please enter your parent or guardian’s email, and we’ll get you set up soon! ";
		String GL1196 ="Parent/Guardian’s Email";
		String GL1197 ="Register for your Gooru Beta account";
		
		//user registration view.
		String GL1198 ="Information";
		String GL1199 ="Do not wish to share";
		String GL1200 ="I am a:";
		String GL1201 ="By clicking Register, I understand and agree with the rules and restrictions of this registration, the ";
		String GL1202 ="Gooru.";
		String GL1203 ="Register";
		String GL1204 ="is already available";
		String GL1205 ="Parent/Guardian";
		String GL1206 ="Child";
		String GL1207 ="Register / Log in";
		String GL1208 ="<p>Thanks for confirming your email! Please register <b>yourself</b> below before you create an account for your child.</p>";
		String GL1209 ="<p>Fill in the following information to create an account for your child.</p>";
		String GL1210 ="Create a child account";
		String GL1211 ="<p>Thanks for confirming your email! Finish up the registration process by filling out the following information.You can always visit the settings page to update any information.</p>";
		
		//child account popup.
		String GL1212="Congrulations! Your child's account has been successfully created. A confirmation email has been send to your email, which contains details about your child account. ";
		String GL1213="We're excited for your child to start taking advantage of Gooru learning resources!";
		String GL1214="Child account successfully created";
		
		//image upload view.
		String GL1215="Choose a picture from";
		String GL1216="On the web";
		String GL1217="My Computer";
		String GL1218="Gooru Images";
		String GL1219="Upload a picture from a file on your computer";
		String GL1220="You can upload a JPG,GIF, or PNG file of size smaller than 5MB.";
		String GL1221="Not Working";
		String GL1222="Read this";
		String GL1223="Upload a picture from a file on the web";
		String GL1224="Image URL";
		String GL1225="Upload";
		String GL1226="Type the image URL in the text field above. If it's correct, you'll see an image preview here. Please upload images smaller than 5MB. ";
		String GL1227="Remember, using others' images on the web without their permission may be bad manners or worse, copyright infringement.";
		String GL1228="Choose an image from the following options";
		String GL1229="The image you are trying to upload is either the wrong file type or too large! Please upload another image.";
		String GL1230="Something went wrong, please try again with some other cover image.";
		
		//Image Crop View
		String GL1231="« Back to upload";
		String GL1232="<h2>Crop this picture</h2>";
		String GL1233="<p>You can drag the box to select the crop area, and use the handle to resize it.</p>";
		String GL1234="Preparing for cropping...";
		String GL1235="Crop";
		String GL1236=	"cropping...";
		
		//Aleart popup vc.
		String GL1237="Sorry! You are only allowed to store your resource in collections.";
		String GL1238 = "If you delete this collection, it will no longer be available.<br>This is a permanent action! ";
		
		String GL1239 = "Click here to learn more";
		
		//Featured Content vc.
		String GL1240="This Week's Featured Collections";
		String GL1241="Did you know ?";
		String GL1242="About";
		String GL1243="Community";
		String GL1244="Careers";
		String GL1245="Contact Us";
		String GL1246="© Gooru 2014";
		
		//Gooru Guide Info Vc
		String GL1247="Use the Gooru Guide to help navigate the site when you get stuck.";
		String GL1248="You haven't confirmed your email account yet.";
		String GL1249="Resend email";
		
		//new text added for folders
		String GL1250= "Write your folder title here";
		
		//login popup in play
		String GL1251="Please log in to create and save your favorite resources";
		String GL1252="Keep me logged in";
		String GL1253="Register here";
		
		//ResetPassword Vc.
		String GL1254="Please enter your new password below.";
		String GL1255="New Password";
		
		//Reset Password Success Vc.
		String GL1256="You may now log in with your new password.";
		
		//Reset Timeout Vc
		String GL1257="The Reset Password link has timed out.";
		String GL1258="Please request a new one";
		String GL1259="here";
		
		//About View Vc
		String GL1260="back to the top";
		
		//Folders
		String GL1261="Move";
		String GL1262="Folder Title";
		String GL1263="Please select a folder where you want this collection to move to.";
		String GL1264="Move this collection";
		
		//IE Supported link.
		String GL1265="http://support.goorulearning.org/hc/en-us/articles/201995178-Unable-to-Upload-Images-on-Gooru-Using-Internet-Explorer-";
		
		String GL1266="Add a Folder";
		
		//About view vc
		String GL1267="Cisco";
		String GL1268="The Gates Foundation";
		String GL1269="ONR";
		String GL1270="Google";
		String GL1271="NGLC";
		String GL1272="Pearson";
		String GL1273="The Hewlett Foundation";
		String GL1274="SCE";
		String GL1275="Fenwick";
		String GL1276="Ram Shriram";
		String GL1277="Gooru is a non-profit organization dedicated to honoring the human right to education. Learn more about our work by visiting the ";
		String GL1278="section of our site.";
		
		//Almost Done Uc.
		String GL1279="Almost done";
		String GL1280="Before we let you free, please fill out the following two fields";
		String GL1281="Role";
		String GL1282="what is your role";
		String GL1283="By clicking OK, I understand and agree with the rules and <br/>restrictions of this registration, the";
		String GL1284="Please choose a username";
		String GL1285="A username must be at least 5 characters long";
		String GL1286="is already in use";
		
		//Save Share Panel.
		String GL1287="Quick Help";
		String GL1288="Getting Started";
		String GL1289="What can I do on Gooru";
		String GL1290="How do I search for resources on Gooru";
		String GL1291="What types of resources does Gooru have";
		String GL1292="How do I use search filters to narrow down my results";
		
		//New text added for folders.
		String GL1293="Get Started Here";
		String GL1294="create a collection";
		String GL1295="Get started by creating a collection. Click on";
		
		//Save Share Panel Cont. 
		String GL1296="lesson 1";
		String GL1297="How do I save a resource I’ve found on Gooru to a collection";
		String GL1298="How do I add narration to a resource";
		String GL1299="Can I share a collection with others";
		String GL1300="As you watch, think about";
		String GL1301="Answer this question";
		String GL1302="How do I teach using Gooru";
		String GL1303="What is a classpage and how do I create one";
		String GL1304="How do I share a classpage with my students";
		String GL1305="How do I begin an assignment that my teacher has shared with me";
		String GL1306="More Questions? Visit Our";
		String GL1307="Support Center";
		String GL1308="Get started by creating a collection. Click on create a collection button on the top corner to start.";
		
		//Search Home Filter Vc.
		String GL1309="filter options";
		String GL1310="Resource Type";
		String GL1311="subjects";
		String GL1312="Spend more time learning and less time searching.";
		String GL1313="Start Search";
		
		//Tryit Out Vc.
		String GL1314="We've made it easier than ever to find great learning resources and organize them into collections.";
		String GL1315="Learn more about the changes.";
		String GL1316="Back to Classic";
		String GL1317="Classic gooru has all of your collections.";
		String GL1318="Try it Out";
		String GL1319="You can always go back to classic gooru to see your shelf.";
		
		String GL1320_1="Grades";
		String GL1321="How it Works in Gooru";
		
		//Gooru in classroom vc.
		String GL1322="Five Teaching Methods using Gooru Collections Inside and Outside the Classroom";
		String GL1323="Blended Learning";
		String GL1324="Flipped Classroom";
		String GL1325="Assessments";
		String GL1326="Project-Based Learning";
		String GL1327="Enriched Instruction";
		
		String GL1328 = "All collections inside this folder will be permanently deleted!";
		String GL1329 = "If you would like to place this folder inside an existing folder, please select it from this list.";	
		String GL1328_1="the best free K-12 learning resources on the Web.";
		String GL1329_1="resources you've discovered into quizzes or collections which are customizable playlists.";
		String GL1330="Using collections and quizzes hand-picked by you, students complete assignments tailored to their exact needs at their own pace.";
		String GL1331="Watch our Video";
		String GL1332="video icon";

		//Landing page get started uc.
		String GL1333="How to Get Started";
		String GL1334="Begin by searching for collections or resources, and filter by grade, subject or teaching standard.";
		String GL1335="Create";
		String GL1336="Start your own collection of resources on a particular subject, or personalize an existing collection for the way you like to teach.";
		String GL1337="Start saving, creating and sharing the cool resources and collections you find. Get started today";
		
		//Delete collection
		String GL1338 = "This collection is currently being used in more than one Class.";
		String GL1339 = "If you delete this collection, it will be removed and no longer available to the Classes. This is a permanent action!";
		
		//Customize Vc.
		String GL1340 ="Watch the Video";
		String GL1341 ="Guide your students through each resource by adding narration";
		
		//Discover Vc
		String GL1342 ="Discover the best learning resources on the Web";
		String GL1343="Quickly find and save exactly what you need, down to the grade level, resource type, and standard. Gooru has over 10 million resources, and 1 million questions covering all K-12 subjects";
		String GL1344="Enter any Science, Math, Social Science, or English Language Arts keyword or topic you would like to discover";
		String GL1345="Narrow your search results using subject, grade, standard, and other filters";
		String GL1346="Are you looking for a single resource or a collection; a curated playlist of resources? Use this toggle to switch between resources and collections";
		String GL1347="Once you've found what you want; drag and drop it into the box in the upper-right corner to create your own collection";
		String GL1348="Once you've gathered your resources, click 'Edit' to customize your collection";
		String GL1349="Need more help? Visit our";
		
		//Faq Vc.
		String GL1350="Can I organize multiple resources into a playlist";
		String GL1351="Yes, a collection is a playlist of resources, and you can easily create a collection from resources that you have found";
		String GL1352="Once I've added multiple resources to my collection, can I edit or reorganize them";
		String GL1353="Yes, to edit your collection in greater detail, hover on an open collecion and click the Edit Collection button that appears. In Edit mode, you can rearrange resources, write a description for the collection, tag it with relevant vocabulary and phrases to make it easy to find, add collaborarators, and edit its privacy settings.";
		String GL1354="Can I share an individual resource with my students";
		String GL1355="Of course! Hover your mouse over the resource you want to share, and click Share. We'll click Share. We'll provide you with a link that you can send to your students.";
		String GL1356="Need more help";
		String GL1357="Support Forums";
		String GL1358="Go to our support forums to get more answers or";
		String GL1359="if you need any additional help";
		String GL1360 = "Your invitation has been sent!";
		
		//Device Support Uc.
		String GL1361="Tech Saavy";
		String GL1362="moving...";
		String GL1363="Standard Description";
		
		String GL1364="Which folder would you like to move this collection to?";
		String GL1365="We've saved a copy of this collection for you to use! Would you like to give it a new title?";
		String GL1366="This collection has been moved to ";
		String GL1367="Collection Moved!";
		
		
		//CLASS PAGE 
		
	
		String GL1368="Edit Due Date";
		String GL1369="Edit Direction";
		String GL1370="Edit Collection";
		String GL1371="Remove Collection";
		String GL1372="Directions:";
		String GL1373="Learning Objective:";
		String GL1374="Not available";
		
		
		//AddCollection popup 
		String GL1375="Assign a collection to your Class";
		String GL1376="Choose a collection";
		String GL1377="Please choose one of the following";
		String GL1378="Don't see one of your collections? Make sure that your collection isn't set to private.";
		String GL1379="Directions (optional)";
		String GL1380="Due Date (optional)";
		String GL1381="Add Classpage";
		String GL1382="Teach with Classpages";
		String GL1383="A Classpage allows you to assign collections with direction and due dates for your class. Create and manage assignments for your students all in one place.";
		
		//Success popup
		String GL1384="Successfully Assigned!";
		String GL1385="Your collection <i>{0}</i> has been successfully assigned to your Class!";
		String GL1386="OK";
		
		// Remove collection popup
		String GL1387="Remove this collection";
		String GL1388="Are you sure that you want to remove this collection from your Class? Removing this collection will NOT delete it.";
		
		String GL1389="Example: Complete this collection. When you're finished, you may continue onto the lab station.";
		// edit direction in class page
		String GL1390="Due Date: ";
		 
		//Error View related.
		String GL1391="Oh no! The page has escaped! We're doing our best to find it.";
		String GL1392="In the meanwhile, learn about ";
		String GL1393="Detectives ";
		
		//Student Signup uc
		String GL1394="registerChild";
		
		//Shelf Tool tip
		String GL1395 = "This collection is public! Other educators can find and use it in their classrooms.";
		String GL1396 = "Webpage";
		
		//class pages related
		String GL1397="Classpages";
		String GL1398="Rounded One";
		String GL1399="Create a Classpage for your class";
		String GL1400="Rounded Two";
		String GL1401="Add Assignment";
		String GL1402="Add collections, due dates and direction to assignments you create.";
		String GL1403="Rounded Three";
		String GL1404="Share the Classpage with your students using the link or class code.";
		String GL1405="Need some more help? Visit our ";
		String GL1406="support center";
		
		//Assignment Popup View.
		String GL1407=	"Assignment Title";
		String GL1408=	"Assignment Directions";
		
		//class page resource item child view."
		String GL1409="Algebra I";
		
		//Add Collections PopupVc.
		String GL1410="Add a Collection";
		
		//Add Collections popupVc
		String GL1411="Choose a Collection";
		String GL1412="Can’t find a Collection on the list? Make sure that those Collections are shareable with others in Collection Edit.";

		//share tab view in class pages
		String GL1413="This link takes students directly to this Classpage.";
		String GL1414="Ask students to enter in this code in the Study tab to view this Classpage.";
		
		//Home Presenter.
		String GL1415="Oh! No";
		String GL1416="Something missing in your mail link. Please contact our support team.";
		String GL1417="The email address specified already exists with in gooru.Please login in to your existing account and create child account. ";
		String GL1418="The user has already registered successfully. Please use sign-in to log in to your account";
		String GL1419="User Not Found. Please Try to Register";
		String GL1420="Something Missing";
		String GL1421="Save a copy of this collection";
		
		//Library View
		String GL1422="Mr";
		String GL1423="Ms";
		
		//Image upload View.
		String GL1424="type";
		
		//Add COllection View
		String GL1425="Collection title should not be empty.";
		String GL1426="Title cann't start with special character";
		String GL1427="Please enter the title less than 50 characters";
		
		//CollectionPlayer MetaData View.
		String GL1428="View";
		
		//Collection End View
		String GL1429="Sent using Gooru. Visit http://www.goorulearning.org/ for more great resources and collections. It's free!";
		
		//Collection Flag View.
		String GL1430="I would like to report \"";
		String GL1431="because";
		
		//Preview player metadata view
		String GL1432="comments";
		
		//Social share small view
		String GL1433="on Gooru";
		
		//Comment Widget Child View
		String GL1434="edited";
		String GL1435="hours";
		String GL1436="hour";
		String GL1437="minutes";
		String GL1438="minute";
		
		//Collection share view
		String GL1439="Gooru - ";
		String GL1440="Sent using Gooru. Visit";
		String GL1441="for more great resources and collections. It's free!";
		
		//Collection Email Share View
		String GL1442="Enter your Email";
		String GL1442_1="Enter your Name";
		String GL1443="I've shared my Gooru collection summary with you";
		String GL1444="Hello [Enter your teacher or tutor's name] <div><br/></div><div>I am sharing my collection summary with you.<br/>(PDF attached)<div>"+"<div><br/></div><div>Thank you!</div><div>[Enter your full name]</div>";
		
		//Print Summary Page
		String GL1445="Multiple Choice and Fill in the Blank Questions";
		String GL1446="Multiple Choice Questions";
		String GL1447="Completed";
		String GL1448="Collection Link";
		
		//Summarypage Email Share
		String GL1449="Email your Collection Results";
		
		String GL1450="Create Folder";
		String GL1451="Create Collection";
		
		
		// loading text for workspace
		
		String GL1452="Looking for your collections...";
		
		//Resource FrameBreaker View.
		String GL1453="You are seeing this page because this resource cannot be displayed in our player.";
		
		//FillintheBlankQuestionView and multiple Choices Question View.
		String GL1454="Please type your answer(s) in the blank(s) provided";
		String GL1455="Blank";
		String GL1456="correct answer";
		String GL1457="Please select the correct answer";
		
		//open ended questions
		String GL1458="Character limit is reached";
		String GL1459="Answer text should not be empty";
		String GL1460="Please type your answer in the field below, and click the \"Submit\" button to save your response when you're done.";
		String GL1461="Example: Complete this collection. When you're finished, you may continue onto the lab station.";
		
		//Abstract Search View.
		String GL1462="previous";
		String GL1463="next";
		String GL1464="e.g. Nasa";
		String GL1465="Collection Type";
		String GL1466="No description Available";
		String GL1467="All grades";
		String GL1468="Search results for";
		
		//Resource More Info Vc
		String GL1469=	"Like this resource?";
		String GL1470="Top Collections that Use this Resource";
		String GL1471="Pages";
		String GL1472=	"Edit this folder in Organize";
		String GL1473=	"Edit this collection in Organize";
		String GL1474=	"Get started by creating a collection!";
		String GL1475="Please select a collection.";
		
		//User Settings View.
		String GL1476=	"(none added)";
		String GL1477="What grade(s) do u teach?";
		String GL1478="What course(s) do u teach?";
		String GL1479="What grade are you in?";
		String GL1480="Select the course(s) you are taking";
		String GL1481="Select grade(s) that you are interested in";
		String GL1482="Select course(s) which you are interested in";
		
		//Save popup related.
		String GL1483="Please confirm your email";
		String GL1484="Please go and check your email to confirm your new email address.";
		
		//Shelf View.
		String GL1485="Add a learning objective for your collection";
		String GL1486="Back to your Class";
		String GL1487="Back To Search";
		
		//Collection Collaborator tab.
		String GL1488="User does not exist";
		String GL1489="Collaborator already added";
		
		//Collection Form in play view.
		String GL1490="You need to confirm your account before you can make collections public";
		
		//CollectionStatisticsTabVc
		String GL1491="Quick Glance";
		String GL1492="avg time";
		String GL1493="adds";
		String GL1495 ="This collection is currently being used in someone's Class!";
		
		//CollectionInfoTabView
		String GL1496 ="Change Course";
		
		//Exists Resource View.
		String GL1497 ="Flag this Resource";
		String GL1498="You have already flagged this resource. Flag it again.";
		
		//Edit Question Popup View.
		String GL1499="Question Type";
		
		//Shelf list view
		String GL1500="Back to search results";
		String GL1501="Folder";
		
		//App Suggest Box
		String GL1502="e.g. TEKS.M.HS.G.7";
		String GL1503="e.g. CCSS.Math.Content.8.F.A.3";
		
		//DateBox Uc.
		String GL1504="The date entered shouldn't be greater than current date.";
		String GL1505="The date entered shouldn't be lesser and equal to current date.";
		String GL1506="Today";
		
		//Tiny Mice.
		String GL1507="Mark as a blank";
		
		//Folders Welcome page.
		String GL1508="Create and Organize your Collections!";
		String GL1509="Collections are playlists of educational resources that can be personalized for your students' learning. Create your own collection by discovering resources on Gooru, the Web, or by adding your own questions.";
		String GL1510="Create a collection and add selected resources.";
		String GL1511="Workspace";
		String GL1512="Organize and add narration to guide your students.";
		String GL1513="Share collections through a link or assign them to your class.";
		String GL1514="Share Assign";
		String GL1515="Please choose a category.";
		
		//Invite Student Popup
		String GL1521 = "Please enter students’ email addresses.";
		String GL1522 = "Send Class code &amp; links to Students";

		String GL1523 = "You can only add {0} students to this Class.";
		String GL1524 = "You can't add yourself to this Class.";
		String GL1525 = "Pending Invitations";
		String GL1526 = "Students in my Class";
		String GL1527 = "No student has joined your class yet!";
		String GL1528 = "You can invite up to {0} students to this class! That's a lot of papers to grade...";
		
		//Study player header
		String GL1529 = "Hi, ";
		String GL1530 = "! Welcome to this collection!";
		String GL1531 = " Click Study to get started!";
		
		//AleartMessage popup
		String GL1535 = "It looks like you don't have permission to access this class. If you are invited to this class, please sign in & try again.";
		String GL1535_1 = "It looks like you don't have permission to access this class.";
		String GL1536 = "Join Class";
		String GL1537 = "Withdraw";
				
		String GL1538 = "Remove Students?";
		String GL1539 = "<ui>Usernames must:<br><br><li style=\"margin-left:10px\">be between 4 and 20 characters in length </li><li style=\"margin-left:10px\">not include spaces or special characters </li></ui><br>If you have any trouble updating your username, you can contact us at <a href=\"mailto:support@goorulearning.org\">support@goorulearning.org</a>.";
        String GL1540 = "Welcome to Class!";
        String GL1541 = "To proceed to join, please read & accept the privacy terms.";
        String GL1542 = "Gooru Privacy Terms";
        String GL1543 = "By clicking \"Join Class,\"  I agree to share my collection progress and information with <i>{0}</i>";
        
        String GL1544 = "Your Collection Summary";
        String GL1545 = "Hi there, you are new to this collection. Go study this collection now!";
        String GL1546 = "You have no previous learning history for this collection ";
       
        String GL1547 = "Are you sure you want to remove {0} as a student? You will no longer be able to access your student's class data.";
    	String GL1548 = "Remove Student?";
    	String GL1549 = "You are a member";
    	String GL1550 = "Partner Libraries";
    	
    	String GL1551 = "You are the teacher of this class.";
    	String GL1552 = "You are now a member of this class.";
    	String GL1553 = "Successfully Joined";
    	String GL1554 = "Welcome to ";
    	String GL1555 = "Are you sure you want to withdraw from this class?<br/> You will no longer be able to access your class study data.";
    	String GL1556 = "Nice!";
    	String GL1557 = "Your invitations are in the mail!";
    	
    	
    	
    	String GL1558 = "This information provides <i>{0}</i> with tools that measure your progress and help to enhance your learning experience.";
    	String GL1559 = "Standards Preference";
    	String GL1560 = "Common Core State Standards";
    	String GL1561 = "California Science Curriculum Standards";
    	String GL1562 = "Texas Essential Knowledge and Skills";
    	String GL1563 = "Join this class to: <ui><li style=\"margin-left:10px\">Track your progress</li><li style=\"margin-left:10px\">Quickly access this class in the future</li></ui>";
    	String GL1564 = "Are you sure you want to hide these standards? If you do, these standards will no longer be visible to you on this site.";
    	
    	String GL1565 = "Looks like you've tagged collections with these Standards!";
        
    	String GL1566 = "Click here for the Autodesk website";
    	String GL1567 = "http://www.autodesk.com/education/";
    	String GL1568 = "Click here for the Office of Naval Research (ONR) website";
    	String GL1569 = "http://www.onr.navy.mil";
    	String GL1570 = "Click here for the Foundation for Teaching Economics (FTE) website";
    	String GL1571 = "http://www.fte.org";
    	String GL1572 = "Click here for the New Global Citizens (NGC) website";
    	String GL1573 = "http://www.newglobalcitizens.org";
    	String GL1574 = "Click here for the WSPWH website";
    	String GL1575 = "http://www.whatsoproudlywehail.org";
    	String GL1576 = "Click here for the Silicon Valley Education Foundation (SVEF) website";
    	String GL1577 = "http://svefoundation.org";
    	
    	
    	String GL1578 = "Class Title";
    	String GL1579 = "Class Info";
    	String GL1580 = "Teacher";
    	String GL1581 = "Due Date";
    	String GL1582 = "Directions";
    	String GL1583 = "Please select the standards initiative(s) you prefer to view on Gooru. These standards will appear in libraries and in other places where resources and collections are visible.";
    	
    	String GL1584="Invite your students to join this class!";
    	String GL1585="Invite students to your class";
    	
    	
    	String GL1586="Collection Progress";
    	String GL1587="Collection Summary";
    	String GL1588="{0} must contain atleast one character.";
    	
    	String GL1589="Invite Only!";
    	String GL1590="Invite students to your class";
    	String GL1591="Enter email addresses";
    	String GL1592="Share in Your Classroom";
    	String GL1593="Class Codes are an easy way to share classes with your students in the classroom. Simply have students enter the class code in the Study tab to find their assignments.";
    	String GL1594="Share via E-mail or Online";
    	String GL1595="Use Web Links if you want to share classes via email or other online channels. Ask your students to click directly on the link to find their assignments.";
    	String GL1596="Once your students join, you can";
    	String GL1597="Manage a Class List";
    	String GL1598="Track Student &amp; Class Progress";
    	String GL1599="Your class is";
    	String GL1600="This means that only students who you invite can access and join this class. Students will need to create their own Gooru accounts. Switch to Open to make your class more accessible.";
    	String GL1601="Public Class,";
    	String GL1602="allowed anyone with the class code or link can access your class.Set up the visibility of your class before sharing it with your stuidents";
    	String GL1603="a default class setting, allows anyone with a class code or link to access your class.";

    	String GL1604="This means that anyone with the Class Code or Class URL can access and join this class.  Switch to Invite Only to limit access.";
    	String GL1605="Introducing the New Class";
    	String GL1606="We've added some new features to your class!";
    	String GL1606_1="Check out some of the new things you can do:";
    	String GL1607="Open & Invite Only Classes";
    	String GL1608="Share your class with everyone or only students you invite";
    	String GL1609="Collection Summary" ;
    	String GL1610="You can see how students in your class do on your collections.";
    	String GL1611="Students in My Class";	
    	String GL1612="Now, students with Gooru accounts can join your class.";	
    	String GL1613 = "To see all standards, please edit your standards preference in settings.";
    	String GL1614="Do you want to save your progress?";
    	String GL1615="Log in to your Gooru account to keep track of your progress!";
    	String GL1616="Hi {0}! Ready to start exploring? Click the Study button to get going. We’ll keep track of your progress for you.";
    	String GL1617="Back to Assignments";
    	String GL1618="Withdraw from class?";
    	String GL1619="Monitor Progress";
    	String GL1620="Your class is Invite Only! This means that only students who you invite can access and join this class. Students will need to create their own Gooru accounts. Switch to Open to make your class more accessible.";
    	String GL1621 = "Open";
    	String GL1622="Your class is open! This means that anyone with the Class Code or Class URL can access and join this class.  Switch to Invite Only to limit access.";
    	String GL1623="Assignments";
    	String GL1624="Students";
    	String GL1625="It's so quiet in this class. Start assigning collections!";
    	
    	//study player text
    	String GL1626="Your Collection Summary";
    	String GL1627="You are currently logged out! Please log in to view your data on this collection.";
    	String GL1628 = "Aggregator";
    	String GL1629 = "e.g. YouTube";
    	String GL1630 = "View in Organize";
    	String GL1631="Back to the class";
    	String GL1632 = "Looks like this class does not exist!";
    	
    	String GL1633 = "Please note: It may take up to an hour for collections analytics to appear for newly added students.";
    	
    	String GL1634 = "To see all standards, please edit your standards preference in settings.";
    	
    	//User Settings View
    	String GL1635 ="Username cannot contain spaces";
    	
    	String GL1636="Note: Your teacher will receive an email from Gooru on your behalf";
    	
    	String GL1637="INSTRUCTIONAL METHOD";
      	String GL1638="AUDIENCE";
      	String GL1639="Choose the purpose for your collection";
      	String GL1640="Choose an audience for this collection";
      	String GL1641="e.g: Students will be able to explain patterns in the number of zeroes of an answer when multiplying by the powers of ten and explain patterns in the placement of decimal point.";
      	String GL1642="LANGUAGE OBJECTIVES";
      	String GL1643="DEPTH OF KNOWLEDGE";
    	String GL1644="Choose the...";
    	String GL1645="Level1: Recall";
    	String GL1646="Level2: Skill/Concept";
      	String GL1647="Level3: Strategic Thinking";
      	String GL1648="Level4: Extended Thinking";      	
      	String GL1649="LEARNING & INNOVATION SKILLS";      	
      	String GL1650 = "Choose the skills that this collection addresses.";
      	String GL1651 = "Creativity and Innovation";
      	String GL1652 = "Critical Thinking and Problem Solving";
    	String GL1653 = "Communication and Collaboration";

    	String GL1654="Edit Folder Metadata";
    	String GL1655 = "Next Generation Science Standards";
    	
    	String GL1656="Primary Information";
    	String GL1657="Secondary Information";
    	
    	String GL1658="TEACHER TIPS";
    	String GL1659="Share how you use this collection with your students. This will help other teachers understand how you are using your collection.";
    	

    	



    	//Navigation Confirmation popup
    	String GL1660="Are you sure you want to navigate away?";
    	String GL1661="Your responses will be lost.";
    	String GL1662="back to response";
    	String GL1663="continue";
    	
    	String GL1664="Educational Use";
    	String GL1665="Activity";
    	String GL1666="Homework";
    	String GL1667="Game";
    	String GL1668="Presentation";
    	String GL1669="Reference Material";
    	String GL1670="Quiz";
    	String GL1671="Curriculum Plan";
    	String GL1672="Lesson Plan";
    	String GL1673="Unit Plan";
    	String GL1674="Project Plan";
    	String GL1675="Reading";
    	String GL1676="Article";
    	String GL1677="Book";
    	String GL1678="Moments of Learning";
    	String GL1679="Preparing the Learning";
    	String GL1680="Interacting with the Text";
    	String GL1681="Extending Understanding";
     	String GL1682="Standards";
    	String GL1683="e.g.CCSS.Math.Content.8.F.A.3";
    	String GL1684="Please choose one of the following...";
    	
    	
    	//Added new fields for player metadata.
    	String GL1685="Time Required";
    	String GL1686="Contributor";
    	String GL1687="Mobile-friendlyness";
    	String GL1688="Data Type";
    	String GL1689="Interactivity Type";
    	String GL1690="Educational Alignment";
    	String GL1691="Educational Role (Audience)";
    	String GL1692="Age Range";
    	String GL1693="Depth of Knowledge";
    	String GL1694="Reading Level";
     	String GL1695="Has Adaptation";
     	String GL1696="Language";
    	String GL1697=	"Country Code";
    	String GL1698="Is Adaptation";
    	String GL1699="Copyright Holder";
    	String GL1700="Host";
    	String GL1701="Gooru Course";
    	String GL1702="Accessbility API";
    	String GL1703="ACCESSIBILITY";
    	String GL1704="Control Flexibility";
    	String GL1705="Access Hazard";
    	String GL1706=	"Media Features";
    	String GL1707="Access Mode";
    	String GL1708="GENERAL INFO";
		String GL1709="e.g: I use this with my students to explain how, etc...";
		String GL1710="Image";
		String GL1711="Video";
		String GL1712="YouTube URL";
		String GL1713="Type the YouTube video URL in the text field above. if it's correct, you'll see a preview below. Feel free to also edit the video start and stop time as well.";
		String GL1714="Preview";
		String GL1715="Gooru Subject";
		String GL1716="RESOURCE INFO";
		String GL1717="Date Created";
		String GL1718="Thumbnail URL";
		String GL1719="License Code";
		String GL1720="EDUCATIONAL INFO";
		String GL1721 = "Language Objective";
		String GL1722 = "Learning & Innovation Skills";
		String GL1723 = "Audience";
		String GL1724 = "Instructional Method";
    	
		
		String GL1725="Ex: Our character is largely determined by our beliefs, experiences, and relationships.";
		String GL1726="Ex: Why is it important to know the qualities of a character? How do characters’ actions reveal or convey who they are?";
		String GL1727="Ex: Write an informational essay.";
		
		String GL1728 = "See All";
		String GL1729 = "Big Ideas";
		String GL1730 = "Essential Questions";
		String GL1731 = "Performance Task";
   }

