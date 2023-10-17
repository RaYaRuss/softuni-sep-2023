package com.likebookapp.init;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.enums.MoodName;
import com.likebookapp.repository.MoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConditionInit implements CommandLineRunner {

    private final MoodRepository moodRepository;

    public ConditionInit(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (moodRepository.count() == 0) {
            Arrays.stream(MoodName.values())
                    .forEach(m -> {
                            Mood mood = new Mood();
            mood.setMoodName(m);
            mood.setDescription("");

            this.moodRepository.save(mood);
        });

        }
    }
}
