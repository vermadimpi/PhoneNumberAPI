package au.com.belong.phone.repository;

import org.springframework.stereotype.Repository;
import au.com.belong.phone.model.Phone;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PhoneRepository {
    static List<Phone> phoneList = new ArrayList<>();

    static {
        phoneList.add(new Phone("p1","0734334434",true, "c1"));
        phoneList.add(new Phone("p2","0734334430",false, "c2"));
        phoneList.add(new Phone("p3","0734334431",true, "c2"));
        phoneList.add(new Phone("p4","0734334432",false, "c4"));
    }

    public Optional<Phone> findPhoneByPhoneId(String phoneId) throws Exception {
        Optional<Phone> phoneFound = phoneList.stream().filter(phone -> phone.getPhoneId().equals(phoneId))
                .findFirst();
        return phoneFound;
    }

    public List<Phone> findAllPhoneNumbers() {
         return phoneList.stream().collect(Collectors.toList());
    }

    public void activatePhoneById(String phoneId) throws Exception {
    	List<Phone> newPhoneList = phoneList;
        newPhoneList = phoneList.stream()
                .map(phone -> {
                   if( phone.getPhoneId().equals(phoneId)){
                     phone.setActive(true);
                    }
                    return phone;
                })
                .collect(Collectors.toList());
        phoneList = newPhoneList;
    }

    public List<Phone> findPhoneByCustomerId(String customerId) throws Exception {
    	    List<Phone> phList = phoneList;
            phList =  phoneList.stream()
                .filter(phone-> phone.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
        return phList;
    }

}
