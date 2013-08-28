package utils;

import logic.UserBean;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {

		UserBean user = (UserBean) command;
		if (!StringUtils.hasLength(user.getUser_id())) {
			errors.rejectValue("user_id", "error.required");
		}

		if (!StringUtils.hasLength(user.getUser_pass())) {
			errors.rejectValue("user_pass", "error.required");
		}

		if (errors.hasErrors()) {
			errors.reject("error.input.user");
		}
	}
}
