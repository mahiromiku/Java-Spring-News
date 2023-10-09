package org.mahiro.projetodio.repository;

import org.mahiro.projetodio.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}

