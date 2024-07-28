package ru.grebennik.shares_analytics.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import ru.grebennik.shares_analytics.aspect.LoggingAspect;
import ru.grebennik.shares_analytics.dao.ShareDAO;
import ru.grebennik.shares_analytics.entity.Share;
import ru.grebennik.shares_analytics.entity.ShareGrowthHistory;
import ru.grebennik.shares_analytics.service.ShareService;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private ShareService shareService;

    @RequestMapping("/")
    public String showAllShares(Model model) {

        // Получаем список всех акций
        List<Share> shares = shareService.getAllShares();

        //todo Запрос не отрабатывает!
//        System.out.println(shareService.getGrowthHistoryByTicker("KAZT"));
//        System.out.println();

        // Добавляем аттрибут в модель
        model.addAttribute("allShares", shares);

        return "all-shares";
    }

    @RequestMapping("/addNewShare")
    public String addShare(Model model) {

        Share share = new Share();
        model.addAttribute("share", share); // добавляем пустой объект в качестве атрибута модели

        return "share-info";
    }

    @RequestMapping("/saveShare")
    public String saveShare(@ModelAttribute ("share") Share share) {

        shareService.saveShare(share);

        return "redirect:/";
    }

    @RequestMapping("/deleteShare")
    public String deleteShare(@RequestParam("shareTicker") String ticker) {

        shareService.deleteShare(ticker);

        return "redirect:/";
    }

    @RequestMapping("/updateShare")
    public String updateShare(@RequestParam("shareTicker") String ticker, Model model) {

        Share share = shareService.getShareByTicker(ticker);
        model.addAttribute("share", share);

        return "share-info";
    }

    @RequestMapping("/exploreShare")
    public String exploreShare(@RequestParam("shareTicker") String ticker, Model model) {

        ShareGrowthHistory growthHistory =  shareService.getGrowthHistoryByTicker(ticker);
        model.addAttribute("growthHistory", growthHistory);

        return "share-info-detailed";
    }

    @RequestMapping("/backToHomePage")
    public String backToHomePage() {
        return "redirect:/";
    }
}
