package org.mahiro.projetodio.controller;

import org.mahiro.projetodio.model.News;
import org.mahiro.projetodio.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/")
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @GetMapping("/{id}")
    public News getNewsById(@PathVariable Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public News createNews(@RequestBody News news) {
        return newsRepository.save(news);
    }

    @PutMapping("/{id}")
    public News updateNews(@PathVariable Long id, @RequestBody News updatedNews) {
        News existingNews = newsRepository.findById(id).orElse(null);
        if (existingNews != null) {
            existingNews.setTitle(updatedNews.getTitle());
            existingNews.setPhoto(updatedNews.getPhoto());
            existingNews.setInformation(updatedNews.getInformation());
            return newsRepository.save(existingNews);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsRepository.deleteById(id);
    }
}

