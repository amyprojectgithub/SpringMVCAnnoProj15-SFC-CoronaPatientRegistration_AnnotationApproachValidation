package com.nt.command;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import lombok.Data;

@Data
public class PatientCommand {
	@NotEmpty(message = "Patient Name is Mandatory")
	private String patName;
	@NotNull(message = "Patient age is Mandatory")
	@Range(min = 1,max = 100,message = "Patient age must be between 1 through 100")
	private Integer age;
	@NotEmpty(message = "Patient location is Mandatory")
	private String location;
	@NotEmpty(message = "Hospital name is Mandatory")
	@Length(min = 3,max = 20,message = "Hospital name must contain min of 3 and max of 12 chars")
	private  String hospital;
	private String vflag="no";

	public PatientCommand() {
		System.out.println("PatientCommand::0-param constructor");
	}






}
