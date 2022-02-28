package API.controller;

import API.entity.Loan;
import API.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/loans")
public class Controller {
    @Autowired
    LoanRepository loanRepository;
//create
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Loan loan){
        loanRepository.save(loan);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }
//findall
@RequestMapping(method = RequestMethod.GET)
public  ResponseEntity<Object> getList(){
    ArrayList<Loan> response = new ArrayList<>();
    response.addAll(loanRepository.findAll());
    return new ResponseEntity<>(response, HttpStatus.OK);

}
}
