package ZealousService.BikeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeDetailsService 
{
	@Autowired
	BikeDetailsRepositary repo;
	
	public BikeDetails create(BikeDetails bike)
	{
		return repo.save(bike);
	}
	
	public List<BikeDetails> MakeFetchAll()
	{
		return repo.findAll();
	}
	
	public Optional<BikeDetails> makefetchone(int id)
	{
		return repo.findById(id);
	}
	
	public String deletebyid(int id)
	{
		BikeDetails temp=repo.findById(id).orElse(new BikeDetails());
		repo.delete(temp);
		return temp.getCusName()+"Has been deleted successfully";
	}
	
	public BikeDetails gettingexactone(int cusid)
	{
		return repo.findById(cusid).orElse(new BikeDetails());
	}
	
	public Optional<BikeDetails> gettingbikenumber(String bikenumber)
	{
		return repo.findAllBycusBikeno(bikenumber);
	}
	
	public Optional<BikeDetails> emailaddress(String email)
	{
		return repo.findAllBycusEmail(email);
	}
	
	public Optional<BikeDetails> contactnumber(long contact)
	{
		return repo.findAllBycusContactno(contact);
	}
}
