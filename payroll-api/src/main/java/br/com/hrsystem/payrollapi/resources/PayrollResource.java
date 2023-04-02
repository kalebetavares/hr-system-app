package br.com.hrsystem.payrollapi.resources;

import br.com.hrsystem.payrollapi.domain.Payroll;
import br.com.hrsystem.payrollapi.resources.dto.PayrollDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface PayrollResource {

    @GetMapping(value = "/{workerId}")
    ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody PayrollDto payrollDto);
}
