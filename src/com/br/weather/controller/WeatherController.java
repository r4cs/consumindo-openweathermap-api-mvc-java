package com.br.weather.controller;

import com.br.weather.model.WeatherModelo;
import com.br.weather.view.WeatherView;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author raquelguzansky
 *
 * Classe responsável pelo controle das operações relacionadas ao clima.
 */
public class WeatherController {
    private static final String API_KEY = "INSERT_API_KEY";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=" + API_KEY + "&lang=pt_br";

    private WeatherModelo model;
    private WeatherView view;

    /**
     * Construtor da classe WeatherController.
     *
     * @param model o modelo de dados do clima
     * @param view  a visualização do clima
     */
    public WeatherController(WeatherModelo model, WeatherView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Realiza a busca da temperatura para um determinado local.
     *
     * @param target a localizacao desejada
     */
    public void fetchTemperatura(String target)  {
        try {
            String apiUrl = String.format(API_URL, target);
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("response: " + response);
            reader.close();
            conn.disconnect();

            JSONObject jsonResponse = new JSONObject(response.toString());

            BigDecimal tempMin = jsonResponse.getJSONObject("main").getBigDecimal("temp_min");
            tempMin = convertToCelsius(tempMin);
            String tempMinString = tempMin.stripTrailingZeros().toPlainString();

            BigDecimal tempMax = jsonResponse.getJSONObject("main").getBigDecimal("temp_max");
            tempMax = convertToCelsius(tempMax);
            String tempMaxString = tempMax.stripTrailingZeros().toPlainString();

            BigDecimal feelsLike = jsonResponse.getJSONObject("main").getBigDecimal("feels_like");
            feelsLike = convertToCelsius(feelsLike);
            String feelsLikeString = feelsLike.stripTrailingZeros().toPlainString();

            Integer humidity = jsonResponse.getJSONObject("main").getInt("humidity");

            long timestamp = jsonResponse.getLong("dt");
            Date data = new Date(timestamp * 1000);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dataString = formatter.format(data);

            BigDecimal temperatura = jsonResponse.getJSONObject("main").getBigDecimal("temp");
            temperatura = convertToCelsius(temperatura);
            String temperaturaString = temperatura.stripTrailingZeros().toPlainString();

            BigDecimal timeZone = jsonResponse.getBigDecimal("timezone");
            String timeZoneString = TimeZoneConverter.convertTimeZone(String.valueOf(timeZone));

            model.setTemperatura(temperaturaString);
            model.setTimeZone(timeZoneString);
            model.setTempMin(tempMinString);
            model.setTempMax(tempMaxString);
            model.setFeelsLike(feelsLikeString);
            model.setHumidity(humidity);
            model.setDate(dataString);

        } catch (IOException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Converte uma temperatura de Kelvin para Celsius.
     *
     * @param kelvin a temperatura em Kelvin
     * @return a temperatura em Celsius
     */
    public BigDecimal convertToCelsius(BigDecimal kelvin) {
        return kelvin.subtract(new BigDecimal("273.15"));
    }

    /**
     * Atualiza a visualização com os dados do clima.
     */
    public void updateView() {
        view.welcome();
        String city = view.getCityFromUser();
        fetchTemperatura(city);
        String temperatura = model.getTemperatura();
        String timeZone = model.getTimeZone();
        view.displayTimeZone(timeZone);
        view.displayTemperatura(city, temperatura);
        view.displayTempMin(model.getTempMin());
        view.displayTempMax(model.getTempMax());
        view.displayFeelsLike(model.getFeelsLike());
        view.displayHumidity(model.getHumidity());
        view.displayDate(model.getDate());
    }
}
