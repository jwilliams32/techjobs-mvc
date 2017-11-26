package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "search")
    //Displays the search
    public String displaySearch(Model model) {

        return "search";

    }

    @RequestMapping(value = "results", method = RequestMethod.POST)
    public String processSearch(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {


        ArrayList<HashMap<String, String>> jobs;


        if (searchType.equals("all")) {
            jobs = JobData.findByValue(searchTerm);

        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);


        }
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("jobs", jobs);
        return "search";
    }
}
       // model.addAttribute("searchType", ListController.columnChoices);
         //   ArrayList<String> value = new ArrayList<>();

        //if(searchType.equals("all")){
        //    ArrayList<String> jobs = JobData.findAll("searchType");
        //}



        //return "search" ;
    //}
    //public String displaySearch(Model model, String column, String value ) {


        //String searchTerm = request.getParameter("search");
//        if(column.equals("all")){
//            ArrayList<HashMap<String, String>> jobs = JobData.findValue(searchTerm);
//            model.addAttribute("searchType", "All");
//            model.addAttribute("jobs", jobs);
//            return "list-column";

//        }else{
//            ArrayList<String> searchTerm = JobData.findColumn();
//            model.addAttribute("searchType", "All" + ListController.columnChoices.get(column) + value);
//            model.addAttribute("column", column);
//           model.addAttribute("searchTerm", searchTerm );

//            return "results";
  //      }
        //HashMap<String, String> columns = new HashMap<>();

        //Map.Entry<String,String> entry
        //model.addAttribute("columns", ListController.columnChoices);
        //model.addAttribute("searchTerm", sTerm);
        //return searchTerm("search", "Java");
        //return "search";

    //}

    //@RequestMapping(value = "results", method = RequestMethod.GET)

    //public String displayJobs(Model model,
        //                      @RequestParam String searchTerm, @RequestParam String searchType) {
      //      ArrayList<HashMap<String, String>> jobs = JobData.findAll();
       //     model.addAttribute("searchType", "All" + ListController.columnChoices.get(searchTerm) + searchType);
        //    model.addAttribute("jobs", jobs);
          //  return "search";
    //}






      //  return "redirect:";
