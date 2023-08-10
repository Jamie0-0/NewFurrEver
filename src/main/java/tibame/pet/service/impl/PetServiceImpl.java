package tibame.pet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tibame.pet.dao.PetDao;
import tibame.pet.service.PetService;
import tibame.pet.vo.Pet;

@Component
public class PetServiceImpl implements PetService {

	@Autowired
	private PetDao petDao;

	@Override
	public Pet add(Pet pet) {
		return petDao.save(pet);
	}

	@Override
	public List<Pet> findAllByPetUid(Integer uid) {

		return petDao.findByPetUid(uid);
	}

}
