package study.springbootrestfulapi.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminUserController {
    private final UserDaoService service;

    public AdminUserController(UserDaoService service) {
        this.service = service;
    }

//    @GetMapping("/v1/users")
//    @GetMapping(value = "/users", params = "version=1")
//    @GetMapping(path = "/users", headers = "X-API-VERSION=1")
    @GetMapping(path = "/users", produces = "application/vnd.company.appv1+json")
    public MappingJacksonValue retrieveAllUsersV1() {
        List<User> users = service.findAll();

        List<UserV2> userV2s = users.stream().map(u -> {
            UserV2 target = new UserV2();
            BeanUtils.copyProperties(u, target);
            return target;
        }).collect(Collectors.toList());

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");
        FilterProvider provider = new SimpleFilterProvider().addFilter("UserInfoV2", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userV2s);
        mappingJacksonValue.setFilters(provider);

        return mappingJacksonValue;
    }


    //    @GetMapping("/v2/users")
//    @GetMapping(value = "/users", params = "version=2")
//    @GetMapping(path = "/users", headers = "X-API-VERSION=2")
    @GetMapping(path = "/users", produces = "application/vnd.company.appv2+json")
    public MappingJacksonValue retrieveAllUsersV2() {
        List<User> users = service.findAll();

        List<UserV2> userV2s = users.stream().map(u -> {
            UserV2 target = new UserV2();
            BeanUtils.copyProperties(u, target);
            target.setGrade(UserGrade.BASIC);
            return target;
        }).collect(Collectors.toList());

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn", "grade");
        FilterProvider provider = new SimpleFilterProvider().addFilter("UserInfoV2", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userV2s);
        mappingJacksonValue.setFilters(provider);

        return mappingJacksonValue;
    }
}
