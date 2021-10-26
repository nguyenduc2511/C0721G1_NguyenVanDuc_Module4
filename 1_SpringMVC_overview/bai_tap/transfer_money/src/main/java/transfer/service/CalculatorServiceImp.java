package transfer.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImp implements CalculatorService {
    @Override
    public double getMoney(double usa, double rate) {
        return usa*rate;
    }
}
