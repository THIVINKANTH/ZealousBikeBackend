package ZealousService.BikeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybikeproject")
@CrossOrigin(origins = "http://localhost:3000/")
public class Controller 
{
	@Autowired
	BikeDetailsService service;
	
	@Autowired
	ServiceDetailsService sservice;
	
	//http://localhost:8080/createbikedetails
	
	@PostMapping("/createbikedetails")
	public String newbikedetails(@RequestBody BikeDetails bike)
	{
		return service.create(bike).getCusName()+"has been added successfully";
	}
	
	@PutMapping("/updatebikedetails")
	public String updatebike(@RequestBody BikeDetails bike)
	{
		BikeDetails temp=service.create(bike);
		return temp+" "+"has been added successfully";
	}
	
	@GetMapping("/listbikedetails")
	public List<BikeDetails> listbikedetails()
	{
		return service.MakeFetchAll();
	}
	
	@GetMapping("/listonebikedetails/{id}")
	public Optional<BikeDetails> listonebike(@PathVariable("id")int id)
	{
		return service.makefetchone(id);
	}
	
	@GetMapping("/findbikenumber/{bikenumber}")
	public Optional<BikeDetails> searchbikenumber(@PathVariable("bikenumber")String bikenumber)
	{
		return service.gettingbikenumber(bikenumber);
	}
	
	@GetMapping("/findemailaddress/{email}")
	public Optional<BikeDetails> gettingemail(@PathVariable("email")String email)
	{
		return service.emailaddress(email);
	}
	
	@GetMapping("/contactnumber/{number}")
	public Optional<BikeDetails> mobilenumber(@PathVariable("number")long number)
	{
		return service.contactnumber(number);
	}
	
	@GetMapping("/")
	public String sample()
	{
		return "Welcome SpringBoot";
	}
	
	@DeleteMapping("/deletebybikedetails/{id}")
	public String deleteabikedetails(@PathVariable("id")int id)
	{
		return service.deletebyid(id);
	}
	
	//service Mapping
	
	@PostMapping("/createnewservice")
	public String newserivedetails(@RequestBody ServiceDetails serv)
	{
		BikeDetails temp=service.gettingexactone(serv.getBikeDetails1().getCusId());
		
		if(serv.getBikeTypeofservice()=="free")
		{
			int total=serv.getBikeNewproductcost()+(serv.getBikeNewproductcost()*18/100);
			serv.setBikeFinalamount(total);
		}
		else
		{
			int total=serv.getBikeNewproductcost()+serv.getBikeLabourcharge();
			total+=total*18/100;//3400+=(3400*18/100)
			serv.setBikeFinalamount(total);
		}
		temp.getMyservicedetails().add(serv);
		serv.setBikeDetails1(temp);
		sservice.newservice(serv);
		return serv.getBikeJobcardno()+"has been service details added";
		
	}
	
	@PutMapping("/updateservicedetails")
	public String updateservice(@RequestBody ServiceDetails serv)
	{
		if(serv.getBikeTypeofservice()=="free")
		{
			int total=serv.getBikeNewproductcost()+(serv.getBikeNewproductcost()*18/100);
			serv.setBikeFinalamount(total);
		}
		else
		{
			int total=serv.getBikeNewproductcost()+serv.getBikeLabourcharge();
			total+=total*18/100;
			serv.setBikeFinalamount(total);
		}
		serv.getBikeDetails1().getMyservicedetails().add(serv);
		ServiceDetails temp=sservice.newservice(serv);
		return temp.getBikeJobcardno()+"Has been updated successfully";
	}
	
	@GetMapping("/exactcusidwithservicedetails/{cusid}")
	public List<ServiceDetails> gettingparticularall(@PathVariable("cusid")int cusid)
	{
		BikeDetails temp=service.gettingexactone(cusid);
		return sservice.Exactcusidwithservicedetails(temp);
	}
	
	@GetMapping("/exactoneservice/{jobcardno}")
	public Optional<ServiceDetails> findoneservice(@PathVariable("jobcardno")int jobcardno)
	{
		return sservice.Exactoneservice(jobcardno);
	}
	
	@GetMapping("/gettingonefreeservice/{typeofservice}")
	public List<ServiceDetails>freeservice(@PathVariable("typeofservice")String typeofservice)

	{
		return sservice.Exacttypeofservice(typeofservice);
	}
	
	@GetMapping("/betweendates/{date1}/{date2}")
	public List<ServiceDetails> Implementdates(@PathVariable("date1")String date1,@PathVariable("date2")String date2)
	{
		return sservice.betweendates(date1, date2);
	}
}
