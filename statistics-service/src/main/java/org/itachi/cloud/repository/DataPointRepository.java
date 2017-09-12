package org.itachi.cloud.repository;

import org.itachi.cloud.domain.timeseries.DataPointId;
import org.itachi.cloud.model.DataPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 14:39
 */
@Repository
public interface DataPointRepository extends CrudRepository<DataPoint, DataPointId> {
    List<DataPoint> findByIdAccount(String account);
}
