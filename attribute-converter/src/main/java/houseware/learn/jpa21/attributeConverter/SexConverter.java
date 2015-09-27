package houseware.learn.jpa21.attributeConverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author fphilip@houseware.es
 */
@Converter(autoApply = true)
public class SexConverter implements AttributeConverter<SexEnum, String> {

    @Override
    public String convertToDatabaseColumn(SexEnum sexEnum) {
        if(sexEnum==null){
          return null;
        }
        switch (sexEnum) {
            case FEMALE:
                return "F";
            case MALE:
                return "M";
            case OTHER:
                return "O";
            default:
                throw new IllegalArgumentException("Unknown value: " + sexEnum);
        }
    }

    @Override
    public SexEnum convertToEntityAttribute(String dbData) {
        if(dbData==null){
          return null;
        }
        switch (dbData) {
            case "F":
            case "f":
            case "0":
                return SexEnum.FEMALE;
            case "M":
            case "m":
            case "1":
                return SexEnum.MALE;
            case "O":
            case "o":
            case "2":
                return SexEnum.OTHER;
            default:
                throw new IllegalArgumentException("Unknown value: " + dbData);
        }
    }

}
