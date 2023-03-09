package ZealousService.BikeService;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeDetailsRepositary extends JpaRepository<BikeDetails, Integer>
{
	public Optional<BikeDetails> findAllBycusBikeno(String bikenumber);
	
	public Optional<BikeDetails> findAllBycusEmail(String email);
	
	public Optional<BikeDetails> findAllBycusContactno(long contact);
}
