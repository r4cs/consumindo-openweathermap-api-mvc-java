package com.br.weather.model;

/**
 * @author raquelguzansky
 *
 * Modelo para os dados meteorológicos.
 */
public class WeatherModelo {

    private String temperatura;
    private String timeZone;
    private String tempMin;
    private String tempMax;
    private String feelsLike;
    private Integer humidity;
    private String data;

    /**
     * Obtém a temperatura.
     *
     * @return a temperatura
     */
    public String getTemperatura() {
        return temperatura;
    }

    /**
     * Define a temperatura.
     *
     * @param temperatura a temperatura a ser definida
     */
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * Obtém o fuso horário.
     *
     * @return o fuso horário
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Define o fuso horário.
     *
     * @param timeZone o fuso horário a ser definido
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * Obtém a temperatura mínima.
     *
     * @return a temperatura mínima
     */
    public String getTempMin() {
        return tempMin;
    }

    /**
     * Define a temperatura mínima.
     *
     * @param tempMin a temperatura mínima a ser definida
     */
    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    /**
     * Obtém a temperatura máxima.
     *
     * @return a temperatura máxima
     */
    public String getTempMax() {
        return tempMax;
    }

    /**
     * Define a temperatura máxima.
     *
     * @param tempMax a temperatura máxima a ser definida
     */
    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    /**
     * Obtém a sensação térmica.
     *
     * @return a sensação térmica
     */
    public String getFeelsLike() {
        return feelsLike;
    }

    /**
     * Define a sensação térmica.
     *
     * @param feelsLike a sensação térmica a ser definida
     */
    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    /**
     * Obtém a umidade.
     *
     * @return a umidade
     */
    public Integer getHumidity() {
        return humidity;
    }

    /**
     * Define a umidade.
     *
     * @param humidity a umidade a ser definida
     */
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * Obtém a data.
     *
     * @return a data
     */
    public String getDate() {
        return data;
    }

    /**
     * Define a data.
     *
     * @param data a data a ser definida
     */
    public void setDate(String data) {
        this.data = data;
    }
}
