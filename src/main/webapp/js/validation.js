function validate(frm) {
	//Make the old error message empty
	document.getElementById("patNameErr").innerHTML="";
	document.getElementById("ageErr").innerHTML="";
	document.getElementById("locationErr").innerHTML="";
	document.getElementById("hospitalErr").innerHTML="";
	//read value from the form
	let name=frm.patName.value;
	let page=frm.age.value;
	let loc=frm.location.value;
	let hsptl=frm.hospital.value;
	let flag=false;
	
	//client side validation logic
	if(name==""){
		document.getElementById("patNameErr").innerHTML="<b>Patient name is mandatory</b>";
		flag=true;
	}
	if(page==""){
		document.getElementById("ageErr").innerHTML="<b>Patient age is mandatory</b>";
		flag=true;
	}
	else if(isNaN(page)){
		document.getElementById("ageErr").innerHTML="<b>Age must be numeric</b>";
		flag=true;
	}
	else if(page < 0 || page > 100){
		document.getElementById("ageErr").innerHTML="<b>Patient age must be 1 through 100</b>";
		flag=true;
	}
	
	if(loc==""){
		document.getElementById("locationErr").innerHTML="<b>Patient location is mandatory</b>";
		flag=true;
	}
	
	if(hsptl==""){
		document.getElementById("hospitalErr").innerHTML="<b>Hospital name is mandatory</b>";
		flag=true;
	}
	else if(hsptl.length < 3 || hsptl.length > 20){
		document.getElementById("hospitalErr").innerHTML="<b>Hospital name must contain min of 3 chars and max of 20 chars</b>";
		flag=true;
	}
	//set vlag to yes indicating client side validation is done
	frm.vflag.value="yes";
	if(flag)
		return false;
	else 
		return true;
	
}