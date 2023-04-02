package br.com.hrsystem.payrollapi.services;

import br.com.hrsystem.payrollapi.domain.Payroll;
import br.com.hrsystem.payrollapi.resources.dto.PayrollDto;

public interface PayrollService {
    Double totalPayment(Double hourlyPrice, Double workedHours);

    Payroll getPayment(Long workerId, PayrollDto payrollDto);
}
