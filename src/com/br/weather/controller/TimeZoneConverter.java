package com.br.weather.controller;

import java.util.TimeZone;

/**
 * @author raquelguzansky
 * Classe abstrata responsável por converter o deslocamento do fuso horário em nomes de fuso horário.
 */
public abstract class TimeZoneConverter {
    private String timezoneOffsetSeconds;

    /**
     * Construtor da classe TimeZoneConverter.
     *
     * @param timezoneOffsetSeconds o deslocamento do fuso horário em segundos
     */
    public TimeZoneConverter(String timezoneOffsetSeconds) {
        this.timezoneOffsetSeconds = timezoneOffsetSeconds;
    }

    /**
     * Converte o deslocamento do fuso horário
     *
     * @param timezoneOffsetSeconds o deslocamento do fuso horário em segundos
     * @return o nome do fuso horário correspondente ao deslocamento
     */
    public static String convertTimeZone(String timezoneOffsetSeconds) {
        long timezoneOffsetMillis = Integer.parseInt(timezoneOffsetSeconds) * 1000L;

        TimeZone timeZone = TimeZone.getTimeZone("GMT" + getTimeZoneOffset(timezoneOffsetMillis));

        String timezoneName = timeZone.getDisplayName();
        return timezoneName;
    }

    /**
     * Formata o deslocamento do fuso horário.
     *
     * @param timezoneOffsetMillis o deslocamento do fuso horário em milissegundos
     * @return uma representação formatada do deslocamento do fuso horário (exemplo: +03:00)
     */
    private static String getTimeZoneOffset(long timezoneOffsetMillis) {
        int hours = (int) (timezoneOffsetMillis / (1000 * 60 * 60));
        int minutes = (int) (Math.abs(timezoneOffsetMillis / (1000 * 60)) % 60);

        String sign = timezoneOffsetMillis >= 0 ? "+" : "-";
        String formattedHours = String.format("%02d", hours);
        String formattedMinutes = String.format("%02d", minutes);

        return sign + formattedHours + ":" + formattedMinutes;
    }
}
