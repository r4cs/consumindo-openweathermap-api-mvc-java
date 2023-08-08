package com.br.weather.view;

import java.util.Scanner;

/**
 * @author raquelguzansky
 *
 * Classe responsável pela visualização dos dados meteorológicos.
 */
public class WeatherView {
    private Scanner scanner;

    /**
     * Construtor da classe WeatherView.
     * Inicializa o scanner para leitura de entrada do usuário.
     */
    public WeatherView() {
        scanner = new Scanner(System.in);
    }

    /**
     * Exibe uma mensagem de boas-vindas.
     */
    public void welcome() {
        System.out.println("Bem vindo ao API de clima (: ");
    }

    /**
     * Solicita ao usuário a entrada da cidade, estado ou país desejado.
     *
     * @return a cidade, estado ou país informado pelo usuário
     */
    public String getCityFromUser() {
        System.out.print("Insira a cidade, estado ou país desejado: ");
        return scanner.nextLine();
    }

    /**
     * Exibe a temperatura para uma determinada cidade.
     *
     * @param city       a cidade para a qual a temperatura é exibida
     * @param temperature a temperatura a ser exibida
     */
    public void displayTemperatura(String city, String temperature) {
        System.out.println("Temperatura em " + city + ": " + temperature + " Celsius");
    }

    /**
     * Exibe a temperatura mínima.
     *
     * @param tempMin a temperatura mínima a ser exibida
     */
    public void displayTempMin(String tempMin) {
        System.out.println("Temperatura mínima " + tempMin + " Celsius");
    }

    /**
     * Exibe a temperatura máxima.
     *
     * @param tempMax a temperatura máxima a ser exibida
     */
    public void displayTempMax(String tempMax) {
        System.out.println("Temperatura máxima " + tempMax + " Celsius");
    }

    /**
     * Exibe a sensação térmica.
     *
     * @param feelsLike a sensação térmica a ser exibida
     */
    public void displayFeelsLike(String feelsLike) {
        System.out.println("Sensação térmica " + feelsLike + " Celsius");
    }

    /**
     * Exibe a umidade.
     *
     * @param humidity a umidade a ser exibida
     */
    public void displayHumidity(Integer humidity) {
        System.out.println("Umidade " + humidity + "%");
    }

    /**
     * Exibe o fuso horário.
     *
     * @param timeZone o fuso horário a ser exibido
     */
    public void displayTimeZone(String timeZone) {
        System.out.println("Fuso horário oficial " + timeZone);
    }

    /**
     * Exibe a data da pesquisa.
     *
     * @param data a data a ser exibida
     */
    public void displayDate(String data) {
        System.out.println("Pesquisado em: " + data);
    }
}
