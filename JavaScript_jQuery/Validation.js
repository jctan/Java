/*Name: John Tan 
Date: 9/21/2013

/*This is to validate special characters and numbers for instructors
and 4 digit number for Course Number.
*/

function validate(){
if(SpecialCharNum() && num()){
return true;
}
else {
return false; //returns false if BOTH above condition have not met
}
}

//Validate for Special Characters and numbers for "Instructors"
function SpecialCharNum(){   
//Declare a variable to validate the special characters and numbers
var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?0123456789";

for(var i = 0; i < document.theForm.instructor.value.length; i++){ //document.FormName.locationId.value.length - loop around the document.form
	if(iChars.indexOf(document.theForm.instructor.value.charAt(i)) != -1){ //if the index in iChars doesn't match in any returning i, execute the alert
	alert("Your search has the following special characters:\n\n" + iChars + "\n\nThese are not allowed.\nPlease try again."); 
	return false;
	}
	else
	return true;
	}
}

//Validate for 4 digit number for "Course Number"
function num(){ 
var x = document.theForm.number.value;

	if(/^\d{4}$/.test(x)) //test for a match in a string to see if there are 4 digit number
	{
	return true; //returns true if there are 4 digit number 
		}
		alert("You Need To Enter 4 Digit Course Number");   //else output the alert
		return false;
}



	