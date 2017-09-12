package org.itachi.cloud.repository.converter;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.itachi.cloud.domain.timeseries.DataPointId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 14:42
 */
@Component
public class DataPointIdWriterConverter implements Converter<DataPointId, DBObject> {
    private static final int FIELDS = 2;
    @Override
    public DBObject convert(DataPointId id) {
        DBObject object = new BasicDBObject(FIELDS);
        object.put("date", id.getDate());
        object.put("account", id.getAccount());
        return object;
    }
}
