package com.Techolution;

/**
 * Created by shrikant on 28/12/2016.
 */

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/satisfied")

/* Mapping all the methods in this Controller under a "/satisfied" path prefix
* $ curl http://localhost:8080/satisfied/
   {90000} where 90000 is the total satisfaction.
* curl should display the desired output
*/

public class AlaCarteController {


    private final AlaCarte fullMeals;

    @Autowired
    public AlaCarteController(AlaCarte fullMeals) {
        this.fullMeals = fullMeals;
    }

    @RequestMapping("/")
    public int getResult() {
        return fullMeals.knapSack();
    }


}
