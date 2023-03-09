package ZealousService.BikeService;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class BikeServiceApplicationTests 
{
	
	@MockBean
	BikeDetailsRepositary repo;
	
	@Autowired
	BikeDetailsService service;
	
	@Test
	public void testcase1()
	{
		Date date=new Date(2023,10,10);
		
		BikeDetails bike1=new BikeDetails(1, "TN93A4782", "Thivinkanth", 9514594679L, "thivinkanth@gmail.com", date, null);
		when(repo.findAll()).thenReturn(Stream.of(bike1).collect(Collectors.toList()));
		assertNotNull(service.MakeFetchAll());
	}
	
	@Test
	public void testread()
	{
		Date date=new Date(2022,10,10);
		Optional<BikeDetails> bike1=Optional.of(new BikeDetails(1,"TN93A4782", "Thivinkanth", 9514594679L, "thivinkanth@gmail.com", date, null));
		Optional<BikeDetails> bike2=Optional.of(new BikeDetails(2,"TN93A4782", "Thivinkanth", 9514594679L, "thivinkanth@gmail.com", date, null));
		
		when(repo.findById(1)).thenReturn(bike1);
		when(repo.findById(2)).thenReturn(bike2);
		
		assertSame(bike1,service.makefetchone(1));
		assertEquals(bike2, service.makefetchone(2));
	}
	
//	@Test
//	void contextLoads() {
//	}

}
