

package com.mycompany.controller;

import com.mycompany.dao.AdminDao;
import com.mycompany.dao.FlightDao;
import com.mycompany.dao.UserDao;
import com.mycompany.exception.FlightException;
import com.mycompany.pojo.Admin;
import com.mycompany.pojo.Flight;
import com.mycompany.pojo.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("adminLogin")
public class AdminController {

    @GetMapping("adminLogin.htm")
    public String showAdminLoginForm(ModelMap model, Admin admin) {

        model.addAttribute("admin", admin);
        return "adminLogin";
    }

    @PostMapping("adminLogin.htm")
    public ModelAndView handleAdminLogin(@ModelAttribute("admin") Admin admin, BindingResult result, SessionStatus status, AdminDao adminDao, HttpSession session) throws FlightException {

        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("index");
            return model;
        } else {
            Admin retrievedAdmin = adminDao.get(admin);
            System.out.println(retrievedAdmin);
            if (retrievedAdmin != null) {
                session.setAttribute("admin", retrievedAdmin);
                status.setComplete();
                ModelAndView model = new ModelAndView("adminWelcome");
                model.setViewName("redirect:adminWelcome.htm");
                return model;
            } else {
                ModelAndView model = new ModelAndView("error");
                return model;
            }
        }
    }

    @RequestMapping(value = "/redirect1", method = RequestMethod.GET)
    public String redirect() {

        return "redirect:adminWelcome";
    }

    @RequestMapping(value = "/adminWelcome", method = RequestMethod.GET)
    public String adminWelcome() {

        return "adminWelcome";
    }

    @GetMapping("createFlight.htm")
    public String showAdminFlightForm(ModelMap model, Flight flight) {

        model.addAttribute("flight", flight);
        return "addFlightData";
    }

    @PostMapping("createFlight.htm")
    public String handleCreateFlightForm(ModelMap model, @ModelAttribute("flight") Flight flight, BindingResult result, SessionStatus status, FlightDao flightDao) throws FlightException {

        if (result.hasErrors()) {
            return "addFlightData";
        } else {
            Flight alreadyFlight = flightDao.get(flight);
  
            if (alreadyFlight == null) {
                flightDao.create(flight);
                status.setComplete();
                return "flightDataAdded";
            } else {
                model.addAttribute("flight", alreadyFlight);
                return "flightError";
            }
        }
    }

    @GetMapping("editFlight.htm")
    public String editAdminFlightForm(ModelMap model, Flight flight) {

        model.addAttribute("flight", flight);
        return "editFlightData";
    }

    @PostMapping("editFlight.htm")
    public String handleEditAdminFlightForm(ModelMap model, @ModelAttribute("flight") Flight flight, BindingResult result, SessionStatus status, FlightDao flightDao) throws FlightException {
        if (result.hasErrors()) {
            return "editFlightData";
        } else {

            Flight alreadyFlight = flightDao.get(flight);
            flight.setId(alreadyFlight.getId());
            if (alreadyFlight != null) {
                flightDao.delete(alreadyFlight);
                flightDao.create(flight);
                status.setComplete();
                return "updateFlightSuccess";
            } else {
                model.addAttribute("flight", alreadyFlight);
                return "flightError";
            }
        }

    }

    @GetMapping("deleteFlight.htm")
    public String deleteAdminFlightForm(ModelMap model, Flight flight) {

        model.addAttribute("flight", flight);
        return "deleteFlightData";
    }

    @PostMapping("deleteFlight.htm")
    public String handleDeleteAdminFlight(ModelMap model, @ModelAttribute("flight") Flight flight, BindingResult result, SessionStatus status, FlightDao flightDao) throws FlightException {
        if (result.hasErrors()) {
            return "addFlightData";
        } else {
            Flight alreadyFlight = flightDao.get(flight);
            if (alreadyFlight != null) {
                flightDao.delete(alreadyFlight);
                status.setComplete();
                return "deleteFlightSuccess";
            } else {
                model.addAttribute("flight", alreadyFlight);
                return "flightError";
            }
        }
    }

    @GetMapping("updateUser.htm")
    public String updateAdminUsersForm(ModelMap model, User user) {

        model.addAttribute("user", user);
        return "editUserData";
    }

    @PostMapping("updateUser.htm")
    public String handleEditAdminUserForm(ModelMap model, @ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDao userDao) throws FlightException {
        if (result.hasErrors()) {
            return "editUserData";
        } else {
            User alreadyUser = userDao.getforDelete(user);
            if (alreadyUser != null) {
                userDao.delete(alreadyUser);
                userDao.create(user);
                status.setComplete();
                return "updateUserSuccess";
            } else {
                model.addAttribute("user", alreadyUser);
                return "userError";
            }
        }

    }

    @GetMapping("deleteUser.htm")
    public String deleteAdminUsersForm(ModelMap model, User user) {

        model.addAttribute("user", user);
        return "deleteUser";
    }

    @PostMapping("deleteUser.htm")
    public String handleDeleteAdminUsersForm(ModelMap model, @ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDao userDao) throws FlightException {
        if (result.hasErrors()) {
            return "deleteUser";
        } else {
            User alreadyUser = userDao.getforDelete(user);
            if (alreadyUser != null) {
                userDao.delete(alreadyUser);
                status.setComplete();
                return "deleteUserSuccess";
            } else {
                model.addAttribute("flight", alreadyUser);
                return "flightError";
            }
        }
    }

    @GetMapping("viewFlight.htm")
    public String showFlightInformation(HttpServletRequest request, FlightDao flightDao) throws FlightException {
        List<Flight> flightList = flightDao.getAll();
        request.setAttribute("flightList", flightList);
        return "viewFlightData";
    }

    @GetMapping("viewAllUsers.htm")
    public String showUserInformation(HttpServletRequest request, UserDao userDao) throws FlightException {
        List<User> userList = userDao.getAll();
        request.setAttribute("userList", userList);
        return "viewUserData";
    }
}
