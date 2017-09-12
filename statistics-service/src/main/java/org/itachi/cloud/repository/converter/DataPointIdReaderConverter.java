package org.itachi.cloud.repository.converter;

import com.mongodb.DBObject;
import org.itachi.cloud.domain.timeseries.DataPointId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 14:40
 */
@Component
public class DataPointIdReaderConverter implements Converter<DBObject, DataPointId> {
    @Override
    public DataPointId convert(DBObject object) {
        Date date = (Date) object.get("date");
        String account = (String) object.get("account");
        return new DataPointId(account, date);
    }
}
