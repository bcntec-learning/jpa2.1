package bcntec.learning.jpa21.attributeConverter;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * @author francisco.philip@gmail.com
 */

@Slf4j
@Converter(autoApply = false)
public class ImageConverter implements AttributeConverter<RenderedImage, String> {


    @Override
    public String convertToDatabaseColumn(RenderedImage attribute) {
        String ret = null;
        if (attribute != null) {
            try {
                JSONObject object = toJson(attribute);
                ret = object.toString();
                log.debug(ret);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return ret;
    }

    @Override
    public RenderedImage convertToEntityAttribute(String dbData) {
        RenderedImage ret = null;
        if (dbData != null) {
            try {
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(dbData);
                ret = toImage(json);
            } catch (ParseException | DataFormatException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        return ret;
    }

    public static JSONObject toJson(RenderedImage image) throws IOException {

        JSONObject json = new JSONObject();
        json.put("type", "png");
        @Cleanup
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", bos);
        byte[] imageBytes = bos.toByteArray();

        json.put("image",
                new String(
                Base64.getEncoder().encode(
                        compress(imageBytes))));

        bos.close();

        return json;
    }

    public static RenderedImage toImage(JSONObject json) throws IOException, DataFormatException {
        String image = (String) json.get("image");
        byte data[] = Base64.getDecoder().decode(image);

        @Cleanup
        ByteArrayInputStream stream = new ByteArrayInputStream(decompress(data));
        return ImageIO.read(stream);
    }

    public static byte[] compress(byte[] data) throws IOException {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        @Cleanup
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        deflater.finish();
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        return outputStream.toByteArray();
    }

    public static byte[] decompress(byte[] data) throws IOException, DataFormatException {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        @Cleanup
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        return outputStream.toByteArray();
    }
}
