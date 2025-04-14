package br.com.brunoeas.poc.core.entities.common.enums.converter;

import br.com.brunoeas.poc.core.entities.common.enums.PersistentEnum;
import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

@AllArgsConstructor
public abstract class AbstractEnumConverter<E extends PersistentEnum<T>, T> implements AttributeConverter<E, T> {

    private final Class<E> enumClass;

    /**
     * Converts the value stored in the entity attribute into the
     * data representation to be stored in the database.
     *
     * @param attribute the entity attribute value to be converted
     * @return the converted data to be stored in the database
     * column
     */
    @Override
    public T convertToDatabaseColumn(E attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    /**
     * Converts the data stored in the database column into the
     * value to be stored in the entity attribute.
     * Note that it is the responsibility of the converter writer to
     * specify the correct <code>dbData</code> type for the corresponding
     * column for use by the JDBC driver: i.e., persistence providers are
     * not expected to do such type conversion.
     *
     * @param dbData the data from the database column to be
     *               converted
     * @return the converted value to be stored in the entity
     * attribute
     */
    @Override
    public E convertToEntityAttribute(T dbData) {
        if (dbData == null) return null;
        return Stream.of(this.enumClass.getEnumConstants())
                .filter(e -> Objects.equals(e.getCode(), dbData))
                .findFirst()
                .orElse(null);
    }

}
