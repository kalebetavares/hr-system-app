package br.com.hrsystem.payrollapi.resources.impl;

import br.com.hrsystem.payrollapi.domain.Payroll;
import br.com.hrsystem.payrollapi.resources.PayrollResource;
import br.com.hrsystem.payrollapi.resources.dto.PayrollDto;
import br.com.hrsystem.payrollapi.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payments")
public class PayrollResourceImpl implements PayrollResource {

    private final PayrollService payrollService;

    @Override
    public ResponseEntity<Payroll> getPayment(Long workerId, PayrollDto payrollDto) {
        return ResponseEntity.ok().body(payrollService.getPayment(workerId, payrollDto));
    }
}
