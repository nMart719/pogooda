package com.example.pogooda_backend.service;

import com.example.pogooda_backend.model.jpa.PomiarCzujnikaZew;
import com.example.pogooda_backend.repository.PomiarCzujnikaZewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Example {

    private final PomiarCzujnikaZewRepository pomiarCzujnikaZewRepository;

    public Example(PomiarCzujnikaZewRepository pomiarCzujnikaZewRepository) {
        this.pomiarCzujnikaZewRepository = pomiarCzujnikaZewRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dodajCos() {
        PomiarCzujnikaZew pomiarCzujnikaZew = new PomiarCzujnikaZew();
        pomiarCzujnikaZew.setTemperaturaZewnetrzna(123.0f);
        pomiarCzujnikaZew.setCzasOdczytu(Timestamp.valueOf(LocalDateTime.now()));

        System.out.println("id: " + pomiarCzujnikaZew.getId());

        pomiarCzujnikaZewRepository.save(pomiarCzujnikaZew);

        System.out.println("id: " + pomiarCzujnikaZew.getId());

        pomiarCzujnikaZew.setPromieniowanieSloneczne(10f);

        pomiarCzujnikaZewRepository.save(pomiarCzujnikaZew);

        Optional<PomiarCzujnikaZew> pomiar = pomiarCzujnikaZewRepository.findById(105);
        if (pomiar.isPresent()) {
            PomiarCzujnikaZew pomiarCzujnikaZew1 = pomiar.get();
            pomiarCzujnikaZewRepository.delete(pomiarCzujnikaZew1);
        }


        pomiarCzujnikaZewRepository.deleteById(105);
    }
}
