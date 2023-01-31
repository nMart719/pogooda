package com.example.pogooda_backend.external_wather_api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MateomaticsApi {


    private static final String BASE_URL = "https://api.meteomatics.com";

    private List<String> allParameters = List.of("t_2m:C", "relative_humidity_2m:p", "pressure_100m:hPa", "prob_precip_1h:p", "pm10:ugm3", "wind_speed_FL10:kmh", "uv:idx", "relative_humidity_2m:p", "dew_point_2m:C", "windchill:C");
    public WeatherSensorsDto fullRead() throws IOException {
        StringBuilder sb = new StringBuilder();
        allParameters.forEach(s -> sb.append(s).append(","));
        sb.deleteCharAt(sb.length()-1);
        String parameter = sb.toString();

        return handleResponse(request(
                LocalDateTime.now().minusDays(1),
                LocalDateTime.now(),
                parameter,
                51.1089776f,
                17.0326689f
        ));
    }

    private static WeatherSensorsDto handleResponse(Response response) throws IOException {
        if (response.code() < 200 || response.code() >= 300)
            throw new RuntimeException("Invalid MateomaticsApi request!");
        ResponseBody body = response.body();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(body.byteStream(), WeatherSensorsDto.class);
    }
    private Response request(
            LocalDateTime startDate,
            LocalDateTime endDate,
            String parameter,
            Float lat, //szerokość geograficzna
            Float lon //długość geograficzna

    ) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String time;
        if (endDate == null)
            time = startDate.atOffset(ZoneOffset.ofHours(1)).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        else
            time = startDate.atOffset(ZoneOffset.ofHours(1)).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                    + "--"
                    + endDate.atOffset(ZoneOffset.ofHours(1)).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                    + ":PT15M";

        String place = lat.toString() + "," + lon.toString();

        Request request = new Request.Builder()
                .url(BASE_URL + "/" + time + "/" + parameter + "/" + place + "/json?model=mix")
                .addHeader("Authorization", "Basic cG9saXRlY2huaWthd3JvY2F3c2thX3N6Y3phZW5pYWs6UERMSDYyOGVkZw==")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        return response;
    }

}
