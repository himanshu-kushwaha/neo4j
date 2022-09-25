//package com.app.neo4j.repository;
//
//import com.app.neo4j.model.Movie;
//
//import javax.persistence.EntityManager;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//public class MovieCriteriaRepository {
//    private EntityManager entityManager;
//    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//    CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
//    Root<Movie> itemRoot = criteriaQuery.from(Movie.class);
//
//    Predicate predicateTitle = criteriaBuilder.equal(itemRoot.get("title"), "The Matrix");
//    criteriaQuery.
//}
//
//import com.app.neo4j.model.Movie;
//import com.app.neo4j.model.MoviePage;
//import com.app.neo4j.model.MovieSearchCriteria;
//import org.springframework.data.domain.*;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Repository
//public class MovieCriteriaRepository {
//
//    private EntityManager entityManager;
//
//    public MovieCriteriaRepository() {
//    }
//
//    private CriteriaBuilder criteriaBuilder;
//
//    public MovieCriteriaRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//        this.criteriaBuilder = entityManager.getCriteriaBuilder();
//    }
//
//    public Page<Movie> findAllWithFilters(MoviePage moviePage,
//                                          MovieSearchCriteria movieSearchCriteria){
//        CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
//        Root<Movie> movieRoot = criteriaQuery.from(Movie.class);
//        Predicate predicate = getPredicate(movieSearchCriteria, movieRoot);
//        criteriaQuery.where(predicate);
//        setOrder(moviePage, criteriaQuery, movieRoot);
//
//        TypedQuery<Movie> typedQuery = entityManager.createQuery(criteriaQuery);
//        typedQuery.setFirstResult(moviePage.getPageNumber() * moviePage.getPageSize());
//        typedQuery.setMaxResults(moviePage.getPageSize());
//
//        Pageable pageable = getPageable(moviePage);
//
//        long movieCount = getMovieCount(predicate);
//
//        return new PageImpl<>(typedQuery.getResultList(), pageable, movieCount);
//    }
//
//    private Predicate getPredicate(MovieSearchCriteria movieSearchCriteria,
//                                   Root<Movie> movieRoot) {
//        List<Predicate> predicates = new ArrayList<>();
//        if(Objects.nonNull(movieSearchCriteria.getTitle())){
//            predicates.add(
//                    criteriaBuilder.like(movieRoot.get("title"),
//                            "%" + movieSearchCriteria.getTitle() + "%")
//            );
//        }
//        if(Objects.nonNull(movieSearchCriteria.getTitle())){
//            predicates.add(
//                    criteriaBuilder.like(movieRoot.get("title"),
//                            "%" + movieSearchCriteria.getTitle() + "%")
//            );
//        }
//        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//    }
//
//    private void setOrder(MoviePage moviePage,
//                          CriteriaQuery<Movie> criteriaQuery,
//                          Root<Movie> movieRoot) {
//        if(moviePage.getSortDirection().equals(Sort.Direction.ASC)){
//            criteriaQuery.orderBy(criteriaBuilder.asc(movieRoot.get(moviePage.getSortBy())));
//        } else {
//            criteriaQuery.orderBy(criteriaBuilder.desc(movieRoot.get(moviePage.getSortBy())));
//        }
//    }
//
//    private Pageable getPageable(MoviePage moviePage) {
//        Sort sort = Sort.by(moviePage.getSortDirection(), moviePage.getSortBy());
//        return PageRequest.of(moviePage.getPageNumber(),moviePage.getPageSize(), sort);
//    }
//
//    private long getMovieCount(Predicate predicate) {
//        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
//        Root<Movie> countRoot = countQuery.from(Movie.class);
//        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
//        return entityManager.createQuery(countQuery).getSingleResult();
//    }
//}
