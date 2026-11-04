package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import mapper.Mapper;

public class CollectionHandler<R> implements Handler<Collection<R>> {
    private final Mapper<ResultSet, R> mapper;

    public CollectionHandler(Mapper<ResultSet, R> mapper) {
        this.mapper = mapper;
    }

    @Override
    public Collection<R> transform(ResultSet resultSet) {
        Collection<R> list = new ArrayList<>();
        if (resultSet == null) return list;
        try {
            while (resultSet.next()) {
                list.add(mapper.map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}