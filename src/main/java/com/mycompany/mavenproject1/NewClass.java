package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.service.EmploymentHistoryService;
import com.mycompany.mavenproject1.service.PersonService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author new
 */
@Controller
@Scope("singleton")
public class NewClass implements Controller {

    @Autowired
    PersonSO personSO;
    @Autowired
    EmploymentHistoryService employmentHistoryService;
    @Autowired
    PersonValidator personValidator;

    public PersonValidator getPersonValidator() {
        return personValidator;
    }

    public void setPersonValidator(PersonValidator personValidator) {
        this.personValidator = personValidator;
    }

    public EmploymentHistoryService getEmploymentHistoryService() {
        return employmentHistoryService;
    }

    public void setEmploymentHistoryService(EmploymentHistoryService employmentHistoryService) {
        this.employmentHistoryService = employmentHistoryService;
    }

    @Autowired
    PersonService personService;

    public PersonSO getPersonSO() {
        return personSO;
    }

    public void setPersonSO(PersonSO personSO) {
        this.personSO = personSO;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public String value() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @RequestMapping(value = "/listPersons")
    public ModelAndView listpersons(ModelMap modelmap) {
        modelmap = new ModelMap();
        return new ModelAndView("listpersons", "listAllPersons", personService.listAllPersons());

    }

    @RequestMapping(value = "/selectPerson")
    public @ResponseBody
    String selectPerson(@RequestBody PersonSO personSO) {

        this.personSO = this.personService.selectPerson(Integer.parseInt(personSO.getId()));
        if (this.personSO != null) {
            return this.personSO.getId() + ":seperator:" + this.personSO.getName() + ":seperator:" + this.personSO.getCountry();
        } else {
            return "NoDataFound";
        }
    }

    @RequestMapping(value = "/hello")
    public ModelAndView helloworld() {
        return new ModelAndView("newjsp", "now", new java.util.Date());

    }

    @RequestMapping(value = "/changeName")
    public @ResponseBody
    String changeName(String product) {

        return product + "changeNamer";

    }

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse res) {
        Map<String, String[]> objparameters = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : objparameters.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
        }
        String username = objparameters.get("username")[0];
        String password = objparameters.get("password")[0];
        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            return new ModelAndView("priceincrease", "command", new Product());
        } else {
            return new ModelAndView("newjsp", "now", new java.util.Date());
        }
    }

    @RequestMapping(value = "/view")
    public ModelAndView view(@ModelAttribute("product") Product product,
            ModelMap modelmap) {
        modelmap.addAttribute("productname", product.getDescription());
        modelmap.addAttribute("price", product.getPrice());
        return new ModelAndView("pricelist", "personSO", new PersonSO());

    }

    @RequestMapping(value = "/addPerson")
    public @ResponseBody
    String addPerson(@RequestBody @Valid @Validated PersonSO personSO, BindingResult result) {

        if (result.hasErrors()) {
            return "error in Submitted Data,check if given name and country has size between two and thirty";
        }
        this.personService.addPerson(personSO);

        return "success";

    }

    @RequestMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable("id") int id) {

        this.personService.deletePerson(id);

        return "redirect:/listPersons";

    }

    @RequestMapping("/editPerson/{id}/{name}/{country}")
    public String editPerson(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("country") String country) {
        PersonSO personSO = new PersonSO(id + "", name, country);
        this.personService.editPerson(personSO);
        return "redirect:/listPersons";

    }

    @RequestMapping(value = "/saveEmpHist")
    public String saveEmpHist(@ModelAttribute("personSO") @Valid PersonSO personSO, BindingResult result, ModelMap model) throws CustomException {
        personValidator.validate(personSO, result);
        if (result.hasErrors()) {
            throw new CustomException("Invalid Values entered for creating Employee History");
        }
        employmentHistoryService.addEmploymentHistory(personSO);
        return "redirect:/listPersons";
    }

    @RequestMapping(value = "/addEmpHist")
    public ModelAndView addEmpHist(@ModelAttribute("personSO") @Valid @Validated PersonSO personSO, BindingResult result, ModelMap model) throws CustomException {
        personValidator.validate(personSO, result);
        if (result.hasErrors()) {
            throw new CustomException("Invalid Values entered for creating Employee History");
        }
        Integer emphistid = employmentHistoryService.getEmploymentHistory(personSO.getId());
        if (emphistid != null && emphistid > 0) {
            throw new CustomException("Employement History Already Present , Emp History ID = \t" + emphistid);
        }
        return new ModelAndView("newjsp1", "personSO", personSO);
    }

    @RequestMapping(value = "/addPersonAndImage")
    public ModelAndView addPersonAndImage() {
        return new ModelAndView("addPersonAndImage", "personSO", new PersonSO());
    }

    @RequestMapping(value = "/uploadPersonAndImage")
    public String uploadPersonAndImage(@RequestParam("personimage") MultipartFile personimage,
            @RequestParam("nameOfPerson") String nameOfPerson, @RequestParam("countryOfPerson") String countryOfPerson) {
        if (!personimage.isEmpty()) {
            try {
                byte[] filebytes = personimage.getBytes();
                String rootPath = System.getProperty("catalina.home");
                File dir = new File("WebApplication2/web" + "/WEB-INF/imgs/");
                if (!dir.exists()) {
                    dir.mkdir();
                }
                File serverFile = new File("C:\\Users\\new\\Documents\\NetBeansProjects\\" + dir.getPath() + File.separator + personimage.getOriginalFilename());
                BufferedOutputStream buffout = new BufferedOutputStream(new FileOutputStream(serverFile));
                buffout.write(filebytes);
                buffout.flush();
                buffout.close();
                PersonSO personSO = new PersonSO(null, nameOfPerson, countryOfPerson, null, personimage.getOriginalFilename());
                Integer id = this.personService.addPersonAndImage(personSO);
                personSO = new PersonSO(id + "", nameOfPerson, countryOfPerson, null, personimage.getOriginalFilename());
            } catch (IOException ex) {
                Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "redirect:/listPersons";
    }

    @RequestMapping(value = "/addEmployementHistoryDetails/{id}/{empHistId}")
    public ModelAndView addEmployementHistoryDetails(@PathVariable("id") int id, @PathVariable("empHistId") String empHistId, ModelMap model) {
        /*
        To be Implemented
         */
        return new ModelAndView("newjsp1");
    }

    @ExceptionHandler(CustomException.class)
    public ModelAndView exceptionHandler(HttpServletRequest req, Exception exception) {
        return new ModelAndView("error", "exception", exception);
    }
}
