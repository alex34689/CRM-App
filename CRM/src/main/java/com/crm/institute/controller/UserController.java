package com.crm.institute.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.crm.institute.Exception.CustomeFieldValidationException;
import com.crm.institute.Exception.UsernameOrIdNotFound;
import com.crm.institute.dto.ChangePassword;
import com.crm.institute.enttity.AlumnoCiclo;
import com.crm.institute.enttity.Alumnos;
import com.crm.institute.enttity.Pagos;
import com.crm.institute.enttity.Role;
import com.crm.institute.enttity.Ciclos;
import com.crm.institute.enttity.UserF;
import com.crm.institute.repository.RoleRepository;
import com.crm.institute.service.AlumnosService;
import com.crm.institute.service.PagosService;
import com.crm.institute.service.CiclosService;
import com.crm.institute.service.UserService;

@Controller
public class UserController {

	private final String TAB_FORM = "formTab";
	private final String TAB_LIST = "listTab";

	@Autowired
	UserService userService;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	AlumnosService alumnosService;

	@Autowired
	PagosService pagosService;

	@Autowired
	CiclosService ciclosService;

	@GetMapping({ "/", "/login" })
	public String index() {
		return "index";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		Role userRole = roleRepository.findByName("USER");
		List<Role> roles = Arrays.asList(userRole);
		model.addAttribute("userForm", new UserF());
		model.addAttribute("roles", roles);
		model.addAttribute("signup", true);
		return "user-form/user-signup";
	}

	@PostMapping("signup")
	public String postSignup(@Valid @ModelAttribute("userForm") UserF user, BindingResult result, ModelMap model) {
		Role userRole = roleRepository.findByName("USER");
		List<Role> roles = Arrays.asList(userRole);
		model.addAttribute("userForm", user);
		model.addAttribute("roles", roles);
		model.addAttribute("signup", true);

		if (result.hasErrors()) {
			return "user-form/user-signup";
		} else {
			try {
				userService.createUser(user);
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				return "user-form/user-signup";

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				return "user-form/user-signup";
			}
		}
		return "index";
	}

	public void baseAttributerForUserForm(Model model, UserF user, String activeTab) {
		model.addAttribute("userForm", user);
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute(activeTab, "active");
	}

	@GetMapping("/userForm")
	public String getUserForm(Model model) {
		baseAttributerForUserForm(model, new UserF(), TAB_LIST);
		return "user-form/user-view";
	}

