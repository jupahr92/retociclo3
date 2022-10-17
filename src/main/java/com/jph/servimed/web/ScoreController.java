package com.jph.servimed.web;

import com.jph.servimed.model.Score;
import com.jph.servimed.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/Score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @GetMapping("/all")
    public List<Score> getServices(){
        return scoreService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Score> getService(@PathVariable("id") int scoreId) {
        return scoreService.getScore(scoreId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score) {
        return scoreService.save(score);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score) {
        return scoreService.update(score);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int scoreId) {
        return scoreService.deleteScore(scoreId);
    }
}
