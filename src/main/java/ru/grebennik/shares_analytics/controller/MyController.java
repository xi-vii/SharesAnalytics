package ru.grebennik.shares_analytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.grebennik.shares_analytics.dao.ShareDAOImpl;
import ru.grebennik.shares_analytics.entity.Share;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private ShareDAOImpl shareDAO;

    @RequestMapping("/")
    public String showAllShares(Model model) {

        // Получаем список всех акций
        List<Share> shares = shareDAO.getAllShares();

        // Добавляем аттрибут в модель
        model.addAttribute("allShares", shares);

        return "all-shares";
    }
}
