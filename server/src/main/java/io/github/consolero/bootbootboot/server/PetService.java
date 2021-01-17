package io.github.consolero.bootbootboot.server;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PetService implements PetApiDelegate {

    @Override
    public ResponseEntity<Pet> getPetById(final Long petId) {
        if (!Long.valueOf(42).equals(petId)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new Pet().name("Emmi"));
    }

}
