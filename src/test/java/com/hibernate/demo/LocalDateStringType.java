package com.hibernate.demo;

import java.time.LocalDate;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

public class LocalDateStringType extends AbstractSingleColumnStandardBasicType<LocalDate> implements DiscriminatorType<LocalDate> {

    public static final LocalDateStringType INSTANCE = new LocalDateStringType();

    public LocalDateStringType() {
        super(VarcharTypeDescriptor.INSTANCE, LocalDateJavaDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return "LocalDateString";
    }

    @Override
    public LocalDate stringToObject(String xml) throws Exception {
        return fromString(xml);
    }

    @Override
    public String objectToSQLString(LocalDate value, Dialect dialect) throws Exception {
        return '\'' + toString(value) + '\'';
    }

}
