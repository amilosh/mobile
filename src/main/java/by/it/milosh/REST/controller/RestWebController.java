package by.it.milosh.REST.controller;

import by.it.milosh.REST.model.Response;
import by.it.milosh.REST.model.UserRest;
import by.it.milosh.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class RestWebController {

    List<UserRest> userRests = new ArrayList<UserRest>();

    @GetMapping(value = "/all")
    public Response getResource() {
        Response response = new Response("Done", userRests);
        return response;
    }



    @PostMapping(value = "/save")
    public Response postCustomer(@RequestBody UserRest userRest) {
        userRests.add(userRest);

        // Create Response Object
        Response response = new Response("Done", userRest);
        return response;
    }


    /*
    @ResponseBody
    @RequestMapping(value = "/save")
    public Response postCustomer(@RequestBody User user) {
        //userRests.add(userRest);

        String username = user.getUsername();

        // Create Response Object
        Response response = new Response("Done", user);
        return response;
    }
    */

}
