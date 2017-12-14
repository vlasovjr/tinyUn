package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDatePersistenceConverter implements
        AttributeConverter<LocalDate, java.sql.Date> {

    //X Y

    //X->Y
    @Override
    public java.sql.Date convertToDatabaseColumn(LocalDate entityValue) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAa");
        return java.sql.Date.valueOf(entityValue);
    }

    //Y->X
    @Override
    public LocalDate convertToEntityAttribute(java.sql.Date databaseValue) {
        System.out.println("XWWWAAAAAAAAAAAAAAAAAAAAAAAa");
        return databaseValue.toLocalDate();
    }
}