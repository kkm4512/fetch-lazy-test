package org.terror.fetchlazy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FetchLazyTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PetRepository petRepository;

    @Test
    void test1() {
        List<Pet> pets = new ArrayList<>();
        for ( int i=0; i<10; i++ ) {
            Pet pet = Pet.builder().name("pet" + i).build();
            pets.add(pet);
        }
        petRepository.saveAll(pets);

        List<Owner> owners = new ArrayList<>();
        for ( int i=0; i<10; i++ ) {
            Owner owner = Owner.builder().name("owner" + i).build();
            owner.setPets(pets);
            owners.add(owner);
        }
        ownerRepository.saveAll(owners);
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        List<Owner> ownerList = ownerRepository.findAll();
    }
}
