package next.controller;

import core.db.DataBase;
import core.mvc.ModelAndView;
import core.mvc.asis.Controller;
import core.mvc.view.ForwardView;
import core.mvc.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController implements Controller {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (!UserSessionUtils.isLogined(req.getSession())) {
            return new ModelAndView(new RedirectView("redirect:/users/loginForm"));
        }

        req.setAttribute("users", DataBase.findAll());
        return new ModelAndView(new ForwardView("/user/list.jsp"));
    }
}
