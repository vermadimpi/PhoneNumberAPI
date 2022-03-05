package au.com.belong.phone.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import au.com.belong.phone.model.Phone;
import au.com.belong.phone.dto.PhoneDto;
import au.com.belong.phone.exception.PhoneNotFoundException;
import au.com.belong.phone.repository.PhoneRepository;
import au.com.belong.phone.util.CommonMapper;
import au.com.belong.phone.util.Messages;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneServiceTest {
    private PhoneService phoneService;
    private PhoneRepository phoneRepository;
    CommonMapper mapper;


    @Before
    public void setUp() throws  Exception{
        mapper = new CommonMapper();
        phoneRepository = new PhoneRepository();
        phoneService = new PhoneService(phoneRepository,mapper);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllPhoneNumbersForNoNullResults() {
        List<PhoneDto> phone = phoneService.findAllPhoneNumbers();
        assertNotEquals(phone, null);
    }
    
    @Test
    public void findAllPhoneNumbers() {
        List<PhoneDto> phone = phoneService.findAllPhoneNumbers();
        assertEquals(phone.size(), 4);
    }

    @Test
    public void findPhoneByPhoneId() throws Exception {
    	PhoneDto phoneDto = phoneService.findPhoneByPhoneId("p2");
        assertEquals(phoneDto.getPhonenumber(), "0734334430");
    }
    
    @Test
    public void activatePhoneById() throws Exception {
        phoneService.activatePhoneById("p2");
        PhoneDto phoneDto = phoneService.findPhoneByPhoneId("p2");
        assertNotEquals(phoneDto.getActive(), "true");
    }
    
    @Test
    public void activatePhoneById_WhenPhoneNotFound() throws Exception {
        assertThatExceptionOfType(PhoneNotFoundException.class)
        .isThrownBy(() -> phoneService.activatePhoneById("p244"));
    }

    @Test
    public void findPhoneByCustomerId() throws Exception {
        List<PhoneDto> phoneList = phoneService.findPhoneByCustomerId("c2");
        assertEquals(phoneList.get(0).getPhonenumber(), "0734334430");
    }
    
    @Test
    public void findPhoneByCustomerId_WhenPhoneNotFound() throws Exception {
    	 assertThatExceptionOfType(PhoneNotFoundException.class)
         .isThrownBy(() -> phoneService.findPhoneByCustomerId("c2ff"));
    }
}