package com.javadevmz.my_social_media.service.paging;

import com.javadevmz.my_social_media.dao.entity.BaseEntity;
import lombok.Getter;
import org.springframework.data.domain.*;

import java.util.*;

/**
 * This class should be extended by service classes using a PagingAndSortingRepository to display
 * data in batches preserving the earlier fetched data. Since all the fetched entities are stored
 * in the same collection it should have one distinct inheritance for every business use-case
 * @param <E>
 * @param <I>
 */
@Deprecated
@Getter
public abstract class PagingManager<E extends BaseEntity<?>, I> {

    protected final Map<I, Pageable> pageableMap = new HashMap<>();
    protected Map<I, List<E>> fetchedEntities = new HashMap<>();

    public abstract List<E> getNextXByCriteria(I criteria, int x, Sort sort);

    protected List<E> postFetch(I criteria, List<E> fetched, int requestedCount){
        List<E> allFetched = fetchedEntities.computeIfAbsent(criteria, x -> new ArrayList<>());
        for(E e : fetched) {
            if (!allFetched.contains(e)) {
                allFetched.add(e);
            }
        }

       if(fetched.size()==requestedCount){
            pageableMap.put(criteria, pageableMap.get(criteria).next());
       }

        return fetchedEntities.get(criteria);
    }

    public void refresh(I criteria){
        fetchedEntities.remove(criteria);
        pageableMap.remove(criteria);
    }

    protected List<E> getFirstX(I criteriaValue, int x, Sort sort) {
        refresh(criteriaValue);
        return getNextXByCriteria(criteriaValue, x, sort);
    }
}
