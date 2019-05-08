package com.frontend.jobmanger.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import models.User;
import models.UserEmploymentState;
import models.UserSexState;

@Controller
public class RegistrationController
{
	
	@GetMapping("/regnewuser")
	public String showRegistrationForm(Model model)
	{
		model.addAttribute("user", new User());
		return "regnewuserform";
	}

	@PostMapping("/submitNewUserReg")
	public String addNewUser(@RequestParam String userFirstName,@RequestParam String userLastName,
			@RequestParam String userBirthDate, @RequestParam String userEmail, @RequestParam String userCity,
			@RequestParam String userStreetName, @RequestParam Integer userStreetNumber,
			@RequestParam String userCountryName, @RequestParam String userNickName,
			@RequestParam UserSexState typesOfUserSex, @RequestParam UserEmploymentState currentEmploymentState,
			@Valid @ModelAttribute User currentUser, BindingResult bindingResult)
	{

		String pageAfterNewUserValidation = "newUserAddConfirmation";
        boolean resultOfInsertForNewUserIntoRepo = false;
		if (bindingResult.hasErrors() || resultOfInsertForNewUserIntoRepo==false) {
			pageAfterNewUserValidation = "regnewuserform";
		}

		//generate password for newly created user
		//put user into a UserRepository!
		
		return pageAfterNewUserValidation;
	}

	
	@ModelAttribute("allUserSexTypes")
	public List<UserSexState> populateUserSexType()
	{
		return Arrays.asList(UserSexState.values());
	}

	@ModelAttribute("allUserEmployeeStateTypes")
	public List<UserEmploymentState> populateUSerEmployeeStateTypes()
	{
		return Arrays.asList(UserEmploymentState.values());
	}
}