	@PostMapping("/userForm")
	public String createUser(@Valid @ModelAttribute("userForm") UserF user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			baseAttributerForUserForm(model, user, TAB_FORM);
		} else {
			try {
				userService.createUser(user);
				baseAttributerForUserForm(model, user, TAB_LIST);

			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForUserForm(model, user, TAB_FORM);

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				baseAttributerForUserForm(model, user, TAB_FORM);

			}
		}
		return "user-form/user-view";
	}

	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name = "id") Long id) throws Exception {
		UserF userToEdit = userService.getUserById(id);

		baseAttributerForUserForm(model, userToEdit, TAB_FORM);
		model.addAttribute("editMode", "true");
		model.addAttribute("passwordForm", new ChangePassword(id));

		return "user-form/user-view";
	}

	@PostMapping("editUser")
	public String postEditUserForm(@Valid @ModelAttribute("userForm") UserF user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			baseAttributerForUserForm(model, user, TAB_FORM);
			model.addAttribute("editMode", "true");
			model.addAttribute("passwordForm", new ChangePassword(user.getId()));
		} else {
			try {
				userService.updateUser(user);
				baseAttributerForUserForm(model, user, TAB_LIST);

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				baseAttributerForUserForm(model, user, TAB_FORM);
				model.addAttribute("editMode", "true");
				model.addAttribute("passwordForm", new ChangePassword(user.getId()));
				return "user-form/user-view";
			}
		}
		return "user-form/user-view";
	}

	@GetMapping("/userForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/userForm";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name = "id") Long id) {
		try {
			userService.deleteUser(id);
		} catch (UsernameOrIdNotFound uoid) {
			model.addAttribute("listErrorMessage", uoid.getMessage());
		}
		return getUserForm(model);
	}

	@PostMapping("/editUser/changePassword")
	public ResponseEntity<String> postEditUserChangePassword(@Valid @RequestBody ChangePassword form, Errors errors) {
		try {
			if (errors.hasErrors()) {
				String result = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
						.collect(Collectors.joining(""));

				throw new Exception(result);
			}
			userService.changePassword(form);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Success");
	}

	public void baseAttributerForAlumnoForm(Model model, Alumnos alumno, AlumnoCiclo alumnoCiclo, String activeTab) {
		model.addAttribute("alumnoForm", alumno);
		model.addAttribute("alumnoCicloForm", alumnoCiclo);
		model.addAttribute("alumnoList", alumnosService.getAllAlumnos());
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute(activeTab, "active");
	}

	@GetMapping("/alumnoForm")
	public String alumnoForm(Model model) {
		baseAttributerForAlumnoForm(model, new Alumnos(), new AlumnoCiclo(), TAB_LIST);
		return "alumno-form/alumno-view";
	}

	@PostMapping("/alumnoForm")
	public String createAlumno(@Valid @ModelAttribute("alumnoForm") Alumnos alumnos,
			@ModelAttribute("alumnoCicloForm") AlumnoCiclo alumnoCiclo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			baseAttributerForAlumnoForm(model, alumnos, alumnoCiclo, TAB_FORM);
		} else {
			try {
				alumnosService.createAlumno(alumnos, alumnoCiclo);
				baseAttributerForAlumnoForm(model, alumnos, alumnoCiclo, TAB_LIST);

			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForAlumnoForm(model, alumnos, alumnoCiclo, TAB_FORM);

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				baseAttributerForAlumnoForm(model, alumnos, alumnoCiclo, TAB_FORM);

			}
		}
		return "alumno-form/alumno-view";
	}

	@GetMapping("/editAlumno/{idAlumno}")
	public String getEditAlumnoForm(Model model, @PathVariable(name = "idAlumno") Long idAlumno) throws Exception {
		Alumnos alumnoToEdit = alumnosService.getAlumnosByIdAlumno(idAlumno);
		AlumnoCiclo alumnoCicloToEdit = alumnosService.getAlumnoCicloByNoCuentaAndGrado(alumnoToEdit.getNoCuenta(),
				alumnoToEdit.getGrado());

		baseAttributerForAlumnoForm(model, alumnoToEdit, alumnoCicloToEdit, TAB_FORM);
		model.addAttribute("editMode", "true");

		return "alumno-form/alumno-view";
	}

	@PostMapping("editAlumno")
	public String postEditAlumnoForm(@Valid @ModelAttribute("alumnoForm") Alumnos alumnos,
			@ModelAttribute("alumnoCicloForm") AlumnoCiclo alumnoCiclo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			baseAttributerForAlumnoForm(model, alumnos, alumnoCiclo, TAB_FORM);
			model.addAttribute("editMode", "true");
		} else {
			try {
				alumnosService.updateAlumnos(alumnos, alumnoCiclo);
				baseAttributerForAlumnoForm(model, alumnos, alumnoCiclo, TAB_LIST);

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				baseAttributerForAlumnoForm(model, alumnos, alumnoCiclo, TAB_FORM);
				model.addAttribute("editMode", "true");
				return "alumno-form/alumno-view";
			}
		}
		return "alumno-form/alumno-view";
	}

	@GetMapping("/alumnoForm/cancel")
	public String cancelEditAlumno(ModelMap model) {
		return "redirect:/alumnoForm";
	}

	public void baseAttributerForPagosForm(Model model, Pagos pagos, String activeTab) {
		model.addAttribute("pagosForm", pagos);
		model.addAttribute("pagosList", pagosService.getAllPagos());
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute(activeTab, "active");
	}

	@GetMapping("/pagosForm")
	public String pagoForm(Model model) {
		baseAttributerForPagosForm(model, new Pagos(), TAB_LIST);
		return "pagos-form/pagos-view";
	}

	@PostMapping("/pagosForm")
	public String createPagos(@Valid @ModelAttribute("pagosForm") Pagos pagos, BindingResult result, Model model) {
		if (result.hasErrors()) {
			baseAttributerForPagosForm(model, pagos, TAB_FORM);
		} else {
			try {
				pagosService.createPago(pagos);
				baseAttributerForPagosForm(model, pagos, TAB_LIST);

			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForPagosForm(model, pagos, TAB_FORM);

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				baseAttributerForPagosForm(model, pagos, TAB_FORM);

			}
		}
		return "pagos-form/pagos-view";
	}

	@GetMapping("/pagosForm/cancel")
	public String cancelPago(ModelMap model) {
		return "redirect:/pagosForm";
	}

	public void baseAttributerForCiclosForm(Model model, Ciclos semanas, String activeTab) {
		model.addAttribute("ciclosForm", semanas);
		model.addAttribute("ciclosList", ciclosService.getAllCiclos());
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute(activeTab, "active");
	}

	@GetMapping("/ciclosForm")
	public String getCiclosForm(Model model) {
		baseAttributerForCiclosForm(model, new Ciclos(), TAB_LIST);
		return "ciclos-form/ciclos-view";
	}

	@PostMapping("/ciclosForm")
	public String createCiclos(@Valid @ModelAttribute("ciclosForm") Ciclos ciclos, BindingResult result, Model model) {
		if (result.hasErrors()) {
			baseAttributerForCiclosForm(model, ciclos, TAB_FORM);
		} else {
			try {
				ciclosService.createCiclos(ciclos);
				baseAttributerForCiclosForm(model, ciclos, TAB_LIST);

			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForCiclosForm(model, ciclos, TAB_FORM);

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				baseAttributerForCiclosForm(model, ciclos, TAB_FORM);

			}
		}
		return "ciclos-form/ciclos-view";
	}

	@GetMapping("/editCiclos/{idCiclo}")
	public String getEditCicloForm(Model model, @PathVariable(name = "idCiclo") Long idCiclo) throws Exception {
		Ciclos cicloToEdit = ciclosService.getCiclosByIdCiclo(idCiclo);

		baseAttributerForCiclosForm(model, cicloToEdit, TAB_FORM);
		model.addAttribute("editMode", "true");

		return "ciclos-form/ciclos-view";
	}

	@PostMapping("editCiclos")
	public String postEditCiclosForm(@Valid @ModelAttribute("ciclosForm") Ciclos ciclos, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			baseAttributerForCiclosForm(model, ciclos, TAB_FORM);
			model.addAttribute("editMode", "true");
		} else {
			try {
				ciclosService.updateCiclos(ciclos);
				baseAttributerForCiclosForm(model, ciclos, TAB_LIST);

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				baseAttributerForCiclosForm(model, ciclos, TAB_FORM);
				model.addAttribute("editMode", "true");
				return "ciclos-form/ciclos-view";
			}
		}
		return "ciclos-form/ciclos-view";
	}

	@GetMapping("/ciclosForm/cancel")
	public String cancelEditCiclos(ModelMap model) {
		return "redirect:/ciclosForm";
	}
}