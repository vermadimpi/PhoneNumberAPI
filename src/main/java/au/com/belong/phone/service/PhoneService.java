package au.com.belong.phone.service;

import org.springframework.stereotype.Service;
import au.com.belong.phone.model.Phone;
import au.com.belong.phone.dto.PhoneDto;
import au.com.belong.phone.exception.PhoneNotFoundException;
import au.com.belong.phone.repository.PhoneRepository;
import au.com.belong.phone.util.CommonMapper;
import au.com.belong.phone.util.Messages;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    private CommonMapper mapper;

    public PhoneService(PhoneRepository phoneRepository, CommonMapper mapper)  {
        this.phoneRepository = phoneRepository;
        this.mapper =mapper;
    }
    
    public PhoneDto findPhoneByPhoneId(String phoneId) throws Exception {
        Optional<Phone> phoneFound = phoneRepository.findPhoneByPhoneId(phoneId);
        Optional<PhoneDto> phoneDto =  phoneFound.map(mapper::convert);
        return phoneDto.get();
    }

    public List<PhoneDto> findAllPhoneNumbers() {
        List<Phone> phoneList = phoneRepository.findAllPhoneNumbers();
        List<PhoneDto> phoneDtosList =  phoneList.stream()
                .filter(Objects::nonNull)
                .map(mapper::convert)
                .collect(Collectors.toList());
        return phoneDtosList;
    }

    public void activatePhoneById(String phoneId) throws Exception {
        Optional<Phone> phone = phoneRepository.findPhoneByPhoneId(phoneId);
        if(phone.isPresent()){
            phoneRepository.activatePhoneById(phoneId);
        }else {
            throw new PhoneNotFoundException(Messages.PHONE_NOT_FOUND);
        }
    }

    public List<PhoneDto> findPhoneByCustomerId(String customerId) throws Exception {
         List<Phone> phoneList = phoneRepository.findPhoneByCustomerId(customerId);
        if(phoneList.isEmpty()){
            throw new PhoneNotFoundException(Messages.CUSTOMER_NOT_FOUND);
        }
        List<PhoneDto> phoneDtosList =  phoneList.stream()
                .filter(Objects::nonNull)
                .map(mapper::convert)
                .collect(Collectors.toList());
        return phoneDtosList;
    }


}
