package com.react.springboot.poc;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.react.springboot.poc.model.Event;
import com.react.springboot.poc.model.Group;
import com.react.springboot.poc.repo.GroupRepository;

@Component
class Initializer implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(Initializer.class);
//	@Autowired
    private GroupRepository repository;
    
    public Initializer(GroupRepository repository) {
    	log.info("AM HIT");
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
    	log.info(Arrays.stream(strings).collect(Collectors.joining(",")));
    	System.out.print("HITS");
        Stream.of("Denver JUG", "Utah JUG", "Seattle JUG",
                "Richmond JUG").forEach(name -> repository.save(new Group(name))
        );

        Group djug = repository.findByName("Denver JUG");
        Event e = Event.builder().title("Full Stack Reactive")
                .description("Reactive with Spring Boot + React")
                .date(Instant.parse("2018-12-12T18:00:00.000Z"))
                .build();
        djug.setEvents(Collections.singleton(e));
        repository.save(djug);

        repository.findAll().forEach(System.out::println);
    }
}