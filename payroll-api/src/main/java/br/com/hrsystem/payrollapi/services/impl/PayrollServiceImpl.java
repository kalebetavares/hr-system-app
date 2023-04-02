package br.com.hrsystem.payrollapi.services.impl;

import br.com.hrsystem.payrollapi.domain.Payroll;
import br.com.hrsystem.payrollapi.domain.User;
import br.com.hrsystem.payrollapi.feignClients.UserFeign;
import br.com.hrsystem.payrollapi.resources.dto.PayrollDto;
import br.com.hrsystem.payrollapi.services.PayrollService;
import br.com.hrsystem.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollServiceImpl implements PayrollService {

    private final Environment environment;
    private final UserFeign userFeign;

    @Override
    public Payroll getPayment(Long workerId, PayrollDto payrollDto) {
        log.info("PAYROLL_SERVICE ::: Get request on " + environment.getProperty("local.server.port") + " port");

        try{
            User user = userFeign.findById(workerId).getBody();

            if (Objects.nonNull(user)) {
                return new Payroll(user.getName(),
                        payrollDto.getDescription(),
                        user.getHourlyPrice(),
                        payrollDto.getWorkedHours(),
                        totalPayment(user.getHourlyPrice(), payrollDto.getWorkedHours()));
            }
        }catch (FeignException exception){
            throw new ObjectNotFoundException("Object not found");
        }catch (Exception exception){
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }

    @Override
    public Double totalPayment(Double hourlyPrice, Double workedHours) {
        return hourlyPrice * workedHours;
    }
}
