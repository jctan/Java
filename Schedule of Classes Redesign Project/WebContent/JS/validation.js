/*
Name: John Tan 
Project: Schedule of Classes Redesign
Date: 12/13/2013

*/


//Prohibit user from typing numbers or special Characters (only allow user to type Alphabets)
function onlyAlphabets(e, t) {
            try {
                if (window.event) {
                    var charCode = window.event.keyCode;
                }
                else if (e) {
                    var charCode = e.which;
                }
                else { return true; }
                if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))
                    return true;
                else
                    return false;
            }
            catch (err) {
                alert(err.Description);
            }
  }

//Validate for 4 digit number or 4 digit number with a "H" for "Course Number"
function num(){ 
var x = document.theForm.number.value;
	
	if(x != ""){
	if(/^\d{4}$/.test(x)) //test for a match in a string to see if there are 4 digit number
	{
	return true; //returns true if there are 4 digit number 
		}
		else if(/^\d{4}[H]{1}$/.test(x)){
		return true;
		}
		else{
		alert("You Need To Enter a 4 Digit Course Number OR a 4 Digit Course Number with a H (For Honors Courses)");   //else output the alert
		return false;
		}
	}
}



//**Validate for Special Characters and numbers for "Instructors"
function SpecialCharNum(){   
//Declare a variable to validate the special characters and numbers
var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?0123456789";

for(var i = 0; i < document.theForm.instructor.value.length; i++){ //document.FormName.locationId.value.length - loop around the document.form
	if(iChars.indexOf(document.theForm.instructor.value.charAt(i)) != -1){ //if the index in iChars doesn't match in any returning i, execute the alert
	alert("Your search has the following special characters:\n\n" + iChars + "\n\nThese are not allowed.\nPlease try again."); 
	return false;
	}
	else{
	return true;
	}
}
}
